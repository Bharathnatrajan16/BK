package org.page;



	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityFiles.UtilityFiles;

	
	public class PageObject extends UtilityFiles {
		public PageObject() {
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//input[@id='ControlOptionsTopHolder_lbSelectionMode_I']")
		private WebElement selectType;

		@FindBy(xpath = "//td[text()='Single']")
		private WebElement singleSelect;

		@FindBy(xpath = "//td[text()='Multiple']")
		private WebElement multiSelect;

		@FindBy(xpath = "//td[text()='CheckColumn']")
		private WebElement checkColumn;

		@FindBy(xpath = "//table[@id='ContentHolder_lbFeatures_LBT']//td")
		private List<WebElement> Options;
		
		@FindBy(xpath = "//table[@id='ContentHolder_lbFeatures_LBT']//td[1]")
		private List<WebElement> CheckOptions;

		@FindBy(xpath = "//input[@id='ContentHolder_lbFeatures_VI']")
		private WebElement selectedOptionValue;

		@FindBy(xpath = "//input[@id='ContentHolder_lbModels_VI']")
		private WebElement selectedModelOptionValue;

		@FindBy(xpath = "//table[@id='ContentHolder_lbModels_LBT']//td[1]")
		private List<WebElement> modelsOptions;

		public WebElement getSelectType() {
			return selectType;
		}

		public WebElement getSingleSelect() {
			return singleSelect;
		}

		public WebElement getMultiSelect() {
			return multiSelect;
		}

		public WebElement getCheckColumn() {
			return checkColumn;
		}

		public List<WebElement> getOptions() {
			return Options;
		}

		public List<WebElement> getModelsOptions() {
			return modelsOptions;
		}

		public WebElement getSelectedOptionValue() {
			return selectedOptionValue;
		}

		public WebElement getSelectedModelOptionValue() {
			return selectedModelOptionValue;
		}
		
		public List<WebElement> getCheckOptions() {
			return CheckOptions;
		}
		// -------------------------------------------------------------//

		public void selectSelectOptionType(String option) {
			click(getSelectType());
			if (option.equalsIgnoreCase("Single")) {
				click(getSingleSelect());
			} else if (option.equalsIgnoreCase("Multiple")) {
				click(getMultiSelect());
			} else if (option.equalsIgnoreCase("CheckColumn")) {
				click(getCheckColumn());
			}
		}

		public void selectModelOptions() {
			try {
				Robot r = new Robot();

				for (WebElement x : getModelsOptions()) {
					r.keyPress(KeyEvent.VK_SHIFT);
					x.click();
					Thread.sleep(2000);
				}
				r.keyRelease(KeyEvent.VK_SHIFT);
			} catch (AWTException e) {

				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public void selectSingleOption() {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_SHIFT);
				Thread.sleep(3000);
				r.keyPress(KeyEvent.VK_SHIFT);
				click(getOptions().get(0));
				Thread.sleep(3000);
				r.keyPress(KeyEvent.VK_SHIFT);
				click(getOptions().get(1));

			} catch (AWTException e) {

				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public void selectMultipleOption() {
			try {
				Robot r = new Robot();
				int count = 0;
				r.keyPress(KeyEvent.VK_SHIFT);
				for (WebElement x : getOptions()) {
					x.click();
					count++;
					Thread.sleep(2000);
					if (count > 3) {
						break;
					}

				}
				r.keyRelease(KeyEvent.VK_SHIFT);

			} catch (AWTException e) {

				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public void selectCheckMultipleOption() {
			try {
				Robot r = new Robot();
				int count = 0;
				for (WebElement x : getCheckOptions()) {
					x.click();
					count++;
					Thread.sleep(2000);
					if (count > 3) {
						break;
					}
				}

			} catch (AWTException e) {

				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public boolean verifySingleOptionSelect() {
			boolean result = false;
			String selectedValue = getAttribute(getSelectedOptionValue());
			System.out.println(selectedValue);
			String[] option = selectedValue.split("\\|");
			for (String x : option) {
				System.out.println(x);
			}
			if (option.length == 1) {
				result = true;
				System.out.println("Only one option select by end user");
			} else {
				result = false;
				System.out.println(option.length);
				System.out.println("Multiple option select by end user");

			}

			return result;
		}

		public boolean verifyMultiOptionSelect() {
			boolean result = false;
			String selectedValue = getAttribute(getSelectedOptionValue());
			System.out.println(selectedValue);
			String[] option = selectedValue.split("\\|");
			for (String x : option) {
				System.out.println(x);
			}
			if (option.length > 1) {
				result = true;
				System.out.println(option.length);
				System.out.println("Multiple option select by end user");

			} else {
				result = false;
				System.out.println("Only one option select by end user");

			}

			return result;
		}

		public boolean verifySingleModelOptionSelect() {
			boolean result = false;
			String selectedValue = getAttribute(getSelectedModelOptionValue());
			System.out.println(selectedValue);
			String[] option = selectedValue.split("\\|");
			for (String x : option) {
				System.out.println(x);
			}
			if (option.length == 1) {
				result = true;
				System.out.println("Only one Models option select by end user");

			} else {
				result = false;
				System.out.println(option.length);
				System.out.println("Multiple Model option select by end user");

			}

			return result;
		}

		public boolean verifyMultiModelOptionSelect() {
			boolean result = false;
			String selectedValue = getAttribute(getSelectedModelOptionValue());
			System.out.println(selectedValue);
			String[] option = selectedValue.split("\\|");
			for (String x : option) {
				System.out.println(x);
			}
			if (option.length > 1) {
				result = true;
				System.out.println(option.length);
				System.out.println("Multiple Model option select by end user");

			} else {
				result = false;
				System.out.println("Only one Models option select by end user");

			}

			return result;
		}
	}


