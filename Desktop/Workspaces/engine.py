# crawl_and_index.py
import requests, re, time
from bs4 import BeautifulSoup
from urllib.parse import urljoin, urldefrag
from collections import deque
import json

MEILI_URL = "http://127.0.0.1:7700/indexes/pages/documents"
HEADERS = {"Authorization": "Bearer MASTER_KEY", "Content-Type": "application/json"}
START_URL = "https://example.com"
MAX_PAGES = 200
ALLOWED_HOST = "example.com"

def clean_text(t): return re.sub(r"\s+", " ", t or "").strip()

def extract_links(base, soup):
    links = []
    for a in soup.select("a[href]"):
        href = urljoin(base, a["href"])
        href, _ = urldefrag(href)
        if href.startswith("http") and ALLOWED_HOST in href:
            links.append(href)
    return links

seen, q, docs = set(), deque([START_URL]), []
while q and len(seen) < MAX_PAGES:
    url = q.popleft()
    if url in seen: continue
    try:
        r = requests.get(url, timeout=10, headers={"User-Agent":"SanjeevBot/0.1"})
        if "text/html" not in r.headers.get("content-type",""): continue
        soup = BeautifulSoup(r.text, "html.parser")
        title = clean_text(soup.title.string if soup.title else url)
        body = clean_text(soup.get_text(" "))
        docs.append({"id": url, "url": url, "title": title, "content": body})
        q.extend(extract_links(url, soup))
        seen.add(url)
        if len(docs) >= 50:  # batch index
            requests.post(MEILI_URL, headers=HEADERS, data=json.dumps(docs)); docs=[]
        time.sleep(0.2)
    except Exception as e:
        pass
if docs:
    requests.post(MEILI_URL, headers=HEADERS, data=json.dumps(docs))
print(f"Indexed {len(seen)} pages.")
