INSERT INTO TICKET VALUES (1, 'KIN-41', 1, 2, 1, null, 1, 2, 'New bug. Ui not working', 30, 'unresolved', 'Linux ubuntu', current timestamp, current timestamp, 1);
INSERT INTO TICKET VALUES (2, 'CMD-52', 2, 1, 1, null, 1, 1, 'New bug. Login not working', 40, 'unresolved', 'Windows XP', current timestamp, current timestamp, 1);
INSERT INTO TICKET VALUES (3, 'LIVE-21', 2, 2, 3, null, 1, 1, 'New bug. Local not working', 50, 'unresolved', 'Windows 7', current timestamp, current timestamp, 1);
INSERT INTO TICKET VALUES (4, 'LIVE-41', 3, 2, 1, null, 1, 2, 'New bug. Change status not working', 60, 'unresolved', 'Windows Vista', current timestamp, current timestamp, 1);
INSERT INTO TICKET VALUES (5, 'CMD-41', 4, 2, 2, null, 2, 2, 'New bug. Admin page not working', 70, 'unresolved', 'Linux ubuntu', current timestamp, current timestamp, 1);
INSERT INTO TICKET VALUES (6, 'LIVE-51', 2, 2, 3, null, 1, 1, 'Story. Login functionality', 50, 'unresolved', 'Windows 7', current timestamp, current timestamp, 1);
INSERT INTO TICKET VALUES (7, 'LIVE-91', 3, 2, 1, null, 1, 2, 'Story. Add new ticket sunction', 60, 'unresolved', 'Windows Vista', current timestamp, current timestamp, 1);
INSERT INTO TICKET VALUES (8, 'CMD-31', 4, 2, 2, null, 2, 2, 'New bug. Autorization is not working properly', 70, 'unresolved', 'Linux ubuntu', current timestamp, current timestamp, 1);



UPDATE TICKET set PARENT_TICKET = 1 WHERE ID <> 1;