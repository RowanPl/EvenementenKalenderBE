insert into roles(rolename) values ('USER'), ('ADMIN');

--   username: karel, password: appel
insert into users(username, password, enabled, email, creator, newsletter) values ('karel', '$2a$12$v3hpM1z6mh.ITK9UdFeeiOHOaRzvrlLCCGQc9tyZi718XWXWmLub6', true , 'Karel@Appel.nl' , true, true ) ;
--   username: admin, password: admin
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED, email, creator ,newsletter) values ('admin', '$2a$10$vJjo.WnrqfGvTX3T2608TOil6Bs2p1GAKJFZ0f7NYJSQY.jXj80nC' , true , 'admin@tester.nl' , false, false ) ;
--   username: user, password: user
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED, email, creator ,newsletter) values ('user', '$2a$10$uZRBZszSel1eenr1nw/6U.kBC1IqHsnyYMKK3f.ThL3OfkTnaafTm' , true , 'user@tester.nl' , false, false ) ;

insert into authorities(username, authority) values ('admin', 'ADMIN');
insert into authorities(username, authority) values ('user', 'USER');
insert into authorities(username, authority) values ('karel', 'CREATOR');


INSERT INTO file_upload_response (file_name, content_type, url) VALUES (
                                                                 'Flyer-De-nieuwe-kleren-van-de-keizer-voorkant-211x300.jpg',
                                                                 'image/jpeg',
                                                                 'http://localhost:8080/download/Flyer-De-nieuwe-kleren-van-de-keizer-voorkant-211x300.jpg'
                                                             );

INSERT INTO event (id,name_of_event, link_to_event, time, more_information, location, event_type, event_creator)
VALUES ( 3001, 'De Nieuwe Kleren van de keizer','spelgroep.nl', '20:00', '
Koning, keizer, admiraal,
Wat lopen ze er prachtig bij allemaal.
Zo mooi als de keizer is ongewoon
In al zijn kleren paradeert hij met zijn kroon.
De keizer is ijdel en wil telkens iets nieuws proberen,
Een jasje, broek, stropdas, alles doet hij voor zijn kleren.
Toch is er niets wat hem echt kan bekoren,
Hij kijkt in de spiegel en voelt zich verloren.
Dan komt zijn dochter met een bijzonder plan… ','Bennekom', 'Theater', 'Spelgroep Bennekom' );

insert into event_dates (event_id) values (3001);
UPDATE event_dates SET dates = '2023-05-15' WHERE event_id = 3001;

update event SET file = 'Flyer-De-nieuwe-kleren-van-de-keizer-voorkant-211x300.jpg' WHERE id = 3001;


