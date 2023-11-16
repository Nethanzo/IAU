/**
 * پروژه کلاسی درس برنامه نویسی موبایل
 * پیاده سازی یک کتابخانه کوچک به کمک شیء گرایی
 * نام دانشجو: علی اسماعیلی دیزناب
 */
import java.awt.Choice;
import java.util.Dictionary; // برای نگهداری لیست کتاب ها از دیکشنری استفاده شده است
import java.util.Hashtable;
import java.util.Scanner;

// تعریف کلاس اصلی
class Book {

    //صفات کلاس
    private int ISBN;
    private String bookName;
    Dictionary<Integer, String> dict = new Hashtable<>();
   
    
    // گتر برای دیکشنری
    public Dictionary<Integer, String> getDict() {
        return dict;
    }

    //ISBN Getter
    public int getISBN() {
        return this.ISBN;
    }
    
    //ISBN Setter
    public void setISBN(int iSBN) {
        this.ISBN = iSBN;
    }
    
    //Book Name Getter
    public String getBookName() {
        return this.bookName;
    }
    
    //Book Name Setter
    public void setBookName(String bn) {
        bookName = bn;
    }

    // متد اضافه کردن کتاب
    public void addBook(Integer id, String name) {
        dict.put(id, name);

    }
    
    //متد نمایش نام کتاب
    public String showbook(Integer id) {
        return dict.get(id);
    }

    //متد حذف کتاب
    public void rmBook(Integer id) {
        dict.remove(id);
    }

    // متد نمایش تعداد کتاب های ثبت شده
    public int totalBooks() {
        return dict.size();
    }

    //متد ایستای پاک کردن صفحه
    static public void cls() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    // متد ایستا برای نمایش منو که منو را نمایش داده و انتخاب کاربر را بر میگرداند
    static public int showMenu() {

        int userchoice;
        Scanner choice = new Scanner(System.in);
        cls();  
        System.out.println("Welcome to Book Keeper Program");
        System.out.println("What Do You Want Me To Do?");
        System.out.println("******************************");
        System.out.println("1 - Add a Book");
        System.out.println("2 - Delete a Book");
        System.out.println("3 - Show Books");
        System.out.println("4 - Exit");

        userchoice = choice.nextInt();
        return userchoice;
    }
    
    

    



    // بدنه اصلی برنامه 
    public static void main(String[] args) {

        Scanner enterid = new Scanner(System.in); //برای دریافت شماره کتاب از کاربر
        Scanner entername = new Scanner(System.in); // برای دریافت نام کتاب از کاربر

        int item;
        int bid;
        String bname;
        Book bk = new Book(); //ایجاد یک نمونه از کلاس
        
        boolean ch = true; //متفیر برای کنترل حلقه 
        
        do {
            item = showMenu(); //نمایش منو و دریافت ورودی کاربر
            try { //برای گرفتن خطای ورودی غیر عددی کاربر
                switch (item) {
                case 1:{ //گزینه اول منو
                    
                    cls();
                    System.out.println("Add Book");
                    System.out.println("****************************");
                    System.out.print("Please Enter Book ID: ");
                    bid = enterid.nextInt();
                    System.out.print("Please Enter Book Name: ");
                    bname = entername.nextLine();
                    bk.addBook(bid, bname);
                    System.out.println(bname + " Added Successfully!");

                    
                    
                    
                    
                 // این قسمت برای ایجاد تاخیر زمانی استفاده شده است   
                    try {
                        Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                   break;
                    
                    
                }
                case 2:{ //گزینه دوم منو

                    int booktodel;
                    Scanner btd = new Scanner(System.in);
                    if (bk.getDict().isEmpty()) { // بررسی خالی نبودن کتابخانه
                    cls();
                    System.out.println("The Library is Empty!");
                    System.out.println("Press Any Key to Continue!");
                    
                    //برای گرفتن هر کلید ورودی کاربر جهت ادامه کار
                    try {
                        System.in.read();
                    }  
                    catch(Exception e)
                    {}
                    break;  

                    }
                    else {
                        cls();
                        System.out.println("Delete A Book");
                        System.out.println("*******************************");
                        System.out.println("You can find book ID from Show Menu");
                        System.out.print("Enter Book ID to Delete: ");
                        booktodel = btd.nextInt();
                        try { //گرفتن خطای ورودی نامناسب کاربر
                        bk.rmBook(booktodel);
                        System.out.println("The Book Has Deleted Successfully!");
                        System.out.println("Press Any Key to Continue!");
                        try {
                            System.in.read();
                        }  
                        catch(Exception e)
                        {}
                        }
                        catch (Exception e) {
                            System.out.println("An Error Occurd... Please Try Again!");
                        }


                        
                        // راه حل موقت برای شمارش کلیدها و مقادیر دیکشنری
                        for (int i=0; i < 1000; i++)
                        {
                                if (bk.showbook(i) != null) {
                                System.out.println(i + "             "+bk.showbook(i));
                                }
                        
                        }

                    break;
                }
            }
                case 3:{ //گزینه سوم منو
                    if (bk.getDict().isEmpty()) {
                    cls();

                    System.out.println("The Library is Empty!");
                    System.out.println("Press Any Key to Continue!");
                    try {
                        System.in.read();
                    }  
                    catch(Exception e)
                    {}
                    break;  

                    }
                    else {
                        cls();
                        System.out.println("ID            Name              ");
                        System.out.println("----          -----------------------------------");
                        
                       
                        for (int i=0; i < 1000; i++)
                        {
                                if (bk.showbook(i) != null) {
                                System.out.println(i + "             "+bk.showbook(i));
                                }
                        
                        }
                        
                        
                      


                        System.out.println("--------------------------------------------------");
                        System.out.println("Press Any Key to Continue!");
                        try {
                            System.in.read();
                        }  
                        catch(Exception e)
                        {
                            
                        } 
                    break;
                    } 
                    
                    
                  
                    
                }
                case 4:{ //خروج از برنامه
                    System.out.println("Goobye!");
                    enterid.close();
                    entername.close();
                   
                    ch = false;

                    break;
                }
                case 0: {
                    break;
                }
                default:
                {
                System.out.println("Bad Choice.. Try Again!");
                break;
                
                }
            
            }
        }
        catch (Exception e) {
                System.out.println("Only 1,2,3 or 4. Run me Again!!! As Penalty...");
                ch = false;
            } 
            
                   
        } while (ch);
       
        
    }
}
        

