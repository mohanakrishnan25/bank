package org.project;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class AdactinHotelApp {

public static void main(String[] args) throws IOException {
	
		BaseClass b=new BaseClass();
		b.getDriver();
		b.maximize();
		b.implicitwait();
		b.loadUrl("https://adactinhotelapp.com/");
		String pathname="C:\\Users\\mohan\\eclipse-workspace\\Frameworks\\Excel Sheets\\AdactinRoomBooking.xlsx";
		String sheetName="Sheet1";
		WebElement txtUsername = b.findElementById("username");
		String name= b.getData(pathname,sheetName,1,0);
		b.type(txtUsername, name);
		WebElement txtpassword = b.findElementById("password");
		String password = b.getData(pathname,sheetName,1,1);
		b.type(txtpassword, password);
		b.findElementByName("login").click();
		WebElement dDnLocation = b.findElementById("location");
		b.selectOptionValue(dDnLocation,"Melbourne");
		String loctionValue = b.getAttributeValue(dDnLocation);
		b.createCell(pathname, sheetName, 1, 7, loctionValue);
		WebElement dDnHotel= b.findElementByName("hotels");
		b.selectOptionValue(dDnHotel, "Hotel Sunshine");
		String hotelName = b.getAttributeValue(dDnHotel);
		b.createCell(pathname, sheetName, 1,8, hotelName);
		WebElement dDnRoomType = b.findElementById("room_type");
		b.selectOptionValue( dDnRoomType,"Super Deluxe");
		String roomType = b.getAttributeValue(dDnRoomType);
		b.createCell(pathname, sheetName, 1, 9, roomType);
		WebElement dDnNoOfRoom = b.findElementById("room_nos");
		b.selectOptionValue(dDnNoOfRoom, "10");
		String noOfRooms = b.getAttributeValue(dDnNoOfRoom);
		b.createCell(pathname, sheetName, 1, 10, noOfRooms);
		WebElement dDnCheckInDate= b.findElementById("datepick_in");
		b.type(dDnCheckInDate, "03/07/2022");
		WebElement dDnCheckOutDate = b.findElementById("datepick_out");
		b.type(dDnCheckOutDate, "04/07/2022");
		WebElement dDnAdultPerRoom = b.findElementById("adult_room");
		b.selectOptionValue(dDnAdultPerRoom, "4");
		WebElement dDnChildPerRoom = b.findElementById("child_room");
		b.selectOptionValue(dDnChildPerRoom, "2");
		b.findElementById("Submit").click();
		b.findElementById("radiobutton_0").click();
		b.findElementById("continue").click();
		WebElement txtFirstName = b.findElementByName("first_name");
		String firstname = b.getData(pathname, sheetName,1,2);
		b.type(txtFirstName, firstname);
		WebElement txtLastName = b.findElementById("last_name");
		String lastname = b.getData(pathname, sheetName,1,3);
		b.type(txtLastName, lastname);
		WebElement txtAddress = b.findElementById("address");
		String address = b.getData(pathname, sheetName,1,4);
		b.type(txtAddress, address);
		WebElement creditCardNo = b.findElementById("cc_num");
		String CreditCard = b.getData(pathname, sheetName,1,5);
		b.type(creditCardNo, CreditCard);
		WebElement dDnCardType = b.findElementById("cc_type");
		b.selectOptionValue(dDnCardType, "MAST");
		WebElement dDnmonth = b.findElementById("cc_exp_month");
		b.selectOptionValue(dDnmonth, "10");
		WebElement dDnYear = b.findElementById("cc_exp_year");
		b.selectOptionValue(dDnYear, "2022");
		WebElement txtCreditCVV = b.findElementById("cc_cvv");
		String cvv = b.getData(pathname, sheetName,1,6);
		b.type(txtCreditCVV, cvv);
		b.findElementById("book_now").click();
		WebElement totalDays= b.findElementById("total_days_dis");
		String totalDay = b.getAttributeValue(totalDays);
		b.createCell(pathname, sheetName, 1,11,totalDay);
		WebElement pricePerNight= b.findElementById("price_night_dis");
		String oneNightPrice = b.getAttributeValue(pricePerNight);
		b.createCell(pathname, sheetName, 1, 12, oneNightPrice);
		WebElement totalPrice = b.findElementById("total_price_dis");
		String price = b.getAttributeValue(totalPrice);
		b.createCell(pathname, sheetName, 1, 13, price);
		WebElement gst = b.findElementById("gst_dis");
		String GST = b.getAttributeValue(gst);
		b.createCell(pathname, sheetName, 1, 14, GST);
		WebElement finalPrice = b.findElementById("final_price_dis");
		String finalBill = b.getAttributeValue(finalPrice);
		b.createCell(pathname, sheetName, 1, 15, finalBill);
		WebElement orderId = b.findElementById("order_no");
		String value = b.getAttributeValue(orderId);
		b.createCell(pathname, sheetName, 1,16,value);
		b.closeAllWindow();
}

}
