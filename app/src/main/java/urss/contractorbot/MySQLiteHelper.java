package urss.contractorbot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MaterialDB";
    private static final String TABLE_MATERIAL = "material";
    private static final String TABLE_TYPE = "materials_type";
    private static final String TABLE_SUPPLIER = "materials_SUPPLIER";

    private static final String KEY_MATERIAL_ID = "_material_id";
    private static final String KEY_MATERIAL_NAME = "material_name";
    private static final String KEY_TYPE_ID = "_type_id";
    private static final String KEY_TYPE_NAME = "type_name";
    private static final String KEY_SUPPLIER_ID = "_SUPPLIER_id";
    private static final String KEY_SUPPLIER_NAME = "SUPPLIER_name";
    private static final String KEY_PRICE = "price";

    private static final String[] COLUMNS_MATERIAL =
    {
        KEY_MATERIAL_ID,
        KEY_MATERIAL_NAME,
        KEY_TYPE_ID,
        KEY_SUPPLIER_ID,
        KEY_PRICE
    };

    private static final String[] COLUMNS_TYPE =
    {
        KEY_MATERIAL_ID,
        KEY_TYPE_NAME
    };

    private static final String[] COLUMNS_SUPPLIER =
    {
        KEY_SUPPLIER_ID,
        KEY_SUPPLIER_NAME
    };

    private static final MaterialSupplier[] SUPPLIERS =
    {
        //region Suppliers
        new MaterialSupplier(1, "Alloy Wire International"),
        new MaterialSupplier(2, "Applied Process, Inc."),
        new MaterialSupplier(3, "Datum Alloys"),
        new MaterialSupplier(4, "Dura-Bar Metal Services"),
        new MaterialSupplier(5, "Eagle Alloys"),
        new MaterialSupplier(6, "Goodfellow"),
        new MaterialSupplier(7, "Gupta Permold"),
        new MaterialSupplier(8, "IBC Advanced Alloys"),
        new MaterialSupplier(9, "Indium Corporation"),
        new MaterialSupplier(10, "Metalmen Sales"),
        new MaterialSupplier(11, "Online Metals"),
        new MaterialSupplier(12, "PLANSEE"),
        new MaterialSupplier(13, "Prototype Casting"),
        new MaterialSupplier(14, "RSP Technology BV"),
        new MaterialSupplier(15, "Titanium Engineers"),
        new MaterialSupplier(16, "Advanced Magnesium Technologies (AMT)"),
        new MaterialSupplier(17, "Aerospace Metal Composites, Ltd."),
        new MaterialSupplier(18, "AFE Technologies (Cronite)"),
        new MaterialSupplier(19, "AIM Specialty Materials"),
        new MaterialSupplier(20, "AMG Aluminum"),
        new MaterialSupplier(21, "AK Steel"),
        new MaterialSupplier(22, "Alcoa - Aluminum Company of America"),
        new MaterialSupplier(23, "Aleris"),
        new MaterialSupplier(24, "ALIMEX GmbH"),
        new MaterialSupplier(25, "Allegheny Ludlum, an Allegheny Technologies Company"),
        new MaterialSupplier(26, "Allvac, an Allegheny Technologies Company"),
        new MaterialSupplier(27, "Alpase, Inc."),
        new MaterialSupplier(28, "Ametek"),
        new MaterialSupplier(29, "Ampco Metals"),
        new MaterialSupplier(30, "ArcelorMittal"),
        new MaterialSupplier(31, "Armoloy"),
        new MaterialSupplier(32, "Ashot Heavy Metals Products"),
        new MaterialSupplier(33, "Assab Steels"),
        new MaterialSupplier(34, "Astaras"),
        new MaterialSupplier(35, "Bales Molding Service"),
        new MaterialSupplier(36, "Beijing Advanced Materials"),
        new MaterialSupplier(37, "Bethlehem Steel Corporation"),
        new MaterialSupplier(38, "Bisalloy Steels"),
        new MaterialSupplier(39, "Bohler-Uddeholm"),
        new MaterialSupplier(40, "Cadi Company"),
        new MaterialSupplier(41, "California Fine Wire"),
        new MaterialSupplier(42, "Carpenter Technology Corporation"),
        new MaterialSupplier(43, "Ceramic Processing Systems"),
        new MaterialSupplier(44, "Chicago Extruded Metals"),
        new MaterialSupplier(45, "China Tungsten"),
        new MaterialSupplier(46, "CLAL-MSX"),
        new MaterialSupplier(47, "Clinton Aluminum and Stainless Steel"),
        new MaterialSupplier(48, "CMW, Inc."),
        new MaterialSupplier(49, "Conforma Clad"),
        new MaterialSupplier(50, "Constellium"),
        new MaterialSupplier(51, "Crucible Compaction Metals"),
        new MaterialSupplier(52, "Crucible Specialty Metals"),
        new MaterialSupplier(53, "Cymat"),
        new MaterialSupplier(54, "Delphi"),
        new MaterialSupplier(55, "Deutsche Titan"),
        new MaterialSupplier(56, "Domite Wear Technology"),
        new MaterialSupplier(57, "Dynacast"),
        new MaterialSupplier(58, "Eagle Brass"),
        new MaterialSupplier(59, "ECOMold"),
        new MaterialSupplier(60, "EDRO"),
        new MaterialSupplier(61, "Electro Optical Systems (EOS)"),
        new MaterialSupplier(62, "Elgiloy® Specialty Metals"),
        new MaterialSupplier(63, "ELM®"),
        new MaterialSupplier(64, "Etrema Products"),
        new MaterialSupplier(65, "FiberNide, Ltd."),
        new MaterialSupplier(66, "FloMet LLC"),
        new MaterialSupplier(67, "Groupe Arcelor"),
        new MaterialSupplier(68, "Hardwire, LLC"),
        new MaterialSupplier(69, "Haynes International"),
        new MaterialSupplier(70, "H.C. Starck"),
        new MaterialSupplier(71, "High Performance Alloys, Inc."),
        new MaterialSupplier(72, "Hogen Industries"),
        new MaterialSupplier(73, "Industeel"),
        new MaterialSupplier(74, "International Mold Steel"),
        new MaterialSupplier(75, "Johnson Matthey"),
        new MaterialSupplier(76, "Kaiser Aluminum"),
        new MaterialSupplier(77, "Kennametal Stellite"),
        new MaterialSupplier(78, "Kinetics, Inc."),
        new MaterialSupplier(79, "Kobe Steel"),
        new MaterialSupplier(80, "Lamineries Matthey"),
        new MaterialSupplier(81, "Latrobe Specialty Steel"),
        new MaterialSupplier(82, "Lucas Milhaupt"),
        new MaterialSupplier(83, "Magnesium Elektron"),
        new MaterialSupplier(84, "Magyar Aluminium"),
        new MaterialSupplier(85, "Materion Corporation (former Brush Wellman)"),
        new MaterialSupplier(86, "Metal Matrix Cast Composites, Inc."),
        new MaterialSupplier(87, "MetalTek International"),
        new MaterialSupplier(88, "Misumi"),
        new MaterialSupplier(89, "Mi-Tech Metals"),
        new MaterialSupplier(90, "Mueller Industries Inc."),
        new MaterialSupplier(91, "NBE Tech"),
        new MaterialSupplier(92, "NewMerc, Ltd."),
        new MaterialSupplier(93, "Niagara LaSalle"),
        new MaterialSupplier(94, "NiCoForm, Inc."),
        new MaterialSupplier(95, "Nihon Superior"),
        new MaterialSupplier(96, "Northwest Aluminum Company"),
        new MaterialSupplier(97, "OMG Americas"),
        new MaterialSupplier(98, "Osprey Metals, Ltd."),
        new MaterialSupplier(99, "Pacific Sintered Materials"),
        new MaterialSupplier(100, "Parkway Products"),
        new MaterialSupplier(101, "PCC-Advanced Forming Technology"),
        new MaterialSupplier(102, "PCP-Canada"),
        new MaterialSupplier(103, "Performance Alloys"),
        new MaterialSupplier(104, "PSM Industries"),
        new MaterialSupplier(105, "Pyramid Steel"),
        new MaterialSupplier(106, "Resistalloy International Ltd."),
        new MaterialSupplier(107, "Rhenium Alloys Inc."),
        new MaterialSupplier(108, "Sandvik"),
        new MaterialSupplier(109, "Schmolz + Bickenbach"),
        new MaterialSupplier(110, "Special Metals (includes former Inco Alloys International)"),
        new MaterialSupplier(111, "Silicon Casting, Inc."),
        new MaterialSupplier(112, "Spectrum Machine, Inc."),
        new MaterialSupplier(113, "SSAB Tunnplåt"),
        new MaterialSupplier(114, "Starmet"),
        new MaterialSupplier(115, "Superior Die Set"),
        new MaterialSupplier(116, "Superior Flux"),
        new MaterialSupplier(117, "ThyssenKrupp"),
        new MaterialSupplier(118, "TIMET"),
        new MaterialSupplier(119, "TiNi Alloy Company"),
        new MaterialSupplier(120, "Tungsten Products, an Allegheny Technologies Company"),
        new MaterialSupplier(121, "United Cast Bar"),
        new MaterialSupplier(122, "Universal Wire Works"),
        new MaterialSupplier(123, "Vista Metals"),
        new MaterialSupplier(124, "Wall Colmonoy Corporation"),
        new MaterialSupplier(125, "Williams Advanced Alloys"),
        new MaterialSupplier(126, "Alliance LLC"),
        new MaterialSupplier(127, "Aremco Products, Inc."),
        new MaterialSupplier(128, "BryCoat, Inc."),
        new MaterialSupplier(129, "Goodfellow"),
        new MaterialSupplier(130, "SCHOTT AG - Nextrema®"),
        new MaterialSupplier(131, "SCHOTT AG - Tubing Division"),
        new MaterialSupplier(132, "Zircar Ceramics"),
        new MaterialSupplier(133, "3M Ceramic Textiles and Composites"),
        new MaterialSupplier(134, "Advanced Ceramics Limited"),
        new MaterialSupplier(135, "AGY"),
        new MaterialSupplier(136, "American Computer Optics"),
        new MaterialSupplier(137, "American Elements®"),
        new MaterialSupplier(138, "Anderman Ceramics"),
        new MaterialSupplier(139, "Applied Nanostructured Solutions"),
        new MaterialSupplier(140, "Bekaert Advanced Coating Technologies"),
        new MaterialSupplier(141, "BNZ Materials"),
        new MaterialSupplier(142, "Cancarb"),
        new MaterialSupplier(143, "Carborundum Corporation"),
        new MaterialSupplier(144, "Carpenter Advanced Ceramics"),
        new MaterialSupplier(145, "Carlisle Brake & Friction"),
        new MaterialSupplier(146, "Ceradyne, Inc."),
        new MaterialSupplier(147, "CeramTec North America"),
        new MaterialSupplier(148, "Channel Industries"),
        new MaterialSupplier(149, "Chemours"),
        new MaterialSupplier(150, "ChevronTexaco"),
        new MaterialSupplier(151, "CIMBAR Performance Minerals"),
        new MaterialSupplier(152, "ConocoPhillips"),
        new MaterialSupplier(153, "CoorsTek"),
        new MaterialSupplier(154, "Corning Incorporated"),
        new MaterialSupplier(155, "Cotronics"),
        new MaterialSupplier(156, "Crystex Composites"),
        new MaterialSupplier(157, "Destech Corporation"),
        new MaterialSupplier(158, "DIAB Inc."),
        new MaterialSupplier(159, "Dicronite"),
        new MaterialSupplier(160, "Donnelly Bros Inc."),
        new MaterialSupplier(161, "Du-Co Ceramics Company"),
        new MaterialSupplier(162, "Duratherm Extended Life Fluids"),
        new MaterialSupplier(163, "EDO Ceramics"),
        new MaterialSupplier(164, "Eifeler Coatings Technology"),
        new MaterialSupplier(165, "Enviro Tech International"),
        new MaterialSupplier(166, "ERG Aerospace"),
        new MaterialSupplier(167, "ESK Ceramics"),
        new MaterialSupplier(168, "Excalibar"),
        new MaterialSupplier(169, "Excel Industries"),
        new MaterialSupplier(170, "Extramet"),
        new MaterialSupplier(171, "ExxonMobil"),
        new MaterialSupplier(172, "Ferro Corporation"),
        new MaterialSupplier(173, "Fibre Glast"),
        new MaterialSupplier(174, "GBC Materials Corporation"),
        new MaterialSupplier(175, "Gouda Refractories"),
        new MaterialSupplier(176, "GrafTech International"),
        new MaterialSupplier(177, "Groltex"),
        new MaterialSupplier(178, "Gwent Electronic Materials"),
        new MaterialSupplier(179, "Heatbath Corporation - Park Metallurgical"),
        new MaterialSupplier(180, "Hexcel Corporation"),
        new MaterialSupplier(181, "Hybrid Plastics"),
        new MaterialSupplier(182, "Imerys (K-T Clay)"),
        new MaterialSupplier(183, "Industrial Nanotech"),
        new MaterialSupplier(184, "International Ceramic Engineering"),
        new MaterialSupplier(185, "International Ceramics and Heating Systems"),
        new MaterialSupplier(186, "Jushi"),
        new MaterialSupplier(187, "KaMin"),
        new MaterialSupplier(188, "Laurel BioComposite"),
        new MaterialSupplier(189, "Lubriplate"),
        new MaterialSupplier(190, "Lyondell"),
        new MaterialSupplier(191, "M Cubed Technologies, Inc."),
        new MaterialSupplier(192, "MarkeTech International"),
        new MaterialSupplier(193, "Mafic Basalt"),
        new MaterialSupplier(194, "Malvern Minerals"),
        new MaterialSupplier(195, "Mateck GmbH"),
        new MaterialSupplier(196, "McDanel Advanced Ceramic Technologies"),
        new MaterialSupplier(197, "Microplasmic Corporation"),
        new MaterialSupplier(198, "Microtherm Group"),
        new MaterialSupplier(199, "Mid-Mountain Materials"),
        new MaterialSupplier(200, "Minelco Inc."),
        new MaterialSupplier(201, "Misumi"),
        new MaterialSupplier(202, "Möller Medical"),
        new MaterialSupplier(203, "Mold-Tech"),
        new MaterialSupplier(204, "Momentive Performance Materials"),
        new MaterialSupplier(205, "Morgan Advanced Ceramics"),
        new MaterialSupplier(206, "Murlin Chemical"),
        new MaterialSupplier(207, "Nabaltec"),
        new MaterialSupplier(208, "Nanocyl"),
        new MaterialSupplier(209, "Nanostructured & Amorphous Materials Inc"),
        new MaterialSupplier(210, "Nippon Yttrium Co."),
        new MaterialSupplier(211, "North American Processing Co."),
        new MaterialSupplier(212, "Novum"),
        new MaterialSupplier(213, "Nyco Minerals"),
        new MaterialSupplier(214, "Nye Lubricants"),
        new MaterialSupplier(215, "Ohio Carbon Blank"),
        new MaterialSupplier(216, "Old Hickory Clay Co."),
        new MaterialSupplier(217, "Orion Engineered Carbons"),
        new MaterialSupplier(218, "Paratherm Corporation"),
        new MaterialSupplier(219, "PEAK Werkstoff"),
        new MaterialSupplier(220, "Piezo Kinetics, Inc."),
        new MaterialSupplier(221, "Potters Industries"),
        new MaterialSupplier(222, "Poco Graphite"),
        new MaterialSupplier(223, "Poraver"),
        new MaterialSupplier(224, "Powder Processing & Technology"),
        new MaterialSupplier(225, "Pyrotek"),
        new MaterialSupplier(226, "Quaker"),
        new MaterialSupplier(227, "Reade Advanced Materials"),
        new MaterialSupplier(228, "Saint-Gobain Quartz PLC"),
        new MaterialSupplier(229, "Sapco"),
        new MaterialSupplier(230, "Sawbones"),
        new MaterialSupplier(231, "Schott Glass Technologies, Inc."),
        new MaterialSupplier(232, "Schmelzer Industries"),
        new MaterialSupplier(233, "SGL Carbon Group"),
        new MaterialSupplier(234, "Skamol"),
        new MaterialSupplier(235, "SMAHT Ceramics"),
        new MaterialSupplier(236, "Southern Clay Products"),
        new MaterialSupplier(237, "Specialty Materials, Inc."),
        new MaterialSupplier(238, "St Cloud Mining"),
        new MaterialSupplier(239, "Stellar Canada"),
        new MaterialSupplier(240, "Terio Corporation"),
        new MaterialSupplier(241, "Texaco"),
        new MaterialSupplier(242, "Thermal Ceramics"),
        new MaterialSupplier(243, "TimCal"),
        new MaterialSupplier(244, "Toho Carbon Fibers"),
        new MaterialSupplier(245, "Tokuyama"),
        new MaterialSupplier(246, "Touchstone Research Laboratory"),
        new MaterialSupplier(247, "Ultracor Inc."),
        new MaterialSupplier(248, "Unifrax I LLC"),
        new MaterialSupplier(249, "Vitro Minerals"),
        new MaterialSupplier(250, "Wessex Inc."),
        new MaterialSupplier(251, "World Minerals"),
        new MaterialSupplier(252, "Zircar Refractory Composites Inc"),
        new MaterialSupplier(253, "Zircar Zirconia"),
        new MaterialSupplier(254, "Axis Proto, Inc."),
        new MaterialSupplier(255, "Bamberger Polymers"),
        new MaterialSupplier(256, "Chemical Concepts"),
        new MaterialSupplier(257, "Conventus Polymers"),
        new MaterialSupplier(258, "CRP Technology"),
        new MaterialSupplier(259, "Daikin Industries"),
        new MaterialSupplier(260, "Drake Plastics"),
        new MaterialSupplier(261, "Durez Corporation, a subsidiary of Sumitomo Bakelite"),
        new MaterialSupplier(262, "East Coast Precision Manufacturing"),
        new MaterialSupplier(263, "Ellsworth Adhesives"),
        new MaterialSupplier(264, "Ensinger, Inc."),
        new MaterialSupplier(265, "Hexion"),
        new MaterialSupplier(266, "I. Stern Plastics Corp."),
        new MaterialSupplier(267, "Mar-Bal Incorporated"),
        new MaterialSupplier(268, "Master Bond Inc."),
        new MaterialSupplier(269, "Nexeo Solutions"),
        new MaterialSupplier(270, "Norplex-Micarta"),
        new MaterialSupplier(271, "PEP Connecticut Plastics"),
        new MaterialSupplier(272, "PlastiComp"),
        new MaterialSupplier(273, "Plastic Service Centers"),
        new MaterialSupplier(274, "Polymer Technology & Services"),
        new MaterialSupplier(275, "Polyplastics Co Ltd."),
        new MaterialSupplier(276, "Quadrant Engineering Plastic Products"),
        new MaterialSupplier(277, "Quadrant Plastic Composites"),
        new MaterialSupplier(278, "Red Seal Electric Company"),
        new MaterialSupplier(279, "RTP Company"),
        new MaterialSupplier(280, "Sumitomo Bakelite North America"),
        new MaterialSupplier(281, "Tamshell"),
        new MaterialSupplier(282, "Topas Advanced Polymers, Inc."),
        new MaterialSupplier(283, "TriStar Plastics Corp."),
        new MaterialSupplier(284, "Vicone High Performance Rubber"),
        new MaterialSupplier(285, "Victrex"),
        new MaterialSupplier(286, "Zeus Inc."),
        new MaterialSupplier(287, "3A Composites"),
        new MaterialSupplier(288, "3D Systems"),
        new MaterialSupplier(289, "3M Adhesives Division"),
        new MaterialSupplier(290, "3M Dental Products"),
        new MaterialSupplier(291, "A. Schulman, Inc."),
        new MaterialSupplier(292, "Aardvark Polymers"),
        new MaterialSupplier(293, "Aaron Industries"),
        new MaterialSupplier(294, "Abatron, Inc."),
        new MaterialSupplier(295, "ABW Plastics"),
        new MaterialSupplier(296, "Accella/li>"),
        new MaterialSupplier(297, "Aclo Compounders"),
        new MaterialSupplier(298, "Adamas"),
        new MaterialSupplier(299, "A.D. Compound"),
        new MaterialSupplier(300, "Addcomp"),
        new MaterialSupplier(301, "Addiplast"),
        new MaterialSupplier(302, "Adell Plastics, Inc."),
        new MaterialSupplier(303, "Advanced Resin Technology"),
        new MaterialSupplier(304, "AKG Polymers"),
        new MaterialSupplier(305, "Akro-Plastic"),
        new MaterialSupplier(306, "Akzo Nobel"),
        new MaterialSupplier(307, "ALBIS PLASTICS"),
        new MaterialSupplier(308, "Alcoa KAMA Co"),
        new MaterialSupplier(309, "Alliance Polymers"),
        new MaterialSupplier(310, "AlphaGary"),
        new MaterialSupplier(311, "Amber Chemical Group"),
        new MaterialSupplier(312, "Amco Plastic Materials"),
        new MaterialSupplier(313, "American Polymers, Inc."),
        new MaterialSupplier(314, "American Precision Products"),
        new MaterialSupplier(315, "Americas Styrenics"),
        new MaterialSupplier(316, "Americhem, former LTL Color Compounds"),
        new MaterialSupplier(317, "Amity Thermosets Limited"),
        new MaterialSupplier(318, "Anocast"),
        new MaterialSupplier(319, "AorTech Biomaterials"),
        new MaterialSupplier(320, "APCM"),
        new MaterialSupplier(321, "A. P. I. SpA"),
        new MaterialSupplier(322, "Applied Composites"),
        new MaterialSupplier(323, "Aptek Laboratories"),
        new MaterialSupplier(324, "Aquabond Technologies"),
        new MaterialSupplier(325, "Arkema"),
        new MaterialSupplier(326, "Arlon Silicone Technologies Division"),
        new MaterialSupplier(327, "Armacell"),
        new MaterialSupplier(328, "Asaclean-Sun Plastech Inc."),
        new MaterialSupplier(329, "Asahi Chemical"),
        new MaterialSupplier(330, "Asahi Glass Company"),
        new MaterialSupplier(331, "Asahi Kasei"),
        new MaterialSupplier(332, "Ascend Performance Materials"),
        new MaterialSupplier(333, "Ashley Polymers, Inc."),
        new MaterialSupplier(334, "Asia Technology Pioneers"),
        new MaterialSupplier(335, "ATG s.r.l."),
        new MaterialSupplier(336, "Atom Adhesives"),
        new MaterialSupplier(337, "A-Top Polymers Inc."),
        new MaterialSupplier(338, "AT Plastics"),
        new MaterialSupplier(339, "Austin Novel Materials"),
        new MaterialSupplier(340, "Axiall Corporation"),
        new MaterialSupplier(341, "Axion Polymers"),
        new MaterialSupplier(342, "Azdel"),
        new MaterialSupplier(343, "Barlog Plastics"),
        new MaterialSupplier(344, "BASF Corporation"),
        new MaterialSupplier(345, "Bayshore Vinyl Compounds"),
        new MaterialSupplier(346, "BecauseWeCare Pty Ltd."),
        new MaterialSupplier(347, "Bedford Reinforced Plastics"),
        new MaterialSupplier(348, "Beijing Chemical Industry Research Institute"),
        new MaterialSupplier(349, "Beijing Evergrow Resources"),
        new MaterialSupplier(350, "Beijing Ranger Chemical Co"),
        new MaterialSupplier(351, "Berry Plastics"),
        new MaterialSupplier(352, "Bhansali"),
        new MaterialSupplier(353, "BiologiQ"),
        new MaterialSupplier(354, "Biomer"),
        new MaterialSupplier(355, "Birch Plastics"),
        new MaterialSupplier(356, "BIW Silicone"),
        new MaterialSupplier(357, "Blue River Coatings"),
        new MaterialSupplier(358, "Bluestar"),
        new MaterialSupplier(359, "BMC - Bulk Molding Compounds, Inc."),
        new MaterialSupplier(360, "Borealis"),
        new MaterialSupplier(361, "BorsodChem Rt."),
        new MaterialSupplier(362, "Bostik"),
        new MaterialSupplier(363, "BP Amoco"),
        new MaterialSupplier(364, "Brandenburger Isoliertechnik GmbH&Co"),
        new MaterialSupplier(365, "Braskem"),
        new MaterialSupplier(366, "Breplast"),
        new MaterialSupplier(367, "Brüggemann Chemical"),
        new MaterialSupplier(368, "Buckeye Polymers"),
        new MaterialSupplier(369, "The Budd Company"),
        new MaterialSupplier(370, "Calsak"),
        new MaterialSupplier(371, "Caplinq"),
        new MaterialSupplier(372, "Carmel Olefins"),
        new MaterialSupplier(373, "Cast Nylons, Ltd."),
        new MaterialSupplier(374, "Cathay Industrial Biotech"),
        new MaterialSupplier(375, "Celanese Corporation"),
        new MaterialSupplier(376, "CEN® Electronic Material Co."),
        new MaterialSupplier(377, "Centro Plastica"),
        new MaterialSupplier(378, "Centroplast Engineering Plastics GmbH"),
        new MaterialSupplier(379, "Chang Chun Plastic"),
        new MaterialSupplier(380, "Changzhou Jinlibao"),
        new MaterialSupplier(381, "Chase Plastics"),
        new MaterialSupplier(382, "Chem Polymer"),
        new MaterialSupplier(383, "Chemours"),
        new MaterialSupplier(384, "ChemRex"),
        new MaterialSupplier(385, "Chengdu Polyster Co."),
        new MaterialSupplier(386, "Cheng Yu Plastic Company Limited"),
        new MaterialSupplier(387, "Chevron Phillips Chemical Company LP"),
        new MaterialSupplier(388, "Chi Mei"),
        new MaterialSupplier(389, "China-Yixing Longly Refractories Co. Ltd"),
        new MaterialSupplier(390, "Chisso Corporation"),
        new MaterialSupplier(391, "CIP Composites"),
        new MaterialSupplier(392, "Clariant Specialty Polymers"),
        new MaterialSupplier(393, "Claude P. Bamberger"),
        new MaterialSupplier(394, "Clinton Aluminum"),
        new MaterialSupplier(395, "CMT Materials"),
        new MaterialSupplier(396, "C.O.I.M."),
        new MaterialSupplier(397, "CoreLite"),
        new MaterialSupplier(398, "Costal Enterprises Company"),
        new MaterialSupplier(399, "Colorite Polymers"),
        new MaterialSupplier(400, "Composite Technologies (CTC)"),
        new MaterialSupplier(401, "Compression Polymers Corp. - Vycom"),
        new MaterialSupplier(402, "Compuestos Dominicanos"),
        new MaterialSupplier(403, "Consolidated Polymer Technologies"),
        new MaterialSupplier(404, "Continental Acrylics"),
        new MaterialSupplier(405, "Cool Polymers, Inc."),
        new MaterialSupplier(406, "Corbion Purac"),
        new MaterialSupplier(407, "Cosmic Plastics, Inc."),
        new MaterialSupplier(408, "Cossa Polimeri"),
        new MaterialSupplier(409, "Covestro, formerly Bayer MaterialScience"),
        new MaterialSupplier(410, "CP-Polymer-Technik GmbH & Co."),
        new MaterialSupplier(411, "Cresset Powers, Ltd."),
        new MaterialSupplier(412, "CRG Industries"),
        new MaterialSupplier(413, "Cri-Tech Performance Materials"),
        new MaterialSupplier(414, "Custom Resins"),
        new MaterialSupplier(415, "Cyclewood Solutions"),
        new MaterialSupplier(416, "Cyclics Corporation"),
        new MaterialSupplier(417, "Cytec"),
        new MaterialSupplier(418, "Daelim H&L Super Engineering Plastics"),
        new MaterialSupplier(419, "Devcon"),
        new MaterialSupplier(420, "Diamond and Network Polymers"),
        new MaterialSupplier(421, "Diapolyacrylate Company"),
        new MaterialSupplier(422, "Dielectric Polymers"),
        new MaterialSupplier(423, "Domo"),
        new MaterialSupplier(424, "Dow Chemical"),
        new MaterialSupplier(425, "Dow Corning"),
        new MaterialSupplier(426, "DSM Engineering Plastics"),
        new MaterialSupplier(427, "DSM Thermoplastic Elastomers"),
        new MaterialSupplier(428, "DuPont High Performance Films"),
        new MaterialSupplier(429, "DuPont Industrial Polymers"),
        new MaterialSupplier(430, "DuPont Packaging Polymers"),
        new MaterialSupplier(431, "DuPont Performance Polymers"),
        new MaterialSupplier(432, "DuPont Teijin Films"),
        new MaterialSupplier(433, "Dymax"),
        new MaterialSupplier(434, "Dynasol"),
        new MaterialSupplier(435, "Dyneon"),
        new MaterialSupplier(436, "Eastman Chemical Company"),
        new MaterialSupplier(437, "Ebbtide Polymers"),
        new MaterialSupplier(438, "Ecomass Technologies"),
        new MaterialSupplier(439, "Edinburg Plastics"),
        new MaterialSupplier(440, "Elastocon® TPE Technologies"),
        new MaterialSupplier(441, "Elastomer Engineering"),
        new MaterialSupplier(442, "Elastomer Engineering Inc. (EEI)"),
        new MaterialSupplier(443, "Eliokem"),
        new MaterialSupplier(444, "Elisto"),
        new MaterialSupplier(445, "Elliott Company"),
        new MaterialSupplier(446, "Elmer's Products, Inc."),
        new MaterialSupplier(447, "Emerald Performance Materials"),
        new MaterialSupplier(448, "Emerson & Cuming"),
        new MaterialSupplier(449, "EMS-Griltech"),
        new MaterialSupplier(450, "EMS-Grivory"),
        new MaterialSupplier(451, "Engineered Bonding Solutions (EBS)"),
        new MaterialSupplier(452, "Engineered Plastics Corporation"),
        new MaterialSupplier(453, "Engineered Polymer Solutions"),
        new MaterialSupplier(454, "Engineered Syntactic Systems"),
        new MaterialSupplier(455, "Entec Engineered Resins"),
        new MaterialSupplier(456, "EPMG, Inc."),
        new MaterialSupplier(457, "E-Polymers"),
        new MaterialSupplier(458, "EPICHEM srl"),
        new MaterialSupplier(459, "Epsan Plastik"),
        new MaterialSupplier(460, "Epsilon Products"),
        new MaterialSupplier(461, "Equate"),
        new MaterialSupplier(462, "Esenttia by Propilco"),
        new MaterialSupplier(463, "Esprix"),
        new MaterialSupplier(464, "Eurofoam"),
        new MaterialSupplier(465, "Eurostar Engineering Plastics"),
        new MaterialSupplier(466, "Eurotec"),
        new MaterialSupplier(467, "EVALCA - EVAL Company of America"),
        new MaterialSupplier(468, "Evonik CYRO"),
        new MaterialSupplier(469, "Evonik Degussa"),
        new MaterialSupplier(470, "Expancel"),
        new MaterialSupplier(471, "Ex-Tech Plastics"),
        new MaterialSupplier(472, "Exxon Chemical Canada"),
        new MaterialSupplier(473, "ExxonMobil Chemical Company"),
        new MaterialSupplier(474, "Fainplast"),
        new MaterialSupplier(475, "Fine Organics"),
        new MaterialSupplier(476, "Firestone"),
        new MaterialSupplier(477, "Flint Hills Resources"),
        new MaterialSupplier(478, "Fluorseals"),
        new MaterialSupplier(479, "Forever Plast"),
        new MaterialSupplier(480, "Formosa Plastics Corporation, USA"),
        new MaterialSupplier(481, "Freudenberg Simrit"),
        new MaterialSupplier(482, "Frisetta Polymer"),
        new MaterialSupplier(483, "Fujipoly Industries"),
        new MaterialSupplier(484, "Garland Manufacturing"),
        new MaterialSupplier(485, "Garlock"),
        new MaterialSupplier(486, "General Plastics"),
        new MaterialSupplier(487, "Gharda Chemicals"),
        new MaterialSupplier(488, "GEHR Plastics Inc."),
        new MaterialSupplier(489, "Gichem Gruppo Industriale Chimico"),
        new MaterialSupplier(490, "Glastic Corporation"),
        new MaterialSupplier(491, "Global EPP"),
        new MaterialSupplier(492, "Global Polymers Corporation"),
        new MaterialSupplier(493, "Glyptal"),
        new MaterialSupplier(494, "W. L. Gore & Associates"),
        new MaterialSupplier(495, "Greco"),
        new MaterialSupplier(496, "Green Dot"),
        new MaterialSupplier(497, "Gromax"),
        new MaterialSupplier(498, "Grupo Repol"),
        new MaterialSupplier(499, "Hannam Chemical"),
        new MaterialSupplier(500, "Haveg Division of Ametek"),
        new MaterialSupplier(501, "Haysite Reinforced Plastics"),
        new MaterialSupplier(502, "Heraeus"),
        new MaterialSupplier(503, "Hexcel Composites"),
        new MaterialSupplier(504, "Hippe"),
        new MaterialSupplier(505, "Honeywell"),
        new MaterialSupplier(506, "Hong Kun Group"),
        new MaterialSupplier(507, "HOS-Technik"),
        new MaterialSupplier(508, "Humiseal"),
        new MaterialSupplier(509, "Huntsman Corporation"),
        new MaterialSupplier(510, "Hyosung Corporation"),
        new MaterialSupplier(511, "ICO Polymers"),
        new MaterialSupplier(512, "Idemitsu Kosan"),
        new MaterialSupplier(513, "IDI Composites International"),
        new MaterialSupplier(514, "Indorama"),
        new MaterialSupplier(515, "Ineos ABS"),
        new MaterialSupplier(516, "Ineos Nova"),
        new MaterialSupplier(517, "Ineos Styrenics"),
        new MaterialSupplier(518, "Infinite Polymer System II"),
        new MaterialSupplier(519, "Innegra Techologies"),
        new MaterialSupplier(520, "Inno-Comp Ltd"),
        new MaterialSupplier(521, "Innospec"),
        new MaterialSupplier(522, "Intercontinental Polymers"),
        new MaterialSupplier(523, "IPB Plastic Sheet Extrusion"),
        new MaterialSupplier(524, "Ipiranga Petroquímica"),
        new MaterialSupplier(525, "Iran Petrochemical Commercial Co."),
        new MaterialSupplier(526, "IRPC"),
        new MaterialSupplier(527, "Isoflon"),
        new MaterialSupplier(528, "ITW Devcon"),
        new MaterialSupplier(529, "ITW Plexus"),
        new MaterialSupplier(530, "Jackon GmbH"),
        new MaterialSupplier(531, "JPJ Technologies"),
        new MaterialSupplier(532, "Kaneka Company"),
        new MaterialSupplier(533, "Kareline Oy Ltd"),
        new MaterialSupplier(534, "Karina"),
        new MaterialSupplier(535, "Kazanorgsintez"),
        new MaterialSupplier(536, "Keysor-Century"),
        new MaterialSupplier(537, "Kingfa Sci. & Tech. Co."),
        new MaterialSupplier(538, "KKPC"),
        new MaterialSupplier(539, "Kleerdex Company"),
        new MaterialSupplier(540, "Kolon"),
        new MaterialSupplier(541, "Korea Engineering Plastics (KEP)"),
        new MaterialSupplier(542, "Kostat"),
        new MaterialSupplier(543, "Kotec Corp"),
        new MaterialSupplier(544, "Kraiburg TPE"),
        new MaterialSupplier(545, "Kraton"),
        new MaterialSupplier(546, "Kuraray Company"),
        new MaterialSupplier(547, "LANXESS"),
        new MaterialSupplier(548, "LATI"),
        new MaterialSupplier(549, "Lehigh Technologies, LLC."),
        new MaterialSupplier(550, "Lehmann & Voss"),
        new MaterialSupplier(551, "Lendell Manufacturing Inc."),
        new MaterialSupplier(552, "LG Chemicals"),
        new MaterialSupplier(553, "Loctite"),
        new MaterialSupplier(554, "Lord Adhesive"),
        new MaterialSupplier(555, "Lotus Nano Paint"),
        new MaterialSupplier(556, "Lubrizol"),
        new MaterialSupplier(557, "Lucent Polymers"),
        new MaterialSupplier(558, "Lucky"),
        new MaterialSupplier(559, "LyondellBasell"),
        new MaterialSupplier(560, "M. Holland"),
        new MaterialSupplier(561, "Mallard Creek Polymers"),
        new MaterialSupplier(562, "Manufacturing Insight LLC"),
        new MaterialSupplier(563, "Manifattura Cattaneo"),
        new MaterialSupplier(564, "Mapal Plastics"),
        new MaterialSupplier(565, "Matrix Composites & Engineering"),
        new MaterialSupplier(566, "The Matrixx Group"),
        new MaterialSupplier(567, "MBA Polymers"),
        new MaterialSupplier(568, "M Chemical Company"),
        new MaterialSupplier(569, "Mearthane Products Group"),
        new MaterialSupplier(570, "Meilian Chemical Co."),
        new MaterialSupplier(571, "Menzolit"),
        new MaterialSupplier(572, "Merquinsa"),
        new MaterialSupplier(573, "Metabolix, Inc."),
        new MaterialSupplier(574, "Metflex"),
        new MaterialSupplier(575, "Metton"),
        new MaterialSupplier(576, "Michelman"),
        new MaterialSupplier(577, "Micropol"),
        new MaterialSupplier(578, "Mikro-Technik"),
        new MaterialSupplier(579, "Mitsubishi"),
        new MaterialSupplier(580, "Mitsui"),
        new MaterialSupplier(581, "Möller Medical"),
        new MaterialSupplier(582, "Momentive Performance Materials"),
        new MaterialSupplier(583, "Monmouth Rubber & Plastics"),
        new MaterialSupplier(584, "MRC Polymers"),
        new MaterialSupplier(585, "MTI Thermoplastic Composites"),
        new MaterialSupplier(586, "MTM Plastics"),
        new MaterialSupplier(587, "Multibase"),
        new MaterialSupplier(588, "Murtfeldt"),
        new MaterialSupplier(589, "Mytex Polymers"),
        new MaterialSupplier(590, "NanoComposite Materials Technology Limited"),
        new MaterialSupplier(591, "Nanosonic, Inc."),
        new MaterialSupplier(592, "NASCA Elastomers"),
        new MaterialSupplier(593, "NatureWorks LLC"),
        new MaterialSupplier(594, "Natural Fiber Composites, Inc."),
        new MaterialSupplier(595, "NEU Specialty Engineered Materials"),
        new MaterialSupplier(596, "Neutrex, Inc."),
        new MaterialSupplier(597, "Nexa"),
        new MaterialSupplier(598, "NeXolve Corporation"),
        new MaterialSupplier(599, "NextGen Adhesives"),
        new MaterialSupplier(600, "Ngai Hing Engineering Plastics (NHEP)"),
        new MaterialSupplier(601, "Niche Polymer"),
        new MaterialSupplier(602, "Nilit"),
        new MaterialSupplier(603, "Noble Polymers"),
        new MaterialSupplier(604, "Noltex"),
        new MaterialSupplier(605, "North Wood Plastics"),
        new MaterialSupplier(606, "Northstar Polymers"),
        new MaterialSupplier(607, "Novatec"),
        new MaterialSupplier(608, "Nurel Engineering Polymers"),
        new MaterialSupplier(609, "NYCOA, Inc."),
        new MaterialSupplier(610, "Nylacast"),
        new MaterialSupplier(611, "Oceanchem Group"),
        new MaterialSupplier(612, "OCTAL Petrochemicals"),
        new MaterialSupplier(613, "Okulen"),
        new MaterialSupplier(614, "Omni Plastics"),
        new MaterialSupplier(615, "Omnia Plastica"),
        new MaterialSupplier(616, "ORBILAN"),
        new MaterialSupplier(617, "Orbis, Menasha Corporation"),
        new MaterialSupplier(618, "Ovation Polymers"),
        new MaterialSupplier(619, "Owens Corning"),
        new MaterialSupplier(620, "Oxford Polymers"),
        new MaterialSupplier(621, "P & P Technology"),
        new MaterialSupplier(622, "Palm Labs Adhesives"),
        new MaterialSupplier(623, "PANIPOL"),
        new MaterialSupplier(624, "Panjin Zhongrun High Performance Polymer Co."),
        new MaterialSupplier(625, "Park Electrochemical Corp."),
        new MaterialSupplier(626, "Parson Adhesives"),
        new MaterialSupplier(627, "Parylene Coating Services"),
        new MaterialSupplier(628, "Pasargad Polymer Peyvand"),
        new MaterialSupplier(629, "Pau Tai"),
        new MaterialSupplier(630, "PBI Performance Products"),
        new MaterialSupplier(631, "PEAK Werkstoff"),
        new MaterialSupplier(632, "Pearl Engineering Polymers Limited"),
        new MaterialSupplier(633, "PennFibre"),
        new MaterialSupplier(634, "Permabond"),
        new MaterialSupplier(635, "Perstorp Compounds"),
        new MaterialSupplier(636, "Petroquimica Triunfo"),
        new MaterialSupplier(637, "Phillips Sumika Polypropylene Company"),
        new MaterialSupplier(638, "Pinnacle Polymers"),
        new MaterialSupplier(639, "Plaskolite Inc."),
        new MaterialSupplier(640, "Plaskolite West"),
        new MaterialSupplier(641, "Plaskon Division-Cookson Group"),
        new MaterialSupplier(642, "The Plastics Group of America"),
        new MaterialSupplier(643, "PlastxWorld"),
        new MaterialSupplier(644, "Plenco - Plastics Engineering Company"),
        new MaterialSupplier(645, "PMC Polymer Products"),
        new MaterialSupplier(646, "Polikim Polimer ve Kimya Sanay"),
        new MaterialSupplier(647, "Polimeri Europa"),
        new MaterialSupplier(648, "Polimeros Mexicanos"),
        new MaterialSupplier(649, "Polimersan Polimer-Kimya San ve Tic.Ltd.Sti."),
        new MaterialSupplier(650, "Polycasa"),
        new MaterialSupplier(651, "PolyChem Alloy"),
        new MaterialSupplier(652, "Polygon Company"),
        new MaterialSupplier(653, "Polymax"),
        new MaterialSupplier(654, "Polymer Industries"),
        new MaterialSupplier(655, "Polymer Resources"),
        new MaterialSupplier(656, "The Polymer Technology Group"),
        new MaterialSupplier(657, "PolyMirae Company Ltd."),
        new MaterialSupplier(658, "PolyOne"),
        new MaterialSupplier(659, "Polyplastic"),
        new MaterialSupplier(660, "Polyram"),
        new MaterialSupplier(661, "Polystrand"),
        new MaterialSupplier(662, "Poly-u-Mac"),
        new MaterialSupplier(663, "Precision Polymer Engineering"),
        new MaterialSupplier(664, "Premix"),
        new MaterialSupplier(665, "Premix Thermoplastics Inc."),
        new MaterialSupplier(666, "Professional Plastics"),
        new MaterialSupplier(667, "Prodways"),
        new MaterialSupplier(668, "Propex Fabrics"),
        new MaterialSupplier(669, "Protective Coating Co."),
        new MaterialSupplier(670, "Quantum"),
        new MaterialSupplier(671, "Quantum Composites, Inc."),
        new MaterialSupplier(672, "Radici"),
        new MaterialSupplier(673, "Raschig Group"),
        new MaterialSupplier(674, "Ravago Manufacturing Americas"),
        new MaterialSupplier(675, "Reliance Industries Limited"),
        new MaterialSupplier(676, "Reltek LLC"),
        new MaterialSupplier(677, "Resin Technology Group"),
        new MaterialSupplier(678, "Resinlab®"),
        new MaterialSupplier(679, "Resinoid Engineering Corporation"),
        new MaterialSupplier(680, "Resirene"),
        new MaterialSupplier(681, "REXtac"),
        new MaterialSupplier(682, "RheTech Products"),
        new MaterialSupplier(683, "Rhodia Engineering Plastics"),
        new MaterialSupplier(684, "Ritelok"),
        new MaterialSupplier(685, "Röchling"),
        new MaterialSupplier(686, "Rogers Corporation"),
        new MaterialSupplier(687, "Rotuba Plastics"),
        new MaterialSupplier(688, "Rubatex"),
        new MaterialSupplier(689, "S&E Specialty Polymers"),
        new MaterialSupplier(690, "SABIC Innovative Plastics"),
        new MaterialSupplier(691, "Saint Gobain Performance Plastics"),
        new MaterialSupplier(692, "St. Joseph Plastics"),
        new MaterialSupplier(693, "Sam Yang Kasei"),
        new MaterialSupplier(694, "Sanyo Chemicals"),
        new MaterialSupplier(695, "ScanTube"),
        new MaterialSupplier(696, "SCG Chemicals"),
        new MaterialSupplier(697, "Schwartz Technical Plastics"),
        new MaterialSupplier(698, "Seals Eastern, Inc."),
        new MaterialSupplier(699, "Sekisui Plastics"),
        new MaterialSupplier(700, "SGL Carbon Group"),
        new MaterialSupplier(701, "Shakespeare Company"),
        new MaterialSupplier(702, "Shamrock Technologies"),
        new MaterialSupplier(703, "Shandong Rike Chemical"),
        new MaterialSupplier(704, "Shell Chemical"),
        new MaterialSupplier(705, "Shin-Etsu Silicones"),
        new MaterialSupplier(706, "Shinil Chemical"),
        new MaterialSupplier(707, "Shuman Plastics"),
        new MaterialSupplier(708, "Sibur"),
        new MaterialSupplier(709, "Sichuan Deyang"),
        new MaterialSupplier(710, "Sidi Kerir Petrochemicals Co."),
        new MaterialSupplier(711, "Sika"),
        new MaterialSupplier(712, "Silikony Polskie"),
        new MaterialSupplier(713, "Silon"),
        new MaterialSupplier(714, "SK Chemicals"),
        new MaterialSupplier(715, "Skybond"),
        new MaterialSupplier(716, "SMAC MontBlac Groupe Technologies"),
        new MaterialSupplier(717, "Solvay Engineered Polymers"),
        new MaterialSupplier(718, "Solvay Specialty Polymers"),
        new MaterialSupplier(719, "SolVin"),
        new MaterialSupplier(720, "Sorbothane"),
        new MaterialSupplier(721, "Southern Clay Products"),
        new MaterialSupplier(722, "Spartech"),
        new MaterialSupplier(723, "Specialty Coating Systems (SCS)"),
        new MaterialSupplier(724, "SPS Guang Zhou"),
        new MaterialSupplier(725, "Stanelco"),
        new MaterialSupplier(726, "Star Plastics"),
        new MaterialSupplier(727, "Star Thermoplastic Alloys and Rubbers"),
        new MaterialSupplier(728, "Sterigenics"),
        new MaterialSupplier(729, "Stir SpA."),
        new MaterialSupplier(730, "Stratasys®"),
        new MaterialSupplier(731, "Struktol"),
        new MaterialSupplier(732, "Styrolution"),
        new MaterialSupplier(733, "Styron"),
        new MaterialSupplier(734, "Süd-Chemie"),
        new MaterialSupplier(735, "Suqian Unitechem"),
        new MaterialSupplier(736, "Sunoco Chemicals"),
        new MaterialSupplier(737, "Supreme Petrochem LTD"),
        new MaterialSupplier(738, "Sylvin Technologies"),
        new MaterialSupplier(739, "Synergy Polymers"),
        new MaterialSupplier(740, "SYNTHOS Kralupy a.s."),
        new MaterialSupplier(741, "Taiwan PU Corporation"),
        new MaterialSupplier(742, "Taiwan Sheen Soon"),
        new MaterialSupplier(743, "Techmer Lehvoss Compounds"),
        new MaterialSupplier(744, "Techno Polymer Company"),
        new MaterialSupplier(745, "Teknor Apex Company"),
        new MaterialSupplier(746, "Teijin Chemicals"),
        new MaterialSupplier(747, "Texas-Carolina Chemicals Corporation"),
        new MaterialSupplier(748, "Thai Petrochemical Industry"),
        new MaterialSupplier(749, "Thermoseal"),
        new MaterialSupplier(750, "Tipco Industries Ltd., India"),
        new MaterialSupplier(751, "Tisan Engineering Plastics"),
        new MaterialSupplier(752, "Titan Chemicals"),
        new MaterialSupplier(753, "Top Polymer Enterprise"),
        new MaterialSupplier(754, "Total Petrochemicals"),
        new MaterialSupplier(755, "Toyobo Company"),
        new MaterialSupplier(756, "Trelleborg"),
        new MaterialSupplier(757, "TSE Industries, Inc"),
        new MaterialSupplier(758, "Tritex LLC"),
        new MaterialSupplier(759, "U.S. Plastic Lumber (USPL)"),
        new MaterialSupplier(760, "Unitika"),
        new MaterialSupplier(761, "UBE Industries"),
        new MaterialSupplier(762, "Unipetrol RPA"),
        new MaterialSupplier(763, "Uniseal"),
        new MaterialSupplier(764, "Valley Adhesives"),
        new MaterialSupplier(765, "Vita Thermoplastic Polymers (VTC)"),
        new MaterialSupplier(766, "Voloknokhim"),
        new MaterialSupplier(767, "Von Roll Isola USA, Inc."),
        new MaterialSupplier(768, "Vyncolit, a subsidiary of Sumitomo Bakelite"),
        new MaterialSupplier(769, "Wacker Silicones"),
        new MaterialSupplier(770, "Wanhua Chemical"),
        new MaterialSupplier(771, "Wanshijie Plastic Sheet Co"),
        new MaterialSupplier(772, "Washington Penn Plastic Co., Inc."),
        new MaterialSupplier(773, "Wellman, Inc."),
        new MaterialSupplier(774, "Westlake Plastics"),
        new MaterialSupplier(775, "Whitecast Polymer Engineering"),
        new MaterialSupplier(776, "Wico Plast"),
        new MaterialSupplier(777, "World Class Technologies"),
        new MaterialSupplier(778, "YOUJU New Materials"),
        new MaterialSupplier(779, "Zakłady Azotowe w Tarnowie-Moscicach S.A."),
        new MaterialSupplier(780, "Zell-Metall Engineering Plastics"),
        new MaterialSupplier(781, "Zeon Chemicals"),
        new MaterialSupplier(782, "Zhejiang Double Fish Plastics Co., Ltd"),
        new MaterialSupplier(783, "Zhejiang Juner New Materials Co, Ltd"),
        new MaterialSupplier(784, "Zoltek RT"),
        new MaterialSupplier(785, "Zylog"),
        new MaterialSupplier(786, "Zyvex Performance Materials")
        //endregion
    };

    private static final MaterialType[] TYPES =
    {
        //region Types
        new MaterialType(1, "Carbon"),
        new MaterialType(2, "Ceramic"),
        new MaterialType(3, "Fluid"),
        new MaterialType(4, "Metal"),
        new MaterialType(5, "Other Engineering Material"),
        new MaterialType(6, "Polymer"),
        new MaterialType(7, "Pure Element"),
        new MaterialType(8, "Wood and Natural Products")
        //endregion
    };

    private static final Material[] MATERIALS =
    {
            new Material("tapestry", TYPES[7], SUPPLIERS[18], 12.5),
            new Material("hardwood", TYPES[7], SUPPLIERS[28], 2.5)
    };

    public MySQLiteHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_TYPE_TABLE = "CREATE TABLE " + TABLE_TYPE + " ( " +
                                   KEY_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                   KEY_TYPE_NAME + " TEXT )";

        String CREATE_SUPPLIER_TABLE = "CREATE TABLE " + TABLE_SUPPLIER + " ( " +
                                           KEY_SUPPLIER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                           KEY_SUPPLIER_NAME + " TEXT )";

        String CREATE_MATERIAL_TABLE = "CREATE TABLE " + TABLE_MATERIAL + " ( " +
                                       KEY_MATERIAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                       KEY_MATERIAL_NAME + " TEXT, " +
                                       KEY_TYPE_ID + " INTEGER, " +
                                       KEY_SUPPLIER_ID + " INTEGER, " +
                                       KEY_PRICE + " REAL, " +
                                       "FOREIGN KEY (" + KEY_TYPE_ID + ") REFERENCES " +
                                                    TABLE_TYPE + " (" + KEY_TYPE_ID + "), " +
                                       "FOREIGN KEY (" + KEY_SUPPLIER_ID + ") REFERENCES " +
                                                    TABLE_SUPPLIER + "(" + KEY_SUPPLIER_ID +"))";

        db.execSQL((CREATE_TYPE_TABLE));
        db.execSQL((CREATE_SUPPLIER_TABLE));
        db.execSQL((CREATE_MATERIAL_TABLE));

        fillTypes(TYPES);
        fillSuppliers(SUPPLIERS);
        fillMaterials(MATERIALS);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATERIAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUPPLIER);
        db.execSQL(("DROP TABLE IF EXISTS " + TABLE_TYPE));

        this.onCreate(db);
    }

    public Cursor getAllMaterials()
    {
        String query = "SELECT " + KEY_MATERIAL_ID +
                            ", " + KEY_MATERIAL_NAME +
                            ", " + KEY_TYPE_ID +
                            ", " + KEY_TYPE_NAME +
                            ", " + KEY_SUPPLIER_ID +
                            ", " + KEY_SUPPLIER_NAME +
                            ", " + KEY_PRICE +

                       " FROM " + TABLE_MATERIAL +

                       " LEFT JOIN " + TABLE_TYPE +
                            " ON " + TABLE_MATERIAL + "." + KEY_TYPE_ID +
                                " = " + TABLE_TYPE + "." + KEY_TYPE_ID +

                       " LEFT JOIN " + TABLE_SUPPLIER +
                            " ON " + TABLE_MATERIAL + "." + KEY_SUPPLIER_ID +
                                " = " + TABLE_SUPPLIER + "." + KEY_SUPPLIER_ID;

        Cursor cursor = null;
        SQLiteDatabase db = this.getWritableDatabase();

        cursor = db.rawQuery(query, null);
        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }

    public Cursor filtre(String column, String search)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_MATERIAL,
                                 COLUMNS_MATERIAL,
                                 column + " LIKE ?",
                                 new String[]{"%" + search + "%"},
                                 null,
                                  null,
                                 null,
                                    null);
        if(cursor != null)
        {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    private void fillTypes(MaterialType[] types)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try
        {
            ContentValues values = new ContentValues();
            for(MaterialType type : types)
            {
                values.put(KEY_TYPE_NAME, type.getName());
                db.insert(TABLE_TYPE, null, values);
            }

            db.setTransactionSuccessful();
        } finally
        {
            db.endTransaction();
        }
    }

    private void fillSuppliers(MaterialSupplier[] suppliers)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try
        {
            ContentValues values = new ContentValues();
            for(MaterialSupplier supplier : suppliers)
            {
                values.put(KEY_SUPPLIER_NAME, supplier.getName());
                db.insert(TABLE_SUPPLIER, null, values);
            }

            db.setTransactionSuccessful();
        } finally
        {
            db.endTransaction();
        }
    }

    private void fillMaterials(Material[] materials)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        try
        {
            ContentValues values = new ContentValues();
            for(Material material : materials)
            {
                values.put(KEY_MATERIAL_NAME, material.getName());
                values.put(KEY_TYPE_ID, material.getType().get_id());
                values.put(KEY_SUPPLIER_ID, material.getSupplier().get_id());
                values.put(KEY_PRICE, material.getPrice());
                db.insert(TABLE_MATERIAL, null, values);
            }

            db.setTransactionSuccessful();
        } finally
        {
            db.endTransaction();
        }
    }
}
