USE music_store;
-- user roles
INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'MODERATOR');
INSERT INTO roles (id, role)
VALUES (3, 'USER');

INSERT INTO users (id, username, password, email, first_name, last_name, age, enabled)
VALUES (1, 'admin', 'de7c7e42d94208a3e95f15f9b1b93adec0363505cdc6e912157d7b2138d69f75c03fcae7552ee96d', 'admin@email.com', 'Admin', 'Adminov', 20, true);

INSERT INTO users (id, username, password, email, first_name, last_name, age, enabled)
VALUES (2, 'moderator', '54e14bf78d3b1629db209792777f64ef2932ebf072c6e9f5acf2f5247deb09c39b3017ab8d969a86', 'moderator@email.com', 'Moderator', 'Moderatorov', 21, true);

INSERT INTO users (id, username, password, email, first_name, last_name, age, enabled)
VALUES (3, 'user', '2012a054ceb65333b56aef46e8682ef641bfdd24418c41e7f126980138513d147f7562ac4fd0eba8', 'user@email.com', 'User', 'Userov', 23, true);

INSERT INTO users (id, username, password, email, first_name, last_name, age, enabled)
VALUES (4, 'moderator2', '54e14bf78d3b1629db209792777f64ef2932ebf072c6e9f5acf2f5247deb09c39b3017ab8d969a86', 'moderator2@email.com', 'Moderator2', 'Moderatorov2', 24, true);

-- user roles ADMIN
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (1, 1);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (1, 2);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (1, 3);

-- user roles MODERATORS
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (2, 2);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (2, 3);

INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (4, 2);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (4, 3);

-- user role USER
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (3, 3);

-- insert event
INSERT INTO events (id, name, description, location, date_time, created_by)
VALUES (1, 'Jazz && Rock stars', 'Top Jazz and Rock musicians.', 'Bulgaria, Plovdiv', '2022-12-20 16:30:00', 'admin');

INSERT INTO events (id, name, description, location, date_time, created_by)
VALUES (2, 'Techno music all day - all night', 'Top DJs from all over the world.', 'Bulgaria, Varna', '2021-12-29 14:00:00', 'moderator');

INSERT INTO events (id, name, description, location, date_time, created_by)
VALUES (3, 'Hip-hop beats! Break dancing and beatboxing!', 'Break dancing and MCs rulez!', 'Bulgaria, Sofia', '2022-01-21 15:45:00', 'moderator');

INSERT INTO events (id, name, description, location, date_time, created_by)
VALUES (4, 'Best beats ever! Top beatboxing!', 'Beatboxing is cool!', 'Bulgaria, Burgas', '2021-12-28 15:45:00', 'moderator2');

-- insert musicians
INSERT INTO musicians (id, name, history, country, event_id)
VALUES (1, 'The Beatles', 'The Beatles were an English rock band, formed in Liverpool in 1960, whose best-known line-up comprised John Lennon, Paul McCartney, George Harrison and Ringo Starr. They are regarded as the most influential band of all time and were integral to the development of 1960s counterculture and popular music''s recognition as an art form. Rooted in skiffle, beat and 1950s rock and roll, their sound incorporated elements of classical music and traditional pop in innovative ways; the band later explored music styles ranging from ballads and Indian music to psychedelia and hard rock. As pioneers in recording, songwriting and artistic presentation, the Beatles revolutionised many aspects of the music industry and were often publicised as leaders of the era''s youth and sociocultural movements.', 'England', 1);

INSERT INTO musicians (id, name, history, country, event_id)
VALUES (2, 'The Dave Brubeck Quartet', 'David Warren Brubeck (December 6, 1920 – December 5, 2012) was an American jazz pianist and composer, considered one of the foremost exponents of cool jazz. Many of his compositions have become jazz standards including "In Your Own Sweet Way" and "The Duke". Brubeck''s style ranged from refined to bombastic, reflecting both his mother''s classical training and his own improvisational skills. His music is known for employing unusual time signatures as well as superimposing contrasting rhythms, meters, and tonalities. Brubeck experimented with time signatures throughout his career, recording "Unsquare Dance" in 7/4, "World''s Fair" in 13/8, and "Blue Rondo a la Turk" in 9/8. He was also a composer of orchestral and sacred music and wrote soundtracks for television, such as Mr. Broadway and the animated miniseries This Is America, Charlie Brown. Often incorrectly attributed to Brubeck, the song "Take Five", which has become a jazz standard, was composed by Brubeck''s long-time musical partner, alto saxophonist Paul Desmond. Appearing on one of the top-selling jazz albums, Time Out, and written in 5/4 time, "Take Five" has endured as a jazz classic associated with Brubeck.', 'United States', 1);

