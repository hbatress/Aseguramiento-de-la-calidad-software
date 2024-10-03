import unittest
from selenium import webdriver
from pyunitreport import HTMLTestRunner
from selenium.webdriver.common.by import By
from selenium.common.exceptions import NoAlertPresentException
import time

class BuyLaptops(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        driver = self.driver
        driver.implicitly_wait(30)
        driver.maximize_window()
        driver.get('https://www.demoblaze.com/')

    def test_steps_to_buy(self):
        laptops_link = self.driver.find_element(By.XPATH,"//a[@onclick=\"byCat('notebook')\"]")
        laptops_link.click()
        time.sleep(5)
        macbook_link = self.driver.find_element(By.LINK_TEXT,"MacBook air")
        macbook_link.click()
        time.sleep(5)
        add_to_cart_button = self.driver.find_element(By.XPATH,"//a[@onclick='addToCart(11)']")
        add_to_cart_button.click()

        time.sleep(5)

        try:
            alert = self.driver.switch_to.alert
            alert.accept()
        except NoAlertPresentException:
            print("No alert was present")

    def tearDown(self):
        input("Presiona Enter para cerrar la ventana del navegador...")
        self.driver.quit()

if __name__ == "__main__":
   unittest.main(verbosity=2, testRunner = HTMLTestRunner(output = 'reportes', report_name='purchasing-report'))