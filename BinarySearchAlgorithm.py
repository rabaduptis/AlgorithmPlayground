import random

def roundNDivide(number):
    return round(number/2)

def fillWithRandomValues(arr):
    for i in range(len(arr)):
        arr[i] = random.randint(0, 100)
    return arr

print('how many random numbers do you want to generate?')
totalNumber=int(input())

filled_array = fillWithRandomValues([0] * totalNumber ) #create 10 index arr with 0,0...
filled_array.sort()
print(filled_array)

print("find a int: ")
selectedNumber = int(input())
print(f'selected int {selectedNumber}')

counter=0
selector=roundNDivide(len(filled_array))
while True:
    if filled_array[selector] == selectedNumber:
        counter=counter+1
        break
    elif selectedNumber<filled_array[selector]:
        selector=round(selector/2)
        counter=counter+1
    elif selectedNumber>filled_array[selector]:
        selector=round(selector+(len(filled_array)-selector)/2)
        counter=counter+1
        
        
print(f' found after {counter} process')