ws [Version 10.0.18363.657]
(c) 2019 Microsoft Corporation. All rights reserved.

C:\Users\Vanshika>sqlplus

SQL*Plus: Release 11.2.0.2.0 Production on Wed Feb 19 10:04:27 2020

Copyright (c) 1982, 2014, Oracle.  All rights reserved.

Enter user-name: system
Enter password:

Connected to:
Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production

SQL> create table transaction(accountId varchar2(20),sdate date,debit number(10,2),credit number(10,2),totalamount number(10,2));

Table created.

SQL> insert into transaction values('12345678901234567890','19-01-2020',500,0,56000);
insert into transaction values('12345678901234567890','19-01-2020',500,0,56000)
                                                      *
ERROR at line 1:
ORA-01843: not a valid month


SQL> insert into transaction values('12345678901234567890','2020-02-19',500,0,56000);
insert into transaction values('12345678901234567890','2020-02-19',500,0,56000)
                                                      *
ERROR at line 1:
ORA-01861: literal does not match format string


SQL> insert into transaction values('12345678901234567890',2020-02-19,500,0,56000);
insert into transaction values('12345678901234567890',2020-02-19,500,0,56000)
                                                             *
ERROR at line 1:
ORA-00932: inconsistent datatypes: expected DATE got NUMBER


SQL> insert into transaction values('12345678901234567890',DATE '2020-01-02,500,0,56000);
ERROR:
ORA-01756: quoted string not properly terminated


SQL> desc transaction;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ACCOUNTID                                          VARCHAR2(20)
 SDATE                                              DATE
 DEBIT                                              NUMBER(10,2)
 CREDIT                                             NUMBER(10,2)
 TOTALAMOUNT                                        NUMBER(10,2)

SQL> select sysdate;
select sysdate
             *
ERROR at line 1:
ORA-00923: FROM keyword not found where expected


SQL> select sysdate from dual;;
select sysdate from dual;
                        *
ERROR at line 1:
ORA-00911: invalid character


SQL> select sysdate from dual;

SYSDATE
---------
19-FEB-20

SQL> insert into transaction values('12345678901234567890', '20-jan-20',500,0,56000);

1 row created.

SQL> insert into transaction values('12345678901234567890', '21-jan-20',0,500,56500);

1 row created.

SQL> insert into transaction values('12345678901234567890', '22-jan-20',0,500,57000);

1 row created.

SQL> insert into transaction values('12345678901234567890', '23-jan-20',0,500,57500);

1 row created.

SQL> insert into transaction values('12345678901234567890', '24-jan-20',0,500,5800);

1 row created.

SQL>
SQL>
SQL> commit;

Commit complete.

SQL> select * from transaction;

ACCOUNTID            SDATE          DEBIT     CREDIT TOTALAMOUNT
-------------------- --------- ---------- ---------- -----------
12345678901234567890 20-JAN-20        500          0       56000
12345678901234567890 21-JAN-20          0        500       56500
12345678901234567890 22-JAN-20          0        500       57000
12345678901234567890 23-JAN-20          0        500       57500
12345678901234567890 24-JAN-20          0        500        5800

SQL> select sysdate from dual;

SYSDATE
---------
19-FEB-20

SQL> select * from transaction where accountId=? and date between '20-jan-20' and '24-jan-20' ;
select * from transaction where accountId=? and date between '20-jan-20' and '24-jan-20'
                                          *
ERROR at line 1:
ORA-00911: invalid character


SQL> select * from transaction where accountId=12345678901234567890 and date between '20-jan-20' and '24-jan-20' ;
select * from transaction where accountId=12345678901234567890 and date between '20-jan-20' and '24-jan-20'
                                                                   *
ERROR at line 1:
ORA-00936: missing expression


SQL> select * from transaction where accountId=12345678901234567890 and sdate between '20-jan-20' and '24-jan-20' ;

ACCOUNTID            SDATE          DEBIT     CREDIT TOTALAMOUNT
-------------------- --------- ---------- ---------- -----------
12345678901234567890 20-JAN-20        500          0       56000
12345678901234567890 21-JAN-20          0        500       56500
12345678901234567890 22-JAN-20          0        500       57000
12345678901234567890 23-JAN-20          0        500       57500
12345678901234567890 24-JAN-20          0        500        5800

SQL>
SQL>
SQL>
SQL>
SQL> desc transaction;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ACCOUNTID                                          VARCHAR2(20)
 SDATE                                              DATE
 DEBIT                                              NUMBER(10,2)
 CREDIT                                             NUMBER(10,2)
 TOTALAMOUNT                                        NUMBER(10,2)

SQL> select * from transaction where accountId=12345678901234567890 and sdate between '20-jan-20' and '24-jan-20' ;

ACCOUNTID            SDATE          DEBIT     CREDIT TOTALAMOUNT
-------------------- --------- ---------- ---------- -----------
12345678901234567890 20-JAN-20        500          0       56000
12345678901234567890 21-JAN-20          0        500       56500
12345678901234567890 22-JAN-20          0        500       57000
12345678901234567890 23-JAN-20          0        500       57500
12345678901234567890 24-JAN-20          0        500        5800

SQL> insert into transaction values('1234567890', '01-feb-20',0,500,60000);

1 row created.

SQL> insert into transaction values('1234567890', '02-feb-20',0,500,60500);

1 row created.

SQL> insert into transaction values('1234567890', '03-feb-20',0,500,61000);

1 row created.

SQL> insert into transaction values('1234567890', '04-feb-20',1000,0,60000);

1 row created.

SQL> insert into transaction values('1234567890', '05-feb-20',1000,0,59000);

1 row created.

SQL> insert into transaction values('1234567890', '06-feb-20',0,3000,62000);

1 row created.

SQL> commit;

Commit complete.

SQL> select * from transaction;

ACCOUNTID            SDATE          DEBIT     CREDIT TOTALAMOUNT
-------------------- --------- ---------- ---------- -----------
12345678901234567890 20-JAN-20        500          0       56000
12345678901234567890 21-JAN-20          0        500       56500
12345678901234567890 22-JAN-20          0        500       57000
12345678901234567890 23-JAN-20          0        500       57500
12345678901234567890 24-JAN-20          0        500        5800
1234567890           01-FEB-20          0        500       60000
1234567890           02-FEB-20          0        500       60500
1234567890           03-FEB-20          0        500       61000
1234567890           04-FEB-20       1000          0       60000
1234567890           05-FEB-20       1000          0       59000
1234567890           06-FEB-20          0       3000       62000

11 rows selected.