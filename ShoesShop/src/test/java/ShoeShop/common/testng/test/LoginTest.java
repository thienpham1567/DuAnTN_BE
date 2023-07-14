package ShoeShop.common.testng.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ShoeShop.common.testng.utils.ExcelUtils;
import ShoeShop.common.testng.logs.LoginData;


public class LoginTest {
	private static WebDriver myBrowser;
	private final String fileExcel = ExcelUtils.excelPath + "test_login.xlsx";
	private Set<LoginData> logs; // Map
	//Trước khi chạy BeforeMthod thì data sẽ bị reset. logs dùng để chứa dữ liệu trước đó	

	private LoginData data;
	
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", ExcelUtils.driverPath);
		logs = new LinkedHashSet<>();
		// dùng HashSet hay LinkHashSet gì cũng được
		// lý do dùng LinkedHashSet để đảm bảo thứ tự dữ liệu test không bị thay đổi do tính chất của kiểu dữ liêu này 
	}
	
	@BeforeMethod
	public void setUpClass() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--incognito"); // ẩn danh
		// khởi tạo và thiết lập các thông số cho web driver
		myBrowser = new ChromeDriver(opt);
		myBrowser.get("http://localhost:5173/"); // trang cần test
		myBrowser.manage().window().maximize();

		// khởi tạo biến lưu dữ liệu của 1 row trong excel
		data = new LoginData(); //Khởi tạo lại từ đầu để có dữ liệu mới, ko nhớ cái cũ
	}
	
	private void processLogin(String username, String password) throws InterruptedException { // Phương thức tiện ích thực hiện thao tác đăng nhập
		WebElement userTag = myBrowser.findElement(By.xpath("//input[@id='username']"));
		userTag.sendKeys(username);
		
		Thread.sleep(1000);

		WebElement passTag = myBrowser.findElement(By.xpath("//input[@id='password']"));
		passTag.sendKeys(password);

		Thread.sleep(1000);
		
		WebElement loginTag = myBrowser.findElement(By.xpath("//button[normalize-space()='Login']"));
		loginTag.click();
		
		Thread.sleep(2000);
	}
	
	@Test(dataProvider = "loginData") //Nhờ vào dataProvider nên Test này sẽ chạy hết những dữ liệu có trong file Excel
	public void multipleLogin(String id, String password, String expected) throws InterruptedException {
		// ở trong sheet dữ liệu có bao nhiêu cột thì mấy ông truyền vào đúng bấy nhiêu tham số là được
		
		processLogin(id, password); // thực hiện đăng nhập
		
		/*
		 *	trả về kết quả actual là url của trang web
		 *	trong trường hợp test thêm sửa xoá actual phải là một thứ gì khác
		 *	tuỳ vào logic của mấy ông muốn so sánh kiểu gì
		 */

		String actualURL = myBrowser.getCurrentUrl(); //actual
		
		// gán dữ liệu cho các fields của đối tượng
		data.setId(id);
		data.setPassword(password);
		data.setAction("Test login (authenticate) function"); // thay đổi mô tả cho phù hợp với trường hợp test
		data.setTestTime(new Date()); 
		data.setExpected(expected); // expected nhập vào từ file data
		data.setActual(actualURL);

//		Thread.sleep(3000);

		assertEquals(expected, actualURL); // so sánh expected với actual
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		data.setTestMethod(result.getName()); // setTestMethod

		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			data.setStatus("SUCCESS"); // setStatus to success
			break;
		case ITestResult.FAILURE:
			data.setStatus("FAILURE"); // setStatus to failure
			data.setException(result.getThrowable().getMessage()); // setException

			// chỉ định đường dẫn lưu file hình ảnh
			String path = ExcelUtils.imagesPath + "failure-" + System.currentTimeMillis() + ".png"; //tên hình

			// gọi phương thức chụp ảnh màn hình từ lớp tiện ích
			ExcelUtils.takeScreenShot(myBrowser, path); //chụp màn hình ngay tại chỗ bị lỗi

			// ghi dữ liệu hình ảnh vào workbook thông qua gán dữ liệu
			data.setImage(path);
			break;
		case ITestResult.SKIP:
			data.setStatus("SKIP"); // setStatus to skip
		default:
			break;
		}

		logs.add(data); //Lưu data vào lags

		myBrowser.close();
	}
	
	@AfterClass
	public void destroy() throws IOException {
		// cuối cùng sau khi đã thực hiện tất cả các test case
		// gọi hàm writeLog để export dữ liệu ra file
		// lưu ý lúc ghi dữ liệu phải đóng file excel trước (nếu đang mở)
		data.writeLog(fileExcel, "test_result", logs); // tham số bao gồm đường dẫn file xuất, tên sheet, bộ dữ liệu
	}

	@DataProvider(name = "loginData")
	public Object[][] data() throws IOException { //ĐỌC
		// mở file excel để lấy dữ liệu test
		XSSFWorkbook workbook = ExcelUtils.getWorkbook(fileExcel);
		// thay đổi tên sheet phù hợp
		XSSFSheet sheet = workbook.getSheet("test_data"); 
		// đọc dữ liệu test bằng hàm tiện ích
		Object[][] data = ExcelUtils.readSheetData(sheet);

		return data;
	}
}
