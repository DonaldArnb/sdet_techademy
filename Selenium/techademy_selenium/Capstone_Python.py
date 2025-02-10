from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.common.exceptions import NoSuchElementException

import time

urls = ['https://the-internet.herokuapp.com/']
s = Service(r"C:\techademy\Selenium\techademy_selenium\chromedriver.exe")

for url in urls:
    driver = webdriver.Chrome(service=s)
    driver.get(url)
    print(driver.title)

    checkboxLink= driver.find_element("xpath","//*[@href='/checkboxes']")
    checkboxLink.click()
    print(driver.title)

#Validate checkboxes selected
    #Checbox definition
    checkbox2= driver.find_element("xpath", "//*[@id='checkboxes']/input[2]")
    checkbox1= driver.find_element("xpath", "//*[@id='checkboxes']/input[1]")

    #Method to assert checkbox selection
    def is_checked(item_id,boolean):
        assert item_id.is_selected()==boolean
        print(item_id.is_selected())
    
    #Function call to validate if relevant checkboxes are checked
    is_checked(checkbox2, True)
    is_checked(checkbox1, False)

#Navigate back    
    driver.back()

#Upload file
    try:
        fileUpload= driver.find_element("xpath","//*[@href='/upload']")
        fileUpload.click()
        fileUploadText= driver.find_element("xpath","//*[@id='content']/div[1]/h3").get_attribute("textContent")
        print(fileUploadText)
        assert fileUploadText == "File Uploader"
        

        fileUploadButton= driver.find_element("xpath","//input[@id='file-upload']")
        fileUploadButton.send_keys(r'C:\techademy\Selenium\techademy_selenium\TestFileToUpload.txt')
        time.sleep(5)

    #Upload and submit file   
        fileSubmit= driver.find_element("xpath","//*[@id='file-submit']")
        fileSubmit.click()
        time.sleep(5)
    except RuntimeError as e:
        print