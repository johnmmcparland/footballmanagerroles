--
-- A program to determine the best role for footballer in the Football Manager game
-- Copyright (C) 2011-12  John McParland (johnmmcparland@gmail.com)
-- 
-- This program is free software: you can redistribute it and/or modify
-- it under the terms of the GNU General Public License as published by
-- the Free Software Foundation, either version 3 of the License, or
-- (at your option) any later version.
--
-- This program is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
-- GNU General Public License for more details. 
-- 
-- You should have received a copy of the GNU General Public License
-- along with this program.  If not, see <http://www.gnu.org/licenses/>.
--

CREATE TABLE CategoriesOutfield(Category VARCHAR(50) NOT NULL PRIMARY KEY);
CREATE TABLE CategoriesGK(Category VARCHAR(50) NOT NULL PRIMARY KEY);
CREATE TABLE TypesOutfield(Type VARCHAR(50) NOT NULL PRIMARY KEY);
CREATE TABLE TypesGK(Type VARCHAR(50) NOT NULL PRIMARY KEY);
CREATE TABLE AttributesOutfield(Attribute VARCHAR(50) NOT NULL PRIMARY KEY,Type VARCHAR(50) NOT NULL,Category VARCHAR(50) NOT NULL,CONSTRAINT SYS_FK_113 FOREIGN KEY(Category) REFERENCES CategoriesOutfield(Category),CONSTRAINT SYS_FK_119 FOREIGN KEY(Type) REFERENCES TypesOutfield(Type));
CREATE TABLE AttributesGK(Attribute VARCHAR(50) NOT NULL PRIMARY KEY,Type VARCHAR(50) NOT NULL,Category VARCHAR(50) NOT NULL,CONSTRAINT SYS_FK_108 FOREIGN KEY(Category) REFERENCES CategoriesGK(Category),CONSTRAINT SYS_FK_122 FOREIGN KEY(Type) REFERENCES TypesGK(Type));

INSERT INTO CategoriesOutfield VALUES('Aerobic');
INSERT INTO CategoriesOutfield VALUES('Attacking');
INSERT INTO CategoriesOutfield VALUES('Ball Control');
INSERT INTO CategoriesOutfield VALUES('Defending');
INSERT INTO CategoriesOutfield VALUES('No Category');
INSERT INTO CategoriesOutfield VALUES('Shooting');
INSERT INTO CategoriesOutfield VALUES('Strength');
INSERT INTO CategoriesOutfield VALUES('Tactics');

INSERT INTO CategoriesGK VALUES('Aerobic');
INSERT INTO CategoriesGK VALUES('Ball Control');
INSERT INTO CategoriesGK VALUES('GK - Handling');
INSERT INTO CategoriesGK VALUES('GK - Shot Stopping');
INSERT INTO CategoriesGK VALUES('No Category');
INSERT INTO CategoriesGK VALUES('Strength');
INSERT INTO CategoriesGK VALUES('Tactics');

INSERT INTO TypesOutfield VALUES('Mental');
INSERT INTO TypesOutfield VALUES('Physical');
INSERT INTO TypesOutfield VALUES('Technical');

INSERT INTO TypesGK VALUES('Goalkeeping');
INSERT INTO TypesGK VALUES('Mental');
INSERT INTO TypesGK VALUES('Physical');

