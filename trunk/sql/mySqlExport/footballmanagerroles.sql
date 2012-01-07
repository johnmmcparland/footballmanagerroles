-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 05, 2012 at 11:22 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `footballmanagerroles`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `ap_s`
--
CREATE TABLE IF NOT EXISTS `ap_s` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Table structure for table `attributesgk`
--

CREATE TABLE IF NOT EXISTS `attributesgk` (
  `Attribute` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  PRIMARY KEY (`Attribute`),
  KEY `SYS_FK_108` (`Category`),
  KEY `SYS_FK_122` (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `attributesgk`
--

INSERT INTO `attributesgk` (`Attribute`, `Type`, `Category`) VALUES
('Acceleration', 'Physical', 'Aerobic'),
('Aerial Ability', 'Goalkeeping', 'GK - Handling'),
('Aggression', 'Mental', 'No Category'),
('Agility', 'Physical', 'Aerobic'),
('Anticipation', 'Mental', 'Tactics'),
('Balance', 'Physical', 'Aerobic'),
('Bravery', 'Mental', 'No Category'),
('Command Of Area', 'Goalkeeping', 'Tactics'),
('Communication', 'Goalkeeping', 'Tactics'),
('Composure', 'Mental', 'GK - Shot Stopping'),
('Concentration', 'Mental', 'GK - Shot Stopping'),
('Creativity', 'Mental', 'No Category'),
('Decisions', 'Mental', 'Tactics'),
('Determination', 'Mental', 'No Category'),
('Eccentricity', 'Goalkeeping', 'No Category'),
('First Touch', 'Goalkeeping', 'Ball Control'),
('Flair', 'Mental', 'No Category'),
('Free Kick Taking', 'Goalkeeping', 'No Category'),
('Handling', 'Goalkeeping', 'GK - Handling'),
('Influence', 'Mental', 'No Category'),
('Jumping', 'Physical', 'Strength'),
('Kicking', 'Goalkeeping', 'GK - Handling'),
('Natural Fitness', 'Physical', 'Strength'),
('Off The Ball', 'Mental', 'No Category'),
('One On Ones', 'Goalkeeping', 'GK - Shot Stopping'),
('Pace', 'Physical', 'Aerobic'),
('Penalty Taking', 'Goalkeeping', 'No Category'),
('Positioning', 'Mental', 'GK - Shot Stopping'),
('Reflexes', 'Goalkeeping', 'GK - Shot Stopping'),
('Rushing Out', 'Goalkeeping', 'Tactics'),
('Stamina', 'Physical', 'Strength'),
('Strength', 'Physical', 'Strength'),
('Teamwork', 'Mental', 'No Category'),
('Tendency To Punch', 'Goalkeeping', 'No Category'),
('Throwing', 'Goalkeeping', 'GK - Handling'),
('Work Rate', 'Mental', 'No Category');

-- --------------------------------------------------------

--
-- Table structure for table `attributesoutfield`
--

CREATE TABLE IF NOT EXISTS `attributesoutfield` (
  `Attribute` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  PRIMARY KEY (`Attribute`),
  KEY `SYS_FK_113` (`Category`),
  KEY `SYS_FK_119` (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `attributesoutfield`
--

INSERT INTO `attributesoutfield` (`Attribute`, `Type`, `Category`) VALUES
('Acceleration', 'Physical', 'Aerobic'),
('Aggression', 'Mental', 'No Category'),
('Agility', 'Physical', 'Aerobic'),
('Anticipation', 'Mental', 'Tactics'),
('Balance', 'Physical', 'Aerobic'),
('Bravery', 'Mental', 'No Category'),
('Composure', 'Mental', 'Tactics'),
('Concentration', 'Mental', 'Tactics'),
('Corners', 'Technical', 'No Category'),
('Creativity', 'Mental', 'Attacking'),
('Crossing', 'Technical', 'Attacking'),
('Decisions', 'Mental', 'Tactics'),
('Determination', 'Mental', 'No Category'),
('Dribbling', 'Technical', 'Ball Control'),
('Finishing', 'Technical', 'Shooting'),
('First Touch', 'Technical', 'Ball Control'),
('Flair', 'Mental', 'Ball Control'),
('Free Kick Taking', 'Technical', 'No Category'),
('Heading', 'Technical', 'Ball Control'),
('Influence', 'Mental', 'No Category'),
('Jumping', 'Physical', 'Strength'),
('Long Shots', 'Technical', 'Shooting'),
('Long Throws', 'Technical', 'No Category'),
('Marking', 'Technical', 'Defending'),
('Natural Fitness', 'Physical', 'Strength'),
('Off The Ball', 'Mental', 'Attacking'),
('Pace', 'Physical', 'Aerobic'),
('Passing', 'Technical', 'Attacking'),
('Penalty Taking', 'Technical', 'No Category'),
('Positioning', 'Mental', 'Defending'),
('Stamina', 'Physical', 'Strength'),
('Strength', 'Physical', 'Strength'),
('Tackling', 'Technical', 'Defending'),
('Teamwork', 'Mental', 'Tactics'),
('Technique', 'Technical', 'Ball Control'),
('Work Rate', 'Mental', 'Strength');

-- --------------------------------------------------------

--
-- Stand-in structure for view `bwm_d`
--
CREATE TABLE IF NOT EXISTS `bwm_d` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Table structure for table `categoriesgk`
--

CREATE TABLE IF NOT EXISTS `categoriesgk` (
  `Category` varchar(50) NOT NULL,
  PRIMARY KEY (`Category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoriesgk`
--

INSERT INTO `categoriesgk` (`Category`) VALUES
('Aerobic'),
('Ball Control'),
('GK - Handling'),
('GK - Shot Stopping'),
('No Category'),
('Strength'),
('Tactics');

-- --------------------------------------------------------

--
-- Table structure for table `categoriesoutfield`
--

CREATE TABLE IF NOT EXISTS `categoriesoutfield` (
  `Category` varchar(50) NOT NULL,
  PRIMARY KEY (`Category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoriesoutfield`
--

INSERT INTO `categoriesoutfield` (`Category`) VALUES
('Aerobic'),
('Attacking'),
('Ball Control'),
('Defending'),
('No Category'),
('Shooting'),
('Strength'),
('Tactics');

-- --------------------------------------------------------

--
-- Stand-in structure for view `cd_c`
--
CREATE TABLE IF NOT EXISTS `cd_c` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `cd_d`
--
CREATE TABLE IF NOT EXISTS `cd_d` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `cd_s`
--
CREATE TABLE IF NOT EXISTS `cd_s` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `dlf_s`
--
CREATE TABLE IF NOT EXISTS `dlf_s` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Table structure for table `duty`
--

CREATE TABLE IF NOT EXISTS `duty` (
  `Duty` varchar(10) NOT NULL,
  PRIMARY KEY (`Duty`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `duty`
--

INSERT INTO `duty` (`Duty`) VALUES
('Attack'),
('Automatic'),
('Cover'),
('Defend'),
('Stopper'),
('Support');

-- --------------------------------------------------------

--
-- Stand-in structure for view `fb_sau`
--
CREATE TABLE IF NOT EXISTS `fb_sau` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `gk_backprime`
--
CREATE TABLE IF NOT EXISTS `gk_backprime` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `gk_d`
--
CREATE TABLE IF NOT EXISTS `gk_d` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `outfield_backprime`
--
CREATE TABLE IF NOT EXISTS `outfield_backprime` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Table structure for table `pitcharea`
--

CREATE TABLE IF NOT EXISTS `pitcharea` (
  `PitchArea` varchar(30) NOT NULL,
  PRIMARY KEY (`PitchArea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pitcharea`
--

INSERT INTO `pitcharea` (`PitchArea`) VALUES
('Attacking Midfielder'),
('Defender'),
('Defensive Midfielder'),
('Goalkeeper'),
('Midfielder'),
('Striker'),
('Sweeper'),
('Wing Back');

-- --------------------------------------------------------

--
-- Table structure for table `positions_to_roles`
--

CREATE TABLE IF NOT EXISTS `positions_to_roles` (
  `PitchArea` varchar(30) NOT NULL,
  `Side` varchar(10) NOT NULL,
  `Role` varchar(50) NOT NULL,
  `Duty` varchar(10) NOT NULL,
  `ViewName` varchar(50) NOT NULL,
  PRIMARY KEY (`PitchArea`,`Side`,`Role`,`Duty`,`ViewName`),
  KEY `SYS_FK_175` (`Side`),
  KEY `SYS_FK_178` (`Role`),
  KEY `SYS_FK_181` (`Duty`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `positions_to_roles`
--

INSERT INTO `positions_to_roles` (`PitchArea`, `Side`, `Role`, `Duty`, `ViewName`) VALUES
('Attacking Midfielder', 'Centre', 'Advanced Playmaker', 'Attack', 'AP_A'),
('Attacking Midfielder', 'Centre', 'Advanced Playmaker', 'Support', 'AP_S'),
('Attacking Midfielder', 'Centre', 'Attacking Midfielder', 'Attack', 'AM_A'),
('Attacking Midfielder', 'Centre', 'Attacking Midfielder', 'Support', 'AM_S'),
('Attacking Midfielder', 'Centre', 'Inside Forward', 'Attack', 'IF_A'),
('Attacking Midfielder', 'Centre', 'Inside Forward', 'Support', 'IF_S'),
('Attacking Midfielder', 'Centre', 'Trequartista', 'Attack', 'T_A'),
('Defender', 'Centre', 'Ball Playing Defender', 'Cover', 'BPD_C'),
('Defender', 'Centre', 'Ball Playing Defender', 'Defend', 'BPD_D'),
('Defender', 'Centre', 'Ball Playing Defender', 'Stopper', 'BPD_S'),
('Defender', 'Centre', 'Central Defender', 'Cover', 'CD_C'),
('Defender', 'Centre', 'Central Defender', 'Defend', 'CD_D'),
('Defender', 'Centre', 'Central Defender', 'Stopper', 'CD_S'),
('Defender', 'Centre', 'Limited Defender', 'Cover', 'LD_C'),
('Defender', 'Centre', 'Limited Defender', 'Defend', 'LD_D'),
('Defender', 'Centre', 'Limited Defender', 'Stopper', 'LD_S'),
('Defensive Midfielder', 'Centre', 'Anchor Man', 'Defend', 'AM_D'),
('Defensive Midfielder', 'Centre', 'Deep Lying Playmaker', 'Defend', 'DLP_D'),
('Defensive Midfielder', 'Centre', 'Deep Lying Playmaker', 'Support', 'DLP_S'),
('Defensive Midfielder', 'Centre', 'Defensive Midfielder', 'Defend', 'DM_D'),
('Defensive Midfielder', 'Centre', 'Defensive Midfielder', 'Support', 'DM_S'),
('Midfielder', 'Centre', 'Advanced Playmaker', 'Attack', 'AP_A'),
('Midfielder', 'Centre', 'Advanced Playmaker', 'Support', 'AP_S'),
('Midfielder', 'Centre', 'Ball Winning Midfielder', 'Defend', 'BWM_D'),
('Midfielder', 'Centre', 'Ball Winning Midfielder', 'Support', 'BWM_S'),
('Midfielder', 'Centre', 'Box To Box Midfielder', 'Support', 'B2BM_S'),
('Midfielder', 'Centre', 'Central Midfielder', 'Attack', 'CM_A'),
('Midfielder', 'Centre', 'Central Midfielder', 'Automatic', 'CM_Au'),
('Midfielder', 'Centre', 'Central Midfielder', 'Defend', 'CM_D'),
('Midfielder', 'Centre', 'Central Midfielder', 'Support', 'CM_S'),
('Midfielder', 'Centre', 'Deep Lying Playmaker', 'Defend', 'DLP_D'),
('Midfielder', 'Centre', 'Deep Lying Playmaker', 'Support', 'DLP_S'),
('Striker', 'Centre', 'Advanced Forward', 'Attack', 'AF_A'),
('Striker', 'Centre', 'Complete Forward', 'Attack', 'CF_A'),
('Striker', 'Centre', 'Complete Forward', 'Support', 'CF_S'),
('Striker', 'Centre', 'Deep Lying Forward', 'Attack', 'DLF_A'),
('Striker', 'Centre', 'Deep Lying Forward', 'Support', 'DLF_S'),
('Striker', 'Centre', 'Defensive Forward', 'Attack', 'DF_A'),
('Striker', 'Centre', 'Defensive Forward', 'Support', 'DF_S'),
('Striker', 'Centre', 'Poacher', 'Attack', 'P_A'),
('Striker', 'Centre', 'Target Man', 'Attack', 'TM_A'),
('Striker', 'Centre', 'Target Man', 'Support', 'TM_S'),
('Striker', 'Centre', 'Trequartista', 'Attack', 'T_A'),
('Attacking Midfielder', 'Left', 'Advanced Playmaker', 'Attack', 'AP_A'),
('Attacking Midfielder', 'Left', 'Advanced Playmaker', 'Support', 'AP_S'),
('Attacking Midfielder', 'Left', 'Defensive Winger', 'Attack', 'DW_A'),
('Attacking Midfielder', 'Left', 'Defensive Winger', 'Support', 'DW_S'),
('Attacking Midfielder', 'Left', 'Inside Forward', 'Attack', 'IF_A'),
('Attacking Midfielder', 'Left', 'Inside Forward', 'Support', 'IF_S'),
('Attacking Midfielder', 'Left', 'Winger', 'Attack', 'W_A'),
('Attacking Midfielder', 'Left', 'Winger', 'Support', 'W_S'),
('Defender', 'Left', 'Full Back', 'Attack', 'FB_A'),
('Defender', 'Left', 'Full Back', 'Automatic', 'FB_Au'),
('Defender', 'Left', 'Full Back', 'Defend', 'FB_D'),
('Defender', 'Left', 'Full Back', 'Support', 'FB_S'),
('Defender', 'Left', 'Wing Back', 'Attack', 'WB_A'),
('Defender', 'Left', 'Wing Back', 'Automatic', 'WB_Au'),
('Defender', 'Left', 'Wing Back', 'Defend', 'WB_D'),
('Defender', 'Left', 'Wing Back', 'Support', 'WB_S'),
('Midfielder', 'Left', 'Defensive Winger', 'Attack', 'DW_A'),
('Midfielder', 'Left', 'Defensive Winger', 'Support', 'DW_S'),
('Midfielder', 'Left', 'Wide Midfielder', 'Attack', 'WM_A'),
('Midfielder', 'Left', 'Wide Midfielder', 'Automatic', 'WM_Au'),
('Midfielder', 'Left', 'Wide Midfielder', 'Defend', 'WM_D'),
('Midfielder', 'Left', 'Wide Midfielder', 'Support', 'WM_S'),
('Midfielder', 'Left', 'Winger', 'Attack', 'W_A'),
('Midfielder', 'Left', 'Winger', 'Support', 'W_S'),
('Wing Back', 'Left', 'Wing Back', 'Attack', 'WB_A'),
('Wing Back', 'Left', 'Wing Back', 'Automatic', 'WB_Au'),
('Wing Back', 'Left', 'Wing Back', 'Defend', 'WB_D'),
('Wing Back', 'Left', 'Wing Back', 'Support', 'WB_S'),
('Goalkeeper', 'None', 'Goalkeeper', 'Defend', 'GK_D'),
('Goalkeeper', 'None', 'Sweeper Keeper', 'Attack', 'SWK_A'),
('Goalkeeper', 'None', 'Sweeper Keeper', 'Defend', 'SWK_D'),
('Goalkeeper', 'None', 'Sweeper Keeper', 'Support', 'SWK_S'),
('Sweeper', 'None', 'Libero', 'Attack', 'L_A'),
('Sweeper', 'None', 'Libero', 'Support', 'L_S'),
('Sweeper', 'None', 'Sweeper', 'Defend', 'SW_D'),
('Attacking Midfielder', 'Right', 'Advanced Playmaker', 'Attack', 'AP_A'),
('Attacking Midfielder', 'Right', 'Advanced Playmaker', 'Support', 'AP_S'),
('Attacking Midfielder', 'Right', 'Defensive Winger', 'Attack', 'DW_A'),
('Attacking Midfielder', 'Right', 'Defensive Winger', 'Support', 'DW_S'),
('Attacking Midfielder', 'Right', 'Inside Forward', 'Attack', 'IF_A'),
('Attacking Midfielder', 'Right', 'Inside Forward', 'Support', 'IF_S'),
('Attacking Midfielder', 'Right', 'Winger', 'Attack', 'W_A'),
('Attacking Midfielder', 'Right', 'Winger', 'Support', 'W_S'),
('Defender', 'Right', 'Full Back', 'Attack', 'FB_A'),
('Defender', 'Right', 'Full Back', 'Automatic', 'FB_Au'),
('Defender', 'Right', 'Full Back', 'Defend', 'FB_D'),
('Defender', 'Right', 'Full Back', 'Support', 'FB_S'),
('Defender', 'Right', 'Wing Back', 'Attack', 'WB_A'),
('Defender', 'Right', 'Wing Back', 'Automatic', 'WB_Au'),
('Defender', 'Right', 'Wing Back', 'Defend', 'WB_D'),
('Defender', 'Right', 'Wing Back', 'Support', 'WB_S'),
('Midfielder', 'Right', 'Defensive Winger', 'Attack', 'DW_A'),
('Midfielder', 'Right', 'Defensive Winger', 'Support', 'DW_S'),
('Midfielder', 'Right', 'Wide Midfielder', 'Attack', 'WM_A'),
('Midfielder', 'Right', 'Wide Midfielder', 'Automatic', 'WM_Au'),
('Midfielder', 'Right', 'Wide Midfielder', 'Defend', 'WM_D'),
('Midfielder', 'Right', 'Wide Midfielder', 'Support', 'WM_S'),
('Midfielder', 'Right', 'Winger', 'Attack', 'W_A'),
('Midfielder', 'Right', 'Winger', 'Support', 'W_S'),
('Wing Back', 'Right', 'Wing Back', 'Attack', 'WB_A'),
('Wing Back', 'Right', 'Wing Back', 'Automatic', 'WB_Au'),
('Wing Back', 'Right', 'Wing Back', 'Defend', 'WB_D'),
('Wing Back', 'Right', 'Wing Back', 'Support', 'WB_S');

-- --------------------------------------------------------

--
-- Stand-in structure for view `p_a`
--
CREATE TABLE IF NOT EXISTS `p_a` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `Role` varchar(50) NOT NULL,
  PRIMARY KEY (`Role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`Role`) VALUES
('Advanced Forward'),
('Advanced Playmaker'),
('Anchor Man'),
('Attacking Midfielder'),
('Ball Playing Defender'),
('Ball Winning Midfielder'),
('Box To Box Midfielder'),
('Central Defender'),
('Central Midfielder'),
('Complete Forward'),
('Deep Lying Forward'),
('Deep Lying Playmaker'),
('Defensive Forward'),
('Defensive Midfielder'),
('Defensive Winger'),
('Full Back'),
('Goalkeeper'),
('Inside Forward'),
('Libero'),
('Limited Defender'),
('Poacher'),
('Sweeper'),
('Sweeper Keeper'),
('Target Man'),
('Trequartista'),
('Wide Midfielder'),
('Wing Back'),
('Winger');

-- --------------------------------------------------------

--
-- Table structure for table `side`
--

CREATE TABLE IF NOT EXISTS `side` (
  `Side` varchar(10) NOT NULL,
  PRIMARY KEY (`Side`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `side`
--

INSERT INTO `side` (`Side`) VALUES
('Centre'),
('Left'),
('None'),
('Right');

-- --------------------------------------------------------

--
-- Stand-in structure for view `tm_a`
--
CREATE TABLE IF NOT EXISTS `tm_a` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `tm_s`
--
CREATE TABLE IF NOT EXISTS `tm_s` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Table structure for table `typesgk`
--

CREATE TABLE IF NOT EXISTS `typesgk` (
  `Type` varchar(50) NOT NULL,
  KEY `gk_types` (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `typesgk`
--

INSERT INTO `typesgk` (`Type`) VALUES
('Goalkeeping'),
('Mental'),
('Physical');

-- --------------------------------------------------------

--
-- Table structure for table `typesoutfield`
--

CREATE TABLE IF NOT EXISTS `typesoutfield` (
  `Type` varchar(50) NOT NULL,
  PRIMARY KEY (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `typesoutfield`
--

INSERT INTO `typesoutfield` (`Type`) VALUES
('Mental'),
('Physical'),
('Technical');

-- --------------------------------------------------------

--
-- Stand-in structure for view `w_sa`
--
CREATE TABLE IF NOT EXISTS `w_sa` (
`Attribute` varchar(50)
,`Type` varchar(50)
,`Category` varchar(50)
);
-- --------------------------------------------------------

--
-- Structure for view `ap_s`
--
DROP TABLE IF EXISTS `ap_s`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ap_s` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'First Touch') or (`attributesoutfield`.`Attribute` = 'Passing') or (`attributesoutfield`.`Attribute` = 'Technique') or (`attributesoutfield`.`Attribute` = 'Creativity') or (`attributesoutfield`.`Attribute` = 'Decisions') or (`attributesoutfield`.`Attribute` = 'Flair') or (`attributesoutfield`.`Attribute` = 'Teamwork') or (`attributesoutfield`.`Attribute` = 'Work Rate') or (`attributesoutfield`.`Attribute` = 'Stamina'));

-- --------------------------------------------------------

--
-- Structure for view `bwm_d`
--
DROP TABLE IF EXISTS `bwm_d`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `bwm_d` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'Marking') or (`attributesoutfield`.`Attribute` = 'Tackling') or (`attributesoutfield`.`Attribute` = 'Aggression') or (`attributesoutfield`.`Attribute` = 'Bravery') or (`attributesoutfield`.`Attribute` = 'Determination') or (`attributesoutfield`.`Attribute` = 'Positioning') or (`attributesoutfield`.`Attribute` = 'Teamwork') or (`attributesoutfield`.`Attribute` = 'Work Rate') or (`attributesoutfield`.`Attribute` = 'Stamina') or (`attributesoutfield`.`Attribute` = 'Strength'));

-- --------------------------------------------------------

--
-- Structure for view `cd_c`
--
DROP TABLE IF EXISTS `cd_c`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cd_c` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'Heading') or (`attributesoutfield`.`Attribute` = 'Marking') or (`attributesoutfield`.`Attribute` = 'Tackling') or (`attributesoutfield`.`Attribute` = 'Composure') or (`attributesoutfield`.`Attribute` = 'Concentration') or (`attributesoutfield`.`Attribute` = 'Decisions') or (`attributesoutfield`.`Attribute` = 'Determination') or (`attributesoutfield`.`Attribute` = 'Positioning') or (`attributesoutfield`.`Attribute` = 'Jumping') or (`attributesoutfield`.`Attribute` = 'Strength') or (`attributesoutfield`.`Attribute` = 'Anticipation') or (`attributesoutfield`.`Attribute` = 'Acceleration'));

-- --------------------------------------------------------

--
-- Structure for view `cd_d`
--
DROP TABLE IF EXISTS `cd_d`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cd_d` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'Heading') or (`attributesoutfield`.`Attribute` = 'Marking') or (`attributesoutfield`.`Attribute` = 'Tackling') or (`attributesoutfield`.`Attribute` = 'Composure') or (`attributesoutfield`.`Attribute` = 'Concentration') or (`attributesoutfield`.`Attribute` = 'Decisions') or (`attributesoutfield`.`Attribute` = 'Determination') or (`attributesoutfield`.`Attribute` = 'Positioning') or (`attributesoutfield`.`Attribute` = 'Jumping') or (`attributesoutfield`.`Attribute` = 'Strength'));

-- --------------------------------------------------------

--
-- Structure for view `cd_s`
--
DROP TABLE IF EXISTS `cd_s`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cd_s` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'Heading') or (`attributesoutfield`.`Attribute` = 'Marking') or (`attributesoutfield`.`Attribute` = 'Tackling') or (`attributesoutfield`.`Attribute` = 'Composure') or (`attributesoutfield`.`Attribute` = 'Concentration') or (`attributesoutfield`.`Attribute` = 'Decisions') or (`attributesoutfield`.`Attribute` = 'Determination') or (`attributesoutfield`.`Attribute` = 'Positioning') or (`attributesoutfield`.`Attribute` = 'Jumping') or (`attributesoutfield`.`Attribute` = 'Strength') or (`attributesoutfield`.`Attribute` = 'Aggression') or (`attributesoutfield`.`Attribute` = 'Bravery'));

-- --------------------------------------------------------

--
-- Structure for view `dlf_s`
--
DROP TABLE IF EXISTS `dlf_s`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `dlf_s` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'Dribbling') or (`attributesoutfield`.`Attribute` = 'First Touch') or (`attributesoutfield`.`Attribute` = 'Long Shots') or (`attributesoutfield`.`Attribute` = 'Passing') or (`attributesoutfield`.`Attribute` = 'Technique') or (`attributesoutfield`.`Attribute` = 'Creativity') or (`attributesoutfield`.`Attribute` = 'Decisions') or (`attributesoutfield`.`Attribute` = 'Off The Ball') or (`attributesoutfield`.`Attribute` = 'Teamwork') or (`attributesoutfield`.`Attribute` = 'Strength'));

-- --------------------------------------------------------

--
-- Structure for view `fb_sau`
--
DROP TABLE IF EXISTS `fb_sau`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `fb_sau` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'Marking') or (`attributesoutfield`.`Attribute` = 'Tackling') or (`attributesoutfield`.`Attribute` = 'Positioning') or (`attributesoutfield`.`Attribute` = 'Teamwork') or (`attributesoutfield`.`Attribute` = 'Work Rate') or (`attributesoutfield`.`Attribute` = 'Acceleration') or (`attributesoutfield`.`Attribute` = 'Stamina') or (`attributesoutfield`.`Attribute` = 'Anticipation') or (`attributesoutfield`.`Attribute` = 'Concentration') or (`attributesoutfield`.`Attribute` = 'Crossing'));

-- --------------------------------------------------------

--
-- Structure for view `gk_backprime`
--
DROP TABLE IF EXISTS `gk_backprime`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gk_backprime` AS select `attributesgk`.`Attribute` AS `Attribute`,`attributesgk`.`Type` AS `Type`,`attributesgk`.`Category` AS `Category` from `attributesgk` where ((`attributesgk`.`Attribute` = 'Concentration') or (`attributesgk`.`Attribute` = 'Determination') or (`attributesgk`.`Attribute` = 'Teamwork') or (`attributesgk`.`Attribute` = 'Work Rate') or (`attributesgk`.`Attribute` = 'Technique') or (`attributesgk`.`Attribute` = 'Anticipation') or (`attributesgk`.`Attribute` = 'Decisions'));

-- --------------------------------------------------------

--
-- Structure for view `gk_d`
--
DROP TABLE IF EXISTS `gk_d`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gk_d` AS select `attributesgk`.`Attribute` AS `Attribute`,`attributesgk`.`Type` AS `Type`,`attributesgk`.`Category` AS `Category` from `attributesgk` where ((`attributesgk`.`Attribute` = 'Aerial Ability') or (`attributesgk`.`Attribute` = 'Command Of Area') or (`attributesgk`.`Attribute` = 'Handling') or (`attributesgk`.`Attribute` = 'One On Ones') or (`attributesgk`.`Attribute` = 'Reflexes') or (`attributesgk`.`Attribute` = 'Composure') or (`attributesgk`.`Attribute` = 'Concentration') or (`attributesgk`.`Attribute` = 'Decisions') or (`attributesgk`.`Attribute` = 'Positioning') or (`attributesgk`.`Attribute` = 'Agility'));

-- --------------------------------------------------------

--
-- Structure for view `outfield_backprime`
--
DROP TABLE IF EXISTS `outfield_backprime`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `outfield_backprime` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'Concentration') or (`attributesoutfield`.`Attribute` = 'Determination') or (`attributesoutfield`.`Attribute` = 'Teamwork') or (`attributesoutfield`.`Attribute` = 'Work Rate') or (`attributesoutfield`.`Attribute` = 'Technique') or (`attributesoutfield`.`Attribute` = 'Anticipation') or (`attributesoutfield`.`Attribute` = 'Creativity') or (`attributesoutfield`.`Attribute` = 'Decisions'));

-- --------------------------------------------------------

--
-- Structure for view `p_a`
--
DROP TABLE IF EXISTS `p_a`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `p_a` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'Dribbling') or (`attributesoutfield`.`Attribute` = 'Finishing') or (`attributesoutfield`.`Attribute` = 'First Touch') or (`attributesoutfield`.`Attribute` = 'Anticipation') or (`attributesoutfield`.`Attribute` = 'Composure') or (`attributesoutfield`.`Attribute` = 'Off The Ball') or (`attributesoutfield`.`Attribute` = 'Acceleration') or (`attributesoutfield`.`Attribute` = 'Agility') or (`attributesoutfield`.`Attribute` = 'Balance') or (`attributesoutfield`.`Attribute` = 'Pace'));

-- --------------------------------------------------------

--
-- Structure for view `tm_a`
--
DROP TABLE IF EXISTS `tm_a`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `tm_a` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'Finishing') or (`attributesoutfield`.`Attribute` = 'First Touch') or (`attributesoutfield`.`Attribute` = 'Heading') or (`attributesoutfield`.`Attribute` = 'Anticipation') or (`attributesoutfield`.`Attribute` = 'Bravery') or (`attributesoutfield`.`Attribute` = 'Determination') or (`attributesoutfield`.`Attribute` = 'Teamwork') or (`attributesoutfield`.`Attribute` = 'Work Rate') or (`attributesoutfield`.`Attribute` = 'Jumping') or (`attributesoutfield`.`Attribute` = 'Strength'));

-- --------------------------------------------------------

--
-- Structure for view `tm_s`
--
DROP TABLE IF EXISTS `tm_s`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `tm_s` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'First Touch') or (`attributesoutfield`.`Attribute` = 'Heading') or (`attributesoutfield`.`Attribute` = 'Long Shots') or (`attributesoutfield`.`Attribute` = 'Aggression') or (`attributesoutfield`.`Attribute` = 'Bravery') or (`attributesoutfield`.`Attribute` = 'Determination') or (`attributesoutfield`.`Attribute` = 'Teamwork') or (`attributesoutfield`.`Attribute` = 'Work Rate') or (`attributesoutfield`.`Attribute` = 'Jumping') or (`attributesoutfield`.`Attribute` = 'Strength'));

-- --------------------------------------------------------

--
-- Structure for view `w_sa`
--
DROP TABLE IF EXISTS `w_sa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `w_sa` AS select `attributesoutfield`.`Attribute` AS `Attribute`,`attributesoutfield`.`Type` AS `Type`,`attributesoutfield`.`Category` AS `Category` from `attributesoutfield` where ((`attributesoutfield`.`Attribute` = 'Crossing') or (`attributesoutfield`.`Attribute` = 'Dribbling') or (`attributesoutfield`.`Attribute` = 'Technique') or (`attributesoutfield`.`Attribute` = 'Decisions') or (`attributesoutfield`.`Attribute` = 'Flair') or (`attributesoutfield`.`Attribute` = 'Off The Ball') or (`attributesoutfield`.`Attribute` = 'Acceleration') or (`attributesoutfield`.`Attribute` = 'Agility') or (`attributesoutfield`.`Attribute` = 'Balance') or (`attributesoutfield`.`Attribute` = 'Pace'));

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attributesgk`
--
ALTER TABLE `attributesgk`
  ADD CONSTRAINT `SYS_FK_108` FOREIGN KEY (`Category`) REFERENCES `categoriesgk` (`Category`),
  ADD CONSTRAINT `SYS_FK_122` FOREIGN KEY (`Type`) REFERENCES `typesgk` (`Type`);

--
-- Constraints for table `attributesoutfield`
--
ALTER TABLE `attributesoutfield`
  ADD CONSTRAINT `SYS_FK_113` FOREIGN KEY (`Category`) REFERENCES `categoriesoutfield` (`Category`),
  ADD CONSTRAINT `SYS_FK_119` FOREIGN KEY (`Type`) REFERENCES `typesoutfield` (`Type`);

--
-- Constraints for table `positions_to_roles`
--
ALTER TABLE `positions_to_roles`
  ADD CONSTRAINT `SYS_FK_181` FOREIGN KEY (`Duty`) REFERENCES `duty` (`Duty`),
  ADD CONSTRAINT `SYS_FK_172` FOREIGN KEY (`PitchArea`) REFERENCES `pitcharea` (`PitchArea`),
  ADD CONSTRAINT `SYS_FK_175` FOREIGN KEY (`Side`) REFERENCES `side` (`Side`),
  ADD CONSTRAINT `SYS_FK_178` FOREIGN KEY (`Role`) REFERENCES `role` (`Role`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
