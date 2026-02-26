import requests
import json
from bs4 import BeautifulSoup

url = "https://www.apnacollege.in/path-player?courseid=sigma-4-dsa&unit=67f7d79e6183f55a0c0f6bb8Unit"

response = requests.get(url)
soup = BeautifulSoup(response.text, "html.parser")

quotes = soup.find_all("span", class_="text")

data = []

for quote in quotes:
    data.append({
        "quote": quote.text
    })


with open("data.json", "w") as f:
    json.dump(data, f, indent=4)
print(data)

