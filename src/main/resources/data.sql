insert into roles(rolename) values ('USER'), ('ADMIN');


INSERT INTO event_creator (id, name, email, phone_number, website, description, location)
values ( 1, 'Spelgroep Bennekom', 'spelgroep@bennekom.nl', '0612345678', 'spelgroep.nl', 'Spelgroep Bennekom is een amateur toneelvereniging die al sinds 1945 bestaat. Wij spelen jaarlijks een voorstelling in het voorjaar en in het najaar. Daarnaast organiseren wij ook andere activiteiten zoals een open podium en een theaterweekend. ', 'Bennekom' );



--   username: karel, password: appel
insert into users(username, password, enabled, email, newsletter, event_creator_id) values ('karel', '$2a$12$v3hpM1z6mh.ITK9UdFeeiOHOaRzvrlLCCGQc9tyZi718XWXWmLub6', true , 'Karel@Appel.nl' , true ,1 ) ;
--   username: admin, password: admin
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED, email ,newsletter) values ('admin', '$2a$10$vJjo.WnrqfGvTX3T2608TOil6Bs2p1GAKJFZ0f7NYJSQY.jXj80nC' , true , 'admin@tester.nl' , false ) ;
--   username: user, password: user
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED, email ,newsletter) values ('user', '$2a$10$uZRBZszSel1eenr1nw/6U.kBC1IqHsnyYMKK3f.ThL3OfkTnaafTm' , true , 'user@tester.nl' , false ) ;

insert into authorities(username, authority) values ('admin', 'ADMIN');
insert into authorities(username, authority) values ('user', 'USER');
insert into authorities(username, authority) values ('karel', 'USER');


INSERT INTO file_upload_response (file_name, content_type, url) VALUES (
                                                                 'Flyer-De-nieuwe-kleren-van-de-keizer-voorkant-211x300.jpg',
                                                                 'image/jpeg',
                                                                 'http://localhost:8080/download/Flyer-De-nieuwe-kleren-van-de-keizer-voorkant-211x300.jpg'
                                                             );




INSERT INTO event (id,name_of_event, link_to_event, time, more_information, location, event_type, event_creator_id)
VALUES ( 3001, 'De Nieuwe Kleren van de keizer','spelgroep.nl', '20:00', '
Koning, keizer, admiraal,
Wat lopen ze er prachtig bij allemaal.
Zo mooi als de keizer is ongewoon
In al zijn kleren paradeert hij met zijn kroon.
De keizer is ijdel en wil telkens iets nieuws proberen,
Een jasje, broek, stropdas, alles doet hij voor zijn kleren.
Toch is er niets wat hem echt kan bekoren,
Hij kijkt in de spiegel en voelt zich verloren.
Dan komt zijn dochter met een bijzonder plan… ','Bennekom', 'THEATER', 1),

    ( 3002, 'De Nieuwe Kleren van de keizer','spelgroep.nl', '20:00', ' Koning, keizer, admiraal, Wat lopen ze er prachtig bij allemaal. Zo mooi als de keizer is ongewoon In al zijn kleren paradeert hij met zijn kroon. De keizer is ijdel en wil telkens iets nieuws proberen, Een jasje, broek, stropdas, alles doet hij voor zijn kleren. Toch is er niets wat hem echt kan bekoren, Hij kijkt in de spiegel en voelt zich verloren. Dan komt zijn dochter met een bijzonder plan… ','Bennekom', 'THEATER', 1),

    ( 3003, 'De Nieuwe Kleren van de keizer','spelgroep.nl', '20:00', ' Koning, keizer, admiraal, Wat lopen ze er prachtig bij allemaal. Zo mooi als de keizer is ongewoon In al zijn kleren paradeert hij met zijn kroon. De keizer is ijdel en wil telkens iets nieuws proberen, Een jasje, broek, stropdas, alles doet hij voor zijn kleren. Toch is er niets wat hem echt kan bekoren, Hij kijkt in de spiegel en voelt zich verloren. Dan komt zijn dochter met een bijzonder plan… ','Bennekom', 'THEATER', 1),

    ( 3004, 'De Nieuwe Kleren van de keizer','spelgroep.nl', '20:00', ' Koning, keizer, admiraal, Wat lopen ze er prachtig bij allemaal. Zo mooi als de keizer is ongewoon In al zijn kleren paradeert hij met zijn kroon. De keizer is ijdel en wil telkens iets nieuws proberen, Een jasje, broek, stropdas, alles doet hij voor zijn kleren. Toch is er niets wat hem echt kan bekoren, Hij kijkt in de spiegel en voelt zich verloren. Dan komt zijn dochter met een bijzonder plan… ','Bennekom', 'THEATER', 1);

insert into event_dates (event_id) values (3001);
UPDATE event_dates SET dates = '2023-05-15' WHERE event_id = 3001;

update event SET file = 'Flyer-De-nieuwe-kleren-van-de-keizer-voorkant-211x300.jpg' WHERE id = 3001;


