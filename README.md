Automation tests for the CarinderiaOMS system
=======

Overview
-----------
This repo contains basic testing scripts using Java on a simple OMS that I built using PHP/MySQL/Apache.    

Automation technologies used:
   * Selenium Webdriver
   * Java
   * Firepath / Firebug



Installation
-----------
   * XAMPP - I used the [XAMPP](https://www.apachefriends.org/index.html) bundle to make things easy to install.  
   * MySQL database - Table structure can be found in the repo and they are the only 3 JPG files in there.  Will probably create a script in the future to create these tables on the fly.
   * PHPExcel - [PHPExcel on GitHub](https://github.com/PHPOffice/PHPExcel) is a PHP class that enables extracted data to be inserted into a Microsoft Excel file.  This was used for the export functionality.

   
Caveats
-------------
The security aspect of this system is not very good but I did add some input validations as there are a lot of forms in this software.  Before using this software, please make sure to implement safeguards at the MySQL level (i.e. Admin user/password for database, super users, etc...).