INSERT INTO AttributesOutfield VALUES('Acceleration','Physical','Aerobic');
INSERT INTO AttributesOutfield VALUES('Aggression','Mental','No Category');
INSERT INTO AttributesOutfield VALUES('Agility','Physical','Aerobic');
INSERT INTO AttributesOutfield VALUES('Anticipation','Mental','Tactics');
INSERT INTO AttributesOutfield VALUES('Balance','Physical','Aerobic');
INSERT INTO AttributesOutfield VALUES('Bravery','Mental','No Category');
INSERT INTO AttributesOutfield VALUES('Composure','Mental','Tactics');
INSERT INTO AttributesOutfield VALUES('Concentration','Mental','Tactics');
INSERT INTO AttributesOutfield VALUES('Corners','Technical','No Category');
INSERT INTO AttributesOutfield VALUES('Creativity','Mental','Attacking');
INSERT INTO AttributesOutfield VALUES('Crossing','Technical','Attacking');
INSERT INTO AttributesOutfield VALUES('Decisions','Mental','Tactics');
INSERT INTO AttributesOutfield VALUES('Determination','Mental','No Category');
INSERT INTO AttributesOutfield VALUES('Dribbling','Technical','Ball Control');
INSERT INTO AttributesOutfield VALUES('Finishing','Technical','Shooting');
INSERT INTO AttributesOutfield VALUES('First Touch','Technical','Ball Control');
INSERT INTO AttributesOutfield VALUES('Flair','Mental','Ball Control');
INSERT INTO AttributesOutfield VALUES('Free Kick Taking','Technical','No Category');
INSERT INTO AttributesOutfield VALUES('Heading','Technical','Ball Control');
INSERT INTO AttributesOutfield VALUES('Influence','Mental','No Category');
INSERT INTO AttributesOutfield VALUES('Jumping','Physical','Strength');
INSERT INTO AttributesOutfield VALUES('Long Shots','Technical','Shooting');
INSERT INTO AttributesOutfield VALUES('Long Throws','Technical','No Category');
INSERT INTO AttributesOutfield VALUES('Marking','Technical','Defending');
INSERT INTO AttributesOutfield VALUES('Natural Fitness','Physical','Strength');
INSERT INTO AttributesOutfield VALUES('Off The Ball','Mental','Attacking');
INSERT INTO AttributesOutfield VALUES('Pace','Physical','Aerobic');
INSERT INTO AttributesOutfield VALUES('Passing','Technical','Attacking');
INSERT INTO AttributesOutfield VALUES('Penalty Taking','Technical','No Category');
INSERT INTO AttributesOutfield VALUES('Positioning','Mental','Defending');
INSERT INTO AttributesOutfield VALUES('Stamina','Physical','Strength');
INSERT INTO AttributesOutfield VALUES('Strength','Physical','Strength');
INSERT INTO AttributesOutfield VALUES('Tackling','Technical','Defending');
INSERT INTO AttributesOutfield VALUES('Teamwork','Mental','Tactics');
INSERT INTO AttributesOutfield VALUES('Technique','Technical','Ball Control');
INSERT INTO AttributesOutfield VALUES('Work Rate','Mental','Strength');

INSERT INTO AttributesGK VALUES('Acceleration','Physical','Aerobic');
INSERT INTO AttributesGK VALUES('Aerial Ability','Goalkeeping','GK - Handling');
INSERT INTO AttributesGK VALUES('Aggression','Mental','No Category');
INSERT INTO AttributesGK VALUES('Agility','Physical','Aerobic');
INSERT INTO AttributesGK VALUES('Anticipation','Mental','Tactics');
INSERT INTO AttributesGK VALUES('Balance','Physical','Aerobic');
INSERT INTO AttributesGK VALUES('Bravery','Mental','No Category');
INSERT INTO AttributesGK VALUES('Command Of Area','Goalkeeping','Tactics');
INSERT INTO AttributesGK VALUES('Communication','Goalkeeping','Tactics');
INSERT INTO AttributesGK VALUES('Composure','Mental','GK - Shot Stopping');
INSERT INTO AttributesGK VALUES('Concentration','Mental','GK - Shot Stopping');
INSERT INTO AttributesGK VALUES('Creativity','Mental','No Category');
INSERT INTO AttributesGK VALUES('Decisions','Mental','Tactics');
INSERT INTO AttributesGK VALUES('Determination','Mental','No Category');
INSERT INTO AttributesGK VALUES('Eccentricity','Goalkeeping','No Category');
INSERT INTO AttributesGK VALUES('First Touch','Goalkeeping','Ball Control');
INSERT INTO AttributesGK VALUES('Flair','Mental','No Category');
INSERT INTO AttributesGK VALUES('Free Kick Taking','Goalkeeping','No Category');
INSERT INTO AttributesGK VALUES('Handling','Goalkeeping','GK - Handling');
INSERT INTO AttributesGK VALUES('Influence','Mental','No Category');
INSERT INTO AttributesGK VALUES('Jumping','Physical','Strength');
INSERT INTO AttributesGK VALUES('Kicking','Goalkeeping','GK - Handling');
INSERT INTO AttributesGK VALUES('Natural Fitness','Physical','Strength');
INSERT INTO AttributesGK VALUES('Off The Ball','Mental','No Category');
INSERT INTO AttributesGK VALUES('One On Ones','Goalkeeping','GK - Shot Stopping');
INSERT INTO AttributesGK VALUES('Pace','Physical','Aerobic');
INSERT INTO AttributesGK VALUES('Penalty Taking','Goalkeeping','No Category');
INSERT INTO AttributesGK VALUES('Positioning','Mental','GK - Shot Stopping');
INSERT INTO AttributesGK VALUES('Reflexes','Goalkeeping','GK - Shot Stopping');
INSERT INTO AttributesGK VALUES('Rushing Out','Goalkeeping','Tactics');
INSERT INTO AttributesGK VALUES('Stamina','Physical','Strength');
INSERT INTO AttributesGK VALUES('Strength','Physical','Strength');
INSERT INTO AttributesGK VALUES('Teamwork','Mental','No Category');
INSERT INTO AttributesGK VALUES('Tendency To Punch','Goalkeeping','No Category');
INSERT INTO AttributesGK VALUES('Throwing','Goalkeeping','GK - Handling');
INSERT INTO AttributesGK VALUES('Work Rate','Mental','No Category');

