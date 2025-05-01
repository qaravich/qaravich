from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import pytest
# import pytest-html
# tio use fixtures we need to imprt pytest
# we can comment the teardown code  and pass the test_setup in each function as parameter
# for each function driver will open and close

@pytest.fixture()
def test_setup():
 global driver
 driver = webdriver.Chrome()
 driver.implicitly_wait(10)
 driver.maximize_window()
 


def test_step1(test_setup):
  # Step1: Launch a below URL
  driver.get("http://the-internet.herokuapp.com/")  
  driver.implicitly_wait(10)
 # verify the title of the Page
  get_title = driver.title
  print(get_title)

# def test_checboxes_text(test_setup):
  #Step2: Click on Checkboxes link
  driver.find_element(By.XPATH,value='//a[@href="/checkboxes"]').click()
  # time.sleep(5)
  driver.implicitly_wait(10)
  
  def test_checkboxes_disp():
   is_checbox_disp = driver.find_element(By.XPATH, value='//*[text()="Checkboxes"]').is_displayed()
   print("in test_checkboxes_disp")
   assert  is_checbox_disp == True
   print(f"Is the checkboxes text is  displayed? {is_checbox_disp}")
  # time.sleep(3)
  driver.implicitly_wait(10)


  test_checkboxes_disp()

# def test_title(test_setup):
  # return all handles value of open browser window 
  handles = driver.window_handles 
  for i in handles: 
      driver.switch_to.window(i) 
    
      # print every open window page title 
      print(driver.title) 

  # Getting current URL 
  get_url = driver.current_url 
    
  # Printing the URL 
  print(get_url)

# to validate and check the checkbox1 is checked or not
# def test_check_box1(test_setup):
 
  is_checbox1_selected = driver.find_element(By.XPATH, value='//*[text()=" checkbox 1"]').is_selected()
#  print(is_checbox1_selected)
  print(f"Is the checkbox1 checked? {is_checbox1_selected}")
  assert is_checbox1_selected == False
 


# to validate and check the checkbox2 is checked or not
# def test_check_box2(test_setup):
  is_checbox2_selected = driver.find_element(By.XPATH, value='//*[@id="checkboxes"]/input[2]').is_selected()
#  print(is_checbox2_selected)
  print(f"Is the checkbox2 checked? {is_checbox2_selected}")
 #assert is_checbox2_selected == True
 

  # time.sleep(3)
  driver.implicitly_wait(10)

  def test_checkbox2():
    print("in test_checkbox2")
    assert driver.find_element(By.XPATH, value='//*[@id="checkboxes"]/input[2]').is_selected() == True
  def test_checkbox1():
    print("in test_checkbox1")
    assert driver.find_element(By.XPATH, value='//*[text()=" checkbox 1"]').is_selected() == False



  test_checkbox1()
  test_checkbox2()
# def test_backtoHome(test_step1):
  # Step3: Navigate back to Home page
  driver.back()

# def test_FileUpload(test_setup):
  #click on File Upload link
  driver.find_element(By.XPATH,value='//a[@href="/upload"]').click()


  # Step4: Verify the text on the Page as “File Uploader”
  fileupdisplay = driver.find_element(By.XPATH,value='//*[text()="File Uploader"]').is_displayed()
  # print(f"Is fileuploder text  is available ? {fileupdisplay}")
  assert True == fileupdisplay

  # time.sleep(3)

  fileuplod = driver.find_element(By.XPATH,value='//input[@id="file-upload"]').is_displayed()
  # print(f"Is fileuplod is available ? {fileuplod}")
  assert fileuplod == True

  # click on Choose File button to select the file
  f = driver.find_element(By.XPATH,value='//input[@id="file-upload"]')
  upload = "E:\\TestData.xlsx"
  f.send_keys(upload)


  # Click on Upload button.
  driver.find_element(By.XPATH,value='//input[@id="file-submit"]').click()


# test_step1(test_setup)

def test_teardown():
  driver.close()
  driver.quit()
  print("FileUploadedSuccessfully")