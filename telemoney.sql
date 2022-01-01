-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2022 at 06:39 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

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
  `ngaychovay` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ngaythulai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='chovay';

--
-- Dumping data for table `chovay`
--

INSERT INTO `chovay` (`id`, `uid`, `ten`, `bank`, `tiengoc`, `laisuat`, `kyhan`, `ngaychovay`, `ngaythulai`) VALUES
(1, 1, 'duan', 'MBBank', 1000000, 5, 12, '2021-12-31 08:22:09', 0),
(2, 1, 'ban duan', 'ACB', 2000000, 4, 24, '2021-12-31 10:16:53', 0),
(3, 1, 'ngu', 'FFF', 12222222, 21, 12, '2021-12-31 10:16:59', 0),
(4, 1, 'haha', 'Ngân Hàng Thương Mại Ngoại Thương Việt Nam (Vietcombank)', 20000000, 2, 1, '2022-01-01 14:51:10', 0),
(5, 1, 'hix', 'Ngân Hàng Kĩ Thương Việt Nam (Techcombank)', 5000000, 3, 36, '2022-01-01 14:56:52', 0);

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
('AAPL', 'Apple', 100, 20000, 200, '2021-12-28 22:01:30'),
('BTC-USD', 'Bitcoin', 1, 35000, 35000, '2021-12-28 21:55:16'),
('COIN', 'Coinbase', 10, 1250, 125, '2021-12-28 22:01:30'),
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
  `Symbol` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `Price` decimal(6,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`Company`, `Symbol`, `Price`) VALUES
