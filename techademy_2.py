#Program to read data from csv file 
# and build a data structure to display the data

import csv
with open('techademy_2.csv') as csv_file:
   
#Read the csv file
    reader = csv.reader(csv_file)
    data_list = []
    
#Iterate through the list file
    for row in reader:
        data_list.append(row)
    csv_list = list(reader)

#Print each row from the list
for row in data_list:
    print(row)