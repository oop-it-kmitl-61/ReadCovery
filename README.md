# Readcovery
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)  
ReadCovery เป็นโปรแกรมที่ช่วยในการแนะนำบทความที่น่าสนใจโดยสามารถเลือกหมวดหมู่ที่ชอบได้ ทำให้เราสามารถอ่านบทความในหมวดหมู่ที่เราสนใจได้อย่างง่ายดาย
โดยหมวดหมู่ที่ผู้ใช้งานสามารถเลือกได้จะมีดังนี้

  - Random เป็นการสุ่มจากบทความทั้งหมด
  - Political บทความด้านการเมือง
  - Sport บทความด้านกีฬา
  - Entertainment บทความด้านความบันเทิง
  - Technology บทความด้านเทคโนโลยี
  ## Library ที่ใช้
  - [JFoenix](https://github.com/jfoenixadmin/JFoenix) เป็น Library GUI component บน JavaFX ช่วยให้การออกแบบง่ายขึ้น
  - [Json - Java](https://github.com/stleary/JSON-java) เป็น Library ที่ใช้ในการจัดการ JSON บนภาษา Java
  
  ![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Working.png)    

> โดยโปรแกรมจะมี 2 ฝั่งคือ ฝั่ง Server และ Client โดยรูปแบบข้อมูลที่สื่อสารกันเป็นรูปแบบ JSON โดยฝั่ง Server จะติดต่อกับระบบฐานข้อมูล MySQL อีกต่อหนึ่ง โดย Client นั้น ใช้ JavaFX ในการพัฒนาระบบ User Interface และฝั่ง Server ใช้ Spring Boot ในการพัฒนา
 ## วิธีการใช้งาน

  สามารถเรียกใช้โปรแกรมได้โดยใช้ JDK  เวอร์ชัน 1.8 และทำการดับเบิ้ลคลิกที่ไฟล์ Readcovery.jar 
  หากไม่มีอะไรเกิดขึ้นให้ทำการเปิดไฟล์ด้วย Command โดยเข้าไปที่ cmd แล้วเข้าไปที่โฟลเดอร์ของไฟล์
  จากนั้นพิมพ์คำสั่ง
   ```
   java -jar Readcovery.jar
   ```
  เพื่อเปิดโปรแกรม
  
  ![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Login.png)    
  เมื่อเปิดขึ้นมาแล้วจะพบกับหน้า Login หากมีบัญชีผู้ใช้แล้วสามารถใช้ Email และ Password เข้าใช้ได้ทันที  
  แต่หากยังไม่มีบัญชีให้ทำการสมัครที่ปุ่ม Register    
  ![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/register.png)    
  สามารถลงทะเบียนได้โดยการกรอกข้อมูลให้ครบ แล้วกดปุ่ม Register  
  จากนั้นสามารถใช้ Email และ Password ที่ทำการลงทะเบียนไว้เพื่อเข้าสู่ระบบได้ทันที    
  ![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/next.png)    
  เมื่อเข้าสู่ระบบจะพบกับบทความที่ถูกสุ่มขึ้นมาจากหมวดหมู่ที่ชอบโดยสามารถกดลูกศรทางด้านขวาเพื่อสุ่มบทความใหม่ได้    
  ![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/back.png)    
หรือหากต้องการย้อนกลับก็สามารถกดที่ลูกศรทางด้านซ้ายเผื่อย้อนกลับได้ แต่สามารถย้อนกลับได้เพียงครั้งเดียวเท่านั้น    
 ![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/readnow.png)    
ถ้าต้องการอ่านบทความนี้ทันทีให้กดที่ปุ่ม Read now!    
 ![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/open.png)    
เมื่อกดปุ่ม Read now! แล้ว เบราว์เซอร์จะทำการเปิดบทความนั้นเพื่ออ่านทันทีได้    
 ![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/save.png)    
หรือหากยังไม่ต้องการอ่านทันที แต่ต้องการเก็บไว้อ่านในภายหลัง ให้กดที่ปุ่ม Save
เพื่อเก็บเอาไว้อ่านในภายหลัง    
![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/saveList.png)    
บทความที่ถูกบันทึกไว้จะเข้าไปอยู่ใน SaveList ซึ่งสามารถเข้าถึงได้ที่ปุ่ม SaveList ด้านบน  
หากต้องการอ่านให้คลิกที่ชื่อบทความแล้วกดที่ปุ่ม Read เพื่อทำการอ่าน    
 ![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/ReadList.png)    
บทความที่เคยอ่านไปแล้วทั้งหมดจะปรากฏอยู่ที่ ReadList ซึ่งอยู่ด้านบนเช่นเดียวกัน
หากต้องการอ่านอีกครั้งให้กดที่ชื่อบทความแล้วกด Read Again    
![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/edit.png)    
สามารถเข้ามาเปลี่ยนหมวดหมู่ที่ชอบได้ที่ปุ่ม Profile ด้านบน เมื่อเปลี่ยนเสร็จแล้วให้กดที่ Save Setting  
หรือหากต้องการออกจากระบบให้กดที่ปุ่ม Logout ด้านล่าง    
![](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Login.png)    
เมื่อออกจากระบบแล้ว โปรแกรมจะกลับเข้าสู่หน้า Login    
 ## ![](https://github.com/compro-itkmitl/Bomberman/blob/master/picreadme/Human.png)Team Members
|  | ชื่อ | นามสกุล | GitHub Username | รหัสนักศึกษา |
|--|--|--|--|--|
| ![Fluk](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Fluke.png) | นายพงศธร| กิตติวรปัญญา | [@Phongsathron](https://github.com/Phongsathron) | 60070055 |
| ![Net](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Net.png) | นายพิชญพล| เพชรบุญช่วย | [@TheNlesh](https://github.com/TheNlesh) | 60070062 |
| ![Gunn](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Gunn.png) | นายพุฒิเมธ | ธรรมแสง | [@jusmistic](https://github.com/jusmistic) | 60070068|


# ![](https://github.com/compro-itkmitl/Bomberman/blob/master/picreadme/Supervisor.png)Assistant Teachers
| ผศ.ดร. ธนิศา นุ่มนนท์  |
| ------ |
| ![Professor](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Professor.png)

รายงานนี้เป็นส่วนหนึ่งของวิชา OBJECT-ORIENTED PROGRAMMING (06016317)
คณะเทคโนโลยีสารสนเทศ สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง
***

Faculty of Information Technology
King Mongkut's Institute of Technology Ladkrabang

***
