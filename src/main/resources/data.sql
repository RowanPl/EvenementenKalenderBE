insert into roles(rolename) values ('USER'), ('ADMIN');

--   username: karel, password: appel
insert into users(username, password, enabled, email, creator, newsletter) values ('karel', '$2a$12$v3hpM1z6mh.ITK9UdFeeiOHOaRzvrlLCCGQc9tyZi718XWXWmLub6', true , 'Karel@Appel.nl' , false, true ) ;

INSERT INTO file_upload_response (file_name, content_type, url) VALUES (
                                                                 'IMG_20220526_192046.jpg',
                                                                 'image/jpeg',
                                                                 'http://localhost:8080/download/IMG_20220526_192046.jpg'
                                                             );


INSERT INTO event (id,name_of_event, link_to_event, time, more_information, location, event_type, event_creator)
VALUES ( 3, 'test','spelgroep.nl', '20:00', 'There is no more info','Bennekom', 'Theater', 'karel' );

-- UPDATE event_dates SET dates = ARRAY['2023-05-05'::date] WHERE id = 3;

insert into event_dates (event_id) values (3);
UPDATE event_dates SET dates = '2023-05-15' WHERE event_id = 3;

update event SET file = 'IMG_20220526_192046.jpg' WHERE id = 3;