CREATE VIEW GK_D (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesGK WHERE ( Attribute = 'Aerial Ability' OR Attribute = 'Command Of Area' OR Attribute = 'Handling' OR Attribute = 'One On Ones' OR Attribute = 'Reflexes' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Agility' );
CREATE VIEW CD_C (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Jumping' OR Attribute = 'Strength' OR Attribute = 'Anticipation' OR Attribute = 'Acceleration' );
CREATE VIEW CD_S (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Jumping' OR Attribute = 'Strength' OR Attribute = 'Aggression' OR Attribute = 'Bravery' );
CREATE VIEW GK_BackPrime (Attribute,Type,Category) AS SELECT Attribute, Type, Category FROM AttributesGK WHERE ( Attribute = 'Concentration' OR Attribute = 'Determination' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Decisions' );
CREATE VIEW FB_SAu (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' OR Attribute = 'Anticipation' OR Attribute = 'Concentration' OR Attribute = 'Crossing' );
CREATE VIEW Outfield_BackPrime (Attribute,Type,Category) AS SELECT Attribute, Type, Category FROM AttributesOutfield WHERE ( Attribute = 'Concentration' OR Attribute = 'Determination' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Creativity' OR Attribute = 'Decisions' );
CREATE VIEW BWM_D (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Aggression' OR Attribute = 'Bravery' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Stamina' OR Attribute = 'Strength' );
CREATE VIEW AP_S (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Stamina' );
CREATE VIEW W_SA (Attribute,Type,Category) AS SELECT Attribute, Type, Category FROM AttributesOutfield WHERE ( Attribute = 'Crossing' OR Attribute = 'Dribbling' OR Attribute = 'Technique' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Acceleration' OR Attribute = 'Agility' OR Attribute = 'Balance' OR Attribute = 'Pace' );
CREATE VIEW DLF_S (Attribute,Type,Category) AS SELECT Attribute, Type, Category FROM AttributesOutfield WHERE ( Attribute = 'Dribbling' OR Attribute = 'First Touch' OR Attribute = 'Long Shots' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Strength' );
CREATE VIEW TM_S (Attribute,Type,Category) AS SELECT Attribute, Type, Category FROM AttributesOutfield WHERE ( Attribute = 'First Touch' OR Attribute = 'Heading' OR Attribute = 'Long Shots' OR Attribute = 'Aggression' OR Attribute = 'Bravery' OR Attribute = 'Determination' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Jumping' OR Attribute = 'Strength' );
CREATE VIEW TM_A (Attribute,Type,Category) AS SELECT Attribute, Type, Category FROM AttributesOutfield WHERE ( Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Heading' OR Attribute = 'Anticipation' OR Attribute = 'Bravery' OR Attribute = 'Determination' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Jumping' OR Attribute = 'Strength' );
CREATE VIEW P_A (Attribute,Type,Category) AS SELECT Attribute, Type, Category FROM AttributesOutfield WHERE ( Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Off The Ball' OR Attribute = 'Acceleration' OR Attribute = 'Agility' OR Attribute = 'Balance' OR Attribute = 'Pace' );
CREATE VIEW CD_D (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Jumping' OR Attribute = 'Strength' );

-- Updated for pitch area to role data (Th 5th Jan 2012)
CREATE TABLE Positions_To_Roles(PitchArea VARCHAR(30) NOT NULL,Side VARCHAR(10) NOT NULL,Role VARCHAR(50) NOT NULL,Duty VARCHAR(10) NOT NULL,ViewName VARCHAR(50) NOT NULL,PRIMARY KEY(PitchArea,Side,Role,Duty,ViewName));
CREATE TABLE PitchArea(PitchArea VARCHAR(30) NOT NULL PRIMARY KEY);
CREATE TABLE Side(Side VARCHAR(10) NOT NULL PRIMARY KEY);
CREATE TABLE Role(Role VARCHAR(50) NOT NULL PRIMARY KEY);
CREATE TABLE Duty(Duty VARCHAR(10) NOT NULL PRIMARY KEY);

ALTER TABLE Positions_To_Roles ADD CONSTRAINT SYS_FK_172 FOREIGN KEY(PitchArea) REFERENCES PitchArea(PitchArea);
ALTER TABLE Positions_To_Roles ADD CONSTRAINT SYS_FK_175 FOREIGN KEY(Side) REFERENCES Side(Side);
ALTER TABLE Positions_To_Roles ADD CONSTRAINT SYS_FK_178 FOREIGN KEY(Role) REFERENCES Role(Role);
ALTER TABLE Positions_To_Roles ADD CONSTRAINT SYS_FK_181 FOREIGN KEY(Duty) REFERENCES Duty(Duty);

INSERT INTO PitchArea VALUES('Attacking Midfielder');
INSERT INTO PitchArea VALUES('Defender');
INSERT INTO PitchArea VALUES('Defensive Midfielder');
INSERT INTO PitchArea VALUES('Goalkeeper');
INSERT INTO PitchArea VALUES('Midfielder');
INSERT INTO PitchArea VALUES('Striker');
INSERT INTO PitchArea VALUES('Sweeper');
INSERT INTO PitchArea VALUES('Wing Back');

INSERT INTO Side VALUES('Centre');
INSERT INTO Side VALUES('Left');
INSERT INTO Side VALUES('None');
INSERT INTO Side VALUES('Right');

INSERT INTO Role VALUES('Advanced Forward');
INSERT INTO Role VALUES('Advanced Playmaker');
INSERT INTO Role VALUES('Anchor Man');
INSERT INTO Role VALUES('Attacking Midfielder');
INSERT INTO Role VALUES('Ball Playing Defender');
INSERT INTO Role VALUES('Ball Winning Midfielder');
INSERT INTO Role VALUES('Box To Box Midfielder');
INSERT INTO Role VALUES('Central Defender');
INSERT INTO Role VALUES('Central Midfielder');
INSERT INTO Role VALUES('Complete Forward');
INSERT INTO Role VALUES('Deep Lying Forward');
INSERT INTO Role VALUES('Deep Lying Playmaker');
INSERT INTO Role VALUES('Defensive Forward');
INSERT INTO Role VALUES('Defensive Midfielder');
INSERT INTO Role VALUES('Defensive Winger');
INSERT INTO Role VALUES('Full Back');
INSERT INTO Role VALUES('Goalkeeper');
INSERT INTO Role VALUES('Inside Forward');
INSERT INTO Role VALUES('Libero');
INSERT INTO Role VALUES('Limited Defender');
INSERT INTO Role VALUES('Poacher');
INSERT INTO Role VALUES('Sweeper');
INSERT INTO Role VALUES('Sweeper Keeper');
INSERT INTO Role VALUES('Target Man');
INSERT INTO Role VALUES('Trequartista');
INSERT INTO Role VALUES('Wide Midfielder');
INSERT INTO Role VALUES('Wing Back');
INSERT INTO Role VALUES('Winger');

INSERT INTO Duty VALUES('Attack');
INSERT INTO Duty VALUES('Automatic');
INSERT INTO Duty VALUES('Cover');
INSERT INTO Duty VALUES('Defend');
INSERT INTO Duty VALUES('Stopper');
INSERT INTO Duty VALUES('Support');

INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Centre','Advanced Playmaker','Attack','AP_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Centre','Advanced Playmaker','Support','AP_S');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Centre','Attacking Midfielder','Attack','AM_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Centre','Attacking Midfielder','Support','AM_S');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Centre','Inside Forward','Attack','IF_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Centre','Inside Forward','Support','IF_S');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Centre','Trequartista','Attack','T_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Left','Advanced Playmaker','Attack','AP_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Left','Advanced Playmaker','Support','AP_S');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Left','Defensive Winger','Attack','DW_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Left','Defensive Winger','Support','DW_S');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Left','Inside Forward','Attack','IF_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Left','Inside Forward','Support','IF_S');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Left','Winger','Attack','W_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Left','Winger','Support','W_S');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Right','Advanced Playmaker','Attack','AP_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Right','Advanced Playmaker','Support','AP_S');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Right','Defensive Winger','Attack','DW_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Right','Defensive Winger','Support','DW_S');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Right','Inside Forward','Attack','IF_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Right','Inside Forward','Support','IF_S');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Right','Winger','Attack','W_A');
INSERT INTO Positions_To_Roles VALUES('Attacking Midfielder','Right','Winger','Support','W_S');
INSERT INTO Positions_To_Roles VALUES('Defender','Centre','Ball Playing Defender','Cover','BPD_C');
INSERT INTO Positions_To_Roles VALUES('Defender','Centre','Ball Playing Defender','Defend','BPD_D');
INSERT INTO Positions_To_Roles VALUES('Defender','Centre','Ball Playing Defender','Stopper','BPD_S');
INSERT INTO Positions_To_Roles VALUES('Defender','Centre','Central Defender','Cover','CD_C');
INSERT INTO Positions_To_Roles VALUES('Defender','Centre','Central Defender','Defend','CD_D');
INSERT INTO Positions_To_Roles VALUES('Defender','Centre','Central Defender','Stopper','CD_S');
INSERT INTO Positions_To_Roles VALUES('Defender','Centre','Limited Defender','Cover','LD_C');
INSERT INTO Positions_To_Roles VALUES('Defender','Centre','Limited Defender','Defend','LD_D');
INSERT INTO Positions_To_Roles VALUES('Defender','Centre','Limited Defender','Stopper','LD_S');
INSERT INTO Positions_To_Roles VALUES('Defender','Left','Full Back','Attack','FB_A');
INSERT INTO Positions_To_Roles VALUES('Defender','Left','Full Back','Automatic','FB_Au');
INSERT INTO Positions_To_Roles VALUES('Defender','Left','Full Back','Defend','FB_D');
INSERT INTO Positions_To_Roles VALUES('Defender','Left','Full Back','Support','FB_S');
INSERT INTO Positions_To_Roles VALUES('Defender','Left','Wing Back','Attack','WB_A');
INSERT INTO Positions_To_Roles VALUES('Defender','Left','Wing Back','Automatic','WB_Au');
INSERT INTO Positions_To_Roles VALUES('Defender','Left','Wing Back','Defend','WB_D');
INSERT INTO Positions_To_Roles VALUES('Defender','Left','Wing Back','Support','WB_S');
INSERT INTO Positions_To_Roles VALUES('Defender','Right','Full Back','Attack','FB_A');
INSERT INTO Positions_To_Roles VALUES('Defender','Right','Full Back','Automatic','FB_Au');
INSERT INTO Positions_To_Roles VALUES('Defender','Right','Full Back','Defend','FB_D');
INSERT INTO Positions_To_Roles VALUES('Defender','Right','Full Back','Support','FB_S');
INSERT INTO Positions_To_Roles VALUES('Defender','Right','Wing Back','Attack','WB_A');
INSERT INTO Positions_To_Roles VALUES('Defender','Right','Wing Back','Automatic','WB_Au');
INSERT INTO Positions_To_Roles VALUES('Defender','Right','Wing Back','Defend','WB_D');
INSERT INTO Positions_To_Roles VALUES('Defender','Right','Wing Back','Support','WB_S');
INSERT INTO Positions_To_Roles VALUES('Defensive Midfielder','Centre','Anchor Man','Defend','AM_D');
INSERT INTO Positions_To_Roles VALUES('Defensive Midfielder','Centre','Deep Lying Playmaker','Defend','DLP_D');
INSERT INTO Positions_To_Roles VALUES('Defensive Midfielder','Centre','Deep Lying Playmaker','Support','DLP_S');
INSERT INTO Positions_To_Roles VALUES('Defensive Midfielder','Centre','Defensive Midfielder','Defend','DM_D');
INSERT INTO Positions_To_Roles VALUES('Defensive Midfielder','Centre','Defensive Midfielder','Support','DM_S');
INSERT INTO Positions_To_Roles VALUES('Goalkeeper','None','Goalkeeper','Defend','GK_D');
INSERT INTO Positions_To_Roles VALUES('Goalkeeper','None','Sweeper Keeper','Attack','SWK_A');
INSERT INTO Positions_To_Roles VALUES('Goalkeeper','None','Sweeper Keeper','Defend','SWK_D');
INSERT INTO Positions_To_Roles VALUES('Goalkeeper','None','Sweeper Keeper','Support','SWK_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Advanced Playmaker','Attack','AP_A');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Advanced Playmaker','Support','AP_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Ball Winning Midfielder','Defend','BWM_D');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Ball Winning Midfielder','Support','BWM_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Box To Box Midfielder','Support','B2BM_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Central Midfielder','Attack','CM_A');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Central Midfielder','Automatic','CM_Au');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Central Midfielder','Defend','CM_D');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Central Midfielder','Support','CM_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Deep Lying Playmaker','Defend','DLP_D');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Centre','Deep Lying Playmaker','Support','DLP_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Left','Defensive Winger','Attack','DW_A');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Left','Defensive Winger','Support','DW_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Left','Wide Midfielder','Attack','WM_A');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Left','Wide Midfielder','Automatic','WM_Au');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Left','Wide Midfielder','Defend','WM_D');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Left','Wide Midfielder','Support','WM_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Left','Winger','Attack','W_A');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Left','Winger','Support','W_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Right','Defensive Winger','Attack','DW_A');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Right','Defensive Winger','Support','DW_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Right','Wide Midfielder','Attack','WM_A');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Right','Wide Midfielder','Automatic','WM_Au');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Right','Wide Midfielder','Defend','WM_D');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Right','Wide Midfielder','Support','WM_S');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Right','Winger','Attack','W_A');
INSERT INTO Positions_To_Roles VALUES('Midfielder','Right','Winger','Support','W_S');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Advanced Forward','Attack','AF_A');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Complete Forward','Attack','CF_A');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Complete Forward','Support','CF_S');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Deep Lying Forward','Attack','DLF_A');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Deep Lying Forward','Support','DLF_S');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Defensive Forward','Attack','DF_A');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Defensive Forward','Support','DF_S');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Poacher','Attack','P_A');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Target Man','Attack','TM_A');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Target Man','Support','TM_S');
INSERT INTO Positions_To_Roles VALUES('Striker','Centre','Trequartista','Attack','T_A');
INSERT INTO Positions_To_Roles VALUES('Sweeper','None','Libero','Attack','L_A');
INSERT INTO Positions_To_Roles VALUES('Sweeper','None','Libero','Support','L_S');
INSERT INTO Positions_To_Roles VALUES('Sweeper','None','Sweeper','Defend','SW_D');
INSERT INTO Positions_To_Roles VALUES('Wing Back','Left','Wing Back','Attack','WB_A');
INSERT INTO Positions_To_Roles VALUES('Wing Back','Left','Wing Back','Automatic','WB_Au');
INSERT INTO Positions_To_Roles VALUES('Wing Back','Left','Wing Back','Defend','WB_D');
INSERT INTO Positions_To_Roles VALUES('Wing Back','Left','Wing Back','Support','WB_S');
INSERT INTO Positions_To_Roles VALUES('Wing Back','Right','Wing Back','Attack','WB_A');
INSERT INTO Positions_To_Roles VALUES('Wing Back','Right','Wing Back','Automatic','WB_Au');
INSERT INTO Positions_To_Roles VALUES('Wing Back','Right','Wing Back','Defend','WB_D');
INSERT INTO Positions_To_Roles VALUES('Wing Back','Right','Wing Back','Support','WB_S');