('Apple Inc.', 'AAPL', '176.34'),
('Microsoft Corporation', 'MSFT', '334.50'),
('Amazon.com Inc.', 'AMZN', '3418.46'),
('Alphabet Inc. Class A', 'GOOGL', '2938.00'),
('Tesla Inc', 'TSLA', '1069.30'),
('Alphabet Inc. Class C', 'GOOG', '2942.00'),
('Meta Platforms Inc. Class A', 'FB', '336.00'),
('NVIDIA Corporation', 'NVDA', '295.60'),
('Berkshire Hathaway Inc. Class B', 'BRK.B', '294.49'),
('UnitedHealth Group Incorporated', 'UNH', '494.80'),
('JPMorgan Chase & Co.', 'JPM', '157.20'),
('Johnson & Johnson', 'JNJ', '168.49'),
('Home Depot Inc.', 'HD', '397.07'),
('Procter & Gamble Company', 'PG', '160.12'),
('Visa Inc. Class A', 'V', '216.62'),
('Pfizer Inc.', 'PFE', '58.79'),
('Bank of America Corp', 'BAC', '44.42'),
('Mastercard Incorporated Class A', 'MA', '360.58'),
('Walt Disney Company', 'DIS', '153.63'),
('Broadcom Inc.', 'AVGO', '664.00'),
('Netflix Inc.', 'NFLX', '614.99'),
('Adobe Inc.', 'ADBE', '570.88'),
('Cisco Systems Inc.', 'CSCO', '62.31'),
('Exxon Mobil Corporation', 'XOM', '61.05'),
('Thermo Fisher Scientific Inc.', 'TMO', '651.00'),
('Accenture Plc Class A', 'ACN', '403.31'),
('salesforce.com inc.', 'CRM', '253.14'),
('Abbott Laboratories', 'ABT', '139.16'),
('Costco Wholesale Corporation', 'COST', '549.02'),
('AbbVie Inc.', 'ABBV', '133.09'),
('PepsiCo Inc.', 'PEP', '169.27'),
('Comcast Corporation Class A', 'CMCSA', '50.00'),
('Coca-Cola Company', 'KO', '58.09'),
('PayPal Holdings Inc.', 'PYPL', '191.90'),
('Chevron Corporation', 'CVX', '116.41'),
('Verizon Communications Inc.', 'VZ', '52.70'),
('Eli Lilly and Company', 'LLY', '275.00'),
('NIKE Inc. Class B', 'NKE', '165.85'),
('Intel Corporation', 'INTC', '51.21'),
('Qualcomm Inc', 'QCOM', '182.49'),
('Danaher Corporation', 'DHR', '320.79'),
('Walmart Inc.', 'WMT', '139.49'),
('McDonald\'s Corporation', 'MCD', '265.05'),
('Wells Fargo & Company', 'WFC', '48.40'),
('Merck & Co. Inc.', 'MRK', '75.73'),
('Intuit Inc.', 'INTU', '637.00'),
('NextEra Energy Inc.', 'NEE', '90.50'),
('AT&T Inc.', 'T', '24.87'),
('Advanced Micro Devices Inc.', 'AMD', '145.92'),
('Linde plc', 'LIN', '339.17'),
('Lowe\'s Companies Inc.', 'LOW', '250.90'),
('Texas Instruments Incorporated', 'TXN', '186.37'),
('Union Pacific Corporation', 'UNP', '242.50'),
('United Parcel Service Inc. Class B', 'UPS', '212.19'),
('Oracle Corporation', 'ORCL', '89.60'),
('Philip Morris International Inc.', 'PM', '92.70'),
('Morgan Stanley', 'MS', '99.33'),
('Honeywell International Inc.', 'HON', '205.44'),
('Applied Materials Inc.', 'AMAT', '155.10'),
('Medtronic Plc', 'MDT', '102.90'),
('Bristol-Myers Squibb Company', 'BMY', '62.05'),
('CVS Health Corporation', 'CVS', '101.31'),
('Starbucks Corporation', 'SBUX', '112.15'),
('Goldman Sachs Group Inc.', 'GS', '385.04'),
('BlackRock Inc.', 'BLK', '913.92'),
('Intuitive Surgical Inc.', 'ISRG', '363.09'),
('ServiceNow Inc.', 'NOW', '648.57'),
('Charles Schwab Corporation', 'SCHW', '85.00'),
('Raytheon Technologies Corporation', 'RTX', '84.90'),
('Amgen Inc.', 'AMGN', '224.80'),
('American Tower Corporation', 'AMT', '278.74'),
('Citigroup Inc.', 'C', '60.20'),
('Prologis Inc.', 'PLD', '161.75'),
('International Business Machines Corporation', 'IBM', '130.50'),
('Zoetis Inc. Class A', 'ZTS', '245.00'),
('S&P Global Inc.', 'SPGI', '473.74'),
('Boeing Company', 'BA', '204.22'),
('Caterpillar Inc.', 'CAT', '206.20'),
('Anthem Inc.', 'ANTM', '455.71'),
('Target Corporation', 'TGT', '221.01'),
('Micron Technology Inc.', 'MU', '94.41'),
('American Express Company', 'AXP', '164.19'),
('General Electric Company', 'GE', '94.00'),
('Automatic Data Processing Inc.', 'ADP', '242.00'),
('3M Company', 'MMM', '174.91'),
('Deere & Company', 'DE', '349.22'),
('Booking Holdings Inc.', 'BKNG', '2402.25'),
('Lam Research Corporation', 'LRCX', '698.72'),
('ConocoPhillips', 'COP', '71.19'),
('Analog Devices Inc.', 'ADI', '172.66'),
('Gilead Sciences Inc.', 'GILD', '72.12'),
('Mondelez International Inc. Class A', 'MDLZ', '64.85'),
('Stryker Corporation', 'SYK', '269.10'),
('TJX Companies Inc', 'TJX', '73.75'),
('Moderna Inc.', 'MRNA', '249.54'),
('Marsh & McLennan Companies Inc.', 'MMC', '170.57'),
('Crown Castle International Corp', 'CCI', '199.39'),
('Altria Group Inc', 'MO', '46.70'),
('Lockheed Martin Corporation', 'LMT', '347.99'),
('Estee Lauder Companies Inc. Class A', 'EL', '365.99'),
('PNC Financial Services Group Inc.', 'PNC', '197.93'),
('General Motors Company', 'GM', '56.91'),
('Chubb Limited', 'CB', '190.64'),
('CME Group Inc. Class A', 'CME', '226.01'),
('CSX Corporation', 'CSX', '36.79'),
('Sherwin-Williams Company', 'SHW', '338.38'),
('Charter Communications Inc. Class A', 'CHTR', '652.50'),
('Edwards Lifesciences Corporation', 'EW', '128.57'),
('Ford Motor Company', 'F', '20.23'),
('Duke Energy Corporation', 'DUK', '102.97'),
('Truist Financial Corporation', 'TFC', '57.77'),
('Intercontinental Exchange Inc.', 'ICE', '135.84'),
('U.S. Bancorp', 'USB', '56.31'),
('Cigna Corporation', 'CI', '225.00'),
('Equinix Inc.', 'EQIX', '818.76'),
('Becton Dickinson and Company', 'BDX', '248.91'),
('Southern Company', 'SO', '66.54'),
('T-Mobile US Inc.', 'TMUS', '120.00'),
('Norfolk Southern Corporation', 'NSC', '287.53'),
('Colgate-Palmolive Company', 'CL', '82.79'),
('Illinois Tool Works Inc.', 'ITW', '240.50'),
('Eaton Corp. Plc', 'ETN', '168.04'),
('Fidelity National Information Services Inc.', 'FIS', '109.05'),
('Air Products and Chemicals Inc.', 'APD', '299.48'),
('Regeneron Pharmaceuticals Inc.', 'REGN', '623.00'),
('Aon Plc Class A', 'AON', '292.41'),
('Moody\'s Corporation', 'MCO', '397.26'),
('KLA Corporation', 'KLAC', '421.00'),
('Fiserv Inc.', 'FISV', '105.54'),
('Waste Management Inc.', 'WM', '161.82'),
('Dominion Energy Inc', 'D', '77.34'),
('FedEx Corporation', 'FDX', '253.82'),
('Capital One Financial Corporation', 'COF', '145.10'),
('Autodesk Inc.', 'ADSK', '281.11'),
('Boston Scientific Corporation', 'BSX', '42.72'),
('HCA Healthcare Inc', 'HCA', '252.05'),
('Freeport-McMoRan Inc.', 'FCX', '41.13'),
('NXP Semiconductors NV', 'NXPI', '227.15'),
('Illumina Inc.', 'ILMN', '380.93'),
('Progressive Corporation', 'PGR', '101.25'),
('Humana Inc.', 'HUM', '460.54'),
('Northrop Grumman Corporation', 'NOC', '382.39'),
('Vertex Pharmaceuticals Incorporated', 'VRTX', '223.50'),
('Ecolab Inc.', 'ECL', '228.24'),
('Synopsys Inc.', 'SNPS', '367.67'),
('Johnson Controls International plc', 'JCI', '78.11'),
('DexCom Inc.', 'DXCM', '573.01'),
('Public Storage', 'PSA', '362.00'),
('IDEXX Laboratories Inc.', 'IDXX', '645.00'),
('Emerson Electric Co.', 'EMR', '91.28'),
('Xilinx Inc.', 'XLNX', '216.25'),
('Exelon Corporation', 'EXC', '54.68'),
('IQVIA Holdings Inc', 'IQV', '281.11'),
('IHS Markit Ltd.', 'INFO', '132.90'),
('Dollar General Corporation', 'DG', '221.33'),
('TE Connectivity Ltd.', 'TEL', '158.45'),
('Cadence Design Systems Inc.', 'CDNS', '188.99'),
('Simon Property Group Inc.', 'SPG', '155.46'),
('EOG Resources Inc.', 'EOG', '87.18'),
('Amphenol Corporation Class A', 'APH', '85.06'),
('Activision Blizzard Inc.', 'ATVI', '65.00'),
('Roper Technologies Inc.', 'ROP', '478.33'),
('MSCI Inc. Class A', 'MSCI', '611.27'),
('Centene Corporation', 'CNC', '84.72'),
('Chipotle Mexican Grill Inc.', 'CMG', '1748.67'),
('Microchip Technology Incorporated', 'MCHP', '86.61'),
('Align Technology Inc.', 'ALGN', '654.00'),
('Digital Realty Trust Inc.', 'DLR', '169.81'),
('Agilent Technologies Inc.', 'A', '157.80'),
('Newmont Corporation', 'NEM', '59.53'),
('Fortinet Inc.', 'FTNT', '348.40'),
('General Dynamics Corporation', 'GD', '204.69'),
('American International Group Inc.', 'AIG', '56.57'),
('Trane Technologies plc', 'TT', '197.30'),
('Kimberly-Clark Corporation', 'KMB', '138.89'),
('O\'Reilly Automotive Inc.', 'ORLY', '678.00'),
('Carrier Global Corp.', 'CARR', '52.82'),
('Cognizant Technology Solutions Corporation Class A', 'CTSH', '86.51'),
('Marriott International Inc. Class A', 'MAR', '165.88'),
('MetLife Inc.', 'MET', '61.78'),
('Motorola Solutions Inc.', 'MSI', '262.90'),
('T. Rowe Price Group', 'TROW', '195.29'),
('Bank of New York Mellon Corporation', 'BK', '58.11'),
('Aptiv PLC', 'APTV', '162.40'),
('HP Inc.', 'HPQ', '37.96'),
('American Electric Power Company Inc.', 'AEP', '86.92'),
('Hilton Worldwide Holdings Inc', 'HLT', '154.71'),
('Paychex Inc.', 'PAYX', '134.40'),
('Baxter International Inc.', 'BAX', '85.55'),
('AutoZone Inc.', 'AZO', '2014.50'),
('eBay Inc.', 'EBAY', '65.35'),
('Schlumberger NV', 'SLB', '29.57'),
('Dow Inc.', 'DOW', '55.14'),
('Sempra Energy', 'SRE', '129.41'),
('DuPont de Nemours Inc.', 'DD', '78.54'),
('SBA Communications Corp. Class A', 'SBAC', '374.28'),
('Prudential Financial Inc.', 'PRU', '108.25'),
('L3Harris Technologies Inc', 'LHX', '208.00'),
('Pioneer Natural Resources Company', 'PXD', '180.03'),
('Parker-Hannifin Corporation', 'PH', '311.89'),
('Constellation Brands Inc. Class A', 'STZ', '244.04'),
('Yum! Brands Inc.', 'YUM', '135.34'),
('General Mills Inc.', 'GIS', '65.99'),
('Global Payments Inc.', 'GPN', '135.37'),
('PPG Industries Inc.', 'PPG', '167.06'),
('SVB Financial Group', 'SIVB', '612.00'),
('Rockwell Automation Inc.', 'ROK', '340.12'),
('Ross Stores Inc.', 'ROST', '110.16'),
('Realty Income Corporation', 'O', '69.22'),
('Sysco Corporation', 'SYY', '76.65'),
('Marathon Petroleum Corporation', 'MPC', '62.96'),
('Travelers Companies Inc.', 'TRV', '154.65'),
('Cintas Corporation', 'CTAS', '436.79'),
('Match Group Inc.', 'MTCH', '133.20'),
('Electronic Arts Inc.', 'EA', '133.38'),
('EPAM Systems Inc.', 'EPAM', '665.00'),
('ResMed Inc.', 'RMD', '258.82'),
('Mettler-Toledo International Inc.', 'MTD', '1626.23'),
('McKesson Corporation', 'MCK', '240.78'),
('Keysight Technologies Inc', 'KEYS', '202.71'),
('First Republic Bank', 'FRC', '203.91'),
('Archer-Daniels-Midland Company', 'ADM', '65.44'),
('International Flavors & Fragrances Inc.', 'IFF', '143.09'),
('Otis Worldwide Corporation', 'OTIS', '85.25'),
('Verisk Analytics Inc', 'VRSK', '225.53'),
('Walgreens Boots Alliance Inc', 'WBA', '50.40'),
('Welltower Inc.', 'WELL', '82.79'),
('Fastenal Company', 'FAST', '62.59'),
('Xcel Energy Inc.', 'XEL', '66.60'),
('Aflac Incorporated', 'AFL', '57.69'),
('CBRE Group Inc. Class A', 'CBRE', '105.82'),
('Twitter Inc.', 'TWTR', '44.05'),
('ANSYS Inc.', 'ANSS', '403.59'),
('Biogen Inc.', 'BIIB', '235.41'),
('Equifax Inc.', 'EFX', '287.03'),
('Monster Beverage Corporation', 'MNST', '94.23'),
('Discover Financial Services', 'DFS', '115.34'),
('Arthur J. Gallagher & Co.', 'AJG', '166.45'),
('Ameriprise Financial Inc.', 'AMP', '302.28'),
('AvalonBay Communities Inc.', 'AVB', '245.77'),
('D.R. Horton Inc.', 'DHI', '104.92'),
('Corteva Inc', 'CTVA', '46.44'),
('State Street Corporation', 'STT', '93.03'),
('West Pharmaceutical Services Inc.', 'WST', '459.84'),
('American Water Works Company Inc.', 'AWK', '182.08'),
('AMETEK Inc.', 'AME', '142.57'),
('TransDigm Group Incorporated', 'TDG', '628.00'),
('Allstate Corporation', 'ALL', '114.13'),
('Nucor Corporation', 'NUE', '114.00'),
('Old Dominion Freight Line Inc.', 'ODFL', '348.31'),
('Public Service Enterprise Group Inc', 'PEG', '64.58'),
('Arista Networks Inc.', 'ANET', '141.85'),
('Phillips 66', 'PSX', '71.90'),
('Williams Companies Inc.', 'WMB', '25.85'),
('Copart Inc.', 'CPRT', '146.18'),
('Zebra Technologies Corporation Class A', 'ZBRA', '585.00'),
('Dollar Tree Inc.', 'DLTR', '137.35'),
('Lennar Corporation Class A', 'LEN', '112.49'),
('Alexandria Real Estate Equities Inc.', 'ARE', '217.63'),
('Eversource Energy', 'ES', '89.44'),
('Cummins Inc.', 'CMI', '213.97'),
('Kinder Morgan Inc Class P', 'KMI', '15.64'),
('Equity Residential', 'EQR', '88.18'),
('WEC Energy Group Inc', 'WEC', '94.65'),
('Fifth Third Bancorp', 'FITB', '43.00'),
('Consolidated Edison Inc.', 'ED', '83.77'),
('Stanley Black & Decker Inc.', 'SWK', '182.20'),
('Willis Towers Watson Public Limited Company', 'WLTW', '236.46'),
('PACCAR Inc', 'PCAR', '84.95'),
('Ball Corporation', 'BLL', '90.00'),
('Kroger Co.', 'KR', '43.21'),
('Valero Energy Corporation', 'VLO', '71.73'),
('Laboratory Corporation of America Holdings', 'LH', '301.91'),
('Extra Space Storage Inc.', 'EXR', '218.00'),
('Etsy Inc.', 'ETSY', '228.16'),
('Weyerhaeuser Company', 'WY', '38.64'),
('Republic Services Inc.', 'RSG', '135.42'),
('Corning Inc', 'GLW', '36.75'),
('CDW Corp.', 'CDW', '202.76'),
('Hershey Company', 'HSY', '188.46'),
('Vulcan Materials Company', 'VMC', '206.36'),
('Martin Marietta Materials Inc.', 'MLM', '437.06'),
('Gartner Inc.', 'IT', '325.53'),
('Cerner Corporation', 'CERN', '91.80'),
('Expedia Group Inc.', 'EXPE', '184.00'),
('Fortive Corp.', 'FTV', '74.50'),
('Albemarle Corporation', 'ALB', '227.90'),
('Teradyne Inc.', 'TER', '162.74'),
('Zimmer Biomet Holdings Inc.', 'ZBH', '126.99'),
('Devon Energy Corporation', 'DVN', '42.05'),
('Tractor Supply Company', 'TSCO', '228.57'),
('ONEOK Inc.', 'OKE', '58.02'),
('Edison International', 'EIX', '67.67'),
('Occidental Petroleum Corporation', 'OXY', '28.93'),
('Mid-America Apartment Communities Inc.', 'MAA', '221.09'),
('Skyworks Solutions Inc.', 'SWKS', '154.14'),
('Enphase Energy Inc.', 'ENPH', '188.00'),
('Synchrony Financial', 'SYF', '46.16'),
('Delta Air Lines Inc.', 'DAL', '39.30'),
('Tyson Foods Inc. Class A', 'TSN', '85.22'),
('Dover Corporation', 'DOV', '173.74'),
('Kraft Heinz Company', 'KHC', '35.23'),
('Southwest Airlines Co.', 'LUV', '41.87'),
('Northern Trust Corporation', 'NTRS', '118.13'),
('PerkinElmer Inc.', 'PKI', '194.00'),
('Church & Dwight Co. Inc.', 'CHD', '99.00'),
('VeriSign Inc.', 'VRSN', '249.64'),
('Ingersoll Rand Inc.', 'IR', '59.74'),
('United Rentals Inc.', 'URI', '332.80'),
('Nasdaq Inc.', 'NDAQ', '206.00'),
('Hartford Financial Services Group Inc.', 'HIG', '68.27'),
('STERIS Plc', 'STE', '244.00'),
('Duke Realty Corporation', 'DRE', '62.59'),
('LyondellBasell Industries NV', 'LYB', '90.55'),
('McCormick & Company Incorporated', 'MKC', '93.03'),
('PPL Corporation', 'PPL', '29.42'),
('DTE Energy Company', 'DTE', '116.82'),
('Huntington Bancshares Incorporated', 'HBAN', '15.25'),
('V.F. Corporation', 'VFC', '69.45'),
('Ameren Corporation', 'AEE', '87.02'),
('Seagate Technology Holdings PLC', 'STX', '111.41'),
('Essex Property Trust Inc.', 'ESS', '342.67'),
('Expeditors International of Washington Inc.', 'EXPD', '130.76'),
('Waters Corporation', 'WAT', '361.71'),
('Generac Holdings Inc.', 'GNRC', '349.90'),
('Entergy Corporation', 'ETR', '110.09'),
('Pool Corporation', 'POOL', '549.65'),
('FirstEnergy Corp.', 'FE', '40.53'),
('Best Buy Co. Inc.', 'BBY', '98.08'),
('W.W. Grainger Inc.', 'GWW', '503.01'),
('KeyCorp', 'KEY', '22.82'),
('Trimble Inc.', 'TRMB', '86.11'),
('Ulta Beauty Inc', 'ULTA', '397.65'),
('Tyler Technologies Inc.', 'TYL', '523.11'),
('Catalent Inc', 'CTLT', '124.96'),
('Baker Hughes Company Class A', 'BKR', '24.22'),
('Monolithic Power Systems Inc.', 'MPWR', '495.60'),
('Xylem Inc.', 'XYL', '117.50'),
('Broadridge Financial Solutions Inc.', 'BR', '180.29'),
('Clorox Company', 'CLX', '169.83'),
('Take-Two Interactive Software Inc.', 'TTWO', '177.90'),
('Hewlett Packard Enterprise Co.', 'HPE', '15.76'),
('CarMax Inc.', 'KMX', '126.20'),
('Regions Financial Corporation', 'RF', '21.52'),
('Quest Diagnostics Incorporated', 'DGX', '167.05'),
('Paycom Software Inc.', 'PAYC', '423.83'),
('NetApp Inc.', 'NTAP', '90.63'),
('Garmin Ltd.', 'GRMN', '134.48'),
('Cooper Companies Inc.', 'COO', '411.21'),
('Hess Corporation', 'HES', '73.49'),
('Halliburton Company', 'HAL', '22.71'),
('Domino\'s Pizza Inc.', 'DPZ', '545.84'),
('Teledyne Technologies Incorporated', 'TDY', '428.73'),
('Caesars Entertainment Inc', 'CZR', '94.45'),
('Citizens Financial Group Inc.', 'CFG', '46.63'),
('Ventas Inc.', 'VTR', '49.15'),
('NVR Inc.', 'NVR', '5784.63'),
('Signature Bank', 'SBNY', '319.50'),
('M&T Bank Corporation', 'MTB', '150.95'),
('Darden Restaurants Inc.', 'DRI', '148.84'),
('Genuine Parts Company', 'GPC', '135.37'),
('Hologic Inc.', 'HOLX', '76.12'),
('Bio-Techne Corporation', 'TECH', '493.50'),
('AmerisourceBergen Corporation', 'ABC', '129.53'),
('Healthpeak Properties Inc.', 'PEAK', '35.19'),
('Akamai Technologies Inc.', 'AKAM', '116.20'),
('Western Digital Corporation', 'WDC', '60.80'),
('Charles River Laboratories International Inc.', 'CRL', '369.20'),
('ViacomCBS Inc. Class B', 'VIAC', '30.50'),
('FLEETCOR Technologies Inc.', 'FLT', '223.69'),
('CMS Energy Corporation', 'CMS', '63.52'),
('Raymond James Financial Inc.', 'RJF', '99.40'),
('Bath & Body Works Inc.', 'BBWI', '69.50'),
('MGM Resorts International', 'MGM', '45.83'),
('FactSet Research Systems Inc.', 'FDS', '479.51'),
('Diamondback Energy Inc.', 'FANG', '105.92'),
('Amcor PLC', 'AMCR', '11.66'),
('Celanese Corporation', 'CE', '161.32'),
('International Paper Company', 'IP', '45.84'),
('Jacobs Engineering Group Inc.', 'J', '137.35'),
('Principal Financial Group Inc.', 'PFG', '72.00'),
('Royal Caribbean Group', 'RCL', '79.35'),
('IDEX Corporation', 'IEX', '230.64'),
('CenterPoint Energy Inc.', 'CNP', '27.52'),
('Avery Dennison Corporation', 'AVY', '208.47'),
('UDR Inc.', 'UDR', '58.68'),
('Textron Inc.', 'TXT', '75.91'),
('Westinghouse Air Brake Technologies Corporation', 'WAB', '90.00'),
('Qorvo Inc.', 'QRVO', '152.00'),
('Carnival Corporation', 'CCL', '21.20'),
('Masco Corporation', 'MAS', '68.00'),
('Cincinnati Financial Corporation', 'CINF', '112.34'),
('J.B. Hunt Transport Services Inc.', 'JBHT', '197.23'),
('Viatris Inc.', 'VTRS', '13.67'),
('Boston Properties Inc.', 'BXP', '114.26'),
('Bio-Rad Laboratories Inc. Class A', 'BIO', '746.26'),
('Conagra Brands Inc.', 'CAG', '33.33'),
('ABIOMED Inc.', 'ABMD', '352.21'),
('Kellogg Company', 'K', '62.87'),
('Eastman Chemical Company', 'EMN', '119.49'),
('Brown & Brown Inc.', 'BRO', '68.03'),
('Coterra Energy Inc.', 'CTRA', '19.47'),
('AES Corporation', 'AES', '23.55'),
('LKQ Corporation', 'LKQ', '58.49'),
('Live Nation Entertainment Inc.', 'LYV', '118.40'),
('Quanta Services Inc.', 'PWR', '111.88'),
('MarketAxess Holdings Inc.', 'MKTX', '410.67'),
('CF Industries Holdings Inc.', 'CF', '72.30'),
('Omnicom Group Inc', 'OMC', '72.19'),
('Teleflex Incorporated', 'TFX', '327.38'),
('Evergy Inc.', 'EVRG', '66.75'),
('Advance Auto Parts Inc.', 'AAP', '232.13'),
('NortonLifeLock Inc.', 'NLOK', '25.80'),
('SolarEdge Technologies Inc.', 'SEDG', '281.15'),
('Iron Mountain Inc.', 'IRM', '51.60'),
('Alliant Energy Corp', 'LNT', '59.55'),
('Cardinal Health Inc.', 'CAH', '50.75'),
('Mosaic Company', 'MOS', '39.17'),
('Interpublic Group of Companies Inc.', 'IPG', '37.07'),
('United Airlines Holdings Inc.', 'UAL', '44.75'),
('J.M. Smucker Company', 'SJM', '132.99'),
('Kimco Realty Corporation', 'KIM', '23.88'),
('Whirlpool Corporation', 'WHR', '227.27'),
('PulteGroup Inc.', 'PHM', '54.65'),
('Fortune Brands Home & Security Inc.', 'FBHS', '102.75'),
('F5 Inc.', 'FFIV', '234.84'),
('FMC Corporation', 'FMC', '109.10'),
('Ceridian HCM Holding Inc.', 'CDAY', '103.89'),
('Incyte Corporation', 'INCY', '73.54'),
('Cboe Global Markets Inc', 'CBOE', '129.00'),
('Hormel Foods Corporation', 'HRL', '46.84'),
('C.H. Robinson Worldwide Inc.', 'CHRW', '102.45'),
('Atmos Energy Corporation', 'ATO', '102.73'),
('Brown-Forman Corporation Class B', 'BF.B', '71.72'),
('Las Vegas Sands Corp.', 'LVS', '38.59'),
('PTC Inc.', 'PTC', '120.51'),
('Marathon Oil Corporation', 'MRO', '16.01'),
('Hasbro Inc.', 'HAS', '97.92'),
('Packaging Corporation of America', 'PKG', '131.30'),
('Host Hotels & Resorts Inc.', 'HST', '17.44'),
('Jack Henry & Associates Inc.', 'JKHY', '165.43'),
('Leidos Holdings Inc.', 'LDOS', '87.35'),
('Robert Half International Inc.', 'RHI', '109.21'),
('Citrix Systems Inc.', 'CTXS', '97.87'),
('DENTSPLY SIRONA Inc.', 'XRAY', '55.85'),
('Fox Corporation Class A', 'FOXA', '37.28'),
('Howmet Aerospace Inc.', 'HWM', '31.13'),
('Lincoln National Corporation', 'LNC', '67.87'),
('Lumen Technologies Inc.', 'LUMN', '12.84'),
('American Airlines Group Inc.', 'AAL', '18.22'),
('Pentair plc', 'PNR', '71.22'),
('Loews Corporation', 'L', '57.02'),
('Tapestry Inc.', 'TPR', '41.26'),
('Comerica Incorporated', 'CMA', '85.30'),
('WestRock Company', 'WRK', '42.90'),
('Allegion PLC', 'ALLE', '127.28'),
('Snap-on Incorporated', 'SNA', '209.94'),
('W. R. Berkley Corporation', 'WRB', '80.17'),
('Regency Centers Corporation', 'REG', '72.86'),
('Juniper Networks Inc.', 'JNPR', '34.05'),
('A. O. Smith Corporation', 'AOS', '82.77'),
('Everest Re Group Ltd.', 'RE', '267.02'),
('BorgWarner Inc.', 'BWA', '43.62'),
('Henry Schein Inc.', 'HSIC', '74.93'),
('NiSource Inc', 'NI', '26.87'),
('NRG Energy Inc.', 'NRG', '42.52'),
('Zions Bancorporation N.A.', 'ZION', '62.36'),
('APA Corp.', 'APA', '26.28'),
('Sealed Air Corporation', 'SEE', '65.39'),
('Universal Health Services Inc. Class B', 'UHS', '128.13'),
('Mohawk Industries Inc.', 'MHK', '171.16'),
('Wynn Resorts Limited', 'WYNN', '89.05'),
('Federal Realty Investment Trust', 'FRT', '132.38'),
('Franklin Resources Inc.', 'BEN', '33.42'),
('Assurant Inc.', 'AIZ', '152.28'),
('Lamb Weston Holdings Inc.', 'LW', '61.75'),
('News Corporation Class A', 'NWSA', '22.33'),
('Globe Life Inc.', 'GL', '92.70'),
('Molson Coors Beverage Company Class B', 'TAP', '45.59'),
('Campbell Soup Company', 'CPB', '41.96'),
('Penn National Gaming Inc.', 'PENN', '51.54'),
('Norwegian Cruise Line Holdings Ltd.', 'NCLH', '22.74'),
('DXC Technology Co.', 'DXC', '32.57'),
('DISH Network Corporation Class A', 'DISH', '32.59'),
('Newell Brands Inc', 'NWL', '21.46'),
('Invesco Ltd.', 'IVZ', '23.34'),
('Pinnacle West Capital Corporation', 'PNW', '69.00'),
('Organon & Co.', 'OGN', '30.22'),
('Nielsen Holdings Plc', 'NLSN', '21.00'),
('DaVita Inc.', 'DVA', '111.42'),
('People\'s United Financial Inc.', 'PBCT', '17.45'),
('Huntington Ingalls Industries Inc.', 'HII', '182.21'),
('Rollins Inc.', 'ROL', '32.78'),
('PVH Corp.', 'PVH', '100.33'),
('Discovery Inc. Class C', 'DISCK', '23.49'),
('Alaska Air Group Inc.', 'ALK', '53.02'),
('Vornado Realty Trust', 'VNO', '41.49'),
('IPG Photonics Corporation', 'IPGP', '168.90'),
('Ralph Lauren Corporation Class A', 'RL', '112.15'),
('Fox Corporation Class B', 'FOX', '35.10'),
('Discovery Inc. Class A', 'DISCA', '24.25'),
('Under Armour Inc. Class A', 'UAA', '20.62'),
('Gap Inc.', 'GPS', '17.28'),
('Under Armour Inc. Class C', 'UA', '17.61'),
('News Corporation Class B', 'NWS', '22.75'),
('GOLD (Giá vàng)', 'XAUUS', '1.00'),
('GOLD (Gia vang)', 'XAUUS', '1293.50');

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
  `tratruoc` double NOT NULL,
  `ngaytragop` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tragop`
--

INSERT INTO `tragop` (`id`, `uid`, `name`, `namecongty`, `tongtien`, `sothang`, `tienhangthang`, `time`, `tratruoc`, `ngaytragop`) VALUES
(1, 1, 'duan', 'cong ty quai vat', 10000000, 8, 1000000, '2022-01-09 17:07:20', 2000000, 0),
(2, 1, 'nguu ma zuong', 'quai vat', 200000000, 2, 50000000, '2022-01-01 16:08:08', 100000000, 0);

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
  `ngayvay` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ngaytralai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='chovay';

--
-- Dumping data for table `vay`
--

INSERT INTO `vay` (`id`, `uid`, `ten`, `bank`, `tiengoc`, `laisuat`, `kyhan`, `ngayvay`, `ngaytralai`) VALUES
(1, 1, 'duan', 'DBBANK', 1000000, 5, 24, '2021-12-29 16:46:00', 0),
(2, 1, 'satori', 'Ngân Hàng Thương Mại Ngoại Thương Việt Nam (Vietcombank)', 100000000, 3, 1, '2022-01-01 15:23:46', 0);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `stocktrans`
--
ALTER TABLE `stocktrans`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `vay`
--
ALTER TABLE `vay`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
