# with open("bt.txt","r") as f:
#     data = f.read()
# newdata = data.replace("java","python")


# with open("bt.txt","w") as f:
#     data = f.write(newdata)

word = "learning"
# with open("bt.txt","r") as f:
#     data = f.read()
#     if(data.find(word)!=-1):
#         print("found")
#     else:
#         print("Not Found!")

# def check_line():
#     data = True
#     line1 = 1
#     with open("bt.txt","r") as f:
#         while(data):
#             data = f.readline()
#             if(word in data):
#                 print(line1)
#             line1+=1 
#     return -1
# check_line()

def eveno():
    with open("bt.txt","r") as f:
        data = f.read()
        # scracth way
        # num = ""
        # for i in range(len(data)):
        #     if(data[i]==","):
        #         print(int(num))
        #         num=""
        #     else:
        #         num+= data[i]
        num = data.split(",")
        print(num)
        count = 1
        for val in num:
            if(int(val)%2==0):
                count+=1
        print(count)
eveno()