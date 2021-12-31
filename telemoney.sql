-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2021 at 09:31 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `telemoney`
--

-- --------------------------------------------------------

--
-- Table structure for table `chi`
--

CREATE TABLE `chi` (
  `idchi` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `namechi` varchar(100) NOT NULL,
  `amountchi` double NOT NULL,
  `deschi` varchar(100) NOT NULL,
  `datechi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chovay`
--

CREATE TABLE `chovay` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `ten` varchar(100) NOT NULL,
  `bank` varchar(100) NOT NULL,
  `tiengoc` double NOT NULL,
  `laisuat` double NOT NULL,
  `kyhan` int(11) NOT NULL,
  `ngaychovay` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='chovay';

--
-- Dumping data for table `chovay`
--

INSERT INTO `chovay` (`id`, `uid`, `ten`, `bank`, `tiengoc`, `laisuat`, `kyhan`, `ngaychovay`) VALUES
(1, 1, 'duan', 'MBBank', 1000000, 5, 12, '2021-12-31 08:22:09'),
(2, 1, 'ban duan', 'ACB', 2000000, 4, 24, '2021-12-31 10:16:53'),
(3, 1, 'ngu', 'FFF', 12222222, 21, 12, '2021-12-31 10:16:59');

-- --------------------------------------------------------

--
-- Table structure for table `mystock`
--

CREATE TABLE `mystock` (
  `symbol` text NOT NULL,
  `name` text NOT NULL,
  `soluong` int(65) NOT NULL,
  `tongbandau` float NOT NULL,
  `giabandau` float NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mystock`
--

INSERT INTO `mystock` (`symbol`, `name`, `soluong`, `tongbandau`, `giabandau`, `time`) VALUES
('AAPL', 'Apple', 102, 20354, 199.549, '2021-12-28 22:01:30'),
('AMZN', 'Amazon.com Inc.', 1, 3344.75, 3344.75, '2022-01-01 03:11:19'),
('COIN', 'Coinbase', 10, 1250, 125, '2021-12-28 22:01:30'),
('GOOG', 'Alphabet Inc. Class C', 1, 2905.19, 2905.19, '2022-01-01 03:30:51'),
('MSFT', 'Microsoft Corporation', 34, 8500, 250, '2021-12-28 22:29:06'),
('TSLA', 'TESLA', 100, 34000000, 867, '2021-12-28 20:28:01');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` varchar(50) DEFAULT NULL,
  `HOTEN` varchar(50) DEFAULT NULL,
  `LUONG` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `HOTEN`, `LUONG`) VALUES
('AT1289736', 'Hoha haha', '78000000'),
('AT981723', 'Hutao', '87000132'),
('YU987123', 'okokokok', '78000000'),
('KJ90879', 'Baka Mitai', '2300000'),
('123', 'ajhsg', '-878234');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `Company` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Symbol` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Price` decimal(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`Company`, `Symbol`, `Price`) VALUES
('Agilent Technologies Inc.', 'A', '157.80'),
('American Airlines Group Inc.', 'AAL', '18.22'),
('Advance Auto Parts Inc.', 'AAP', '232.13'),
('Apple Inc.', 'AAPL', '176.34'),
('AbbVie Inc.', 'ABBV', '133.09'),
('AmerisourceBergen Corporation', 'ABC', '129.53'),
('ABIOMED Inc.', 'ABMD', '352.21'),
('Abbott Laboratories', 'ABT', '139.16'),
('Accenture Plc Class A', 'ACN', '403.31'),
('Adobe Inc.', 'ADBE', '570.88'),
('Analog Devices Inc.', 'ADI', '172.66'),
('Archer-Daniels-Midland Company', 'ADM', '65.44'),
('Automatic Data Processing Inc.', 'ADP', '242.00'),
('Autodesk Inc.', 'ADSK', '281.11'),
('Ameren Corporation', 'AEE', '87.02'),
('American Electric Power Company Inc.', 'AEP', '86.92'),
('AES Corporation', 'AES', '23.55'),
('Aflac Incorporated', 'AFL', '57.69'),
('American International Group Inc.', 'AIG', '56.57'),
('Assurant Inc.', 'AIZ', '152.28'),
('Arthur J. Gallagher & Co.', 'AJG', '166.45'),
('Akamai Technologies Inc.', 'AKAM', '116.20'),
('Albemarle Corporation', 'ALB', '227.90'),
('Align Technology Inc.', 'ALGN', '654.00'),
('Alaska Air Group Inc.', 'ALK', '53.02'),
('Allstate Corporation', 'ALL', '114.13'),
('Allegion PLC', 'ALLE', '127.28'),
('Applied Materials Inc.', 'AMAT', '155.10'),
('Amcor PLC', 'AMCR', '11.66'),
('Advanced Micro Devices Inc.', 'AMD', '145.92'),
('AMETEK Inc.', 'AME', '142.57'),
('Amgen Inc.', 'AMGN', '224.80'),
('Ameriprise Financial Inc.', 'AMP', '302.28'),
('American Tower Corporation', 'AMT', '278.74'),
('Amazon.com Inc.', 'AMZN', '3418.46'),
('Arista Networks Inc.', 'ANET', '141.85'),
('ANSYS Inc.', 'ANSS', '403.59'),
('Anthem Inc.', 'ANTM', '455.71'),
('Aon Plc Class A', 'AON', '292.41'),
('A. O. Smith Corporation', 'AOS', '82.77'),
('APA Corp.', 'APA', '26.28'),
('Air Products and Chemicals Inc.', 'APD', '299.48'),
('Amphenol Corporation Class A', 'APH', '85.06'),
('Aptiv PLC', 'APTV', '162.40'),
('Alexandria Real Estate Equities Inc.', 'ARE', '217.63'),
('Atmos Energy Corporation', 'ATO', '102.73'),
('Activision Blizzard Inc.', 'ATVI', '65.00'),
('AvalonBay Communities Inc.', 'AVB', '245.77'),
('Broadcom Inc.', 'AVGO', '664.00'),
('Avery Dennison Corporation', 'AVY', '208.47'),
('American Water Works Company Inc.', 'AWK', '182.08'),
('American Express Company', 'AXP', '164.19'),
('AutoZone Inc.', 'AZO', '2014.50'),
('Boeing Company', 'BA', '204.22'),
('Bank of America Corp', 'BAC', '44.42'),
('Baxter International Inc.', 'BAX', '85.55'),
('Bath & Body Works Inc.', 'BBWI', '69.50'),
('Best Buy Co. Inc.', 'BBY', '98.08'),
('Becton Dickinson and Company', 'BDX', '248.91'),
('Franklin Resources Inc.', 'BEN', '33.42'),
('Brown-Forman Corporation Class B', 'BF.B', '71.72'),
('Biogen Inc.', 'BIIB', '235.41'),
('Bio-Rad Laboratories Inc. Class A', 'BIO', '746.26'),
('Bank of New York Mellon Corporation', 'BK', '58.11'),
('Booking Holdings Inc.', 'BKNG', '2402.25'),
('Baker Hughes Company Class A', 'BKR', '24.22'),
('BlackRock Inc.', 'BLK', '913.92'),
('Ball Corporation', 'BLL', '90.00'),
('Bristol-Myers Squibb Company', 'BMY', '62.05'),
('Broadridge Financial Solutions Inc.', 'BR', '180.29'),
('Berkshire Hathaway Inc. Class B', 'BRK.B', '294.49'),
('Brown & Brown Inc.', 'BRO', '68.03'),
('Boston Scientific Corporation', 'BSX', '42.72'),
('BITCOIN', 'BTC-USD', '4000.00'),
('BorgWarner Inc.', 'BWA', '43.62'),
('Boston Properties Inc.', 'BXP', '114.26'),
('Citigroup Inc.', 'C', '60.20'),
('Conagra Brands Inc.', 'CAG', '33.33'),
('Cardinal Health Inc.', 'CAH', '50.75'),
('Carrier Global Corp.', 'CARR', '52.82'),
('Caterpillar Inc.', 'CAT', '206.20'),
('Chubb Limited', 'CB', '190.64'),
('Cboe Global Markets Inc', 'CBOE', '129.00'),
('CBRE Group Inc. Class A', 'CBRE', '105.82'),
('Crown Castle International Corp', 'CCI', '199.39'),
('Carnival Corporation', 'CCL', '21.20'),
('Ceridian HCM Holding Inc.', 'CDAY', '103.89'),
('Cadence Design Systems Inc.', 'CDNS', '188.99'),
('CDW Corp.', 'CDW', '202.76'),
('Celanese Corporation', 'CE', '161.32'),
('Cerner Corporation', 'CERN', '91.80'),
('CF Industries Holdings Inc.', 'CF', '72.30'),
('Citizens Financial Group Inc.', 'CFG', '46.63'),
('Church & Dwight Co. Inc.', 'CHD', '99.00'),
('C.H. Robinson Worldwide Inc.', 'CHRW', '102.45'),
('Charter Communications Inc. Class A', 'CHTR', '652.50'),
('Cigna Corporation', 'CI', '225.00'),
('Cincinnati Financial Corporation', 'CINF', '112.34'),
('Colgate-Palmolive Company', 'CL', '82.79'),
('Clorox Company', 'CLX', '169.83'),
('Comerica Incorporated', 'CMA', '85.30'),
('Comcast Corporation Class A', 'CMCSA', '50.00'),
('CME Group Inc. Class A', 'CME', '226.01'),
('Chipotle Mexican Grill Inc.', 'CMG', '1748.67'),
('Cummins Inc.', 'CMI', '213.97'),
('CMS Energy Corporation', 'CMS', '63.52'),
('Centene Corporation', 'CNC', '84.72'),
('CenterPoint Energy Inc.', 'CNP', '27.52'),
('Capital One Financial Corporation', 'COF', '145.10'),
('Cooper Companies Inc.', 'COO', '411.21'),
('ConocoPhillips', 'COP', '71.19'),
('Costco Wholesale Corporation', 'COST', '549.02'),
('Campbell Soup Company', 'CPB', '41.96'),
('Copart Inc.', 'CPRT', '146.18'),
('Charles River Laboratories International Inc.', 'CRL', '369.20'),
('salesforce.com inc.', 'CRM', '253.14'),
('Cisco Systems Inc.', 'CSCO', '62.31'),
('CSX Corporation', 'CSX', '36.79'),
('Cintas Corporation', 'CTAS', '436.79'),
('Catalent Inc', 'CTLT', '124.96'),
('Coterra Energy Inc.', 'CTRA', '19.47'),
('Cognizant Technology Solutions Corporation Class A', 'CTSH', '86.51'),
('Corteva Inc', 'CTVA', '46.44'),
('Citrix Systems Inc.', 'CTXS', '97.87'),
('CVS Health Corporation', 'CVS', '101.31'),
('Chevron Corporation', 'CVX', '116.41'),
('Caesars Entertainment Inc', 'CZR', '94.45'),
('Dominion Energy Inc', 'D', '77.34'),
('Delta Air Lines Inc.', 'DAL', '39.30'),
('DuPont de Nemours Inc.', 'DD', '78.54'),
('Deere & Company', 'DE', '349.22'),
('Discover Financial Services', 'DFS', '115.34'),
('Dollar General Corporation', 'DG', '221.33'),
('Quest Diagnostics Incorporated', 'DGX', '167.05'),
('D.R. Horton Inc.', 'DHI', '104.92'),
('Danaher Corporation', 'DHR', '320.79'),
('Walt Disney Company', 'DIS', '153.63'),
('Discovery Inc. Class A', 'DISCA', '24.25'),
('Discovery Inc. Class C', 'DISCK', '23.49'),
('DISH Network Corporation Class A', 'DISH', '32.59'),
('Digital Realty Trust Inc.', 'DLR', '169.81'),
('Dollar Tree Inc.', 'DLTR', '137.35'),
('Dover Corporation', 'DOV', '173.74'),
('Dow Inc.', 'DOW', '55.14'),
('Domino\'s Pizza Inc.', 'DPZ', '545.84'),
('Duke Realty Corporation', 'DRE', '62.59'),
('Darden Restaurants Inc.', 'DRI', '148.84'),
('DTE Energy Company', 'DTE', '116.82'),
('Duke Energy Corporation', 'DUK', '102.97'),
('DaVita Inc.', 'DVA', '111.42'),
('Devon Energy Corporation', 'DVN', '42.05'),
('DXC Technology Co.', 'DXC', '32.57'),
('DexCom Inc.', 'DXCM', '573.01'),
('Electronic Arts Inc.', 'EA', '133.38'),
('eBay Inc.', 'EBAY', '65.35'),
('Ecolab Inc.', 'ECL', '228.24'),
('Consolidated Edison Inc.', 'ED', '83.77'),
('Equifax Inc.', 'EFX', '287.03'),
('Edison International', 'EIX', '67.67'),
('Estee Lauder Companies Inc. Class A', 'EL', '365.99'),
('Eastman Chemical Company', 'EMN', '119.49'),
('Emerson Electric Co.', 'EMR', '91.28'),
('Enphase Energy Inc.', 'ENPH', '188.00'),
('EOG Resources Inc.', 'EOG', '87.18'),
('EPAM Systems Inc.', 'EPAM', '665.00'),
('Equinix Inc.', 'EQIX', '818.76'),
('Equity Residential', 'EQR', '88.18'),
('Eversource Energy', 'ES', '89.44'),
('Essex Property Trust Inc.', 'ESS', '342.67'),
('Ethereum', 'ETH', '3988.00'),
('Eaton Corp. Plc', 'ETN', '168.04'),
('Entergy Corporation', 'ETR', '110.09'),
('Etsy Inc.', 'ETSY', '228.16'),
('Evergy Inc.', 'EVRG', '66.75'),
('Edwards Lifesciences Corporation', 'EW', '128.57'),
('Exelon Corporation', 'EXC', '54.68'),
('Expeditors International of Washington Inc.', 'EXPD', '130.76'),
('Expedia Group Inc.', 'EXPE', '184.00'),
('Extra Space Storage Inc.', 'EXR', '218.00'),
('Ford Motor Company', 'F', '20.23'),
('Diamondback Energy Inc.', 'FANG', '105.92'),
('Fastenal Company', 'FAST', '62.59'),
('Meta Platforms Inc. Class A', 'FB', '336.00'),
('Fortune Brands Home & Security Inc.', 'FBHS', '102.75'),
('Freeport-McMoRan Inc.', 'FCX', '41.13'),
('FactSet Research Systems Inc.', 'FDS', '479.51'),
('FedEx Corporation', 'FDX', '253.82'),
('FirstEnergy Corp.', 'FE', '40.53'),
('F5 Inc.', 'FFIV', '234.84'),
('Fidelity National Information Services Inc.', 'FIS', '109.05'),
('Fiserv Inc.', 'FISV', '105.54'),
('Fifth Third Bancorp', 'FITB', '43.00'),
('FLEETCOR Technologies Inc.', 'FLT', '223.69'),
('FMC Corporation', 'FMC', '109.10'),
('Fox Corporation Class B', 'FOX', '35.10'),
('Fox Corporation Class A', 'FOXA', '37.28'),
('First Republic Bank', 'FRC', '203.91'),
('Federal Realty Investment Trust', 'FRT', '132.38'),
('Fortinet Inc.', 'FTNT', '348.40'),
('Fortive Corp.', 'FTV', '74.50'),
('General Dynamics Corporation', 'GD', '204.69'),
('General Electric Company', 'GE', '94.00'),
('Gilead Sciences Inc.', 'GILD', '72.12'),
('General Mills Inc.', 'GIS', '65.99'),
('Globe Life Inc.', 'GL', '92.70'),
('Corning Inc', 'GLW', '36.75'),
('General Motors Company', 'GM', '56.91'),
('Generac Holdings Inc.', 'GNRC', '349.90'),
('Alphabet Inc. Class C', 'GOOG', '2942.00'),
('Alphabet Inc. Class A', 'GOOGL', '2938.00'),
('Genuine Parts Company', 'GPC', '135.37'),
('Global Payments Inc.', 'GPN', '135.37'),
('Gap Inc.', 'GPS', '17.28'),
('Garmin Ltd.', 'GRMN', '134.48'),
('Goldman Sachs Group Inc.', 'GS', '385.04'),
('W.W. Grainger Inc.', 'GWW', '503.01'),
('Halliburton Company', 'HAL', '22.71'),
('Hasbro Inc.', 'HAS', '97.92'),
('Huntington Bancshares Incorporated', 'HBAN', '15.25'),
('HCA Healthcare Inc', 'HCA', '252.05'),
('Home Depot Inc.', 'HD', '397.07'),
('Hess Corporation', 'HES', '73.49'),
('Hartford Financial Services Group Inc.', 'HIG', '68.27'),
('Huntington Ingalls Industries Inc.', 'HII', '182.21'),
('Hilton Worldwide Holdings Inc', 'HLT', '154.71'),
('Hologic Inc.', 'HOLX', '76.12'),
('Honeywell International Inc.', 'HON', '205.44'),
('Hewlett Packard Enterprise Co.', 'HPE', '15.76'),
('HP Inc.', 'HPQ', '37.96'),
('Hormel Foods Corporation', 'HRL', '46.84'),
('Henry Schein Inc.', 'HSIC', '74.93'),
('Host Hotels & Resorts Inc.', 'HST', '17.44'),
('Hershey Company', 'HSY', '188.46'),
('Humana Inc.', 'HUM', '460.54'),
('Howmet Aerospace Inc.', 'HWM', '31.13'),
('International Business Machines Corporation', 'IBM', '130.50'),
('Intercontinental Exchange Inc.', 'ICE', '135.84'),
('IDEXX Laboratories Inc.', 'IDXX', '645.00'),
('IDEX Corporation', 'IEX', '230.64'),
('International Flavors & Fragrances Inc.', 'IFF', '143.09'),
('Illumina Inc.', 'ILMN', '380.93'),
('Incyte Corporation', 'INCY', '73.54'),
('IHS Markit Ltd.', 'INFO', '132.90'),
('Intel Corporation', 'INTC', '51.21'),
('Intuit Inc.', 'INTU', '637.00'),
('International Paper Company', 'IP', '45.84'),
('Interpublic Group of Companies Inc.', 'IPG', '37.07'),
('IPG Photonics Corporation', 'IPGP', '168.90'),
('IQVIA Holdings Inc', 'IQV', '281.11'),
('Ingersoll Rand Inc.', 'IR', '59.74'),
('Iron Mountain Inc.', 'IRM', '51.60'),
('Intuitive Surgical Inc.', 'ISRG', '363.09'),
('Gartner Inc.', 'IT', '325.53'),
('Illinois Tool Works Inc.', 'ITW', '240.50'),
('Invesco Ltd.', 'IVZ', '23.34'),
('Jacobs Engineering Group Inc.', 'J', '137.35'),
('J.B. Hunt Transport Services Inc.', 'JBHT', '197.23'),
('Johnson Controls International plc', 'JCI', '78.11'),
('Jack Henry & Associates Inc.', 'JKHY', '165.43'),
('Johnson & Johnson', 'JNJ', '168.49'),
('Juniper Networks Inc.', 'JNPR', '34.05'),
('JPMorgan Chase & Co.', 'JPM', '157.20'),
('Kellogg Company', 'K', '62.87'),
('KeyCorp', 'KEY', '22.82'),
('Keysight Technologies Inc', 'KEYS', '202.71'),
('Kraft Heinz Company', 'KHC', '35.23'),
('Kimco Realty Corporation', 'KIM', '23.88'),
('KLA Corporation', 'KLAC', '421.00'),
('Kimberly-Clark Corporation', 'KMB', '138.89'),
('Kinder Morgan Inc Class P', 'KMI', '15.64'),
('CarMax Inc.', 'KMX', '126.20'),
('Coca-Cola Company', 'KO', '58.09'),
('Kroger Co.', 'KR', '43.21'),
('Loews Corporation', 'L', '57.02'),
('Leidos Holdings Inc.', 'LDOS', '87.35'),
('Lennar Corporation Class A', 'LEN', '112.49'),
('Laboratory Corporation of America Holdings', 'LH', '301.91'),
('L3Harris Technologies Inc', 'LHX', '208.00'),
('Linde plc', 'LIN', '339.17'),
('LKQ Corporation', 'LKQ', '58.49'),
('Eli Lilly and Company', 'LLY', '275.00'),
('Lockheed Martin Corporation', 'LMT', '347.99'),
('Lincoln National Corporation', 'LNC', '67.87'),
('Alliant Energy Corp', 'LNT', '59.55'),
('Lowe\'s Companies Inc.', 'LOW', '250.90'),
('Lam Research Corporation', 'LRCX', '698.72'),
('Lumen Technologies Inc.', 'LUMN', '12.84'),
('Southwest Airlines Co.', 'LUV', '41.87'),
('Las Vegas Sands Corp.', 'LVS', '38.59'),
('Lamb Weston Holdings Inc.', 'LW', '61.75'),
('LyondellBasell Industries NV', 'LYB', '90.55'),
('Live Nation Entertainment Inc.', 'LYV', '118.40'),
('Mastercard Incorporated Class A', 'MA', '360.58'),
('Mid-America Apartment Communities Inc.', 'MAA', '221.09'),
('Marriott International Inc. Class A', 'MAR', '165.88'),
('Masco Corporation', 'MAS', '68.00'),
('McDonald\'s Corporation', 'MCD', '265.05'),
('Microchip Technology Incorporated', 'MCHP', '86.61'),
('McKesson Corporation', 'MCK', '240.78'),
('Moody\'s Corporation', 'MCO', '397.26'),
('Mondelez International Inc. Class A', 'MDLZ', '64.85'),
('Medtronic Plc', 'MDT', '102.90'),
('MetLife Inc.', 'MET', '61.78'),
('MGM Resorts International', 'MGM', '45.83'),
('Mohawk Industries Inc.', 'MHK', '171.16'),
('McCormick & Company Incorporated', 'MKC', '93.03'),
('MarketAxess Holdings Inc.', 'MKTX', '410.67'),
('Martin Marietta Materials Inc.', 'MLM', '437.06'),
('Marsh & McLennan Companies Inc.', 'MMC', '170.57'),
('3M Company', 'MMM', '174.91'),
('Monster Beverage Corporation', 'MNST', '94.23'),
('Altria Group Inc', 'MO', '46.70'),
('Mosaic Company', 'MOS', '39.17'),
('Marathon Petroleum Corporation', 'MPC', '62.96'),
('Monolithic Power Systems Inc.', 'MPWR', '495.60'),
('Merck & Co. Inc.', 'MRK', '75.73'),
('Moderna Inc.', 'MRNA', '249.54'),
('Marathon Oil Corporation', 'MRO', '16.01'),
('Morgan Stanley', 'MS', '99.33'),
('MSCI Inc. Class A', 'MSCI', '611.27'),
('Microsoft Corporation', 'MSFT', '334.50'),
('Motorola Solutions Inc.', 'MSI', '262.90'),
('M&T Bank Corporation', 'MTB', '150.95'),
('Match Group Inc.', 'MTCH', '133.20'),
('Mettler-Toledo International Inc.', 'MTD', '1626.23'),
('Micron Technology Inc.', 'MU', '94.41'),
('Norwegian Cruise Line Holdings Ltd.', 'NCLH', '22.74'),
('Nasdaq Inc.', 'NDAQ', '206.00'),
('NextEra Energy Inc.', 'NEE', '90.50'),
('Newmont Corporation', 'NEM', '59.53'),
('Netflix Inc.', 'NFLX', '614.99'),
('NiSource Inc', 'NI', '26.87'),
('NIKE Inc. Class B', 'NKE', '165.85'),
('NortonLifeLock Inc.', 'NLOK', '25.80'),
('Nielsen Holdings Plc', 'NLSN', '21.00'),
('Northrop Grumman Corporation', 'NOC', '382.39'),
('ServiceNow Inc.', 'NOW', '648.57'),
('NRG Energy Inc.', 'NRG', '42.52'),
('Norfolk Southern Corporation', 'NSC', '287.53'),
('NetApp Inc.', 'NTAP', '90.63'),
('Northern Trust Corporation', 'NTRS', '118.13'),
('Nucor Corporation', 'NUE', '114.00'),
('NVIDIA Corporation', 'NVDA', '295.60'),
('NVR Inc.', 'NVR', '5784.63'),
('Newell Brands Inc', 'NWL', '21.46'),
('News Corporation Class B', 'NWS', '22.75'),
('News Corporation Class A', 'NWSA', '22.33'),
('NXP Semiconductors NV', 'NXPI', '227.15'),
('Realty Income Corporation', 'O', '69.22'),
('Old Dominion Freight Line Inc.', 'ODFL', '348.31'),
('Organon & Co.', 'OGN', '30.22'),
('ONEOK Inc.', 'OKE', '58.02'),
('Omnicom Group Inc', 'OMC', '72.19'),
('Oracle Corporation', 'ORCL', '89.60'),
('O\'Reilly Automotive Inc.', 'ORLY', '678.00'),
('Otis Worldwide Corporation', 'OTIS', '85.25'),
('Occidental Petroleum Corporation', 'OXY', '28.93'),
('Paycom Software Inc.', 'PAYC', '423.83'),
('Paychex Inc.', 'PAYX', '134.40'),
('People\'s United Financial Inc.', 'PBCT', '17.45'),
('PACCAR Inc', 'PCAR', '84.95'),
('Healthpeak Properties Inc.', 'PEAK', '35.19'),
('Public Service Enterprise Group Inc', 'PEG', '64.58'),
('Penn National Gaming Inc.', 'PENN', '51.54'),
('PepsiCo Inc.', 'PEP', '169.27'),
('Pfizer Inc.', 'PFE', '58.79'),
('Principal Financial Group Inc.', 'PFG', '72.00'),
('Procter & Gamble Company', 'PG', '160.12'),
('Progressive Corporation', 'PGR', '101.25'),
('Parker-Hannifin Corporation', 'PH', '311.89'),
('PulteGroup Inc.', 'PHM', '54.65'),
('Packaging Corporation of America', 'PKG', '131.30'),
('PerkinElmer Inc.', 'PKI', '194.00'),
('Prologis Inc.', 'PLD', '161.75'),
('Philip Morris International Inc.', 'PM', '92.70'),
('PNC Financial Services Group Inc.', 'PNC', '197.93'),
('Pentair plc', 'PNR', '71.22'),
('Pinnacle West Capital Corporation', 'PNW', '69.00'),
('Pool Corporation', 'POOL', '549.65'),
('PPG Industries Inc.', 'PPG', '167.06'),
('PPL Corporation', 'PPL', '29.42'),
('Prudential Financial Inc.', 'PRU', '108.25'),
('Public Storage', 'PSA', '362.00'),
('Phillips 66', 'PSX', '71.90'),
('PTC Inc.', 'PTC', '120.51'),
('PVH Corp.', 'PVH', '100.33'),
('Quanta Services Inc.', 'PWR', '111.88'),
('Pioneer Natural Resources Company', 'PXD', '180.03'),
('PayPal Holdings Inc.', 'PYPL', '191.90'),
('Qualcomm Inc', 'QCOM', '182.49'),
('Qorvo Inc.', 'QRVO', '152.00'),
('Royal Caribbean Group', 'RCL', '79.35'),
('Everest Re Group Ltd.', 'RE', '267.02'),
('Regency Centers Corporation', 'REG', '72.86'),
('Regeneron Pharmaceuticals Inc.', 'REGN', '623.00'),
('Regions Financial Corporation', 'RF', '21.52'),
('Robert Half International Inc.', 'RHI', '109.21'),
('Raymond James Financial Inc.', 'RJF', '99.40'),
('Ralph Lauren Corporation Class A', 'RL', '112.15'),
('ResMed Inc.', 'RMD', '258.82'),
('Rockwell Automation Inc.', 'ROK', '340.12'),
('Rollins Inc.', 'ROL', '32.78'),
('Roper Technologies Inc.', 'ROP', '478.33'),
('Ross Stores Inc.', 'ROST', '110.16'),
('Republic Services Inc.', 'RSG', '135.42'),
('Raytheon Technologies Corporation', 'RTX', '84.90'),
('SBA Communications Corp. Class A', 'SBAC', '374.28'),
('Signature Bank', 'SBNY', '319.50'),
('Starbucks Corporation', 'SBUX', '112.15'),
('Charles Schwab Corporation', 'SCHW', '85.00'),
('SolarEdge Technologies Inc.', 'SEDG', '281.15'),
('Sealed Air Corporation', 'SEE', '65.39'),
('Sherwin-Williams Company', 'SHW', '338.38'),
('SVB Financial Group', 'SIVB', '612.00'),
('J.M. Smucker Company', 'SJM', '132.99'),
('Schlumberger NV', 'SLB', '29.57'),
('Snap-on Incorporated', 'SNA', '209.94'),
('Synopsys Inc.', 'SNPS', '367.67'),
('Southern Company', 'SO', '66.54'),
('Simon Property Group Inc.', 'SPG', '155.46'),
('S&P Global Inc.', 'SPGI', '473.74'),
('Sempra Energy', 'SRE', '129.41'),
('STERIS Plc', 'STE', '244.00'),
('State Street Corporation', 'STT', '93.03'),
('Seagate Technology Holdings PLC', 'STX', '111.41'),
('Constellation Brands Inc. Class A', 'STZ', '244.04'),
('Stanley Black & Decker Inc.', 'SWK', '182.20'),
('Skyworks Solutions Inc.', 'SWKS', '154.14'),
('Synchrony Financial', 'SYF', '46.16'),
('Stryker Corporation', 'SYK', '269.10'),
('Sysco Corporation', 'SYY', '76.65'),
('AT&T Inc.', 'T', '24.87'),
('Molson Coors Beverage Company Class B', 'TAP', '45.59'),
('TransDigm Group Incorporated', 'TDG', '628.00'),
('Teledyne Technologies Incorporated', 'TDY', '428.73'),
('Bio-Techne Corporation', 'TECH', '493.50'),
('TE Connectivity Ltd.', 'TEL', '158.45'),
('Teradyne Inc.', 'TER', '162.74'),
('Truist Financial Corporation', 'TFC', '57.77'),
('Teleflex Incorporated', 'TFX', '327.38'),
('Target Corporation', 'TGT', '221.01'),
('TJX Companies Inc', 'TJX', '73.75'),
('Thermo Fisher Scientific Inc.', 'TMO', '651.00'),
('T-Mobile US Inc.', 'TMUS', '120.00'),
('Tapestry Inc.', 'TPR', '41.26'),
('Trimble Inc.', 'TRMB', '86.11'),
('T. Rowe Price Group', 'TROW', '195.29'),
('Travelers Companies Inc.', 'TRV', '154.65'),
('Tractor Supply Company', 'TSCO', '228.57'),
('Tesla Inc', 'TSLA', '1069.30'),
('Tyson Foods Inc. Class A', 'TSN', '85.22'),
('Trane Technologies plc', 'TT', '197.30'),
('Take-Two Interactive Software Inc.', 'TTWO', '177.90'),
('Twitter Inc.', 'TWTR', '44.05'),
('Texas Instruments Incorporated', 'TXN', '186.37'),
('Textron Inc.', 'TXT', '75.91'),
('Tyler Technologies Inc.', 'TYL', '523.11'),
('Under Armour Inc. Class C', 'UA', '17.61'),
('Under Armour Inc. Class A', 'UAA', '20.62'),
('United Airlines Holdings Inc.', 'UAL', '44.75'),
('UDR Inc.', 'UDR', '58.68'),
('Universal Health Services Inc. Class B', 'UHS', '128.13'),
('Ulta Beauty Inc', 'ULTA', '397.65'),
('UnitedHealth Group Incorporated', 'UNH', '494.80'),
('Union Pacific Corporation', 'UNP', '242.50'),
('United Parcel Service Inc. Class B', 'UPS', '212.19'),
('United Rentals Inc.', 'URI', '332.80'),
('U.S. Bancorp', 'USB', '56.31'),
('Visa Inc. Class A', 'V', '216.62'),
('V.F. Corporation', 'VFC', '69.45'),
('ViacomCBS Inc. Class B', 'VIAC', '30.50'),
('Valero Energy Corporation', 'VLO', '71.73'),
('Vulcan Materials Company', 'VMC', '206.36'),
('Vornado Realty Trust', 'VNO', '41.49'),
('Verisk Analytics Inc', 'VRSK', '225.53'),
('VeriSign Inc.', 'VRSN', '249.64'),
('Vertex Pharmaceuticals Incorporated', 'VRTX', '223.50'),
('Ventas Inc.', 'VTR', '49.15'),
('Viatris Inc.', 'VTRS', '13.67'),
('Verizon Communications Inc.', 'VZ', '52.70'),
('Westinghouse Air Brake Technologies Corporation', 'WAB', '90.00'),
('Waters Corporation', 'WAT', '361.71'),
('Walgreens Boots Alliance Inc', 'WBA', '50.40'),
('Western Digital Corporation', 'WDC', '60.80'),
('WEC Energy Group Inc', 'WEC', '94.65'),
('Welltower Inc.', 'WELL', '82.79'),
('Wells Fargo & Company', 'WFC', '48.40'),
('Whirlpool Corporation', 'WHR', '227.27'),
('Willis Towers Watson Public Limited Company', 'WLTW', '236.46'),
('Waste Management Inc.', 'WM', '161.82'),
('Williams Companies Inc.', 'WMB', '25.85'),
('Walmart Inc.', 'WMT', '139.49'),
('W. R. Berkley Corporation', 'WRB', '80.17'),
('WestRock Company', 'WRK', '42.90'),
('West Pharmaceutical Services Inc.', 'WST', '459.84'),
('Weyerhaeuser Company', 'WY', '38.64'),
('Wynn Resorts Limited', 'WYNN', '89.05'),
('GOLD (Gia vang)', 'XAUUS', '1293.50'),
('Xcel Energy Inc.', 'XEL', '66.60'),
('Xilinx Inc.', 'XLNX', '216.25'),
('Exxon Mobil Corporation', 'XOM', '61.05'),
('DENTSPLY SIRONA Inc.', 'XRAY', '55.85'),
('Xylem Inc.', 'XYL', '117.50'),
('Yum! Brands Inc.', 'YUM', '135.34'),
('Zimmer Biomet Holdings Inc.', 'ZBH', '126.99'),
('Zebra Technologies Corporation Class A', 'ZBRA', '585.00'),
('Zions Bancorporation N.A.', 'ZION', '62.36'),
('Zoetis Inc. Class A', 'ZTS', '245.00');

-- --------------------------------------------------------

--
-- Table structure for table `stocktrans`
--

CREATE TABLE `stocktrans` (
  `id` int(5) NOT NULL,
  `uid` int(11) NOT NULL,
  `symbol` varchar(100) NOT NULL,
  `giamua` double NOT NULL,
  `soluong` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `type` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stocktrans`
--

INSERT INTO `stocktrans` (`id`, `uid`, `symbol`, `giamua`, `soluong`, `time`, `type`) VALUES
(1, 1, 'FB', 78.98, 10, '2021-12-31 06:08:46', 'ban'),
(2, 1, 'TWTR', 44.5, 1, '2021-12-31 06:18:31', 'mua'),
(3, 1, 'MSFT', 330, 1, '2021-12-31 06:20:15', 'mua'),
(4, 1, 'PKI', 200, 1, '2021-12-31 06:26:33', 'mua'),
(5, 1, 'FB', 344, 1, '2021-12-31 06:35:55', 'mua'),
(6, 1, 'CARR', 50, 1, '2021-12-31 06:40:51', 'mua'),
(7, 1, 'MSFT', 339, 2, '2021-12-31 06:42:07', 'mua'),
(8, 1, 'FB', 350, 1, '2021-12-31 06:47:34', 'mua'),
(10, 1, 'FB', 1000, 1, '2021-12-31 06:50:56', 'mua'),
(11, 1, 'PKI', 199, 1, '2021-12-31 06:53:12', 'mua'),
(16, 1, 'BTC-USD', 10000, 1, '2021-12-31 07:02:52', 'mua'),
(18, 1, 'BTC-USD', 3000, 1, '2021-12-31 07:14:48', 'mua'),
(19, 1, 'AAPL', 177, 1, '2021-12-31 19:12:50', 'ban'),
(20, 1, 'BTC-USD', 50000, 1, '2021-12-31 19:15:55', 'ban'),
(21, 1, 'AAPL', 177, 1, '2021-12-31 20:07:31', 'mua');

-- --------------------------------------------------------

--
-- Table structure for table `thu`
--

CREATE TABLE `thu` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `namethu` varchar(100) NOT NULL,
  `amountthu` double NOT NULL,
  `desthu` varchar(100) NOT NULL,
  `datethu` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tong`
--

CREATE TABLE `tong` (
  `uid` int(5) NOT NULL,
  `sodu` double NOT NULL,
  `tongtaisan` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='tong';

--
-- Dumping data for table `tong`
--

INSERT INTO `tong` (`uid`, `sodu`, `tongtaisan`) VALUES
(1, 600000000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tragop`
--

CREATE TABLE `tragop` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `namecongty` varchar(100) NOT NULL,
  `tongtien` double NOT NULL,
  `sothang` int(11) NOT NULL,
  `tienhangthang` double NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `tratruoc` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tragop`
--

INSERT INTO `tragop` (`id`, `uid`, `name`, `namecongty`, `tongtien`, `sothang`, `tienhangthang`, `time`, `tratruoc`) VALUES
(1, 1, 'duan', 'cong ty quai vat', 10000000, 8, 1000000, '2022-01-09 17:07:20', 2000000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` varchar(50) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `USERNAME`, `PASSWORD`) VALUES
('1', 'Admin', 'Vuthanhdat'),
('2', 'Baka', 'Mitai');

-- --------------------------------------------------------

--
-- Table structure for table `vay`
--

CREATE TABLE `vay` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `ten` varchar(100) NOT NULL,
  `bank` varchar(100) NOT NULL,
  `tiengoc` double NOT NULL,
  `laisuat` double NOT NULL,
  `kyhan` int(11) NOT NULL,
  `ngayvay` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='chovay';

--
-- Dumping data for table `vay`
--

INSERT INTO `vay` (`id`, `uid`, `ten`, `bank`, `tiengoc`, `laisuat`, `kyhan`, `ngayvay`) VALUES
(1, 1, 'duan', 'DBBANK', 1000000, 5, 24, '2021-12-29 16:46:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chi`
--
ALTER TABLE `chi`
  ADD PRIMARY KEY (`idchi`);

--
-- Indexes for table `chovay`
--
ALTER TABLE `chovay`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mystock`
--
ALTER TABLE `mystock`
  ADD PRIMARY KEY (`symbol`(65));

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`Symbol`);

--
-- Indexes for table `stocktrans`
--
ALTER TABLE `stocktrans`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `thu`
--
ALTER TABLE `thu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tong`
--
ALTER TABLE `tong`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `tragop`
--
ALTER TABLE `tragop`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `vay`
--
ALTER TABLE `vay`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chi`
--
ALTER TABLE `chi`
  MODIFY `idchi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `chovay`
--
ALTER TABLE `chovay`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `stocktrans`
--
ALTER TABLE `stocktrans`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `thu`
--
ALTER TABLE `thu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tong`
--
ALTER TABLE `tong`
  MODIFY `uid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tragop`
--
ALTER TABLE `tragop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `vay`
--
ALTER TABLE `vay`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