INSERT INTO musicians (id, name, history, country, event_id)
VALUES (3, 'Beastie Boys', 'Beastie Boys were an American hip hop group from New York City, formed in 1981. The group was composed of Michael "Mike D" Diamond (vocals, drums), Adam "MCA" Yauch (vocals, bass), and Adam "Ad-Rock" Horovitz (vocals, guitar, programming). Beastie Boys were formed out of members of experimental hardcore punk band The Young Aborigines in 1978, with Diamond as vocalist, Jeremy Shatan on bass guitar, John Berry on guitar, and Kate Schellenbach on drums. When Shatan left in 1981, Yauch replaced him on bass and the band changed their name to Beastie Boys. Berry left shortly thereafter and was replaced by Horovitz. After achieving local success with the 1983 comedy hip hop single "Cooky Puss," Beastie Boys made a full transition to hip hop, and Schellenbach left. They toured with Madonna in 1985 and a year later released their debut album, Licensed to Ill (1986), the first rap record to top the Billboard 200 chart. Their second album, Paul''s Boutique (1989), composed almost entirely of samples, was a commercial failure, but later received critical acclaim. Check Your Head (1992) and Ill Communication (1994) found mainstream success, followed by Hello Nasty (1998), To the 5 Boroughs (2004), The Mix-Up (2007), and Hot Sauce Committee Part Two (2011). Beastie Boys have sold 20 million records in the United States and had seven platinum-selling albums from 1986 to 2004. They are the biggest-selling rap group since Billboard began recording sales in 1991. In 2012, they became the third rap group to be inducted into the Rock and Roll Hall of Fame. In the same year, Yauch died of cancer and Beastie Boys disbanded. Since then, the remaining two members have released several retrospective works, including a book and documentary film detailing the history of the group as well as a career-spanning compilation album. Diamond has produced acts including Portugal. The Man, while Horovitz has taken small acting roles and continues to play music.', 'United States', 3);

-- insert albums
INSERT INTO albums (id, name, released, price, genre, musician_id)
VALUES (1, 'Please Please Me', '1963-03-22', 25.00, 'ROCK', 1);

INSERT INTO albums (id, name, released, price, genre, musician_id)
VALUES (2, 'With The Beatles', '1963-11-22', 30.00, 'ROCK', 1);

INSERT INTO albums (id, name, released, price, genre, musician_id)
VALUES (3, 'Old Sounds From San Francisco', '1948-01-01', 50.00, 'JAZZ', 2);

INSERT INTO albums (id, name, released, price, genre, musician_id)
VALUES (4, 'Licensed to Ill', '1986-11-15', 45.00, 'HIP_HOP', 3);

-- insert songs
INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (1, 'I Saw Her Standing There', 175, 'ROCK', 1);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (2, 'Misery', 109, 'ROCK', 1);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (3, 'Anna (Go to Him)', 175, 'ROCK', 1);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (4, 'Chains', 143, 'ROCK', 1);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (5, 'It Won''t Be Long', 133, 'ROCK', 2);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (6, 'All I''ve Got to Do', 122, 'ROCK', 2);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (7, 'How High The Moon', 150, 'JAZZ', 3);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (8, 'Serenades Suite', 160, 'JAZZ', 3);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (9, 'Rhymin & Stealin', 248, 'HIP_HOP', 4);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (10, 'The New Style', 275, 'HIP_HOP', 4);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (11, 'She''s Crafty', 205, 'HIP_HOP', 4);

INSERT INTO songs (id, name, duration, genre, album_id)
VALUES (12, 'Posse in Effect', 146, 'HIP_HOP', 4);

-- insert pictures
INSERT INTO pictures (id, title, url, public_id, musician_id)
VALUES (1, 'The Beatles', 'http://res.cloudinary.com/user9913/image/upload/v1638399010/ka9eaigrs0fzfgwfvfp0.jpg', 'ka9eaigrs0fzfgwfvfp0', 1);

INSERT INTO pictures (id, title, url, public_id)
VALUES (2, 'page-not-found', 'http://res.cloudinary.com/user9913/image/upload/v1638715828/gqidfoygwoiyqa96pceg.png', 'gqidfoygwoiyqa96pceg');

INSERT INTO pictures (id, title, url, public_id)
VALUES (3, 'jazz', 'http://res.cloudinary.com/user9913/image/upload/v1638716585/q0sgyen66vvtc2jfcye8.png', 'q0sgyen66vvtc2jfcye8');

INSERT INTO pictures (id, title, url, public_id)
VALUES (4, 'rocks', 'http://res.cloudinary.com/user9913/image/upload/v1638716815/ssfppqip8hrhlgrswpl6.png', 'ssfppqip8hrhlgrswpl6');

INSERT INTO pictures (id, title, url, public_id)
VALUES (5, 'break', 'http://res.cloudinary.com/user9913/image/upload/v1638716899/f6xz0nlj3vvivc9nx2fp.png', 'f6xz0nlj3vvivc9nx2fp');

INSERT INTO pictures (id, title, url, public_id)
VALUES (6, 'repair', 'http://res.cloudinary.com/user9913/image/upload/v1638716994/gue28iod5rqzq5js6yii.png', 'gue28iod5rqzq5js6yii');

INSERT INTO pictures (id, title, url, public_id, musician_id)
VALUES (7, 'The Dave Brubeck Quartet', 'http://res.cloudinary.com/user9913/image/upload/v1638717554/dq9cu0mo0j4marsov5ay.jpg', 'dq9cu0mo0j4marsov5ay', 2);

INSERT INTO pictures (id, title, url, public_id, musician_id)
VALUES (8, 'Beastie Boys', 'https://res.cloudinary.com/user9913/image/upload/v1639430957/g6rkl1pehle3aeks5ns1.jpg', 'g6rkl1pehle3aeks5ns1', 3);