-- Updated extra view types (M 23 Jan 2012)
CREATE VIEW SWK_DSA (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesGK WHERE ( Attribute = 'Aerial Ability' OR Attribute = 'Command Of Area' OR Attribute = 'Communication' OR Attribute = 'Eccentricity' OR Attribute = 'Handling' OR Attribute = 'Reflexes' OR Attribute = 'Rushing Out' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Acceleration' OR Attribute = 'Agility' OR Attribute = 'Pace' );
CREATE VIEW FB_D (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Concentration' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' );
CREATE VIEW FB_A (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Crossing' OR Attribute = 'Dribbling' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Concentration' OR Attribute = 'Off The Ball' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' );
CREATE VIEW WB_D (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' );
CREATE VIEW WB_SAu (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Crossing' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' );
CREATE VIEW WB_A (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Crossing' OR Attribute = 'Dribbling' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Decisions' OR Attribute = 'Off The Ball' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' );
CREATE VIEW L_S (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Dribbling' OR Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Acceleration' OR Attribute = 'Balance' OR Attribute = 'Jumping' );
CREATE VIEW L_A (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Dribbling' OR Attribute = 'Heading' OR Attribute = 'Long Shots' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Acceleration' OR Attribute = 'Balance' OR Attribute = 'Jumping' );
CREATE VIEW SW_D (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Acceleration' OR Attribute = 'Balance' OR Attribute = 'Jumping' );
CREATE VIEW BPD_D (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Technique' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Jumping' OR Attribute = 'Strength' );
CREATE VIEW BPD_S (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Technique' OR Attribute = 'Aggression' OR Attribute = 'Bravery' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Jumping' OR Attribute = 'Strength' OR Attribute = 'Passing' OR Attribute = 'Creativity' );
CREATE VIEW BPD_C (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Concentration' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Acceleration' OR Attribute = 'Jumping' OR Attribute = 'Strength' );
CREATE VIEW LD_C (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Acceleration' OR Attribute = 'Jumping' OR Attribute = 'Strength' );
CREATE VIEW LD_D (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Jumping' OR Attribute = 'Strength' );
CREATE VIEW LD_S (Attribute,Type,Category) AS SELECT Attribute AS Attribute, Type AS Type, Category AS Category FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Aggression' OR Attribute = 'Bravery' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Jumping' OR Attribute = 'Strength' );

-- Correcting view names
update Positions_To_Roles set ViewName='FB_SAu' where ViewName='FB_S' or ViewName='FB_Au';
update Positions_To_Roles set ViewName='W_SA' where ViewName='W_S' or ViewName='W_A';
update Positions_To_Roles set ViewName='SWK_DSA' where ViewName='SWK_D' or ViewName='SWK_S' or ViewName='SWK_A';
update Positions_To_Roles set ViewName='WB_SAu' where ViewName='WB_S' or ViewName='WB_Au';

-- Adding new roles/duties (Defensive midfield area)
CREATE VIEW DM_D (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' OR Attribute = 'Strength' );
CREATE VIEW DM_S (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' OR Attribute = 'Strength' );
CREATE VIEW DLP_D (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Technique' OR Attribute = 'Composure' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Strength' );
CREATE VIEW DLP_S (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Technique' OR Attribute = 'Composure' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Off The Ball' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' );
CREATE VIEW AM_D (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Work Rate' OR Attribute = 'Strength' );

-- Winger/wide midfielder roles
CREATE VIEW DW_SA (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Crossing' OR Attribute = 'Dribbling' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Technique' OR Attribute = 'Decisions' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Pace' OR Attribute = 'Stamina' );
CREATE VIEW WM_DSAAu (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Crossing' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Stamina' );

update Positions_To_Roles set ViewName='DW_SA' where ViewName='DW_S' or ViewName='DW_A';
update Positions_To_Roles set ViewName='WM_DSAAu' where ViewName='WM_D' or ViewName='WM_S' or ViewName='WM_A' or ViewName='WM_Au';

-- Central midfield roles
CREATE VIEW CM_D (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'First Touch' OR Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' );
CREATE VIEW CM_A (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Long Shots' OR Attribute = 'Passing' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' );
CREATE VIEW CM_SAu (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'First Touch' OR Attribute = 'Long Shots' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Off The Ball' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' );
CREATE VIEW BWM_S (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Aggression' OR Attribute = 'Bravery' OR Attribute = 'Determination' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Stamina' OR Attribute = 'Strength' ); 
CREATE VIEW B2BM_S (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Heading' OR Attribute = 'Long Shots' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Bravery' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Off The Ball' OR Attribute = 'Positioning' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' OR Attribute = 'Strength' );
CREATE VIEW AP_A (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Dribbling' OR Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' ); 

-- Attacking midfield roles
CREATE VIEW IF_S (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Dribbling' OR Attribute = 'Long Shots' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Acceleration' OR Attribute = 'Pace' );
CREATE VIEW IF_A (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Crossing' OR Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'Passing' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Acceleration' OR Attribute = 'Pace' );
CREATE VIEW AM_S (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'First Touch' OR Attribute = 'Long Shots' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Balance' );
CREATE VIEW AM_A (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Dribbling' OR Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' );
CREATE VIEW T_A (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Creativity' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Agility' );

-- Forward roles
CREATE VIEW DLF_A (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Off The Ball' OR Attribute = 'Balance' );
CREATE VIEW AF_A (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Crossing' OR Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'Heading' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Work Rate' OR Attribute = 'Pace' );
CREATE VIEW CF_SA (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Heading' OR Attribute = 'Long Shots' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Acceleration' OR Attribute = 'Agility' OR Attribute = 'Balance' OR Attribute = 'Jumping' OR Attribute = 'Pace' OR Attribute = 'Strength' );
CREATE VIEW DF_S (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'First Touch' OR Attribute = 'Long Shots' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Pace' OR Attribute = 'Stamina' OR Attribute = 'Strength' );
CREATE VIEW DF_A (Attribute) AS SELECT Attribute FROM AttributesOutfield WHERE ( Attribute = 'Finishing' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Stamina' OR Attribute = 'Strength' );

-- Correcting some new view names
update Positions_To_Roles set ViewName='CM_SAu' where ViewName='CM_S' or ViewName='CM_Au';
update Positions_To_Roles set ViewName='CF_SA' where ViewName='CF_S' or ViewName='CF_A';

-- Correcting some views which don't show all of the attribute columns
alter view af_a as select * from attributesoutfield where ( Attribute = 'Crossing' OR Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'Heading' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Work Rate' OR Attribute = 'Pace' );
alter view am_a as select * from AttributesOutfield where ( Attribute = 'Dribbling' OR Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' );
alter view am_s as SELECT * from AttributesOutfield where ( Attribute = 'First Touch' OR Attribute = 'Long Shots' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Balance' );
alter view AM_D AS SELECT * from AttributesOutfield where ( Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Work Rate' OR Attribute = 'Strength' );
alter view DM_D AS select * from AttributesOutfield where ( Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' OR Attribute = 'Strength' );
alter view DM_S AS select * from AttributesOutfield where ( Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' OR Attribute = 'Strength' );
alter view DLP_D AS select * from AttributesOutfield where ( Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Technique' OR Attribute = 'Composure' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Strength' );
alter view DLP_S AS select * from AttributesOutfield where ( Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Technique' OR Attribute = 'Composure' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Off The Ball' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' );
alter view AM_D AS select * from AttributesOutfield where ( Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Concentration' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Work Rate' OR Attribute = 'Strength' );
alter view DW_SA AS select * from AttributesOutfield where ( Attribute = 'Crossing' OR Attribute = 'Dribbling' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Technique' OR Attribute = 'Decisions' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Pace' OR Attribute = 'Stamina' );
alter view WM_DSAAu AS select * from AttributesOutfield where ( Attribute = 'Crossing' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Stamina' );
alter view CM_D AS select * from AttributesOutfield where ( Attribute = 'First Touch' OR Attribute = 'Heading' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' );
alter view CM_A AS select * from AttributesOutfield where ( Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Long Shots' OR Attribute = 'Passing' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' );
alter view CM_SAu AS select * from AttributesOutfield where ( Attribute = 'First Touch' OR Attribute = 'Long Shots' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Off The Ball' OR Attribute = 'Positioning' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' );
alter view BWM_S AS select * from AttributesOutfield where ( Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Aggression' OR Attribute = 'Bravery' OR Attribute = 'Determination' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Stamina' OR Attribute = 'Strength' ); 
alter view B2BM_S AS select * from AttributesOutfield where ( Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Heading' OR Attribute = 'Long Shots' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Bravery' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Off The Ball' OR Attribute = 'Positioning' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' OR Attribute = 'Stamina' OR Attribute = 'Strength' );
alter view AP_A AS select * from AttributesOutfield where ( Attribute = 'Dribbling' OR Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' ); 
alter view IF_S AS select * from AttributesOutfield where ( Attribute = 'Dribbling' OR Attribute = 'Long Shots' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Acceleration' OR Attribute = 'Pace' );
alter view IF_A AS select * from AttributesOutfield where ( Attribute = 'Crossing' OR Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'Passing' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Acceleration' OR Attribute = 'Pace' );
alter view AM_S AS select * from AttributesOutfield where ( Attribute = 'First Touch' OR Attribute = 'Long Shots' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Balance' );
alter view AM_A AS select * from AttributesOutfield where ( Attribute = 'Dribbling' OR Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Work Rate' OR Attribute = 'Acceleration' );
alter view T_A AS select * from AttributesOutfield where ( Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Creativity' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Agility' );
alter view DLF_A AS select * from AttributesOutfield where ( Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Off The Ball' OR Attribute = 'Balance' );
alter view AF_A AS select * from AttributesOutfield where ( Attribute = 'Crossing' OR Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'Heading' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Flair' OR Attribute = 'Off The Ball' OR Attribute = 'Work Rate' OR Attribute = 'Pace' );
alter view CF_SA AS select * from AttributesOutfield where ( Attribute = 'Dribbling' OR Attribute = 'Finishing' OR Attribute = 'First Touch' OR Attribute = 'Heading' OR Attribute = 'Long Shots' OR Attribute = 'Passing' OR Attribute = 'Technique' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Creativity' OR Attribute = 'Decisions' OR Attribute = 'Determination' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Acceleration' OR Attribute = 'Agility' OR Attribute = 'Balance' OR Attribute = 'Jumping' OR Attribute = 'Pace' OR Attribute = 'Strength' );
alter view DF_S AS select * from AttributesOutfield where ( Attribute = 'First Touch' OR Attribute = 'Long Shots' OR Attribute = 'Marking' OR Attribute = 'Passing' OR Attribute = 'Tackling' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Pace' OR Attribute = 'Stamina' OR Attribute = 'Strength' );
alter view DF_A AS select * from AttributesOutfield where ( Attribute = 'Finishing' OR Attribute = 'Marking' OR Attribute = 'Tackling' OR Attribute = 'Anticipation' OR Attribute = 'Composure' OR Attribute = 'Off The Ball' OR Attribute = 'Teamwork' OR Attribute = 'Work Rate' OR Attribute = 'Stamina' OR Attribute = 'Strength' );
