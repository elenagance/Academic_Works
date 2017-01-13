//*******************************
//
// Zip code class
//
// This is a template for your zip code class
// You may add methods and instance variables to this
// class but your code must work with the provided test class ZipTest.java
//
//Elena Gladoun
//eg2850
//*******************************


public class Zipcode{


    private String zipcode;
    private String barcode;
    private String convertedZip;
    private String convertedBar;

    //for inputs that are zip codes 
    public Zipcode(int zip_number){
    	//make zip number into string zipcode 
    	zipcode=""+zip_number;
    	if (zipcode.length()<5 || zipcode.length()>5){
    		System.out.println("That is an invalid Zipcode");
    	}
    	else{
    		barcode=""; 
    		convertedZip="";
    		this.getChecker();
    		this.zipConvert();
    		this.createBarCode();
    	}
    }
    
    //for inputs that are barcodes
    public Zipcode(String bar_code){
    	barcode = bar_code;
    	if(barcode.length()<32||barcode.length()>32){
    		System.out.println("Invalid input");
    	}
    	else{
    		zipcode=""; 
    		convertedBar="";
    		this.convertBar();
    		this.barToZip();
    	}
    }

   // you will need to add more your own methods here
 
    public void getChecker(){
    	int sum = 0;
    	for(int i=0;i<zipcode.length();i++){
    		char ch = zipcode.charAt(i);
    		int dig = Character.getNumericValue(ch);
    		sum+=dig;
    	}
    	int rem = sum%10; 
    	int check = 10-rem; 
    	zipcode= zipcode+check; 
    }
    
    //loop through the zip code, to add sum and to create the 1s and 0s
    public void zipConvert(){
    	for(int i=0;i<zipcode.length(); i++){
    		//take number and convert to its code 
    		char ch = zipcode.charAt(i); 
    		if (ch=='1'){
    			convertedZip=convertedZip+"00011";
    		}
    		if (ch=='2'){
    			convertedZip=convertedZip+"00101";
    		}
    		if (ch=='3'){
    			convertedZip=convertedZip+"00111";
    		}
    		if (ch=='4'){
    			convertedZip=convertedZip+"01000";
    		}
    		if (ch=='5'){
    			convertedZip=convertedZip+"01011";
    		}
    		if (ch=='6'){
    			convertedZip=convertedZip+"01100";
    		}
    		if (ch=='7'){
    			convertedZip=convertedZip+"10000";
    		}
    		if (ch=='8'){
    			convertedZip=convertedZip+"10011";
    		}
    		if (ch=='9'){
    			convertedZip=convertedZip+"10100";
    		}
    		if (ch=='0'){
    			convertedZip=convertedZip+"11000";
    		}
    	}
    	
    }
    //convert to a bar code 
    //loop through convertedZip and convert to : and | w/ borders 
    public void createBarCode(){
    	barcode = barcode+"|";
    	for(int i=0;i<convertedZip.length(); i++){
    		char ch = convertedZip.charAt(i); 
    		if (ch=='1'){
    			barcode=barcode+"|";
    		}
    		if (ch=='0'){
    			barcode=barcode+":";
    		}
    	}
    	barcode = barcode+"|";
    }
    
    //obtain zipcode from bar code. 
    //loop through the code and convert to 1s and 0s, 
    //skipping the first and six(border+check digit)
    public void convertBar(){
    	if(barcode.length()==32){
    		for (int i=1; i<(barcode.length()-6); i++){
    			char ch = barcode.charAt(i); 
    			if (ch=='|'){
    				convertedBar=convertedBar+"1";
    			}
    			if (ch==':'){
    				convertedBar=convertedBar+"0";
    			}
    			if (ch!=':'&&ch!='|'){
    				System.out.println("that was an invalid bar code");
    			}
    		}
    	}
    }
    
    //loop through converted Bar using code
    public void barToZip(){
    	for(int i=0;i<convertedBar.length(); i+=5){
    		//take substring of i - i+5 (digit length)
    		String st=convertedBar.substring(i,i+5);
    		//evaluate string 
    		if (st.equals("00011")){
    			zipcode=zipcode+"1";
    		}
    		if (st.equals("00101")){
    			zipcode=zipcode+"2";
    		}
    		if (st.equals("00111")){
    			zipcode=zipcode+"3";
    		}
    		if (st.equals("01000")){
    			zipcode=zipcode+"4";
    		}
    		if (st.equals("01011")){
    			zipcode=zipcode+"5";
    		}
    		if (st.equals("01100")){
    			zipcode=zipcode+"6";
    		}
    		if (st.equals("10000")){
    			zipcode=zipcode+"7";
    		}
    		if (st.equals("10011")){
    			zipcode=zipcode+"8";
    		}
    		if (st.equals("10100")){
    			zipcode=zipcode+"9";
    		}
    		if (st.equals("11000")){
    			zipcode=zipcode+"0";
    		}
    	}
    }
    
    
	//leave this method as is

    public String getBarcode(){
    	return barcode;
   
    }

    public String getZipcode(){
    	return zipcode; 
    	
    }
}


