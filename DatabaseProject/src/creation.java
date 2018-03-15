// Ulaş SARIKAYA 
// #20130702054
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class creation {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/as8?useUnicode=yes&characterEncoding=UTF-8";
	//character UTF8 ekledim
	static final String USER = "root";
	static final String PASS = "mysql";
	
	static JTable table = new JTable();

	public static void main(String[] args)
	{	
		Connection conn = null;
		Statement stmt = null;
		
		JFrame frame = new JFrame();
		
		JPanel p = new JPanel();
		
		JButton b= new JButton("Create Tables");
		JButton b1=new JButton("Insert Tables");
		
		frame.setSize(400, 400);
		p.setSize(400,400);
		
		p.add(b);
		p.add(b1);
		
		frame.add(p);
		frame.setVisible(true);
		
		
		b.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display/center the jdialog when the button is pressed
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
					Statement stmt = (Statement) conn.createStatement();
					
							String createTables="CREATE TABLE IF NOT EXISTS `BOOKSTORE` (\n" + 
							"  `book_name` varchar(200) DEFAULT NULL,\n" +
							"  `ISBN` int(20) DEFAULT NULL,\n" +
							"  `price` int(20) DEFAULT NULL\n" +
							") ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;\n" + 
							"\n" ;
							String createTables1="CREATE TABLE IF NOT EXISTS `CUSTOMER_INFO` (\n" + 
							"  `customer_no` int(20) NOT NULL,\n" + 
							"  `customer_name` varchar(25) DEFAULT NULL,\n" + 
							"  `customer_surname` varchar(25) DEFAULT NULL,\n" + 
							"  `branch_name` varchar(50) DEFAULT NULL,\n" +
							"  `country_id` int(20) NOT NULL\n" + 
							") ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;\n" + 
							"\n" ;
							String createTables2="CREATE TABLE IF NOT EXISTS `SALESMAN_INFO` (\n" + 
									"  `salesman_no` int(20) NOT NULL,\n" + 
									"  `salesman_name` varchar(25) DEFAULT NULL,\n" + 
									"  `salesman_surname` varchar(25) DEFAULT NULL,\n" + 
									"  `branch_name` varchar(50) DEFAULT NULL,\n" +
									"  `country_id` int(20) NOT NULL\n" + 
									") ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;\n" + 
									"\n" ;
							String createTables3="CREATE TABLE IF NOT EXISTS `DISTRICTS` (\n" + 
							"  `district_id` int(11) DEFAULT NULL,\n" + 
							"  `district_name` varchar(50) NOT NULL\n" + 
							") ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;\n" + 
							"\n" ; 
							String createTables4="CREATE TABLE IF NOT EXISTS `COUNTRY` (\n" + 
							"  `country_id` int(11) NOT NULL,\n" + 
							"  `country_name` varchar(50) DEFAULT NULL,\n" + 
							"  `district_id` int(11) DEFAULT NULL\n" + 
							") ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;\n" + 
							"\n" ; 
							String createTables5="CREATE TABLE IF NOT EXISTS `BRANCHES` (\n" + 
							"  `branch_id` int(11) NOT NULL,\n" + 
							"  `branch_name` varchar(50) DEFAULT NULL,\n" +
							"  `district_id` int(11) DEFAULT NULL\n" +
							") ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;\n" + 
							"\n" ;
							String createTables6="ALTER TABLE `CUSTOMER_INFO`\n" + 
							"  ADD PRIMARY KEY (`customer_no`),\n" + 
							"  ADD UNIQUE KEY `customer_no` (`customer_no`),\n" + 
							"  ADD KEY `fk_country_id` (`country_id`);\n" + 
							"\n" ; 
							String createTables7="ALTER TABLE `DISTRICTS`\n" + 
							"  ADD PRIMARY KEY (`district_id`);\n" + 
							"\n" ; 
							String createTables8="ALTER TABLE `COUNTRY`\n" + 
							"  ADD PRIMARY KEY (`country_id`),\n" + 
							"  ADD KEY `fk_district_id` (`district_id`);\n" + 
							"\n" ;
							String createTables9="ALTER TABLE `CUSTOMER_INFO`\n" + 
							"  MODIFY `customer_no` int(20) NOT NULL;\n" + 
							"\n" ;
							String createTables10="ALTER TABLE `DISTRICTS`\n" + 
							"  MODIFY `district_id` int(20) NOT NULL;\n" + 
							"\n" ; 
							String createTables11="ALTER TABLE `COUNTRY`\n" + 
							"  MODIFY `country_id` int(20) NOT NULL;\n" + 
							"\n" ; 
							String createTables12="ALTER TABLE `CUSTOMER_INFO`\n" + 
							"  ADD CONSTRAINT `fk_country_id` FOREIGN KEY (`country_id`) REFERENCES `COUNTRY` (`country_id`);\n" + 
							"\n" ;
							String createTables13="ALTER TABLE `COUNTRY`\n" + 
							"  ADD CONSTRAINT `fk_district_id` FOREIGN KEY (`district_id`) REFERENCES `DISTRICTS` (`district_id`);\n" + 
							"\n" ; 
						  String createTables14="	CREATE TABLE IF NOT EXISTS `STORE-SALE` (\n" + 
						  		"`customer_no` int(20) NOT NULL,\n" + 
						  		"`book_name` varchar(200) DEFAULT NULL,\n" + 
						  		"`price` int(20) DEFAULT NULL,\n" + 
						  		"`salesman_no` int(20) NOT NULL,\n" + 
						  		"`ISBN` int(20) DEFAULT NULL,\n" + 
						  		"`Date` DATE\n" + 
						  		") ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;\n" ;


					boolean rs = stmt.execute(createTables);
					boolean rs1= stmt.execute(createTables1);
					boolean rs2 = stmt.execute(createTables2);
					boolean rs3 = stmt.execute(createTables3);
					boolean rs4 = stmt.execute(createTables4);
					boolean rs5 = stmt.execute(createTables5);
					boolean rs6 = stmt.execute(createTables6);					
					boolean rs7 = stmt.execute(createTables7);
					boolean rs8 = stmt.execute(createTables8);
					boolean rs9 = stmt.execute(createTables9);
					boolean rs10 = stmt.execute(createTables10);
					boolean rs11 = stmt.execute(createTables11);
					boolean rs12 = stmt.execute(createTables12);
					boolean rs13 = stmt.execute(createTables13);
					boolean rs14 = stmt.execute(createTables14);



					// STEP 6: Clean-up environment
					stmt.close();
					conn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					// finally block used to close resources
					try {
						if (stmt != null)
							stmt.close();
					} catch (SQLException se2) {
					}// nothing we can do
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}// end finally try
				}// end try
				
								//scan.close();
	
		  }
		});
		b1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display/center the jdialog when the button is pressed
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
					Statement stmt = (Statement) conn.createStatement();
					String insertTables="INSERT INTO `DISTRICTS` (`district_id`, `district_name`) VALUES\n" + 
							"(1, 'EGE'),\n" + 
							"(2, 'AKDENIZ'),\n" + 
							"(3, 'KARADENIZ'),\n" + 
							"(4, 'DOĞU ANADOLU'),\n" + 
							"(5, 'GUNEY DOGU ANADOLU'),\n" + 
							"(6, 'IC ANADOLU'),\n" + 
							"(7, 'MARMARA');";
					String insertTables2="INSERT INTO `COUNTRY` (`country_id`, `country_name`, `district_id`) VALUES\n" + 
							"(1, 'Adana', 5),\n" + 
							"(2, 'Adıyaman', 4),\n" + 
							"(3, 'Afyonkarahisar', 2),\n" + 
							"(4, 'Ağrı', 3),\n" + 
							"(5, 'Aksaray', 7),\n" + 
							"(6, 'Amasya', 1),\n" + 
							"(7, 'Ankara', 7),\n" + 
							"(8, 'Antalya', 5),\n" + 
							"(9, 'Ardahan', 3),\n" + 
							"(10, 'Artvin', 1),\n" + 
							"(11, 'Aydın', 2),\n" + 
							"(12, 'Balıkesir', 6),\n" + 
							"(13, 'Bartın', 1),\n" + 
							"(14, 'Batman', 4),\n" + 
							"(15, 'Bayburt', 1),\n" + 
							"(16, 'Bilecik', 6),\n" + 
							"(17, 'Bingöl', 3),\n" + 
							"(18, 'Bitlis', 3),\n" + 
							"(19, 'Bolu', 1),\n" + 
							"(20, 'Denizli', 5),\n" + 
							"(21, 'Bursa', 6),\n" + 
							"(22, 'Çanakkale', 6),\n" + 
							"(23, 'Çankırı', 7),\n" + 
							"(24, 'Çorum', 7),\n" + 
							"(25, 'Burdur', 2),\n" + 
							"(26, 'Diyarbakır', 4),\n" + 
							"(27, 'Düzce', 1),\n" + 
							"(28, 'Edirne', 6),\n" + 
							"(29, 'Elazığ', 3),\n" + 
							"(30, 'Erzincan', 3),\n" + 
							"(31, 'Erzurum', 3),\n" + 
							"(32, 'Eskişehir', 7),\n" + 
							"(33, 'Gaziantep', 4),\n" + 
							"(34, 'Giresun', 1),\n" + 
							"(35, 'Gümüşhane', 1),\n" + 
							"(36, 'Hakkari', 3),\n" + 
							"(37, 'Hatay', 5),\n" + 
							"(38, 'Iğdır', 3),\n" + 
							"(39, 'Isparta', 5),\n" + 
							"(40, 'İstanbul', 6),\n" + 
							"(41, 'İzmir', 2),\n" + 
							"(42, 'Kahramanmaraş', 5),\n" + 
							"(43, 'Karabük', 1),\n" + 
							"(44, 'Karaman', 7),\n" + 
							"(45, 'Kars', 3),\n" + 
							"(46, 'Kastamonu', 1),\n" + 
							"(47, 'Kayseri', 7),\n" + 
							"(48, 'Kırıkkale', 7),\n" + 
							"(49, 'Kırklareli', 6),\n" + 
							"(50, 'Kırşehir', 7),\n" + 
							"(51, 'Kilis', 4),\n" + 
							"(52, 'Kocaeli', 6),\n" + 
							"(53, 'Konya', 7),\n" + 
							"(54, 'Kütahya', 2),\n" + 
							"(55, 'Malatya', 3),\n" + 
							"(56, 'Manisa', 2),\n" + 
							"(57, 'Mardin', 4),\n" + 
							"(58, 'Mersin', 5),\n" + 
							"(59, 'Muğla', 2),\n" + 
							"(60, 'Muş', 3),\n" + 
							"(61, 'Nevşehir', 7),\n" + 
							"(62, 'Niğde', 7),\n" + 
							"(63, 'Ordu', 1),\n" + 
							"(64, 'Osmaniye', 5),\n" + 
							"(65, 'Rize', 1),\n" + 
							"(66, 'Sakarya', 6),\n" + 
							"(67, 'Samsun', 1),\n" + 
							"(68, 'Siirt', 4),\n" + 
							"(69, 'Sinop', 1),\n" + 
							"(70, 'Sivas', 7),\n" + 
							"(71, 'Şanlıurfa', 4),\n" + 
							"(72, 'Şırnak', 3),\n" + 
							"(73, 'Tekirdağ', 6),\n" + 
							"(74, 'Tokat', 1),\n" + 
							"(75, 'Trabzon', 1),\n" + 
							"(76, 'Tunceli', 3),\n" + 
							"(77, 'Uşak', 2),\n" + 
							"(78, 'Van', 3),\n" + 
							"(79, 'Yalova', 6),\n" + 
							"(80, 'Yozgat', 7),\n" + 
							"(81, 'Zonguldak', 2);";
		
					String insertTables3="INSERT INTO `BOOKSTORE` (`book_name`, `ISBN`, `price`) VALUES\n" + 
							"(	'	Bir savaş pilotunun anıları	'	,	1000000000	,	20	)	,	\n" + 
							"(	'	Kore savaşlarında Mehmetçik	'	,	1000000001	,	21	)	,	\n" + 
							"(	'	21. yüzyılda savaş stratejileri	'	,	1000000002	,	22	)	,	\n" + 
							"(	'	Asker ve vatan	'	,	1000000003	,	23	)	,	\n" + 
							"(	'	Savaşı anlamak  21. yüzyıl için strateji	'	,	1000000004	,	24	)	,	\n" + 
							"(	'	Uluslararası güvenlik ve strateji	'	,	1000000005	,	25	)	,	\n" + 
							"(	'	Osmanlıdan Cumhuriyete ordu siyaset ilişkisi ve 27 Mayıs 1960 askeri darbesi	'	,	1000000006	,	26	)	,	\n" + 
							"(	'	Ordu ve politika	'	,	1000000007	,	27	)	,	\n" + 
							"(	'	Takvimül edvar  takvimler	'	,	1000000008	,	28	)	,	\n" + 
							"(	'	Yıldız etkinliği ve değişkenliği sempozyumu (2000Çanakkale)	'	,	1000000009	,	29	)	,	\n" + 
							"(	'	Microsoft office excel 2007	'	,	1000000010	,	30	)	,	\n" + 
							"(	'	34 konuda yeni başlayanlar için bilgisayar	'	,	1000000011	,	31	)	,	\n" + 
							"(	'	İnternet ve hukuk	'	,	1000000012	,	32	)	,	\n" + 
							"(	'	Borland Quattro Pro for Windows  sürüm 5.0	'	,	1000000013	,	33	)	,	\n" + 
							"(	'	Foxpro 2.5 for dos	'	,	1000000014	,	34	)	,	\n" + 
							"(	'	3ds Max 8 ile görselleştirme	'	,	1000000015	,	35	)	,	\n" + 
							"(	'	AutoCAD 2000 ile bilgisayar destekli teknik resim	'	,	1000000016	,	36	)	,	\n" + 
							"(	'	Elektronik yayıncılık ve web tasarım	'	,	1000000017	,	37	)	,	\n" + 
							"(	'	C# ile ASP.Net 3.5	'	,	1000000018	,	38	)	,	\n" + 
							"(	'	Maya unlimited	'	,	1000000019	,	39	)	,	\n" + 
							"(	'	JavaScript	'	,	1000000020	,	40	)	,	\n" + 
							"(	'	10 adımda flash oyun programlama	'	,	1000000021	,	41	)	,	\n" + 
							"(	'	10 adımda web tasarımı	'	,	1000000022	,	42	)	,	\n" + 
							"(	'	Programlama ve veritabanı mantığı	'	,	1000000023	,	43	)	,	\n" + 
							"(	'	Web tasarım rehberi	'	,	1000000024	,	44	)	,	\n" + 
							"(	'	Flash CS4 ve uygulamalar ile Actionscript 3.0	'	,	1000000025	,	45	)	,	\n" + 
							"(	'	PHP	'	,	1000000026	,	46	)	,	\n" + 
							"(	'	Bilgisayara giriş ve güncel yazılımlar 1	'	,	1000000027	,	47	)	,	\n" + 
							"(	'	Visual basic, NET	'	,	1000000028	,	48	)	,	\n" + 
							"(	'	SolidWorks	'	,	1000000029	,	49	)	,	\n" + 
							"(	'	Çevre teknolojisi 1	'	,	1000000030	,	50	)	,	\n" + 
							"(	'	Mühendislik jeolojisi	'	,	1000000031	,	51	)	,	\n" + 
							"(	'	Çevre mikrobiyolojisi	'	,	1000000032	,	52	)	,	\n" + 
							"(	'	Daha geç olmadan	'	,	1000000033	,	53	)	,	\n" + 
							"(	'	Ergene Havzası çevre düzeni planı I	'	,	1000000034	,	54	)	,	\n" + 
							"(	'	Ergene Havzası çevre düzeni planı II	'	,	1000000035	,	55	)	,	\n" + 
							"(	'	Ergene Havzası çevre düzeni planı III	'	,	1000000036	,	56	)	,	\n" + 
							"(	'	Ulusal jeomorfoloji sempozyumu 	'	,	1000000037	,	57	)	,	\n" + 
							"(	'	Çevre sorunları	'	,	1000000038	,	58	)	,	\n" + 
							"(	'	Ekoloji ve çevre sorunları	'	,	1000000039	,	59	)	,	\n" + 
							"(	'	Çözümlü problemlerle temel prosesler	'	,	1000000040	,	60	)	,	\n" + 
							"(	'	Yer bilimi  fen bilimlerinde özel konular 2	'	,	1000000041	,	61	)	,	\n" + 
							"(	'	Okyanusya coğrafyası	'	,	1000000042	,	62	)	,	\n" + 
							"(	'	Kafir Halil  hikayesi	'	,	1000000043	,	63	)	,	\n" + 
							"(	'	Küresel ısınma  etkileri ve önlemleri	'	,	1000000044	,	64	)	,	\n" + 
							"(	'	Fikirler ve hatıralar etrafında Mehmed Akifi anlamak	'	,	1000000045	,	65	)	,	\n" + 
							"(	'	Baki kalan bu kubbede bir hoş sada imiş  unutulmaz mısralar	'	,	1000000046	,	66	)	,	\n" + 
							"(	'	Kültür ve edebiyatımızda ilkler ve enler	'	,	1000000047	,	67	)	,	\n" + 
							"(	'	Açıklamalarıyla safahattan seçmeler	'	,	1000000048	,	68	)	,	\n" + 
							"(	'	Edebiyatımızda Çanakkale savaşları	'	,	1000000049	,	69	)	,	\n" + 
							"(	'	Beyoğlu çıkmazı  bir başkomiser Galip polisiyesi	'	,	1000000050	,	70	)	,	\n" + 
							"(	'	Kaybolan sesler dünya dillerinin yok oluş süreci	'	,	1000000051	,	71	)	,	\n" + 
							"(	'	Duygular içimde tutsak kaldılar	'	,	1000000052	,	72	)	,	\n" + 
							"(	'	Söz ektim kağıt üstüne	'	,	1000000053	,	73	)	,	\n" + 
							"(	'	Suskunluğun dili	'	,	1000000054	,	74	)	,	\n" + 
							"(	'	Ansiklopedik Türk dili ve edebiyatı terimleri sözlüğü	'	,	1000000055	,	75	)	,	\n" + 
							"(	'	Osmanlı saray düğünleri ve şenlikleri 1  Ali surnamesi	'	,	1000000056	,	76	)	,	\n" + 
							"(	'	Osmanlı saray düğünleri ve şenlikleri 2  intizami surnamesi	'	,	1000000057	,	77	)	,	\n" + 
							"(	'	Osmanlı saray düğünleri ve şenlikleri 1  manzum surnameler	'	,	1000000058	,	78	)	,	\n" + 
							"(	'	80 günde devri alem	'	,	1000000059	,	79	)	,	\n" + 
							"(	'	80 günde dünya turu	'	,	1000000060	,	80	)	,	\n" + 
							"(	'	Alice harikalar diyarında	'	,	1000000061	,	81	)	,	\n" + 
							"(	'	Alise harikalar diyarında	'	,	1000000062	,	82	)	,	\n" + 
							"(	'	Altın ışık	'	,	1000000063	,	83	)	,	\n" + 
							"(	'	Değirmenimden mektuplar	'	,	1000000064	,	84	)	,	\n" + 
							"(	'	Altın ışık	'	,	1000000065	,	85	)	,	\n" + 
							"(	'	Andersen masalları	'	,	1000000066	,	86	)	,	\n" + 
							"(	'	Andersen masalları	'	,	1000000067	,	87	)	,	\n" + 
							"(	'	Ezop masalları	'	,	1000000068	,	88	)	,	\n" + 
							"(	'	Ezop masalları	'	,	1000000069	,	89	)	,	\n" + 
							"(	'	İlkokullar için çocuk şiirleri antolojisi	'	,	1000000070	,	90	)	,	\n" + 
							"(	'	Falaka gecelerim	'	,	1000000071	,	91	)	,	\n" + 
							"(	'	Dede Korkut hikayeleri	'	,	1000000072	,	92	)	,	\n" + 
							"(	'	Falaka gecelerim	'	,	1000000073	,	93	)	,	\n" + 
							"(	'	Dede Korkut hikayeleri	'	,	1000000074	,	94	)	,	\n" + 
							"(	'	Define adası	'	,	1000000075	,	95	)	,	\n" + 
							"(	'	Güliverin gezileri	'	,	1000000076	,	96	)	,	\n" + 
							"(	'	Define adası	'	,	1000000077	,	97	)	,	\n" + 
							"(	'	Gülliverin gezileri	'	,	1000000078	,	98	)	,	\n" + 
							"(	'	Heidi	'	,	1000000079	,	99	)	,	\n" + 
							"(	'	Heidi	'	,	1000000080	,	100	)	,	\n" + 
							"(	'	Hikayeler	'	,	1000000081	,	101	)	,	\n" + 
							"(	'	İnsan ne ile yaşar	'	,	1000000082	,	102	)	,	\n" + 
							"(	'	Karagöz ile Hacivat	'	,	1000000083	,	103	)	,	\n" + 
							"(	'	Karagöz ve Hacivat	'	,	1000000084	,	104	)	,	\n" + 
							"(	'	Türk manilerinden seçmeler	'	,	1000000085	,	105	)	,	\n" + 
							"(	'	Keloğlan masalları	'	,	1000000086	,	106	)	,	\n" + 
							"(	'	Türkçede deyimler	'	,	1000000087	,	107	)	,	\n" + 
							"(	'	Keloğlan masalları	'	,	1000000088	,	108	)	,	\n" + 
							"(	'	Türk ninnilerinden seçmeler	'	,	1000000089	,	109	)	,	\n" + 
							"(	'	La Fonteineden seçmeler	'	,	1000000090	,	110	)	,	\n" + 
							"(	'	La Fonteineden seçmeler	'	,	1000000091	,	111	)	,	\n" + 
							"(	'	Türk manilerinden seçmeler	'	,	1000000092	,	112	)	,	\n" + 
							"(	'	Mehmet Akiften seçmeler	'	,	1000000093	,	113	)	,	\n" + 
							"(	'	Yalnız Efe	'	,	1000000094	,	114	)	,	\n" + 
							"(	'	Yalnız Efe	'	,	1000000095	,	115	)	,	\n" + 
							"(	'	Mehmet Akiften seçmeler	'	,	1000000096	,	116	)	,	\n" + 
							"(	'	Vatan yahut Silistre	'	,	1000000097	,	117	)	,	\n" + 
							"(	'	Mevlananın Mesnevisinden seçme hikayeler	'	,	1000000098	,	118	)	,	\n" + 
							"(	'	Üç silahşörler	'	,	1000000099	,	119	)	,	\n" + 
							"(	'	Mevlananın Mesnevisinden seçme hikayeler	'	,	1000000100	,	120	)	,	\n" + 
							"(	'	Üç silahşörler	'	,	1000000101	,	121	)	,	\n" + 
							"(	'	Mutlu prens	'	,	1000000102	,	122	)	,	\n" + 
							"(	'	Türkülerden seçmeler	'	,	1000000103	,	123	)	,	\n" + 
							"(	'	Nasreddin Hoca hikayeleri	'	,	1000000104	,	124	)	,	\n" + 
							"(	'	Nasrettin Hoca Hikayeleri	'	,	1000000105	,	125	)	,	\n" + 
							"(	'	Oliver Twist	'	,	1000000106	,	126	)	,	\n" + 
							"(	'	Oliver Twist	'	,	1000000107	,	127	)	,	\n" + 
							"(	'	Şermin	'	,	1000000108	,	128	)	,	\n" + 
							"(	'	Ömerin çocukluğu	'	,	1000000110	,	130	)	,	\n" + 
							"(	'	Robin Hood	'	,	1000000111	,	131	)	,	\n" + 
							"(	'	Şermin	'	,	1000000112	,	132	)	,	\n" + 
							"(	'	Pollyanna	'	,	1000000113	,	133	)	,	\n" + 
							"(	'	Tekerlemeler	'	,	1000000114	,	134	)	,	\n" + 
							"(	'	Peter Pan	'	,	1000000115	,	135	)	,	\n" + 
							"(	'	Tiryaki sözleri	'	,	1000000116	,	136	)	,	\n" + 
							"(	'	Peter Pan	'	,	1000000117	,	137	)	,	\n" + 
							"(	'	Tom Sawyer	'	,	1000000118	,	138	)	,	\n" + 
							"(	'	Pinokyo	'	,	1000000119	,	139	)	,	\n" + 
							"(	'	Tom Sawyer	'	,	1000000120	,	140	)	,	\n" + 
							"(	'	Pinokyo	'	,	1000000121	,	141	)	,	\n" + 
							"(	'	Türk atasözlerinden seçmeler	'	,	1000000122	,	142	)	,	\n" + 
							"(	'	Türk bilmecelerinden seçmeler	'	,	1000000123	,	143	)	,	\n" + 
							"(	'	Türk bilmecelerinden seçmeler	'	,	1000000124	,	144	)	,	\n" + 
							"(	'	Çöplük	'	,	1000000125	,	145	)	,	\n" + 
							"(	'	Diriliş	'	,	1000000126	,	146	)	,	\n" + 
							"(	'	Duman	'	,	1000000127	,	147	)	,	\n" + 
							"(	'	İnanç	'	,	1000000128	,	148	)	,	\n" + 
							"(	'	İnsan ne ile yaşar	'	,	1000000129	,	149	)	,	\n" + 
							"(	'	Karamazov kardeşler	'	,	1000000130	,	150	)	,	\n" + 
							"(	'	Madam Bovary	'	,	1000000131	,	151	)	,	\n" + 
							"(	'	Sergüzeşt	'	,	1000000132	,	152	)	,	\n" + 
							"(	'	Ölü canlar	'	,	1000000133	,	153	)	,	\n" + 
							"(	'	Böyle Buyurdu Zerdüşt	'	,	1000000134	,	154	)	,	\n" + 
							"(	'	Babalar ve oğullar	'	,	1000000135	,	155	)	,	\n" + 
							"(	'	Kelimelerle barışık yaşamak	'	,	1000000136	,	156	)	,	\n" + 
							"(	'	Dionizyak coşkunun ihtişam ve sefaleti	'	,	1000000137	,	157	)	,	\n" + 
							"(	'	Türk tekerlemelerinden seçmeler	'	,	1000000138	,	158	)	,	\n" + 
							"(	'	Bize göre  bir seyahatin notları	'	,	1000000139	,	159	)	,	\n" + 
							"(	'	Turfanda mı yoksa turfa mı	'	,	1000000140	,	160	)	,	\n" + 
							"(	'	Çocuklar için bilmece bildirmece	'	,	1000000141	,	161	)	,	\n" + 
							"(	'	Bir asker eşinin anıları 	'	,	1000000142	,	162	)	,	\n" + 
							"(	'	Cemal Reşit Rey	'	,	1000000143	,	163	)	,	\n" + 
							"(	'	Parmak oyunları  tekerlemeler bilmeceler	'	,	1000000144	,	164	)	,	\n" + 
							"(	'	Sahne çocuk oyunları (1)	'	,	1000000145	,	165	)	,	\n" + 
							"(	'	Çocuklar için tiyatro oyunları	'	,	1000000146	,	166	)	,	\n" + 
							"(	'	Travmatik aşklar tramvayı	'	,	1000000147	,	167	)	,	\n" + 
							"(	'	Türk halk oyunları	'	,	1000000148	,	168	)	,	\n" + 
							"(	'	Yaşama hakkı  çocuklar için tiyatro oyunları	'	,	1000000149	,	169	)	,	\n" + 
							"(	'	Geçmiş zaman olur ki...  yaşantımızda dün ve bugün	'	,	1000000150	,	170	)	,	\n" + 
							"(	'	Yaşantımızda tiryakilik	'	,	1000000151	,	171	)	,	\n" + 
							"(	'	Yıldız pınarı  çocuklar için tiyatro oyunları	'	,	1000000152	,	172	)	,	\n" + 
							"(	'	Çocuk edebiyatı	'	,	1000000153	,	173	)	,	\n" + 
							"(	'	Çocuk oyunları	'	,	1000000154	,	174	)	,	\n" + 
							"(	'	Çocuk oyunları (2)	'	,	1000000155	,	175	)	,	\n" + 
							"(	'	Hiciv ve meyhane sohbetleri	'	,	1000000156	,	176	)	,	\n" + 
							"(	'	Hukuk içi - hukuk dışı öyküler	'	,	1000000157	,	177	)	,	\n" + 
							"(	'	Kırmızı melek	'	,	1000000158	,	178	)	,	\n" + 
							"(	'	Kralın doğum günü	'	,	1000000159	,	179	)	,	\n" + 
							"(	'	Örneklerle kuklalar ve kukla oyunları	'	,	1000000160	,	180	)	,	\n" + 
							"(	'	Monologlar ve çocuk oyunları	'	,	1000000161	,	181	)	,	\n" + 
							"(	'	Batılılaşma ve Türk edebiyatı 	'	,	1000000162	,	182	)	,	\n" + 
							"(	'	Yahya Kemal Beyatlı  şiire adanmış bir yaşam	'	,	1000000163	,	183	)	,	\n" + 
							"(	'	Selma	'	,	1000000164	,	184	)	,	\n" + 
							"(	'	Kır Çiçekleri  (seçmeler)	'	,	1000000165	,	185	)	,	\n" + 
							"(	'	Sitem	'	,	1000000166	,	186	)	,	\n" + 
							"(	'	Taşlamalar	'	,	1000000167	,	187	)	,	\n" + 
							"(	'	Edirne manileri	'	,	1000000168	,	188	)	,	\n" + 
							"(	'	Kitap, kütüphane ve okuma ile ilgili öyküler	'	,	1000000169	,	189	)	,	\n" + 
							"(	'	Meriç rüzgârının gizemi	'	,	1000000170	,	190	)	,	\n" + 
							"(	'	Osmanlı Türkçesi 1	'	,	1000000171	,	191	)	,	\n" + 
							"(	'	Türk tiyatrosunda Kurtuluş savaşı	'	,	1000000172	,	192	)	,	\n" + 
							"(	'	Maraşta divanından parça kalmış halk şairleri	'	,	1000000173	,	193	)	,	\n" + 
							"(	'	Mahalli kelimeler sözlüğü	'	,	1000000174	,	194	)	,	\n" + 
							"(	'	Berceste yazıları	'	,	1000000175	,	195	)	,	\n" + 
							"(	'	Şehir mektupları	'	,	1000000176	,	196	)	,	\n" + 
							"(	'	Aşık tarzı edebiyat geleneği ve İstanbul	'	,	1000000177	,	197	)	,	\n" + 
							"(	'	Bir gül bu karanlıklarda Tanpınar üzerine yazılar	'	,	1000000178	,	198	)	,	\n" + 
							"(	'	Dar vakitlerde geniş zamanlar  Behçet Necatigilin şiiri	'	,	1000000179	,	199	)	,	\n" + 
							"(	'	Dilbilim el kitabı  temel kavramlar ve konular	'	,	1000000180	,	200	)	,	\n" + 
							"(	'	Edebiyat coğrafyasında Akdeniz	'	,	1000000181	,	201	)	,	\n" + 
							"(	'	Kader hep erken zaman hep geç  Cahit Zarifoğlu’nun şiirleri	'	,	1000000182	,	202	)	,	\n" + 
							"(	'	Karabibik	'	,	1000000183	,	203	)	,	\n" + 
							"(	'	Klasik edebiyat bilgisi  belagat	'	,	1000000184	,	204	)	,	\n" + 
							"(	'	Klasik edebiyat bilgisi  biçim - ölçü - kafiye	'	,	1000000185	,	205	)	,	\n" + 
							"(	'	Safahattan seçmeler	'	,	1000000186	,	206	)	,	\n" + 
							"(	'	Mevlananın dayanılmaz davetine katılmak 	'	,	1000000187	,	207	)	,	\n" + 
							"(	'	Müstecabizade İsmetin hayatı ve eserleri üzerine bir inceleme	'	,	1000000188	,	208	)	,	\n" + 
							"(	'	Osmanlının gezginleri	'	,	1000000189	,	209	)	,	\n" + 
							"(	'	Sebk-i Hindi ve Türk edebiyatında Hint tarzı	'	,	1000000190	,	210	)	,	\n" + 
							"(	'	Türk basınında Tevfik Fikret 1924-1940	'	,	1000000191	,	211	)	,	\n" + 
							"(	'	Türk edebiyatı tarihinde milli edebiyat dönemi (1911-1923)	'	,	1000000192	,	212	)	,	\n" + 
							"(	'	Türkiye Türkçesi söz dizimi	'	,	1000000193	,	213	)	,	\n" + 
							"(	'	Yahya Kemalin eserleri üzerinde bir üslup araştırması	'	,	1000000194	,	214	)	,	\n" + 
							"(	'	Seçme hikayeler ve Yalnız Efe	'	,	1000000195	,	215	)	,	\n" + 
							"(	'	Yazılı ve sözlü anlatım  kompozisyon bilgileri	'	,	1000000196	,	216	)	,	\n" + 
							"(	'	İnsan iletişim ve dil	'	,	1000000197	,	217	)	,	\n" + 
							"(	'	Bodrum sana benzer  sevdaya şiirler	'	,	1000000198	,	218	)	,	\n" + 
							"(	'	Bodruma veda	'	,	1000000199	,	219	)	,	\n" + 
							"(	'	Dilim lal yüreğim konuşur	'	,	1000000200	,	220	)	,	\n" + 
							"(	'	Garip hallerimiz	'	,	1000000201	,	221	)	,	\n" + 
							"(	'	İz bırakanlar  romanlaşan hayatlar	'	,	1000000202	,	222	)	,	\n" + 
							"(	'	başı sonu olmayan hikayeler	'	,	1000000203	,	223	)	,	\n" + 
							"(	'	Şöhretli eşek arıları	'	,	1000000204	,	224	)	,	\n" + 
							"(	'	Adalet menzili	'	,	1000000205	,	225	)	,	\n" + 
							"(	'	Kültürlerde Şahmeran  kıyıda	'	,	1000000206	,	226	)	,	\n" + 
							"(	'	Ötgen künler  geçmiş günler	'	,	1000000207	,	227	)	,	\n" + 
							"(	'	Son denize kadar	'	,	1000000208	,	228	)	,	\n" + 
							"(	'	Son Timurlu 1	'	,	1000000209	,	229	)	,	\n" + 
							"(	'	Son Timurlu 2	'	,	1000000210	,	230	)	,	\n" + 
							"(	'	Uluğbeyin hazinesi	'	,	1000000211	,	231	)	,	\n" + 
							"(	'	Binbir gece masalları'	,	1000000212	,	232	)	,	\n" + 
							"(	'	Bir başkadır bizim eller  hatıralar, gözlemler	'	,	1000000213	,	233	)	,	\n" + 
							"(	'	Bozgun zamanı	'	,	1000000214	,	234	)	,	\n" + 
							"(	'	Bozgundan sonra	'	,	1000000215	,	235	)	,	\n" + 
							"(	'	Harem (Osmanlı Türkçesi aslı ile birlikte)	'	,	1000000216	,	236	)	,	\n" + 
							"(	'	İçimizdeki inci taneciği	'	,	1000000217	,	237	)	,	\n" + 
							"(	'	Karacaoğlan  koşmalar	'	,	1000000218	,	238	)	,	\n" + 
							"(	'	Rumeli acısı	'	,	1000000219	,	239	)	,	\n" + 
							"(	'	Rübab-ı şikeste	'	,	1000000220	,	240	)	,	\n" + 
							"(	'	Seley Çakkan fıkraları	'	,	1000000221	,	241	)	,	\n" + 
							"(	'	Siyah inciler	'	,	1000000222	,	242	)	,	\n" + 
							"(	'	Son gece	'	,	1000000223	,	243	)	,	\n" + 
							"(	'	Şermin (Osmanlı Türkçesi aslı ile birlikte)	'	,	1000000224	,	244	)	,	\n" + 
							"(	'	Gülzar-ı manevi  giriş - inceleme	'	,	1000000225	,	245	)	,	\n" + 
							"(	'	Yalnız efe	'	,	1000000226	,	246	)	,	\n" + 
							"(	'	Anne beyaz çoraplarım nerde  	'	,	1000000227	,	247	)	,	\n" + 
							"(	'	Bu gözler neler gördü?	'	,	1000000228	,	248	)	,	\n" + 
							"(	'	Enver Paşanın son günleri	'	,	1000000229	,	249	)	,	\n" + 
							"(	'	Yarım asır evvel bizi idare edenler	'	,	1000000230	,	250	)	,	\n" + 
							"(	'	Bize göre  bir seyahatin notları	'	,	1000000231	,	251	)	,	\n" + 
							"(	'	Çağlayanlar	'	,	1000000232	,	252	)	,	\n" + 
							"(	'	Falaka	'	,	1000000233	,	253	)	,	\n" + 
							"(	'	Frankfurt seyahatnamesi	'	,	1000000234	,	254	)	,	\n" + 
							"(	'	Göl saatleri	'	,	1000000235	,	255	)	,	\n" + 
							"(	'	Gurebahane-i Laklakan	'	,	1000000236	,	256	)	,	\n" + 
							"(	'	Halukun defteri	'	,	1000000237	,	257	)	,	\n" + 
							"(	'	Piyale	'	,	1000000238	,	258	)	,	\n" + 
							"(	'	Seçilmiş hikayeler	'	,	1000000239	,	259	)	,	\n" + 
							"(	'	Şairlerin en garibi öldü	'	,	1000000240	,	260	)	,	\n" + 
							"(	'	Edebiyatımızda hüzün	'	,	1000000241	,	261	)	,	\n" + 
							"(	'	Cezmi  tarihe müstenit bir hikaye	'	,	1000000242	,	262	)	,	\n" + 
							"(	'	Çocukluğum	'	,	1000000243	,	263	)	,	\n" + 
							"(	'	Efendi ile uşak	'	,	1000000244	,	264	)	,	\n" + 
							"(	'	Felatun Bey ve Rakım Efendi	'	,	1000000245	,	265	)	,	\n" + 
							"(	'	Geliştiren öyküler	'	,	1000000246	,	266	)	,	\n" + 
							"(	'	Geliştiren sözler	'	,	1000000247	,	267	)	,	\n" + 
							"(	'	İki şehrin hikayesi	'	,	1000000248	,	268	)	,	\n" + 
							"(	'	İntibah	'	,	1000000249	,	269	)	,	\n" + 
							"(	'	Karabibik	'	,	1000000250	,	270	)	,	\n" + 
							"(	'	Raphael ( Rafael )  yirmi yaş sayfaları	'	,	1000000251	,	271	)	,	\n" + 
							"(	'	Sefiller	'	,	1000000252	,	272	)	,	\n" + 
							"(	'	Sergi Baba	'	,	1000000253	,	273	)	,	\n" + 
							"(	'	Suç ve ceza	'	,	1000000254	,	274	)	,	\n" + 
							"(	'	Taaşuk-ı Talat ve Fitnat	'	,	1000000255	,	275	)	,	\n" + 
							"(	'	Turfanda mı yoksa turfa mı	'	,	1000000256	,	276	)	,	\n" + 
							"(	'	Uğultulu tepeler	'	,	1000000257	,	277	)	,	\n" + 
							"(	'	Yeraltından notlar	'	,	1000000258	,	278	)	,	\n" + 
							"(	'	Ord. Prof. Dr. Ali Fuad Başgilden mektuplar	'	,	1000000259	,	279	)	,	\n" + 
							"(	'	Gençlerle başbaşa	'	,	1000000260	,	280	)	,	\n" + 
							"(	'	Yakın maziden hatıra kırıntıları	'	,	1000000261	,	281	)	,	\n" + 
							"(	'	Türkçe meselesi	'	,	1000000262	,	282	)	,	\n" + 
							"(	'	Kültür ve sanat dünyamızda Yahya Kemal Beyatlı I	'	,	1000000263	,	283	)	,	\n" + 
							"(	'	Kültür ve sanat dünyamızda Yahya Kemal Beyatlı II	'	,	1000000264	,	284	)	,	\n" + 
							"(	'	Hazreti Mevlana ve yakınları Sipehsalar risales	'	,	1000000265	,	285	)	,	\n" + 
							"(	'	Çanakkale Savaşı hikayeleri  Osmanlı dağılırken ağlayan hikayeler 3	'	,	1000000266	,	286	)	,	\n" + 
							"(	'	Kırk vezir hikayeleri	'	,	1000000267	,	287	)	,	\n" + 
							"(	'	Ademden önce	'	,	1000000268	,	288	)	,	\n" + 
							"(	'	Akdeniz	'	,	1000000269	,	289	)	,	\n" + 
							"(	'	Alın teri	'	,	1000000270	,	290	)	,	\n" + 
							"(	'	Amcamın rüyası	'	,	1000000271	,	291	)	,	\n" + 
							"(	'	Amerika	'	,	1000000272	,	292	)	,	\n" + 
							"(	'	Ana	'	,	1000000273	,	293	)	,	\n" + 
							"(	'	Anna Karenina I	'	,	1000000274	,	294	)	,	\n" + 
							"(	'	Anna Karenina II	'	,	1000000275	,	295	)	,	\n" + 
							"(	'	Ant	'	,	1000000276	,	296	)	,	\n" + 
							"(	'	Antikacı dükkanı	'	,	1000000277	,	297	)	,	\n" + 
							"(	'	Arkadaş	'	,	1000000278	,	298	)	,	\n" + 
							"(	'	Aşk ve gurur	'	,	1000000279	,	299	)	,	\n" + 
							"(	'	Ateş yakmak	'	,	1000000280	,	300	)	,	\n" + 
							"(	'	Ay vadisi	'	,	1000000281	,	301	)	,	\n" + 
							"(	'	Başkasının karısı	'	,	1000000282	,	302	)	,	\n" + 
							"(	'	Batıda yeni birşey yok	'	,	1000000283	,	303	)	,	\n" + 
							"(	'	Benim üniversitelerim	'	,	1000000284	,	304	)	,	\n" + 
							"(	'	Moby Dick (Beyaz Balina)	'	,	1000000285	,	305	)	,	\n" + 
							"(	'	Beyaz diş	'	,	1000000286	,	306	)	,	\n" + 
							"(	'	Beyaz geceler	'	,	1000000287	,	307	)	,	\n" + 
							"(	'	Bir aşk sayfası	'	,	1000000288	,	308	)	,	\n" + 
							"(	'	Bir delinin güncesi	'	,	1000000289	,	309	)	,	\n" + 
							"(	'	Bir kadının yirmi dört saati	'	,	1000000290	,	310	)	,	\n" + 
							"(	'	Bir Noel ezgisi	'	,	1000000291	,	311	)	,	\n" + 
							"(	'	Budala	'	,	1000000292	,	312	)	,	\n" + 
							"(	'	Büyük umutlar	'	,	1000000293	,	313	)	,	\n" + 
							"(	'	Can yoldaşı	'	,	1000000294	,	314	)	,	\n" + 
							"(	'	Carmen	'	,	1000000295	,	315	)	,	\n" + 
							"(	'	Çılgın kalabalıktan uzak	'	,	1000000296	,	316	)	,	\n" + 
							"(	'	Cimri	'	,	1000000297	,	317	)	,	\n" + 
							"(	'	Çirkin ördek yavrusu	'	,	1000000298	,	318	)	,	\n" + 
							"(	'	Çocuk kalbi	'	,	1000000299	,	319	)	,	\n" + 
							"(	'	Çocukluğum	'	,	1000000300	,	320	)	,	\n" + 
							"(	'	Çocukluk delikanlılık gençlik	'	,	1000000301	,	321	)	,	\n" + 
							"(	'	Dava	'	,	1000000302	,	322	)	,	\n" + 
							"(	'	David Copperfield	'	,	1000000303	,	323	)	,	\n" + 
							"(	'	Davulun sesi	'	,	1000000304	,	324	)	,	\n" + 
							"(	'	Dede ile torunu	'	,	1000000305	,	325	)	,	\n" + 
							"(	'	Değirmenimden mektuplar	'	,	1000000306	,	326	)	,	\n" + 
							"(	'	Dehşet ülkesi	'	,	1000000307	,	327	)	,	\n" + 
							"(	'	Delikanlı	'	,	1000000308	,	328	)	,	\n" + 
							"(	'	Denemeler	'	,	1000000309	,	329	)	,	\n" + 
							"(	'	Deniz kurdu	'	,	1000000310	,	330	)	,	\n" + 
							"(	'	Diriliş	'	,	1000000311	,	331	)	,	\n" + 
							"(	'	Doğu yakası	'	,	1000000312	,	332	)	,	\n" + 
							"(	'	Don Kişot	'	,	1000000313	,	333	)	,	\n" + 
							"(	'	Don Quijote	'	,	1000000314	,	334	)	,	\n" + 
							"(	'	Dönüşüm	'	,	1000000315	,	335	)	,	\n" + 
							"(	'	Dorian Grayin portresi	'	,	1000000316	,	336	)	,	\n" + 
							"(	'	Düello	'	,	1000000317	,	337	)	,	\n" + 
							"(	'	Duman	'	,	1000000318	,	338	)	,	\n" + 
							"(	'	Dünyayı sarsan on gün	'	,	1000000319	,	339	)	,	\n" + 
							"(	'	Düş ülkelerine yolculuk	'	,	1000000320	,	340	)	,	\n" + 
							"(	'	Ecinniler	'	,	1000000321	,	341	)	,	\n" + 
							"(	'	Ebedi koca	'	,	1000000322	,	342	)	,	\n" + 
							"(	'	Ekmeğimi kazanırken	'	,	1000000323	,	343	)	,	\n" + 
							"(	'	Ekmek işçileri	'	,	1000000324	,	344	)	,	\n" + 
							"(	'	Emek I	'	,	1000000325	,	345	)	,	\n" + 
							"(	'	Emek II	'	,	1000000326	,	346	)	,	\n" + 
							"(	'	En güçlü kim?	'	,	1000000327	,	347	)	,	\n" + 
							"(	'	Ezilenler	'	,	1000000328	,	348	)	,	\n" + 
							"(	'	Falaka	'	,	1000000329	,	349	)	,	\n" + 
							"(	'	Faust	'	,	1000000330	,	350	)	,	\n" + 
							"(	'	Genç Wertherin anıları	'	,	1000000331	,	351	)	,	\n" + 
							"(	'	Gerçeği arayış	'	,	1000000332	,	352	)	,	\n" + 
							"(	'	Germinal	'	,	1000000333	,	353	)	,	\n" + 
							"(	'	Goriot baba	'	,	1000000334	,	354	)	,	\n" + 
							"(	'	Gulliver cüceler ülkesinde	'	,	1000000335	,	355	)	,	\n" + 
							"(	'	Gulliver devler ülkesinde	'	,	1000000336	,	356	)	,	\n" + 
							"(	'	Güneş çocuğu	'	,	1000000337	,	357	)	,	\n" + 
							"(	'	Hacı Murat	'	,	1000000338	,	358	)	,	\n" + 
							"(	'	Hain kurt	'	,	1000000339	,	359	)	,	\n" + 
							"(	'	Halk avcısı	'	,	1000000340	,	360	)	,	\n" + 
							"(	'	İki gelinin anıları	'	,	1000000341	,	361	)	,	\n" + 
							"(	'	İki şehrin hikayesi	'	,	1000000342	,	362	)	,	\n" + 
							"(	'	İlahi komedya	'	,	1000000343	,	363	)	,	\n" + 
							"(	'	İnsan ne ile yaşar	'	,	1000000344	,	364	)	,	\n" + 
							"(	'	İnsancıklar	'	,	1000000345	,	365	)	,	\n" + 
							"(	'	İstiridye korsanları	'	,	1000000346	,	366	)	,	\n" + 
							"(	'	İvan İlyiçin ölümü	'	,	1000000347	,	367	)	,	\n" + 
							"(	'	İzlanda balıkçısı	'	,	1000000348	,	368	)	,	\n" + 
							"(	'	Jane Eyre	'	,	1000000349	,	369	)	,	\n" + 
							"(	'	John Barleycorn  bir alkoliğin anıları	'	,	1000000350	,	370	)	,	\n" + 
							"(	'	Karagöz Hacivat	'	,	1000000351	,	371	)	,	\n" + 
							"(	'	Karamazov kardeşler I	'	,	1000000352	,	372	)	,	\n" + 
							"(	'	Karamazov kardeşler II	'	,	1000000353	,	373	)	,	\n" + 
							"(	'	Kazaklar	'	,	1000000354	,	374	)	,	\n" + 
							"(	'	Kelile ve Dimne	'	,	1000000355	,	375	)	,	\n" + 
							"(	'	Keloğlan	'	,	1000000356	,	376	)	,	\n" + 
							"(	'	Kibarlık budalası	'	,	1000000357	,	377	)	,	\n" + 
							"(	'	Kırmızı ve siyah	'	,	1000000358	,	378	)	,	\n" + 
							"(	'	Kodin	'	,	1000000359	,	379	)	,	\n" + 
							"(	'	Köy doktoru	'	,	1000000360	,	380	)	,	\n" + 
							"(	'	Köylüler	'	,	1000000361	,	381	)	,	\n" + 
							"(	'	Kreutzer sonatı	'	,	1000000362	,	382	)	,	\n" + 
							"(	'	Küçük adam ne oldu sana	'	,	1000000363	,	383	)	,	\n" + 
							"(	'	Kumarbaz	'	,	1000000364	,	384	)	,	\n" + 
							"(	'	Maça kızı	'	,	1000000365	,	385	)	,	\n" + 
							"(	'	Martin Eden	'	,	1000000366	,	386	)	,	\n" + 
							"(	'	Mustafa Mıstık	'	,	1000000367	,	387	)	,	\n" + 
							"(	'	Mutlu prens	'	,	1000000368	,	388	)	,	\n" + 
							"(	'	Nana	'	,	1000000369	,	389	)	,	\n" + 
							"(	'	Nasıl yapmalı? I	'	,	1000000370	,	390	)	,	\n" + 
							"(	'	Nasıl yapmalı? II	'	,	1000000371	,	391	)	,	\n" + 
							"(	'	Nasrettin Hoca	'	,	1000000372	,	392	)	,	\n" + 
							"(	'	Moskova önlerinde  Volokolamsk Şosesi savaşları	'	,	1000000373	,	393	)	,	\n" + 
							"(	'	Netoçka Nezvanova	'	,	1000000374	,	394	)	,	\n" + 
							"(	'	Notre Dameın kamburu	'	,	1000000375	,	395	)	,	\n" + 
							"(	'	Oblomov	'	,	1000000376	,	396	)	,	\n" + 
							"(	'	Oğullar ve sevgililer	'	,	1000000377	,	397	)	,	\n" + 
							"(	'	Oliver Twist	'	,	1000000378	,	398	)	,	\n" + 
							"(	'	Ölü canlar	'	,	1000000379	,	399	)	,	\n" + 
							"(	'	Özgürlük	'	,	1000000380	,	400	)	;		";
					
					String insertTables4="INSERT INTO `BRANCHES` (`branch_id`, `branch_name`, `district_id`) VALUES\n" + 
							"\n" + 
							"(1, 'AdanaAtasehir', 5),\n" + 
							"(2, 'AdıyamanAtasehir', 4),\n" + 
							"(3, 'AfyonkarahisarAtasehir', 2),\n" + 
							"(4, 'AğrıAtasehir',3),\n" + 
							"(5, 'AksarayAtasehir', 7),\n" + 
							"(6, 'AmasyaAtasehir',1),\n" + 
							"(7, 'AnkaraAtasehir', 7),\n" + 
							"(8, 'AntalyaAtasehir', 5),\n" + 
							"(9, 'ArdahanAtasehir', 3),\n" + 
							"(10, 'ArtvinAtasehir', 1),\n" + 
							"(11, 'AydınAtasehir', 2),\n" + 
							"(12, 'BalıkesirAtasehir', 6),\n" + 
							"(13, 'BartınAtasehir', 1),\n" + 
							"(14, 'BatmanAtasehir', 4),\n" + 
							"(15, 'BayburtAtasehir', 1),\n" + 
							"(16, 'BilecikAtasehir', 6),\n" + 
							"(17, 'BingölAtasehir', 3),\n" + 
							"(18, 'BitlisAtasehir', 3),\n" + 
							"(19, 'BoluAtasehir', 1),\n" + 
							"(20, 'DenizliAtasehir', 5),\n" + 
							"(21, 'BursaAtasehir', 6),\n" + 
							"(22, 'ÇanakkaleAtasehir', 6),\n" + 
							"(23, 'ÇankırıAtasehir', 7),\n" + 
							"(24, 'ÇorumAtasehir', 7),\n" + 
							"(25, 'BurdurAtasehir', 2),\n" + 
							"(26, 'DiyarbakırAtasehir', 4),\n" + 
							"(27, 'DüzceAtasehir', 1),\n" + 
							"(28, 'EdirneAtasehir', 6),\n" + 
							"(29, 'ElazığAtasehir', 3),\n" + 
							"(30, 'ErzincanAtasehir', 3),\n" + 
							"(31, 'ErzurumAtasehir', 3),\n" + 
							"(32, 'EskişehirAtasehir', 7),\n" + 
							"(33, 'GaziantepAtasehir', 4),\n" + 
							"(34, 'GiresunAtasehir', 1),\n" + 
							"(35, 'GümüşhaneAtasehir', 1),\n" + 
							"(36, 'HakkariAtasehir', 3),\n" + 
							"(37, 'HatayAtasehir', 5),\n" + 
							"(38, 'IğdırAtasehir', 3),\n" + 
							"(39, 'IspartaAtasehir', 5),\n" + 
							"(40, 'İstanbulAtasehir', 6),\n" + 
							"(41, 'İzmirAtasehir', 2),\n" + 
							"(42, 'KahramanmaraşAtasehir', 5),\n" + 
							"(43, 'KarabükAtasehir', 1),\n" + 
							"(44, 'KaramanAtasehir', 7),\n" + 
							"(45, 'KarsAtasehir', 3),\n" + 
							"(46, 'KastamonuAtasehir', 1),\n" + 
							"(47, 'KayseriAtasehir', 7),\n" + 
							"(48, 'KırıkkaleAtasehir', 7),\n" + 
							"(49, 'KırklareliAtasehir', 6),\n" + 
							"(50, 'KırşehirAtasehir', 7),\n" + 
							"(51, 'KilisAtasehir', 4),\n" + 
							"(52, 'KocaeliAtasehir', 6),\n" + 
							"(53, 'KonyaAtasehir', 7),\n" + 
							"(54, 'KütahyaAtasehir', 2),\n" + 
							"(55, 'MalatyaAtasehir', 3),\n" + 
							"(56, 'ManisaAtasehir', 2),\n" + 
							"(57, 'MardinAtasehir', 4),\n" + 
							"(58, 'MersinAtasehir', 5),\n" + 
							"(59, 'MuğlaAtasehir', 2),\n" + 
							"(60, 'MuşAtasehir', 3),\n" + 
							"(61, 'NevşehirAtasehir', 7),\n" + 
							"(62, 'NiğdeAtasehir', 7),\n" + 
							"(63, 'OrduAtasehir', 1),\n" + 
							"(64, 'OsmaniyeAtasehir', 5),\n" + 
							"(65, 'RizeAtasehir', 1),\n" + 
							"(66, 'SakaryaAtasehir', 6),\n" + 
							"(67, 'SamsunAtasehir', 1),\n" + 
							"(68, 'SiirtAtasehir', 4),\n" + 
							"(69, 'SinopAtasehir', 1),\n" + 
							"(70, 'SivasAtasehir', 7),\n" + 
							"(71, 'ŞanlıurfaAtasehir', 4),\n" + 
							"(72, 'ŞırnakAtasehir',3),\n" + 
							"(73, 'TekirdağAtasehir',6),\n" + 
							"(74, 'TokatAtasehir', 1),\n" + 
							"(75, 'TrabzonAtasehir', 1),\n" + 
							"(76, 'TunceliAtasehir', 3),\n" + 
							"(77, 'UşakAtasehir', 2),\n" + 
							"(78, 'VanAtasehir', 3),\n" + 
							"(79, 'YalovaAtasehir', 6),\n" + 
							"(80, 'YozgatAtasehir', 7),\n" + 
							"(81, 'ZonguldakAtasehir', 2);\n" ;
					
					String insertTables5="INSERT INTO `BRANCHES` (`branch_id`, `branch_name`, `district_id`) VALUES\n" + 
							"\n" + 
							"(1, 'AdanaKadikoy', 5),\n" + 
							"(2, 'AdıyamanKadikoy', 4),\n" + 
							"(3, 'AfyonkarahisarKadikoy', 2),\n" + 
							"(4, 'AğrıKadikoy',3),\n" + 
							"(5, 'AksarayKadikoy', 7),\n" + 
							"(6, 'AmasyaKadikoy',1),\n" + 
							"(7, 'AnkaraKadikoy', 7),\n" + 
							"(8, 'AntalyaKadikoy', 5),\n" + 
							"(9, 'ArdahanKadikoy', 3),\n" + 
							"(10, 'ArtvinKadikoy', 1),\n" + 
							"(11, 'AydınKadikoy', 2),\n" + 
							"(12, 'BalıkesirKadikoy', 6),\n" + 
							"(13, 'BartınKadikoy', 1),\n" + 
							"(14, 'BatmanKadikoy', 4),\n" + 
							"(15, 'BayburtKadikoy', 1),\n" + 
							"(16, 'BilecikKadikoy', 6),\n" + 
							"(17, 'BingölKadikoy', 3),\n" + 
							"(18, 'BitlisKadikoy', 3),\n" + 
							"(19, 'BoluKadikoy', 1),\n" + 
							"(20, 'DenizliKadikoy', 5),\n" + 
							"(21, 'BursaKadikoy', 6),\n" + 
							"(22, 'ÇanakkaleKadikoy', 6),\n" + 
							"(23, 'ÇankırıKadikoy', 7),\n" + 
							"(24, 'ÇorumKadikoy', 7),\n" + 
							"(25, 'BurdurKadikoy', 2),\n" + 
							"(26, 'DiyarbakırKadikoy', 4),\n" + 
							"(27, 'DüzceKadikoy', 1),\n" + 
							"(28, 'EdirneKadikoy', 6),\n" + 
							"(29, 'ElazığKadikoy', 3),\n" + 
							"(30, 'ErzincanKadikoy', 3),\n" + 
							"(31, 'ErzurumKadikoy', 3),\n" + 
							"(32, 'EskişehirKadikoy', 7),\n" + 
							"(33, 'GaziantepKadikoy', 4),\n" + 
							"(34, 'GiresunKadikoy', 1),\n" + 
							"(35, 'GümüşhaneKadikoy', 1),\n" + 
							"(36, 'HakkariKadikoy', 3),\n" + 
							"(37, 'HatayKadikoy', 5),\n" + 
							"(38, 'IğdırKadikoy', 3),\n" + 
							"(39, 'IspartaKadikoy', 5),\n" + 
							"(40, 'İstanbulKadikoy', 6),\n" + 
							"(41, 'İzmirKadikoy', 2),\n" + 
							"(42, 'KahramanmaraşKadikoy', 5),\n" + 
							"(43, 'KarabükKadikoy', 1),\n" + 
							"(44, 'KaramanKadikoy', 7),\n" + 
							"(45, 'KarsKadikoy', 3),\n" + 
							"(46, 'KastamonuKadikoy', 1),\n" + 
							"(47, 'KayseriKadikoy', 7),\n" + 
							"(48, 'KırıkkaleKadikoy', 7),\n" + 
							"(49, 'KırklareliKadikoy', 6),\n" + 
							"(50, 'KırşehirKadikoy', 7),\n" + 
							"(51, 'KilisKadikoy', 4),\n" + 
							"(52, 'KocaeliKadikoy', 6),\n" + 
							"(53, 'KonyaKadikoy', 7),\n" + 
							"(54, 'KütahyaKadikoy', 2),\n" + 
							"(55, 'MalatyaKadikoy', 3),\n" + 
							"(56, 'ManisaKadikoy', 2),\n" + 
							"(57, 'MardinKadikoy', 4),\n" + 
							"(58, 'MersinKadikoy', 5),\n" + 
							"(59, 'MuğlaKadikoy', 2),\n" + 
							"(60, 'MuşKadikoy', 3),\n" + 
							"(61, 'NevşehirKadikoy', 7),\n" + 
							"(62, 'NiğdeKadikoy', 7),\n" + 
							"(63, 'OrduKadikoy', 1),\n" + 
							"(64, 'OsmaniyeKadikoy', 5),\n" + 
							"(65, 'RizeKadikoy', 1),\n" + 
							"(66, 'SakaryaKadikoy', 6),\n" + 
							"(67, 'SamsunKadikoy', 1),\n" + 
							"(68, 'SiirtKadikoy', 4),\n" + 
							"(69, 'SinopKadikoy', 1),\n" + 
							"(70, 'SivasKadikoy', 7),\n" + 
							"(71, 'ŞanlıurfaKadikoy', 4),\n" + 
							"(72, 'ŞırnakKadikoy',3),\n" + 
							"(73, 'TekirdağKadikoy',6),\n" + 
							"(74, 'TokatKadikoy', 1),\n" + 
							"(75, 'TrabzonKadikoy', 1),\n" + 
							"(76, 'TunceliKadikoy', 3),\n" + 
							"(77, 'UşakKadikoy', 2),\n" + 
							"(78, 'VanKadikoy', 3),\n" + 
							"(79, 'YalovaKadikoy', 6),\n" + 
							"(80, 'YozgatKadikoy', 7),\n" + 
							"(81, 'ZonguldakKadikoy', 2);\n" ;
					
					String insertTables6="INSERT INTO `BRANCHES` (`branch_id`, `branch_name`, `district_id`) VALUES\n" + 
							"\n" + 
							"(1, 'AdanaKayisdagi', 5),\n" + 
							"(2, 'AdıyamanKayisdagi', 4),\n" + 
							"(3, 'AfyonkarahisarKayisdagi', 2),\n" + 
							"(4, 'AğrıKayisdagi',3),\n" + 
							"(5, 'AksarayKayisdagi', 7),\n" + 
							"(6, 'AmasyaKayisdagi',1),\n" + 
							"(7, 'AnkaraKayisdagi', 7),\n" + 
							"(8, 'AntalyaKayisdagi', 5),\n" + 
							"(9, 'ArdahanKayisdagi', 3),\n" + 
							"(10, 'ArtvinKayisdagi', 1),\n" + 
							"(11, 'AydınKayisdagi', 2),\n" + 
							"(12, 'BalıkesirKayisdagi', 6),\n" + 
							"(13, 'BartınKayisdagi', 1),\n" + 
							"(14, 'BatmanKayisdagi', 4),\n" + 
							"(15, 'BayburtKayisdagi', 1),\n" + 
							"(16, 'BilecikKayisdagi', 6),\n" + 
							"(17, 'BingölKayisdagi', 3),\n" + 
							"(18, 'BitlisKayisdagi', 3),\n" + 
							"(19, 'BoluKayisdagi', 1),\n" + 
							"(20, 'DenizliKayisdagi', 5),\n" + 
							"(21, 'BursaKayisdagi', 6),\n" + 
							"(22, 'ÇanakkaleKayisdagi', 6),\n" + 
							"(23, 'ÇankırıKayisdagi', 7),\n" + 
							"(24, 'ÇorumKayisdagi', 7),\n" + 
							"(25, 'BurdurKayisdagi', 2),\n" + 
							"(26, 'DiyarbakırKayisdagi', 4),\n" + 
							"(27, 'DüzceKayisdagi', 1),\n" + 
							"(28, 'EdirneKayisdagi', 6),\n" + 
							"(29, 'ElazığKayisdagi', 3),\n" + 
							"(30, 'ErzincanKayisdagi', 3),\n" + 
							"(31, 'ErzurumKayisdagi', 3),\n" + 
							"(32, 'EskişehirKayisdagi', 7),\n" + 
							"(33, 'GaziantepKayisdagi', 4),\n" + 
							"(34, 'GiresunKayisdagi', 1),\n" + 
							"(35, 'GümüşhaneKayisdagi', 1),\n" + 
							"(36, 'HakkariKayisdagi', 3),\n" + 
							"(37, 'HatayKayisdagi', 5),\n" + 
							"(38, 'IğdırKayisdagi', 3),\n" + 
							"(39, 'IspartaKayisdagi', 5),\n" + 
							"(40, 'İstanbulKayisdagi', 6),\n" + 
							"(41, 'İzmirKayisdagi', 2),\n" + 
							"(42, 'KahramanmaraşKayisdagi', 5),\n" + 
							"(43, 'KarabükKayisdagi', 1),\n" + 
							"(44, 'KaramanKayisdagi', 7),\n" + 
							"(45, 'KarsKayisdagi', 3),\n" + 
							"(46, 'KastamonuKayisdagi', 1),\n" + 
							"(47, 'KayseriKayisdagi', 7),\n" + 
							"(48, 'KırıkkaleKayisdagi', 7),\n" + 
							"(49, 'KırklareliKayisdagi', 6),\n" + 
							"(50, 'KırşehirKayisdagi', 7),\n" + 
							"(51, 'KilisKayisdagi', 4),\n" + 
							"(52, 'KocaeliKayisdagi', 6),\n" + 
							"(53, 'KonyaKayisdagi', 7),\n" + 
							"(54, 'KütahyaKayisdagi', 2),\n" + 
							"(55, 'MalatyaKayisdagi', 3),\n" + 
							"(56, 'ManisaKayisdagi', 2),\n" + 
							"(57, 'MardinKayisdagi', 4),\n" + 
							"(58, 'MersinKayisdagi', 5),\n" + 
							"(59, 'MuğlaKayisdagi', 2),\n" + 
							"(60, 'MuşKayisdagi', 3),\n" + 
							"(61, 'NevşehirKayisdagi', 7),\n" + 
							"(62, 'NiğdeKayisdagi', 7),\n" + 
							"(63, 'OrduKayisdagi', 1),\n" + 
							"(64, 'OsmaniyeKayisdagi', 5),\n" + 
							"(65, 'RizeKayisdagi', 1),\n" + 
							"(66, 'SakaryaKayisdagi', 6),\n" + 
							"(67, 'SamsunKayisdagi', 1),\n" + 
							"(68, 'SiirtKayisdagi', 4),\n" + 
							"(69, 'SinopKayisdagi', 1),\n" + 
							"(70, 'SivasKayisdagi', 7),\n" + 
							"(71, 'ŞanlıurfaKayisdagi', 4),\n" + 
							"(72, 'ŞırnakKayisdagi',3),\n" + 
							"(73, 'TekirdağKayisdagi',6),\n" + 
							"(74, 'TokatKayisdagi', 1),\n" + 
							"(75, 'TrabzonKayisdagi', 1),\n" + 
							"(76, 'TunceliKayisdagi', 3),\n" + 
							"(77, 'UşakKayisdagi', 2),\n" + 
							"(78, 'VanKayisdagi', 3),\n" + 
							"(79, 'YalovaKayisdagi', 6),\n" + 
							"(80, 'YozgatKayisdagi', 7),\n" + 
							"(81, 'ZonguldakKayisdagi', 2);\n" ;
					
					String insertTables7="INSERT INTO `BRANCHES` (`branch_id`, `branch_name`, `district_id`) VALUES\n" + 
							"(1, 'AdanaUmraniye', 5),\n" + 
							"(2, 'AdıyamanUmraniye', 4),\n" + 
							"(3, 'AfyonkarahisarUmraniye', 2),\n" + 
							"(4, 'AğrıUmraniye',3),\n" + 
							"(5, 'AksarayUmraniye', 7),\n" + 
							"(6, 'AmasyaUmraniye',1),\n" + 
							"(7, 'AnkaraUmraniye', 7),\n" + 
							"(8, 'AntalyaUmraniye', 5),\n" + 
							"(9, 'ArdahanUmraniye', 3),\n" + 
							"(10, 'ArtvinUmraniye', 1),\n" + 
							"(11, 'AydınUmraniye', 2),\n" + 
							"(12, 'BalıkesirUmraniye', 6),\n" + 
							"(13, 'BartınUmraniye', 1),\n" + 
							"(14, 'BatmanUmraniye', 4),\n" + 
							"(15, 'BayburtUmraniye', 1),\n" + 
							"(16, 'BilecikUmraniye', 6),\n" + 
							"(17, 'BingölUmraniye', 3),\n" + 
							"(18, 'BitlisUmraniye', 3),\n" + 
							"(19, 'BoluUmraniye', 1),\n" + 
							"(20, 'DenizliUmraniye', 5),\n" + 
							"(21, 'BursaUmraniye', 6),\n" + 
							"(22, 'ÇanakkaleUmraniye', 6),\n" + 
							"(23, 'ÇankırıUmraniye', 7),\n" + 
							"(24, 'ÇorumUmraniye', 7),\n" + 
							"(25, 'BurdurUmraniye', 2),\n" + 
							"(26, 'DiyarbakırUmraniye', 4),\n" + 
							"(27, 'DüzceUmraniye', 1),\n" + 
							"(28, 'EdirneUmraniye', 6),\n" + 
							"(29, 'ElazığUmraniye', 3),\n" + 
							"(30, 'ErzincanUmraniye', 3),\n" + 
							"(31, 'ErzurumUmraniye', 3),\n" + 
							"(32, 'EskişehirUmraniye', 7),\n" + 
							"(33, 'GaziantepUmraniye', 4),\n" + 
							"(34, 'GiresunUmraniye', 1),\n" + 
							"(35, 'GümüşhaneUmraniye', 1),\n" + 
							"(36, 'HakkariUmraniye', 3),\n" + 
							"(37, 'HatayUmraniye', 5),\n" + 
							"(38, 'IğdırUmraniye', 3),\n" + 
							"(39, 'IspartaUmraniye', 5),\n" + 
							"(40, 'İstanbulUmraniye', 6),\n" + 
							"(41, 'İzmirUmraniye', 2),\n" + 
							"(42, 'KahramanmaraşUmraniye', 5),\n" + 
							"(43, 'KarabükUmraniye', 1),\n" + 
							"(44, 'KaramanUmraniye', 7),\n" + 
							"(45, 'KarsUmraniye', 3),\n" + 
							"(46, 'KastamonuUmraniye', 1),\n" + 
							"(47, 'KayseriUmraniye', 7),\n" + 
							"(48, 'KırıkkaleUmraniye', 7),\n" + 
							"(49, 'KırklareliUmraniye', 6),\n" + 
							"(50, 'KırşehirUmraniye', 7),\n" + 
							"(51, 'KilisUmraniye', 4),\n" + 
							"(52, 'KocaeliUmraniye', 6),\n" + 
							"(53, 'KonyaUmraniye', 7),\n" + 
							"(54, 'KütahyaUmraniye', 2),\n" + 
							"(55, 'MalatyaUmraniye', 3),\n" + 
							"(56, 'ManisaUmraniye', 2),\n" + 
							"(57, 'MardinUmraniye', 4),\n" + 
							"(58, 'MersinUmraniye', 5),\n" + 
							"(59, 'MuğlaUmraniye', 2),\n" + 
							"(60, 'MuşUmraniye', 3),\n" + 
							"(61, 'NevşehirUmraniye', 7),\n" + 
							"(62, 'NiğdeUmraniye', 7),\n" + 
							"(63, 'OrduUmraniye', 1),\n" + 
							"(64, 'OsmaniyeUmraniye', 5),\n" + 
							"(65, 'RizeUmraniye', 1),\n" + 
							"(66, 'SakaryaUmraniye', 6),\n" + 
							"(67, 'SamsunUmraniye', 1),\n" + 
							"(68, 'SiirtUmraniye', 4),\n" + 
							"(69, 'SinopUmraniye', 1),\n" + 
							"(70, 'SivasUmraniye', 7),\n" + 
							"(71, 'ŞanlıurfaUmraniye', 4),\n" + 
							"(72, 'ŞırnakUmraniye',3),\n" + 
							"(73, 'TekirdağUmraniye',6),\n" + 
							"(74, 'TokatUmraniye', 1),\n" + 
							"(75, 'TrabzonUmraniye', 1),\n" + 
							"(76, 'TunceliUmraniye', 3),\n" + 
							"(77, 'UşakUmraniye', 2),\n" + 
							"(78, 'VanUmraniye', 3),\n" + 
							"(79, 'YalovaUmraniye', 6),\n" + 
							"(80, 'YozgatUmraniye', 7),\n" + 
							"(81, 'ZonguldakUmraniye', 2);\n";
					
					String insertTables8="INSERT INTO `BRANCHES` (`branch_id`, `branch_name`, `district_id`) VALUES\n" + 
							"(1, 'AdanaModa', 5),\n" + 
							"(2, 'AdıyamanModa', 4),\n" + 
							"(3, 'AfyonkarahisarModa', 2),\n" + 
							"(4, 'AğrıModa',3),\n" + 
							"(5, 'AksarayModa', 7),\n" + 
							"(6, 'AmasyaModa',1),\n" + 
							"(7, 'AnkaraModa', 7),\n" + 
							"(8, 'AntalyaModa', 5),\n" + 
							"(9, 'ArdahanModa', 3),\n" + 
							"(10, 'ArtvinModa', 1),\n" + 
							"(11, 'AydınModa', 2),\n" + 
							"(12, 'BalıkesirModa', 6),\n" + 
							"(13, 'BartınModa', 1),\n" + 
							"(14, 'BatmanModa', 4),\n" + 
							"(15, 'BayburtModa', 1),\n" + 
							"(16, 'BilecikModa', 6),\n" + 
							"(17, 'BingölModa', 3),\n" + 
							"(18, 'BitlisModa', 3),\n" + 
							"(19, 'BoluModa', 1),\n" + 
							"(20, 'DenizliModa', 5),\n" + 
							"(21, 'BursaModa', 6),\n" + 
							"(22, 'ÇanakkaleModa', 6),\n" + 
							"(23, 'ÇankırıModa', 7),\n" + 
							"(24, 'ÇorumModa', 7),\n" + 
							"(25, 'BurdurModa', 2),\n" + 
							"(26, 'DiyarbakırModa', 4),\n" + 
							"(27, 'DüzceModa', 1),\n" + 
							"(28, 'EdirneModa', 6),\n" + 
							"(29, 'ElazığModa', 3),\n" + 
							"(30, 'ErzincanModa', 3),\n" + 
							"(31, 'ErzurumModa', 3),\n" + 
							"(32, 'EskişehirModa', 7),\n" + 
							"(33, 'GaziantepModa', 4),\n" + 
							"(34, 'GiresunModa', 1),\n" + 
							"(35, 'GümüşhaneModa', 1),\n" + 
							"(36, 'HakkariModa', 3),\n" + 
							"(37, 'HatayModa', 5),\n" + 
							"(38, 'IğdırModa', 3),\n" + 
							"(39, 'IspartaModa', 5),\n" + 
							"(40, 'İstanbulModa', 6),\n" + 
							"(41, 'İzmirModa', 2),\n" + 
							"(42, 'KahramanmaraşModa', 5),\n" + 
							"(43, 'KarabükModa', 1),\n" + 
							"(44, 'KaramanModa', 7),\n" + 
							"(45, 'KarsModa', 3),\n" + 
							"(46, 'KastamonuModa', 1),\n" + 
							"(47, 'KayseriModa', 7),\n" + 
							"(48, 'KırıkkaleModa', 7),\n" + 
							"(49, 'KırklareliModa', 6),\n" + 
							"(50, 'KırşehirModa', 7),\n" + 
							"(51, 'KilisModa', 4),\n" + 
							"(52, 'KocaeliModa', 6),\n" + 
							"(53, 'KonyaModa', 7),\n" + 
							"(54, 'KütahyaModa', 2),\n" + 
							"(55, 'MalatyaModa', 3),\n" + 
							"(56, 'ManisaModa', 2),\n" + 
							"(57, 'MardinModa', 4),\n" + 
							"(58, 'MersinModa', 5),\n" + 
							"(59, 'MuğlaModa', 2),\n" + 
							"(60, 'MuşModa', 3),\n" + 
							"(61, 'NevşehirModa', 7),\n" + 
							"(62, 'NiğdeModa', 7),\n" + 
							"(63, 'OrduModa', 1),\n" + 
							"(64, 'OsmaniyeModa', 5),\n" + 
							"(65, 'RizeModa', 1),\n" + 
							"(66, 'SakaryaModa', 6),\n" + 
							"(67, 'SamsunModa', 1),\n" + 
							"(68, 'SiirtModa', 4),\n" + 
							"(69, 'SinopModa', 1),\n" + 
							"(70, 'SivasModa', 7),\n" + 
							"(71, 'ŞanlıurfaModa', 4),\n" + 
							"(72, 'ŞırnakModa',3),\n" + 
							"(73, 'TekirdağModa',6),\n" + 
							"(74, 'TokatModa', 1),\n" + 
							"(75, 'TrabzonModa', 1),\n" + 
							"(76, 'TunceliModa', 3),\n" + 
							"(77, 'UşakModa', 2),\n" + 
							"(78, 'VanModa', 3),\n" + 
							"(79, 'YalovaModa', 6),\n" + 
							"(80, 'YozgatModa', 7),\n" + 
							"(81, 'ZonguldakModa', 2);\n" ;
					
					String insertTables9="INSERT INTO `CUSTOMER_INFO` (`customer_no`, `customer_name`, `customer_surname`, `country_id`, `branch_name`) VALUES\n" + 
							"(	1	,	 'TUGBA'	,	'CEVAHIR'	,	1	,	 'AdanaAtasehir'	)	,\n" + 
							"(	2	,	 'Ridvan'	,	 'Sancakli'	,	2	,	 'AdıyamanAtasehir'	)	,\n" + 
							"(	3	,	 'Eke'	,	 'Sunter'	,	3	,	 'AfyonkarahisarAtasehir'	)	,\n" + 
							"(	4	,	 'Koray'	,	 'Sofuoglu'	,	4	,	 'AğrıAtasehir'	)	,\n" + 
							"(	5	,	 'Demirel'	,	 'Saglik'	,	5	,	 'AksarayAtasehir'	)	,\n" + 
							"(	6	,	 'Ozakan'	,	 'Turkan'	,	6	,	 'AmasyaAtasehir'	)	,\n" + 
							"(	7	,	 'MEHMET HİLMİ'	,	 'SÖZEN'	,	7	,	 'AnkaraAtasehir'	)	,\n" + 
							"(	8	,	 'Erdal'	,	 'Emre'	,	8	,	 'AntalyaAtasehir'	)	,\n" + 
							"(	9	,	 'ALİ Dincay'	,	 'ÇAKMAK'	,	9	,	 'ArdahanAtasehir'	)	,\n" + 
							"(	10	,	 'Tug'	,	 'ÖZBEK'	,	10	,	 'ArtvinAtasehir'	)	,\n" + 
							"(	11	,	 'Aka GÜLÇİN'	,	 'KUŞ'	,	11	,	 'AydınAtasehir'	)	,\n" + 
							"(	12	,	 'Latife'	,	 'ÇINKIT'	,	12	,	 'BalıkesirAtasehir'	)	,\n" + 
							"(	13	,	 'Ayyildiz'	,	 'BİLİCİ'	,	13	,	 'BartınAtasehir'	)	,\n" + 
							"(	14	,	 'Selin NUR'	,	 'EKİNCİ'	,	14	,	 'BatmanAtasehir'	)	,\n" + 
							"(	15	,	 'ZARİFE'	,	 'KARSLI'	,	15	,	 'BayburtAtasehir'	)	,\n" + 
							"(	16	,	 'ZELİHA'	,	 'OYNAK'	,	16	,	 'BilecikAtasehir'	)	,\n" + 
							"(	17	,	 'NURDAN'	,	 'Ozbek'	,	17	,	 'BingölAtasehir'	)	,\n" + 
							"(	18	,	 'Sayar'	,	 'DOĞAN'	,	18	,	 'BitlisAtasehir'	)	,\n" + 
							"(	19	,	 'Deger'	,	 'KARADAVUT'	,	19	,	 'BoluAtasehir'	)	,\n" + 
							"(	20	,	 'ABDULKADİR'	,	 'Gunduz'	,	20	,	 'DenizliAtasehir'	)	,\n" + 
							"(	21	,	 'Bereket'	,	 'BABA'	,	21	,	 'BursaAtasehir'	)	,\n" + 
							"(	22	,	 'YAVUZ'	,	 'Kut'	,	22	,	 'ÇanakkaleAtasehir'	)	,\n" + 
							"(	23	,	 'Ece'	,	 'GÜLŞAN'	,	23	,	 'ÇankırıAtasehir'	)	,\n" + 
							"(	24	,	 'MUSTAFA'	,	 'Sokullu'	,	24	,	 'ÇorumAtasehir'	)	,\n" + 
							"(	25	,	 'BAYRAM'	,	 'GÜRDAL'	,	25	,	 'BurdurAtasehir'	)	,\n" + 
							"(	26	,	 'Tankut'	,	 'AŞKIN'	,	26	,	 'DiyarbakırAtasehir'	)	,\n" + 
							"(	27	,	 'Umit'	,	 'KOCASARAÇ'	,	27	,	 'DüzceAtasehir'	)	,\n" + 
							"(	28	,	 'Sansal'	,	 'EVRAN'	,	28	,	 'EdirneAtasehir'	)	,\n" + 
							"(	29	,	 'SELMA'	,	 'Tuba'	,	29	,	 'ElazığAtasehir'	)	,\n" + 
							"(	30	,	 'BUĞRA'	,	 'Sarikaya'	,	30	,	 'ErzincanAtasehir'	)	,\n" + 
							"(	31	,	 'İKLİL'	,	 'AYHAN'	,	31	,	 'ErzurumAtasehir'	)	,\n" + 
							"(	32	,	 'Ozkut SERDAR'	,	 'TÜRE'	,	32	,	 'EskişehirAtasehir'	)	,\n" + 
							"(	33	,	 'LEMAN'	,	 'CERİT'	,	33	,	 'GaziantepAtasehir'	)	,\n" + 
							"(	34	,	 'SAADET Ergun'	,	 'DEMİR'	,	34	,	 'GiresunAtasehir'	)	,\n" + 
							"(	35	,	 'Kubat'	,	 'YAZAK'	,	35	,	 'GümüşhaneAtasehir'	)	,\n" + 
							"(	36	,	 'EMİNE'	,	 'ATEŞ'	,		36	,	 'HakkariAtasehir'	)	,\n" + 
							"(	37	,	 'HÜSEYİN'	,	 'ÖZTÜRK'	,	37	,	 'HatayAtasehir'	)	,\n" + 
							"(	38	,	 'TAYFUR'	,	 'HACI'	,		38	,	 'IğdırAtasehir'	)	,\n" + 
							"(	39	,	 'BENGÜ'	,	 'DURMUŞ'	,	39	,	 'IspartaAtasehir'	)	,\n" + 
							"(	40	,	 'HACI HASAN'	,	 'KARAKAYA'	,	40	,	 'İstanbulAtasehir'	)	,\n" + 
							"(	41	,	 'HÜSEYİN FATİH'	,	 'KİRİŞCİ'	,	41	,	 'İzmirAtasehir'	)	,\n" + 
							"(	42	,	 'ÜMİT'	,	 'KURTPINAR'	,	42	,	 'KahramanmaraşAtasehir'	)	,\n" + 
							"(	43	,	 'SONGÜL'	,	 'BENGÜ'	,	43	,	 'KarabükAtasehir'	)	,\n" + 
							"(	44	,	 'SEÇİL'	,	 'KIRBAŞ'	,	44	,	 'KaramanAtasehir'	)	,\n" + 
							"(	45	,	 'HASAN'	,	 'BAYTAN'	,	45	,	 'KarsAtasehir'	)	,\n" + 
							"(	46	,	 'ŞEHMUS'	,	 'SARI'	,	46	,	 'KastamonuAtasehir'	)	,\n" + 
							"(	47	,	 'REŞAT'	,	 'BAYTAN'	,	47	,	 'KayseriAtasehir'	)	,\n" + 
							"(	48	,	 'HASAN'	,	 'YAZAK'	,	48	,	 'KırıkkaleAtasehir'	)	,\n" + 
							"(	49	,	 'YUNUS'	,	 'AKSÖZ'	,	49	,	 'KırklareliAtasehir'	)	,\n" + 
							"(	50	,	 'BERÇEM'	,	 'CÖMERT'	,	50	,	 'KırşehirAtasehir'	)	,\n" + 
							"(	51	,	 'ÖMER GÖKHAN'	,	 'MUTLU'	,	51	,	 'KilisAtasehir'	)	,\n" + 
							"(	52	,	 'YASEMİN'	,	 'AVŞAR'	,	52	,	 'KocaeliAtasehir'	)	,\n" + 
							"(	53	,	 'EMRAH'	,	 'ASLAN'	,	53	,	 'KonyaAtasehir'	)	,\n" + 
							"(	54	,	 'CAN'	,	 'ÇİFT'	,	54	,	 'KütahyaAtasehir'	)	,\n" + 
							"(	55	,	 'YASEMİN'	,	 'ÜZEN'	,	55	,	 'MalatyaAtasehir'	)	,\n" + 
							"(	56	,	 'BELGİN'	,	 'ORHAN'	,	56	,	 'ManisaAtasehir'	)	,\n" + 
							"(	57	,	 'AVŞAR SELİN'	,	 'GÖKMEYDAN'	,	57	,	 'MardinAtasehir'	)	,\n" + 
							"(	58	,	 'MEHMET AKİF'	,	 'SARIGÜL'	,	58	,	 'MersinAtasehir'	)	,\n" + 
							"(	59	,	 'SARIGÜL'	,	 'ÖRDEK'	,	59	,	 'MuğlaAtasehir'	)	,\n" + 
							"(	60	,	 'AKKAYA KÜRŞAD'	,	 'KÖSEOĞLU'	,	60	,	 'MuşAtasehir'	)	,\n" + 
							"(	61	,	 'MEHMET NURİ'	,	 'AKKAYA'	,	61	,	 'NevşehirAtasehir'	)	,\n" + 
							"(	62	,	 'KÖSEOĞLU'	,	 'KAHYA'	,	62	,	 'NiğdeAtasehir'	)	,\n" + 
							"(	63	,	 'DUYGU'	,	 'KARAGÖZ'	,	63	,	 'OrduAtasehir'	)	,\n" + 
							"(	64	,	 'FATMA'	,	 'ÇAVLI'	,	64	,	 'OsmaniyeAtasehir'	)	,\n" + 
							"(	65	,	 'SELİM'	,	 'MALÇOK'	,	65	,	 'RizeAtasehir'	)	,\n" + 
							"(	66	,	 'ŞERMİN'	,	 'ATALAY'	,	66	,	 'SakaryaAtasehir'	)	,\n" + 
							"(	67	,	 'VOLKAN'	,	 'VURGAN'	,	67	,	 'SamsunAtasehir'	)	,\n" + 
							"(	68	,	 'SERPİL'	,	 'ÇAVLI'	,	68	,	 'SiirtAtasehir'	)	,\n" + 
							"(	69	,	 'GİZEM'	,	 'SOYTAŞ'	,	69	,	 'SinopAtasehir'	)	,\n" + 
							"(	70	,	 'ŞERMİN'	,	 'KIZANOĞLU'	,	70	,	 'SivasAtasehir'	)	,\n" + 
							"(	71	,	 'ELİFCAN'	,	 'ETLEÇ'	,	71	,	 'ŞanlıurfaAtasehir'	)	,\n" + 
							"(	72	,	 'ALİ SEÇKİN'	,	 'OLGAÇ'	,	72	,	 'ŞırnakAtasehir'	)	,\n" + 
							"(	73	,	 'ETLEÇ'	,	 'AKŞAHİN'	,	73	,	 'TekirdağAtasehir'	)	,\n" + 
							"(	74	,	 'ÖMER'	,	 'AKGÜL'	,	74	,	 'TokatAtasehir'	)	,\n" + 
							"(	75	,	 'HACI HASAN'	,	 'ÖZİŞ'	,	75	,	 'TrabzonAtasehir'	)	,\n" + 
							"(	76	,	 'EMİR MURAT'	,	 'TEL KANKILIÇ'	,	76	,	 'TunceliAtasehir'	)	,\n" + 
							"(	77	,	 'İLAY'	,	 'ÖZALP'	,	77	,	 'UşakAtasehir'	)	,\n" + 
							"(	78	,	 'FATIMA İLAY'	,	 'ULU'	,	78	,	 'VanAtasehir'	)	,\n" + 
							"(	79	,	 'MELTEM'	,	 'ÖZALP'	,	79	,	 'YalovaAtasehir'	)	,\n" + 
							"(	80	,	 'YAVUZ SELİM'	,	 'KARADUMAN'	,	80	,	 'YozgatAtasehir'	)	,\n" + 
							"(	81	,	 'ADNAN'	,	 'İNANÇ'	,	81	,	 'ZonguldakAtasehir'	)	,\n" + 
							"(	82	,	 'BAHRİ'	,	 'AYHAN'	,	1	,	 'AdanaAtasehir'	)	,\n" + 
							"(	83	,	 'NURULLAH'	,	 'SAVRAN'	,	2	,	 'AdıyamanAtasehir'	)	,\n" + 
							"(	84	,	 'NAGİHAN'	,	 'ŞAHİN'	,	3	,	 'AfyonkarahisarAtasehir'	)	,\n" + 
							"(	85	,	 'AYHAN'	,	 'GÖKTAŞ'	,	4	,	 'AğrıAtasehir'	)	,\n" + 
							"(	86	,	 'VELİ ENES'	,	 'BAKLACI'	,	5	,	 'AksarayAtasehir'	)	,\n" + 
							"(	87	,	 'AYCAN ÖZDEN'	,	 'BAĞCI'	,	6	,	 'AmasyaAtasehir'	)	,\n" + 
							"(	88	,	 'BAKLACI'	,	 'ALP'	,	7	,	 'AnkaraAtasehir'	)	,\n" + 
							"(	89	,	 'ERKAN'	,	 'SABAZ'	,	8	,	 'AntalyaAtasehir'	)	,\n" + 
							"(	90	,	 'ENNUR'	,	 'KURT'	,	9	,	 'ArdahanAtasehir'	)	,\n" + 
							"(	91	,	 'SEZGİN'	,	 'KURT'	,	10	,	 'ArtvinAtasehir'	)	,\n" + 
							"(	92	,	 'TUBA'	,	 'KURT'	,	11	,	 'AydınAtasehir'	)	,\n" + 
							"(	93	,	 'FEVZİ FIRAT'	,	 'TURAN'	,	12	,	 'BalıkesirAtasehir'	)	,\n" + 
							"(	94	,	 'MERİÇ'	,	 'HAKYOL'	,	13	,	 'BartınAtasehir'	)	,\n" + 
							"(	95	,	 'ŞEBNEM'	,	 'TURAN'	,	14	,	 'BatmanAtasehir'	)	,\n" + 
							"(	96	,	 'DENİZ'	,	 'TURAN'	,	15	,	 'BayburtAtasehir'	)	,\n" + 
							"(	97	,	 'BİLGİN'	,	 'ÇELEN'	,	16	,	 'BilecikAtasehir'	)	,\n" + 
							"(	98	,	 'EMİNE'	,	 'CANDAN'	,	17	,	 'BingölAtasehir'	)	,\n" + 
							"(	99	,	 'İZZETTİN'	,	 'ABAT'	,	18	,	 'BitlisAtasehir'	)	,\n" + 
							"(	100	,	 'MURAT'	,	 'KAYKI'	,	19	,	 'BoluAtasehir'	)	,\n" + 
							"(	101	,	 'PINAR'	,	 'TURAN'	,	20	,	 'DenizliAtasehir'	)	,\n" + 
							"(	102	,	 'MEHRİ'	,	 'ÖZATEŞ'	,	21	,	 'BursaAtasehir'	)	,\n" + 
							"(	103	,	 'İSMAİL'	,	 'KIZANOĞLU'	,	22	,	 'ÇanakkaleAtasehir'	)	,\n" + 
							"(	104	,	 'MUSTAFA'	,	 'CANDAN'	,	23	,	 'ÇankırıAtasehir'	)	,\n" + 
							"(	105	,	 'ARİF'	,	 'KIR'	,	24	,	 'ÇorumAtasehir'	)	,\n" + 
							"(	106	,	 'MURAT'	,	 'ÖZATEŞ'	,	25	,	 'BurdurAtasehir'	)	,\n" + 
							"(	107	,	 'ASLIHAN'	,	 'FAKIOĞLU'	,	26	,	 'DiyarbakırAtasehir'	)	,\n" + 
							"(	108	,	 'MUSTAFA'	,	 'ÜLGEN'	,	27	,	 'DüzceAtasehir'	)	,\n" + 
							"(	109	,	 'ÜLKÜ'	,	 'KÖKSAL'	,	28	,	 'EdirneAtasehir'	)	,\n" + 
							"(	110	,	 'İSMAİL YAVUZ'	,	 'TOŞUR'	,	29	,	 'ElazığAtasehir'	)	,\n" + 
							"(	111	,	 'CEM'	,	 'TOPKARA'	,	30	,	 'ErzincanAtasehir'	)	,\n" + 
							"(	112	,	 'ONUR KADİR'	,	 'ERGÜN'	,	31	,	 'ErzurumAtasehir'	)	,\n" + 
							"(	113	,	 'Berna'	,	 'ÜLGEN'	,	32	,	 'EskişehirAtasehir'	)	,\n" + 
							"(	114	,	 'MUHAMMED'	,	 'ÇAKMAK'	,	33	,	 'GaziantepAtasehir'	)	,\n" + 
							"(	115	,	 'FERHAT'	,	 'ÇAVLI'	,	34	,	 'GiresunAtasehir'	)	,\n" + 
							"(	116	,	 'ABDULSELAM'	,	 'AYDIN'	,	35	,	 'GümüşhaneAtasehir'	)	,\n" + 
							"(	117	,	 'Berna'	,	 'TOPAK'	,	36	,	 'HakkariAtasehir'	)	,\n" + 
							"(	118	,	 'HAMZA'	,	 'TUNCAY'	,	37	,	 'HatayAtasehir'	)	,\n" + 
							"(	119	,	 'ONUR'	,	 'DEMİRELLİ'	,	38	,	 'IğdırAtasehir'	)	,\n" + 
							"(	120	,	 'TESLİME NAZLI'	,	 'ALBAYRAK'	,	39	,	 'IspartaAtasehir'	)	,\n" + 
							"(	121	,	 'ERDEM'	,	 '1'	,	40	,	 'İstanbulAtasehir'	)	,\n" + 
							"(	122	,	 'Berna'	,	 'ÇATUK'	,	41	,	 'İzmirAtasehir'	)	,\n" + 
							"(	123	,	 'GÜLDEN'	,	 'SÖNMEZ'	,	42	,	 'KahramanmaraşAtasehir'	)	,\n" + 
							"(	124	,	 'Berna'	,	 'SERT'	,	43	,	 'KarabükAtasehir'	)	,\n" + 
							"(	125	,	 'ZAFER'	,	 'BİÇER'	,	44	,	 'KaramanAtasehir'	)	,\n" + 
							"(	126	,	 'ELİF TUĞÇE'	,	 'CANTÜRK'	,	45	,	 'KarsAtasehir'	)	,\n" + 
							"(	127	,	 'BÜŞRA'	,	 'AKSOY'	,	46	,	 'KastamonuAtasehir'	)	,\n" + 
							"(	128	,	 'Berna'	,	 'GÜNDÜZ'	,	47	,	 'KayseriAtasehir'	)	,\n" + 
							"(	129	,	 'İBRAHİM'	,	 'DEMİR'	,	48	,	 'KırıkkaleAtasehir'	)	,\n" + 
							"(	130	,	 'EDA'	,	 'TAŞAR'	,	49	,	 'KırklareliAtasehir'	)	,\n" + 
							"(	131	,	 'TUĞBA'	,	 'AKŞAHİN'	,	50	,	 'KırşehirAtasehir'	)	,\n" + 
							"(	132	,	 'ZEYNEP'	,	 'CILIZ BASHEER'	,	51	,	 'KilisAtasehir'	)	,\n" + 
							"(	133	,	 'HİLAL'	,	 'FAKIOĞLU'	,	52	,	 'KocaeliAtasehir'	)	,\n" + 
							"(	134	,	 'SERPİL'	,	 'AKAY'	,	53	,	 'KonyaAtasehir'	)	,\n" + 
							"(	135	,	 'AYTAÇ'	,	 'GÖKALP'	,	54	,	 'KütahyaAtasehir'	)	,\n" + 
							"(	136	,	 'ABDURRAHMAN'	,	 'FAKIOĞLU'	,	55	,	 'MalatyaAtasehir'	)	,\n" + 
							"(	137	,	 'EMİNE'	,	 'EVRAN'	,	56	,	 'ManisaAtasehir'	)	,\n" + 
							"(	138	,	 'EMRE'	,	 'KUŞ'	,	57	,	 'MardinAtasehir'	)	,\n" + 
							"(	139	,	 'MURAT'	,	 'UTLU'	,	58	,	 'MersinAtasehir'	)	,\n" + 
							"(	140	,	 'HATİCE'	,	 'GÖKALP'	,	59	,	 'MuğlaAtasehir'	)	,\n" + 
							"(	141	,	 'AYŞEGÜL'	,	 'BAHÇECİ'	,	60	,	 'MuşAtasehir'	)	,\n" + 
							"(	142	,	 'KIVANÇ'	,	 'GÖKÇEK'	,	61	,	 'NevşehirAtasehir'	)	,\n" + 
							"(	143	,	 'TANER'	,	 'ÖZDAMAR'	,	62	,	 'NiğdeAtasehir'	)	,\n" + 
							"(	144	,	 'ATİLLA '	,	 'GÖKÇEK'	,	63	,	 'OrduAtasehir'	)	,\n" + 
							"(	145	,	 'TAMER'	,	 'KARDAŞ'	,	64	,	 'OsmaniyeAtasehir'	)	,\n" + 
							"(	146	,	 'HALUK'	,	 'KILIÇ'	,	65	,	 'RizeAtasehir'	)	,\n" + 
							"(	147	,	 'ZEYNEP'	,	 'SÜLEYMAN'	,	66	,	 'SakaryaAtasehir'	)	,\n" + 
							"(	148	,	 'ŞAHİN'	,	 'YANIK'	,	67	,	 'SamsunAtasehir'	)	,\n" + 
							"(	149	,	 'VELİ ÇAĞLAR'	,	 'TAN'	,	68	,	 'SiirtAtasehir'	)	,\n" + 
							"(	150	,	 'SÜLEYMAN'	,	 'SEVİNÇ'	,	69	,	 'SinopAtasehir'	)	,\n" + 
							"(	151	,	 'SERHAT'	,	 'AYYILDIZ'	,	70	,	 'SivasAtasehir'	)	,\n" + 
							"(	152	,	 'SÜLEYMAN'	,	 'ÖZDEMİR'	,	71	,	 'ŞanlıurfaAtasehir'	)	,\n" + 
							"(	153	,	 'İLYAS'	,	 'KARADEMİR'	,	72	,	 'ŞırnakAtasehir'	)	,\n" + 
							"(	154	,	 'GÖKHAN'	,	 'ÇELEN'	,	73	,	 'TekirdağAtasehir'	)	,\n" + 
							"(	155	,	 'FERDA'	,	 'EŞFER'	,	74	,	 'TokatAtasehir'	)	,\n" + 
							"(	156	,	 'ÖZDEMİR'	,	 'KESKİN'	,	75	,	 'TrabzonAtasehir'	)	,\n" + 
							"(	157	,	 'FATMA ESİN'	,	 'SARICA DAROL'	,	76	,	 'TunceliAtasehir'	)	,\n" + 
							"(	158	,	 'MEHMET'	,	 'SERTOĞLU'	,	77	,	 'UşakAtasehir'	)	,\n" + 
							"(	159	,	 'İPEK'	,	 'KARADAĞ'	,	78	,	 'VanAtasehir'	)	,\n" + 
							"(	160	,	 'FUAT'	,	 'ÜNAL'	,	79	,	 'YalovaAtasehir'	)	,\n" + 
							"(	161	,	 ''	,	 'FUAT'	,	80	,	 'YozgatAtasehir'	)	,\n" + 
							"(	162	,	 'TUĞBA'	,	 'LEVENT'	,	81	,	 'ZonguldakAtasehir'	)	,\n" + 
							"(	163	,	 'FUAT SAMİ'	,	 'ÇİFTCİ'	,	1	,	 'AdanaAtasehir'	)	,\n" + 
							"(	164	,	 'GÜLŞAH'	,	 'ÇEÇEN'	,	2	,	 'AdıyamanAtasehir'	)	,\n" + 
							"(	165	,	 'SEMRA'	,	 'PAKSOY'	,	3	,	 'AfyonkarahisarAtasehir'	)	,\n" + 
							"(	166	,	 'TUNA'	,	 'FAKIOĞLU'	,	4	,	 'AğrıAtasehir'	)	,\n" + 
							"(	167	,	 'MAKBULE '	,	 'KIRLI'	,	5	,	 'AksarayAtasehir'	)	,\n" + 
							"(	168	,	 'DENİZ'	,	 'ÇİTİL'	,	6	,	 'AmasyaAtasehir'	)	,\n" + 
							"(	169	,	 'EYYUP SABRİ'	,	 'GÜLER'	,	7	,	 'AnkaraAtasehir'	)	,\n" + 
							"(	170	,	 'BÜŞRA'	,	 'IŞIKLI'	,	8	,	 'AntalyaAtasehir'	)	,\n" + 
							"(	171	,	 'AZİZ'	,	 'KARATOPRAK'	,	9	,	 'ArdahanAtasehir'	)	,\n" + 
							"(	172	,	 'AHMET '	,	 'EROL'	,	10	,	 'ArtvinAtasehir'	)	,\n" + 
							"(	173	,	 'ENES '	,	 'PINARBAŞILI'	,	11	,	 'AydınAtasehir'	)	,\n" + 
							"(	174	,	 'GÜLŞAH'	,	 'BULUT'	,	12	,	 'BalıkesirAtasehir'	)	,\n" + 
							"(	175	,	 'EMİNE'	,	 'ZAİM'	,	13	,	 'BartınAtasehir'	)	,\n" + 
							"(	176	,	 'GÖKHAN'	,	 'TOPALOĞLU'	,	14	,	 'BatmanAtasehir'	)	,\n" + 
							"(	177	,	 'ZAFER'	,	 'KARADAĞ'	,	15	,	 'BayburtAtasehir'	)	,\n" + 
							"(	178	,	 'SEDA'	,	 'SERBEST'	,	16	,	 'BilecikAtasehir'	)	,\n" + 
							"(	179	,	 'ÖMER'	,	 'GÜNDÜZ'	,	17	,	 'BingölAtasehir'	)	,\n" + 
							"(	180	,	 'HAMİT'	,	 'TOKAT'	,	18	,	 'BitlisAtasehir'	)	,\n" + 
							"(	181	,	 'RESUL'	,	 'AKKAYA'	,	19	,	 'BoluAtasehir'	)	,\n" + 
							"(	182	,	 'YAVUZ'	,	 'ŞAHİN'	,	20	,	 'DenizliAtasehir'	)	,\n" + 
							"(	183	,	 'ELA'	,	 'SÜVERAN'	,	21	,	 'BursaAtasehir'	)	,\n" + 
							"(	184	,	 'YAKUP İLKER'	,	 'HALICI'	,	22	,	 'ÇanakkaleAtasehir'	)	,\n" + 
							"(	185	,	 'HATİCE'	,	 'BAŞYURT'	,	23	,	 'ÇankırıAtasehir'	)	,\n" + 
							"(	186	,	 'ONUR'	,	 'NAZLI'	,	24	,	 'ÇorumAtasehir'	)	,\n" + 
							"(	187	,	 'NAZAN'	,	 'HOŞER'	,	25	,	 'BurdurAtasehir'	)	,\n" + 
							"(	188	,	 'MUSTAFA '	,	 'KÖKSAL'	,	26	,	 'DiyarbakırAtasehir'	)	,\n" + 
							"(	189	,	 'ÖMER'	,	 'DEMİREL'	,	27	,	 'DüzceAtasehir'	)	,\n" + 
							"(	190	,	 'MURAT'	,	 'ÖZAN SANHAL'	,	28	,	 'EdirneAtasehir'	)	,\n" + 
							"(	191	,	 'DERYA'	,	 'OCAK'	,	29	,	 'ElazığAtasehir'	)	,\n" + 
							"(	192	,	 'RAŞİD'	,	 'DANIŞOĞLU'	,	30	,	 'ErzincanAtasehir'	)	,\n" + 
							"(	193	,	 'MİNE'	,	 'ÖZDEN'	,	31	,	 'ErzurumAtasehir'	)	,\n" + 
							"(	194	,	 'DİDEM'	,	 'KOÇAR'	,	32	,	 'EskişehirAtasehir'	)	,\n" + 
							"(	195	,	 'RAŞİD'	,	 'ÖZDEMİR'	,	33	,	 'GaziantepAtasehir'	)	,\n" + 
							"(	196	,	 'ŞULE MİNE'	,	 'GÜLŞAN'	,	34	,	 'GiresunAtasehir'	)	,\n" + 
							"(	197	,	 'RABİA'	,	 'ÇAKMAK'	,	35	,	 'GümüşhaneAtasehir'	)	,\n" + 
							"(	198	,	 'VAZİR AKBER'	,	 'ÖZTAŞ'	,	36	,	 'HakkariAtasehir'	)	,\n" + 
							"(	199	,	 'EMEL'	,	 'TOKTAŞ'	,	37	,	 'HatayAtasehir'	)	,\n" + 
							"(	200	,	 'SEVDA'	,	 'BAĞCI'	,	38	,	 'IğdırAtasehir'	)	,\n" + 
							"(	201	,	 'FATİH'	,	 'GÖK'	,	39	,	 'IspartaAtasehir'	)	,\n" + 
							"(	202	,	 'EMİNE'	,	 'GÖKCE'	,	40	,	 'İstanbulAtasehir'	)	,\n" + 
							"(	203	,	 'ÖZNUR'	,	 'BEKAR'	,	41	,	 'İzmirAtasehir'	)	,\n" + 
							"(	204	,	 'BARIŞ'	,	 'EVRENOS'	,	42	,	 'KahramanmaraşAtasehir'	)	,\n" + 
							"(	205	,	 'SAİD'	,	 'AYYILDIZ'	,	43	,	 'KarabükAtasehir'	)	,\n" + 
							"(	206	,	 'SAMET SANCAR'	,	 'KARADUMAN'	,	44	,	 'KaramanAtasehir'	)	,\n" + 
							"(	207	,	 'ÇAĞRI'	,	 'AÇAR'	,	45	,	 'KarsAtasehir'	)	,\n" + 
							"(	208	,	 'ABDULLAH'	,	 'ORAK'	,	46	,	 'KastamonuAtasehir'	)	,\n" + 
							"(	209	,	 'ÖZNUR'	,	 'SALTÜRK'	,	47	,	 'KayseriAtasehir'	)	,\n" + 
							"(	210	,	 'AYŞE'	,	 'KARADAĞ'	,	48	,	 'KırıkkaleAtasehir'	)	,\n" + 
							"(	211	,	 'BERÇEM'	,	 'ÖZEL'	,	49	,	 'KırklareliAtasehir'	)	,\n" + 
							"(	212	,	 'AKIN'	,	 'ASİL'	,	50	,	 'KırşehirAtasehir'	)	,\n" + 
							"(	213	,	 'İBRAHİM'	,	 'DEVECİ'	,	51	,	 'KilisAtasehir'	)	,\n" + 
							"(	214	,	 'MAHİR'	,	 'DİRİCAN'	,	52	,	 'KocaeliAtasehir'	)	,\n" + 
							"(	215	,	 'RUKİYE'	,	 'GENÇPINAR'	,	53	,	 'KonyaAtasehir'	)	,\n" + 
							"(	216	,	 'AKIN'	,	 'SARI'	,	54	,	 'KütahyaAtasehir'	)	,\n" + 
							"(	217	,	 'İLKNUR'	,	 'TEN'	,	55	,	 'MalatyaAtasehir'	)	,\n" + 
							"(	218	,	 'AKIN'	,	 'BOLAT'	,	56	,	 'ManisaAtasehir'	)	,\n" + 
							"(	219	,	 'SERTAÇ'	,	 'PEYNİRCİ'	,	57	,	 'MardinAtasehir'	)	,\n" + 
							"(	220	,	 'SEVİL'	,	 'SANHAL'	,	58	,	 'MersinAtasehir'	)	,\n" + 
							"(	221	,	 'AKIN'	,	 'YANCAR'	,	59	,	 'MuğlaAtasehir'	)	,\n" + 
							"(	222	,	 'AYKAN'	,	 'AKKAYA'	,	60	,	 'MuşAtasehir'	)	,\n" + 
							"(	223	,	 'AKIN'	,	 'FINDIK GÜVENDİ'	,	61	,	 'NevşehirAtasehir'	)	,\n" + 
							"(	224	,	 'AKIN'	,	 'SARIÇİÇEK'	,	62	,	 'NiğdeAtasehir'	)	,\n" + 
							"(	225	,	 'EMİNE'	,	 'ŞEN'	,	63	,	 'OrduAtasehir'	)	,\n" + 
							"(	226	,	 'AKIN'	,	 'KIRASLAN'	,	64	,	 'OsmaniyeAtasehir'	)	,\n" + 
							"(	227	,	 'YASEMİN'	,	 'ORHAN'	,	65	,	 'RizeAtasehir'	)	,\n" + 
							"(	228	,	 'MAHMUT BURAK'	,	 'ÜNÜVAR'	,	66	,	 'SakaryaAtasehir'	)	,\n" + 
							"(	229	,	 'NEVİN'	,	 'ÇOBANOĞLU'	,	67	,	 'SamsunAtasehir'	)	,\n" + 
							"(	230	,	 'MERİH'	,	 'GÖKÇEN'	,	68	,	 'SiirtAtasehir'	)	,\n" + 
							"(	231	,	 'İZZETTİN'	,	 'KAYA'	,	69	,	 'SinopAtasehir'	)	,\n" + 
							"(	232	,	 'AKIN'	,	 'ATEŞ'	,	70	,	 'SivasAtasehir'	)	,\n" + 
							"(	233	,	 'FERAT'	,	 'TAYFUR'	,	71	,	 'ŞanlıurfaAtasehir'	)	,\n" + 
							"(	234	,	 'ADİL'	,	 'DÖNMEZ'	,	72	,	 'ŞırnakAtasehir'	)	,\n" + 
							"(	235	,	 'AKIN'	,	 'BEREKATOĞLU'	,	73	,	 'TekirdağAtasehir'	)	,\n" + 
							"(	236	,	 'TEVFİK'	,	 'GÜRDEMİR'	,	74	,	 'TokatAtasehir'	)	,\n" + 
							"(	237	,	 'ÖMER FARUK'	,	 'YILMAZ'	,	75	,	 'TrabzonAtasehir'	)	,\n" + 
							"(	238	,	 'AKIN'	,	 'DEVECİ'	,	76	,	 'TunceliAtasehir'	)	,\n" + 
							"(	239	,	 'ÇAĞRI'	,	 'ŞAHİN'	,	77	,	 'UşakAtasehir'	)	,\n" + 
							"(	240	,	 'ÖZGÜR'	,	 'KARADUMAN'	,	78	,	 'VanAtasehir'	)	,\n" + 
							"(	241	,	 'AKIN'	,	 'GÖKÇE'	,	79	,	 'YalovaAtasehir'	)	,\n" + 
							"(	242	,	 'HALİL'	,	 'KURT'	,	80	,	 'YozgatAtasehir'	)	,\n" + 
							"(	243	,	 'BAŞAK'	,	 'ÖZSAYIM'	,	81	,	 'ZonguldakAtasehir'	)	,\n" + 
							"(	244	,	 'AKIN'	,	 'KOTTAŞ'	,	1	,	 'AdanaAtasehir'	)	,\n" + 
							"(	245	,	 'HASAN '	,	 'TOKATLIOĞLU'	,	2	,	 'AdıyamanAtasehir'	)	,\n" + 
							"(	246	,	 'AKIN'	,	 'İLGEN'	,	3	,	 'AfyonkarahisarAtasehir'	)	,\n" + 
							"(	247	,	 'ASLIHAN'	,	 'DEMİRTÜRK'	,	4	,	 'AğrıAtasehir'	)	,\n" + 
							"(	248	,	 'ABDULLAH'	,	 'KIZMAZ'	,	5	,	 'AksarayAtasehir'	)	,\n" + 
							"(	249	,	 'ŞEHMUS'	,	 'KEŞKEK'	,	6	,	 'AmasyaAtasehir'	)	,\n" + 
							"(	250	,	 'SERDAR'	,	 'YILMAZ'	,	7	,	 'AnkaraAtasehir'	)	,\n" + 
							"(	251	,	 'SERTAÇ'	,	 'BAŞAR'	,	8	,	 'AntalyaAtasehir'	)	,\n" + 
							"(	252	,	 'ULAŞ'	,	 'ARSLAN'	,	9	,	 'ArdahanAtasehir'	)	,\n" + 
							"(	253	,	 'YUSUF'	,	 'ÇELEN'	,	10	,	 'ArtvinAtasehir'	)	,\n" + 
							"(	254	,	 'ULAŞ'	,	 'KARADENİZ'	,	11	,	 'AydınAtasehir'	)	,\n" + 
							"(	255	,	 'SİBEL'	,	 'AYDIN'	,	12	,	 'BalıkesirAtasehir'	)	,\n" + 
							"(	256	,	 'ULAŞ'	,	 'TUNCAY'	,	13	,	 'BartınAtasehir'	)	,\n" + 
							"(	257	,	 'MEHMET CİHAT'	,	 'KARAHAN'	,	14	,	 'BatmanAtasehir'	)	,\n" + 
							"(	258	,	 'ULAŞ'	,	 'TOPAK'	,	15	,	 'BayburtAtasehir'	)	,\n" + 
							"(	259	,	 'SÜLEYMAN'	,	 'OLCAR'	,	16	,	 'BilecikAtasehir'	)	,\n" + 
							"(	260	,	 'ULAŞ'	,	 'HALICI'	,	17	,	 'BingölAtasehir'	)	,\n" + 
							"(	261	,	 'MEHMET'	,	 'OLGAÇ'	,	18	,	 'BitlisAtasehir'	)	,\n" + 
							"(	262	,	 'NEZAKET'	,	 'DEMİR'	,	19	,	 'BoluAtasehir'	)	,\n" + 
							"(	263	,	 'ULAŞ'	,	 'BAYRAKTAR'	,	20	,	 'DenizliAtasehir'	)	,\n" + 
							"(	264	,	 'HAMZA'	,	 'KAYA'	,	21	,	 'BursaAtasehir'	)	,\n" + 
							"(	265	,	 'ULAŞ '	,	 'VAROL'	,	22	,	 'ÇanakkaleAtasehir'	)	,\n" + 
							"(	266	,	 'EMİNE'	,	 'OFLAZOĞLU'	,	23	,	 'ÇankırıAtasehir'	)	,\n" + 
							"(	267	,	 'EVREN'	,	 'URUÇ'	,	24	,	 'ÇorumAtasehir'	)	,\n" + 
							"(	268	,	 'ULAŞ'	,	 'KARAPIÇAK'	,	25	,	 'BurdurAtasehir'	)	,\n" + 
							"(	269	,	 'ANIL'	,	 'ÇETİN'	,	26	,	 'DiyarbakırAtasehir'	)	,\n" + 
							"(	270	,	 'ALİ'	,	 'ÇİTİL'	,	27	,	 'DüzceAtasehir'	)	,\n" + 
							"(	271	,	 'ANIL'	,	 'KURTULUŞ'	,	28	,	 'EdirneAtasehir'	)	,\n" + 
							"(	272	,	 'EYÜP'	,	 'ÖZ'	,	29	,	 'ElazığAtasehir'	)	,\n" + 
							"(	273	,	 'HATİCE'	,	 'SAVAŞ'	,	30	,	 'ErzincanAtasehir'	)	,\n" + 
							"(	274	,	 'ÇAĞLAR'	,	 'BABADAĞI'	,	31	,	 'ErzurumAtasehir'	)	,\n" + 
							"(	275	,	 'CEYHUN'	,	 'DOĞAN'	,	32	,	 'EskişehirAtasehir'	)	,\n" + 
							"(	276	,	 'ANIL FARUK'	,	 'CEYLAN'	,	33	,	 'GaziantepAtasehir'	)	,\n" + 
							"(	277	,	 'MEVLÜT'	,	 'BAŞARGAN'	,	34	,	 'GiresunAtasehir'	)	,\n" + 
							"(	278	,	 'NURAY'	,	 'SARIKAYA'	,	35	,	 'GümüşhaneAtasehir'	)	,\n" + 
							"(	279	,	 'ANIL'	,	 'YÜREK'	,	36	,	 'HakkariAtasehir'	)	,\n" + 
							"(	280	,	 'ERAY'	,	 'ANIL'	,	37	,	 'HatayAtasehir'	)	,\n" + 
							"(	281	,	 'NİHAL'	,	 'ÖZTAŞ'	,	38	,	 'IğdırAtasehir'	)	,\n" + 
							"(	282	,	 'EDA'	,	 'ÜNLÜ'	,	39	,	 'IspartaAtasehir'	)	,\n" + 
							"(	283	,	 'VELİT'	,	 'ÖZTAŞ'	,	40	,	 'İstanbulAtasehir'	)	,\n" + 
							"(	284	,	 'HİKMET'	,	 'BULUT'	,	41	,	 'İzmirAtasehir'	)	,\n" + 
							"(	285	,	 'ÖZGE'	,	 'ÖZTAŞ'	,	42	,	 'KahramanmaraşAtasehir'	)	,\n" + 
							"(	286	,	 'FATMA'	,	 'KAVUKOĞLU'	,	43	,	 'KarabükAtasehir'	)	,\n" + 
							"(	287	,	 'AHMET'	,	 'ÇINKIT'	,	44	,	 'KaramanAtasehir'	)	,\n" + 
							"(	288	,	 'AHMAD '	,	 'ÖZTAŞ'	,	45	,	 'KarsAtasehir'	)	,\n" + 
							"(	289	,	 'HAZEL'	,	 'ÖZTAŞ'	,	46	,	 'KastamonuAtasehir'	)	,\n" + 
							"(	290	,	 'ŞERİFE EZGİ'	,	 'ÖZMEN'	,	47	,	 'KayseriAtasehir'	)	,\n" + 
							"(	291	,	 'TAHER HİLMİ'	,	 'SAĞCAN'	,	48	,	 'KırıkkaleAtasehir'	)	,\n" + 
							"(	292	,	 'EYLEM'	,	 'ÇELİK'	,	49	,	 'KırklareliAtasehir'	)	,\n" + 
							"(	293	,	 'MELİHA ESRA'	,	 'KÜTÜK'	,	50	,	 'KırşehirAtasehir'	)	,\n" + 
							"(	294	,	 'TAHER '	,	 'DÖNMEZ'	,	51	,	 'KilisAtasehir'	)	,\n" + 
							"(	295	,	 'SÜMEYRA'	,	 'TOMBUL'	,	52	,	 'KocaeliAtasehir'	)	,\n" + 
							"(	296	,	 'SAMET'	,	 'EREN'	,	53	,	 'KonyaAtasehir'	)	,\n" + 
							"(	297	,	 'MUHAMMED NURİ'	,	 'CANTÜRK'	,	54	,	 'KütahyaAtasehir'	)	,\n" + 
							"(	298	,	 'MEHMET'	,	 'SARIGÜL'	,	55	,	 'MalatyaAtasehir'	)	,\n" + 
							"(	299	,	 'MEHMET ALİ'	,	 'KURT'	,	56	,	 'ManisaAtasehir'	)	,\n" + 
							"(	300	,	 'ESRA'	,	 'SEVİNÇ'	,	57	,	 'MardinAtasehir'	)	,\n" + 
							"(	301	,	 'YAHYA'	,	 'BABADAĞI'	,	58	,	 'MersinAtasehir'	)	,\n" + 
							"(	302	,	 'HASAN ESRA'	,	 'ÇEKİÇ'	,	59	,	 'MuğlaAtasehir'	)	,\n" + 
							"(	303	,	 'ESRA'	,	 'DEMİRKAPI'	,	60	,	 'MuşAtasehir'	)	,\n" + 
							"(	304	,	 'ÖMER AYKUT'	,	 'SERT'	,	61	,	 'NevşehirAtasehir'	)	,\n" + 
							"(	305	,	 'EVREN'	,	 'AŞKIN'	,	62	,	 'NiğdeAtasehir'	)	,\n" + 
							"(	306	,	 'ESRA'	,	 'KOYUNCU'	,	63	,	 'OrduAtasehir'	)	,\n" + 
							"(	307	,	 'ESRA'	,	 'ARMAĞAN'	,	64	,	 'OsmaniyeAtasehir'	)	,\n" + 
							"(	308	,	 'SUNA'	,	 'KAYA'	,	65	,	 'RizeAtasehir'	)	,\n" + 
							"(	309	,	 'SİBEL'	,	 'TUNCAY'	,	66	,	 'SakaryaAtasehir'	)	,\n" + 
							"(	310	,	 'HASAN'	,	 'GÖKSOY'	,	67	,	 'SamsunAtasehir'	)	,\n" + 
							"(	311	,	 'RAMAZAN FERHAD'	,	 'SARI'	,	68	,	 'SiirtAtasehir'	)	,\n" + 
							"(	312	,	 ' NİLAY'	,	 'KAPLAN'	,	69	,	 'SinopAtasehir'	)	,\n" + 
							"(	313	,	 'ELİF'	,	 'TAŞDELEN'	,	70	,	 'SivasAtasehir'	)	,\n" + 
							"(	314	,	 'SEMA'	,	 'SUZAN'	,	71	,	 'ŞanlıurfaAtasehir'	)	,\n" + 
							"(	315	,	 'ELA'	,	 'ÇAĞLAR'	,	72	,	 'ŞırnakAtasehir'	)	,\n" + 
							"(	316	,	 'FATMA'	,	 'CANTÜRK'	,	73	,	 'TekirdağAtasehir'	)	,\n" + 
							"(	317	,	 'SEMA'	,	 'DÖNMEZ'	,	74	,	 'TokatAtasehir'	)	,\n" + 
							"(	318	,	 'HASAN BİLEN'	,	 'BAKAN'	,	75	,	 'TrabzonAtasehir'	)	,\n" + 
							"(	319	,	 'FATİH'	,	 'KAYAALP'	,	76	,	 'TunceliAtasehir'	)	,\n" + 
							"(	320	,	 'SEMA SELCAN'	,	 'ÖZTÜRK'	,	77	,	 'UşakAtasehir'	)	,\n" + 
							"(	321	,	 'EYÜP'	,	 'ÜNGÜR'	,	78	,	 'VanAtasehir'	)	,\n" + 
							"(	322	,	 'MEHMET'	,	 'KALYONCU UÇAR'	,	79	,	 'YalovaAtasehir'	)	,\n" + 
							"(	323	,	 'YASER'	,	 'GÜRSOY'	,	80	,	 'YozgatAtasehir'	)	,\n" + 
							"(	324	,	 'SEMA DİLEK'	,	 'ÇEKİÇ'	,	81	,	 'ZonguldakAtasehir'	)	,\n" + 
							"(	325	,	 'ERDİNÇ'	,	 'FİLİZAY'	,	1	,	 'AdanaKadikoy'	)	,\n" + 
							"(	326	,	 'SEMA'	,	 'YARADILMIŞ'	,	2	,	 'AdıyamanKadikoy'	)	,\n" + 
							"(	327	,	 'EZGİ'	,	 'KILIÇ'	,	3	,	 'AfyonkarahisarKadikoy'	)	,\n" + 
							"(	328	,	 'SAMET SANCAR'	,	 'UYSAL'	,	4	,	 'AğrıKadikoy'	)	,\n" + 
							"(	329	,	 'SEMA'	,	 'GÜLER'	,	5	,	 'AksarayKadikoy'	)	,\n" + 
							"(	330	,	 'HİLAL'	,	 'DEMİREL'	,	6	,	 'AmasyaKadikoy'	)	,\n" + 
							"(	331	,	 'SEMA '	,	 'HASSAN'	,	7	,	 'AnkaraKadikoy'	)	,\n" + 
							"(	332	,	 'SEMA'	,	 'ÖZKANLI'	,	8	,	 'AntalyaKadikoy'	)	,\n" + 
							"(	333	,	 'RAZİYE DAMLA'	,	 'ÖZEN'	,	9	,	 'ArdahanKadikoy'	)	,\n" + 
							"(	334	,	 'SÜLEYMAN'	,	 'ÖZMUK'	,	10	,	 'ArtvinKadikoy'	)	,\n" + 
							"(	335	,	 'CIVAN'	,	 'COŞKUN'	,	11	,	 'AydınKadikoy'	)	,\n" + 
							"(	336	,	 'MERVE'	,	 'ÖZEK'	,	12	,	 'BalıkesirKadikoy'	)	,\n" + 
							"(	337	,	 'CIVAN'	,	 'DEDE'	,	13	,	 'BartınKadikoy'	)	,\n" + 
							"(	338	,	 'CIVAN'	,	 'ÖZTÜRK'	,	14	,	 'BatmanKadikoy'	)	,\n" + 
							"(	339	,	 'TÜMAY'	,	 'APAYDIN'	,	15	,	 'BayburtKadikoy'	)	,\n" + 
							"(	340	,	 'CIVAN'	,	 'AYMAN'	,	16	,	 'BilecikKadikoy'	)	,\n" + 
							"(	341	,	 'AHMET '	,	 'ASIG'	,	17	,	 'BingölKadikoy'	)	,\n" + 
							"(	342	,	 'SEDA ELÇİM'	,	 'SEĞMEN'	,	18	,	 'BitlisKadikoy'	)	,\n" + 
							"(	343	,	 'CIVAN'	,	 'BACAK'	,	19	,	 'BoluKadikoy'	)	,\n" + 
							"(	344	,	 'BERK'	,	 'YALÇIN'	,	20	,	 'DenizliKadikoy'	)	,\n" + 
							"(	345	,	 'ASUMAN'	,	 'KÖSEOĞLU'	,	21	,	 'BursaKadikoy'	)	,\n" + 
							"(	346	,	 'BURAK'	,	 'KOÇYİĞİT'	,	22	,	 'ÇanakkaleKadikoy'	)	,\n" + 
							"(	347	,	 'TÜLAY'	,	 'EYİSOY'	,	23	,	 'ÇankırıKadikoy'	)	,\n" + 
							"(	348	,	 'BURAK'	,	 'BAL'	,	24	,	 'ÇorumKadikoy'	)	,\n" + 
							"(	349	,	 'İSMAİL'	,	 'KUSERLİ'	,	25	,	 'BurdurKadikoy'	)	,\n" + 
							"(	350	,	 'UYSAN'	,	 'ÖZBEK'	,	26	,	 'DiyarbakırKadikoy'	)	,\n" + 
							"(	351	,	 'BURAK'	,	 'GENEZ'	,	27	,	 'DüzceKadikoy'	)	,\n" + 
							"(	352	,	 'MAHMUT'	,	 'DOĞAN'	,	28	,	 'EdirneKadikoy'	)	,\n" + 
							"(	353	,	 'TEVHİD'	,	 'POLAT'	,	29	,	 'ElazığKadikoy'	)	,\n" + 
							"(	354	,	 'ONAT'	,	 'ÇEVİKER'	,	30	,	 'ErzincanKadikoy'	)	,\n" + 
							"(	355	,	 'BURAK'	,	 'YILDIRIM'	,	31	,	 'ErzurumKadikoy'	)	,\n" + 
							"(	356	,	 'GÜLŞEN'	,	 'YEGEN YILMAZ'	,	32	,	 'EskişehirKadikoy'	)	,\n" + 
							"(	357	,	 'BURAK'	,	 'BAKLACI'	,	33	,	 'GaziantepKadikoy'	)	,\n" + 
							"(	358	,	 'TEKİN'	,	 'NACAR'	,	34	,	 'GiresunKadikoy'	)	,\n" + 
							"(	359	,	 'ŞEYDA'	,	 'ULU'	,	35	,	 'GümüşhaneKadikoy'	)	,\n" + 
							"(	360	,	 'BURAK'	,	 'KOCA'	,	36	,	 'HakkariKadikoy'	)	,\n" + 
							"(	361	,	 'MURAT'	,	 'GÜMÜŞÇÜ'	,	37	,	 'HatayKadikoy'	)	,\n" + 
							"(	362	,	 'YASEMİN'	,	 'OCAK'	,	38	,	 'IğdırKadikoy'	)	,\n" + 
							"(	363	,	 'BURAK'	,	 'SAVRAN'	,	39	,	 'IspartaKadikoy'	)	,\n" + 
							"(	364	,	 'MUSTAFA'	,	 'KAYMAN KÖSE'	,	40	,	 'İstanbulKadikoy'	)	,\n" + 
							"(	365	,	 'SÜLEYMAN'	,	 'AYDEMİR'	,	41	,	 'İzmirKadikoy'	)	,\n" + 
							"(	366	,	 'BURAK'	,	 'KORKMAZ'	,	42	,	 'KahramanmaraşKadikoy'	)	,\n" + 
							"(	367	,	 'HASAN'	,	 'ÖRDEK'	,	43	,	 'KarabükKadikoy'	)	,\n" + 
							"(	368	,	 'BURAK'	,	 'ÖZAN SANHAL'	,	44	,	 'KaramanKadikoy'	)	,\n" + 
							"(	369	,	 'HAKAN'	,	 'HİÇDURMAZ'	,	45	,	 'KarsKadikoy'	)	,\n" + 
							"(	370	,	 'ÖMER'	,	 'OĞUZ'	,	46	,	 'KastamonuKadikoy'	)	,\n" + 
							"(	371	,	 'HACI'	,	 'KOÇER'	,	47	,	 'KayseriKadikoy'	)	,\n" + 
							"(	372	,	 'TANER'	,	 'HİÇDURMAZ'	,	48	,	 'KırıkkaleKadikoy'	)	,\n" + 
							"(	373	,	 'FEYZAHAN'	,	 'BULUT'	,	49	,	 'KırklareliKadikoy'	)	,\n" + 
							"(	374	,	 'BAŞAK'	,	 'HİÇDURMAZ'	,	50	,	 'KırşehirKadikoy'	)	,\n" + 
							"(	375	,	 'MEHMET ŞİRİN'	,	 'EMET'	,	51	,	 'KilisKadikoy'	)	,\n" + 
							"(	376	,	 'MUHAMMED'	,	 'HİÇDURMAZ'	,	52	,	 'KocaeliKadikoy'	)	,\n" + 
							"(	377	,	 'ATILGAN'	,	 'AKBULUT'	,	53	,	 'KonyaKadikoy'	)	,\n" + 
							"(	378	,	 'HALİM'	,	 'HİÇDURMAZ'	,	54	,	 'KütahyaKadikoy'	)	,\n" + 
							"(	379	,	 'ÖZLEM'	,	 'DEVECİ'	,	55	,	 'MalatyaKadikoy'	)	,\n" + 
							"(	380	,	 'EMRE'	,	 'HİÇDURMAZ'	,	56	,	 'ManisaKadikoy'	)	,\n" + 
							"(	381	,	 'ŞULE'	,	 'FİLİZ'	,	57	,	 'MardinKadikoy'	)	,\n" + 
							"(	382	,	 'CANSU'	,	 'HİÇDURMAZ'	,	58	,	 'MersinKadikoy'	)	,\n" + 
							"(	383	,	 'MEHMET ALİ'	,	 'ATAK'	,	59	,	 'MuğlaKadikoy'	)	,\n" + 
							"(	384	,	 'BARAN'	,	 'HİÇDURMAZ'	,	60	,	 'MuşKadikoy'	)	,\n" + 
							"(	385	,	 'ŞÜKRÜ'	,	 'KARA'	,	61	,	 'NevşehirKadikoy'	)	,\n" + 
							"(	386	,	 'KIYMET'	,	 'GÜRDEMİR'	,	62	,	 'NiğdeKadikoy'	)	,\n" + 
							"(	387	,	 'GÜLŞAH'	,	 'GÜNDOĞDU'	,	63	,	 'OrduKadikoy'	)	,\n" + 
							"(	388	,	 'YUSUF'	,	 'DEMİR'	,	64	,	 'OsmaniyeKadikoy'	)	,\n" + 
							"(	389	,	 'DİLEK'	,	 'ÇEVİRGEN'	,	65	,	 'RizeKadikoy'	)	,\n" + 
							"(	390	,	 'SAMİ'	,	 'AYDIN'	,	66	,	 'SakaryaKadikoy'	)	,\n" + 
							"(	391	,	 'EMİNE'	,	 'EROL'	,	67	,	 'SamsunKadikoy'	)	,\n" + 
							"(	392	,	 'BURCU'	,	 'ÜREYEN'	,	68	,	 'SiirtKadikoy'	)	,\n" + 
							"(	393	,	 'YUSUF'	,	 'GÖKSEL'	,	69	,	 'SinopKadikoy'	)	,\n" + 
							"(	394	,	 'KASIM'	,	 'ÇAKIR'	,	70	,	 'SivasKadikoy'	)	,\n" + 
							"(	395	,	 'YUSUF'	,	 'ÖZKAYNAR'	,	71	,	 'ŞanlıurfaKadikoy'	)	,\n" + 
							"(	396	,	 'MUSTAFA'	,	 'GÜVEN'	,	72	,	 'ŞırnakKadikoy'	)	,\n" + 
							"(	397	,	 'YUSUF'	,	 'GÖRMELİ'	,	73	,	 'TekirdağKadikoy'	)	,\n" + 
							"(	398	,	 'MUHLİS'	,	 'YURDSEVEN'	,	74	,	 'TokatKadikoy'	)	,\n" + 
							"(	399	,	 'YUSUF'	,	 'YALÇIN'	,	75	,	 'TrabzonKadikoy'	)	,\n" + 
							"(	400	,	 'OSMAN'	,	 'SEVEN'	,	76	,	 'TunceliKadikoy'	)	,\n" + 
							"(	401	,	 'MUHAMMED'	,	 'BULUT'	,	77	,	 'UşakKadikoy'	)	,\n" + 
							"(	402	,	 'YÜCEL'	,	 'KÜTÜK'	,	78	,	 'VanKadikoy'	)	,\n" + 
							"(	403	,	 'SENEM'	,	 'DOĞAN'	,	79	,	 'YalovaKadikoy'	)	,\n" + 
							"(	404	,	 'NESLİHAN'	,	 'ŞAHAN'	,	80	,	 'YozgatKadikoy'	)	,\n" + 
							"(	405	,	 'TUĞBA'	,	 'KÜTÜK'	,	81	,	 'ZonguldakKadikoy'	)	,\n" + 
							"(	406	,	 'YUSUF '	,	 'ALBAY'	,	1	,	 'AdanaKadikoy'	)	,\n" + 
							"(	407	,	 'NEBİL'	,	 'AKGÜL'	,	2	,	 'AdıyamanKadikoy'	)	,\n" + 
							"(	408	,	 'YUSUF FERHAD'	,	 'DÖNMEZ'	,	3	,	 'AfyonkarahisarKadikoy'	)	,\n" + 
							"(	409	,	 'HACI'	,	 'YILMAZ'	,	4	,	 'AğrıKadikoy'	)	,\n" + 
							"(	410	,	 'BURÇ'	,	 'AYCAN'	,	5	,	 'AksarayKadikoy'	)	,\n" + 
							"(	411	,	 'ASUDAN TUĞÇE'	,	 'GÜNDÜZ'	,	6	,	 'AmasyaKadikoy'	)	,\n" + 
							"(	412	,	 'REMZİYE'	,	 'BURÇ'	,	7	,	 'AnkaraKadikoy'	)	,\n" + 
							"(	413	,	 'FUNDA'	,	 'AKGÜL'	,	8	,	 'AntalyaKadikoy'	)	,\n" + 
							"(	414	,	 'SELİN'	,	 'DEMİREL'	,	9	,	 'ArdahanKadikoy'	)	,\n" + 
							"(	415	,	 'BURÇ'	,	 'DÜZGÜN'	,	10	,	 'ArtvinKadikoy'	)	,\n" + 
							"(	416	,	 'NİMET'	,	 'BURÇ'	,	11	,	 'AydınKadikoy'	)	,\n" + 
							"(	417	,	 'BURÇ'	,	 'DOĞAN'	,	12	,	 'BalıkesirKadikoy'	)	,\n" + 
							"(	418	,	 'VOLKAN'	,	 'ŞAHİNER'	,	13	,	 'BartınKadikoy'	)	,\n" + 
							"(	419	,	 'MURAT'	,	 'ORDULU ŞAHİN'	,	14	,	 'BatmanKadikoy'	)	,\n" + 
							"(	420	,	 'ÜMİT'	,	 'ELÇİÇEK'	,	15	,	 'BayburtKadikoy'	)	,\n" + 
							"(	421	,	 'YUSUF'	,	 'BURÇ'	,	16	,	 'BilecikKadikoy'	)	,\n" + 
							"(	422	,	 'BURÇ'	,	 'BAŞ'	,	17	,	 'BingölKadikoy'	)	,\n" + 
							"(	423	,	 'BİLAL BURÇ'	,	 'BAHÇECİ'	,	18	,	 'BitlisKadikoy'	)	,\n" + 
							"(	424	,	 'CEMİLE AYŞE'	,	 'POSTALLI'	,	19	,	 'BoluKadikoy'	)	,\n" + 
							"(	425	,	 'BURÇ'	,	 'BURÇ'	,	20	,	 'DenizliKadikoy'	)	,\n" + 
							"(	426	,	 'KAMİL'	,	 'BULUT'	,	21	,	 'BursaKadikoy'	)	,\n" + 
							"(	427	,	 'UMUT'	,	 'TAŞ'	,	22	,	 'ÇanakkaleKadikoy'	)	,\n" + 
							"(	428	,	 'KORAY'	,	 'MERDEN'	,	23	,	 'ÇankırıKadikoy'	)	,\n" + 
							"(	429	,	 'İSMAİL '	,	 'BULAKÇI'	,	24	,	 'ÇorumKadikoy'	)	,\n" + 
							"(	430	,	 'MELTEM'	,	 'KORUCU'	,	25	,	 'BurdurKadikoy'	)	,\n" + 
							"(	431	,	 'ŞENOL'	,	 'ŞİRZAİ'	,	26	,	 'DiyarbakırKadikoy'	)	,\n" + 
							"(	432	,	 'DERYA'	,	 'ERAT'	,	27	,	 'DüzceKadikoy'	)	,\n" + 
							"(	433	,	 'VEHBİ'	,	 'YILMAZ'	,	28	,	 'EdirneKadikoy'	)	,\n" + 
							"(	434	,	 'MUSTAFA'	,	 'BULAKÇI'	,	29	,	 'ElazığKadikoy'	)	,\n" + 
							"(	435	,	 'MURAT'	,	 'ŞENOL'	,	30	,	 'ErzincanKadikoy'	)	,\n" + 
							"(	436	,	 'ŞENOL ERSEGUN'	,	 'SADIÇ'	,	31	,	 'ErzurumKadikoy'	)	,\n" + 
							"(	437	,	 'TEYFİK'	,	 'BAHÇECİ'	,	32	,	 'EskişehirKadikoy'	)	,\n" + 
							"(	438	,	 'BİRSEN'	,	 'EMET'	,	33	,	 'GaziantepKadikoy'	)	,\n" + 
							"(	439	,	 'İBRAHİM'	,	 'HASSAN'	,	34	,	 'GiresunKadikoy'	)	,\n" + 
							"(	440	,	 'YURDAGÜL'	,	 'AĞCA'	,	35	,	 'GümüşhaneKadikoy'	)	,\n" + 
							"(	441	,	 'BURAK'	,	 'DENİZ'	,	36	,	 'HakkariKadikoy'	)	,\n" + 
							"(	442	,	 'ÇAĞRI'	,	 'ŞENOL'	,	37	,	 'HatayKadikoy'	)	,\n" + 
							"(	443	,	 'İREM'	,	 'TURMUŞ'	,	38	,	 'IğdırKadikoy'	)	,\n" + 
							"(	444	,	 'ŞENOL'	,	 'DOĞAN'	,	39	,	 'IspartaKadikoy'	)	,\n" + 
							"(	445	,	 'MUSA'	,	 'SABAZ'	,	40	,	 'İstanbulKadikoy'	)	,\n" + 
							"(	446	,	 'BAHADIR'	,	 'ŞENOL'	,	41	,	 'İzmirKadikoy'	)	,\n" + 
							"(	447	,	 'GÖKHAN'	,	 'GÜLER'	,	42	,	 'KahramanmaraşKadikoy'	)	,\n" + 
							"(	448	,	 'SONAY'	,	 'ÇEPNİ'	,	43	,	 'KarabükKadikoy'	)	,\n" + 
							"(	449	,	 'REFAETTİN'	,	 'ŞENOL'	,	44	,	 'KaramanKadikoy'	)	,\n" + 
							"(	450	,	 'ŞENOL'	,	 'KAYAOĞLU'	,	45	,	 'KarsKadikoy'	)	,\n" + 
							"(	451	,	 'GÜLŞAH'	,	 'KUMBUL'	,	46	,	 'KastamonuKadikoy'	)	,\n" + 
							"(	452	,	 'YASEMİN'	,	 'AKBAŞ'	,	47	,	 'KayseriKadikoy'	)	,\n" + 
							"(	453	,	 'ENGİN'	,	 'KAYA'	,	48	,	 'KırıkkaleKadikoy'	)	,\n" + 
							"(	454	,	 'ŞENOL'	,	 'HAMDEMİRCİ'	,	49	,	 'KırklareliKadikoy'	)	,\n" + 
							"(	455	,	 'GAMZE'	,	 'DEMİR'	,	50	,	 'KırşehirKadikoy'	)	,\n" + 
							"(	456	,	 'ERHAN'	,	 'ŞENOL'	,	51	,	 'KilisKadikoy'	)	,\n" + 
							"(	457	,	 'ERTAN'	,	 'ÇİNPOLAT'	,	52	,	 'KocaeliKadikoy'	)	,\n" + 
							"(	458	,	 'ŞENOL'	,	 'ŞENGÜLEROĞLU'	,	53	,	 'KonyaKadikoy'	)	,\n" + 
							"(	459	,	 'MURAT'	,	 'ŞENOL'	,	54	,	 'KütahyaKadikoy'	)	,\n" + 
							"(	460	,	 'ORGÜL '	,	 'ÖZDEMİR'	,	55	,	 'MalatyaKadikoy'	)	,\n" + 
							"(	461	,	 'EYLEM'	,	 'KAPÇAK'	,	56	,	 'ManisaKadikoy'	)	,\n" + 
							"(	462	,	 'TÜRKER'	,	 'ŞAHBAZ'	,	57	,	 'MardinKadikoy'	)	,\n" + 
							"(	463	,	 'DERYA'	,	 'YÜKSELMİŞ'	,	58	,	 'MersinKadikoy'	)	,\n" + 
							"(	464	,	 'EMCED'	,	 'DERYA'	,	59	,	 'MuğlaKadikoy'	)	,\n" + 
							"(	465	,	 'TUBA'	,	 'AKKAYA'	,	60	,	 'MuşKadikoy'	)	,\n" + 
							"(	466	,	 'AHMET SERCAN'	,	 'ALTUNÖZ'	,	61	,	 'NevşehirKadikoy'	)	,\n" + 
							"(	467	,	 'DERYA'	,	 'BACAKSIZ'	,	62	,	 'NiğdeKadikoy'	)	,\n" + 
							"(	468	,	 'ŞAHABETTİN'	,	 'CANPOLAT'	,	63	,	 'OrduKadikoy'	)	,\n" + 
							"(	469	,	 'GİZEM'	,	 'DERYA'	,	64	,	 'OsmaniyeKadikoy'	)	,\n" + 
							"(	470	,	 'RIDVAN'	,	 'BAHÇECİ'	,	65	,	 'RizeKadikoy'	)	,\n" + 
							"(	471	,	 'FARUK'	,	 'DERYA'	,	66	,	 'SakaryaKadikoy'	)	,\n" + 
							"(	472	,	 'GÖKÇEN'	,	 'İLBAY'	,	67	,	 'SamsunKadikoy'	)	,\n" + 
							"(	473	,	 'ENGİN'	,	 'SARI'	,	68	,	 'SiirtKadikoy'	)	,\n" + 
							"(	474	,	 'DERYA'	,	 'ABAT'	,	69	,	 'SinopKadikoy'	)	,\n" + 
							"(	475	,	 'FİLİZ'	,	 'DERYA'	,	70	,	 'SivasKadikoy'	)	,\n" + 
							"(	476	,	 'NEZAKET'	,	 'KAN'	,	71	,	 'ŞanlıurfaKadikoy'	)	,\n" + 
							"(	477	,	 'EMEL'	,	 'SEVİNÇ'	,	72	,	 'ŞırnakKadikoy'	)	,\n" + 
							"(	478	,	 'HAKAN'	,	 'GÖDE'	,	73	,	 'TekirdağKadikoy'	)	,\n" + 
							"(	479	,	 'TUNA'	,	 'DURUK'	,	74	,	 'TokatKadikoy'	)	,\n" + 
							"(	480	,	 'TOLGA'	,	 'DERYA'	,	75	,	 'TrabzonKadikoy'	)	,\n" + 
							"(	481	,	 'DERYA'	,	 'ORHAN'	,	76	,	 'TunceliKadikoy'	)	,\n" + 
							"(	482	,	 'DERMAN'	,	 'TOKTAŞ'	,	77	,	 'UşakKadikoy'	)	,\n" + 
							"(	483	,	 'DERYA'	,	 'ALTUN'	,	78	,	 'VanKadikoy'	)	,\n" + 
							"(	484	,	 'ŞENOL'	,	 'ERTÜRK'	,	79	,	 'YalovaKadikoy'	)	,\n" + 
							"(	485	,	 'AZİZ'	,	 'SERT'	,	80	,	 'YozgatKadikoy'	)	,\n" + 
							"(	486	,	 'RAHİME'	,	 'ŞAHİNER'	,	81	,	 'ZonguldakKadikoy'	)	,\n" + 
							"(	487	,	 'PINAR'	,	 'YILMAZ'	,	1	,	 'AdanaKadikoy'	)	,\n" + 
							"(	488	,	 'AYLİA'	,	 'GÖKÇEK'	,	2	,	 'AdıyamanKadikoy'	)	,\n" + 
							"(	489	,	 'RAHİME'	,	 'PARLAK'	,	3	,	 'AfyonkarahisarKadikoy'	)	,\n" + 
							"(	490	,	 'SALİHA'	,	 'İNCEOĞLU'	,	4	,	 'AğrıKadikoy'	)	,\n" + 
							"(	491	,	 'RAHİME'	,	 'SOBAY'	,	5	,	 'AksarayKadikoy'	)	,\n" + 
							"(	492	,	 'SONGÜL'	,	 'KARAKÖK GÜNGÖR'	,	6	,	 'AmasyaKadikoy'	)	,\n" + 
							"(	493	,	 'MEHMET'	,	 'ÇAKMAK'	,	7	,	 'AnkaraKadikoy'	)	,\n" + 
							"(	494	,	 'RAHİME'	,	 'ÖZDEMİR'	,	8	,	 'AntalyaKadikoy'	)	,\n" + 
							"(	495	,	 'AHMET '	,	 'ÖĞÜTMEN KOÇ'	,	9	,	 'ArdahanKadikoy'	)	,\n" + 
							"(	496	,	 'BİNNUR'	,	 'YAKAR'	,	10	,	 'ArtvinKadikoy'	)	,\n" + 
							"(	497	,	 'KÜRŞAD'	,	 'ÖZCAN'	,	11	,	 'AydınKadikoy'	)	,\n" + 
							"(	498	,	 'SÜHEYLA'	,	 'SUVARİ'	,	12	,	 'BalıkesirKadikoy'	)	,\n" + 
							"(	499	,	 'DİDEM'	,	 'SEYREK'	,	13	,	 'BartınKadikoy'	)	,\n" + 
							"(	500	,	 'KÜRŞAD'	,	 'ÖZEN'	,	14	,	 'BatmanKadikoy'	)	,\n" + 
							"(	501	,	 'HAKAN'	,	 'KÜRŞAD'	,	15	,	 'BayburtKadikoy'	)	,\n" + 
							"(	502	,	 'KÜRŞAD'	,	 'TOLU'	,	16	,	 'BilecikKadikoy'	)	,\n" + 
							"(	503	,	 'ŞERİFE YASEMİN'	,	 'EROĞLU'	,	17	,	 'BingölKadikoy'	)	,\n" + 
							"(	504	,	 'HİLAL'	,	 'GÖRMELİ'	,	18	,	 'BitlisKadikoy'	)	,\n" + 
							"(	505	,	 'HAKAN'	,	 'TOKAT'	,	19	,	 'BoluKadikoy'	)	,\n" + 
							"(	506	,	 'GÜLHANIM'	,	 'KÜRŞAD'	,	20	,	 'DenizliKadikoy'	)	,\n" + 
							"(	507	,	 'ÖZLEM'	,	 'KÜRŞAD'	,	21	,	 'BursaKadikoy'	)	,\n" + 
							"(	508	,	 'YUNUS '	,	 'ESMERAY'	,	22	,	 'ÇanakkaleKadikoy'	)	,\n" + 
							"(	509	,	 'KAMERCAN'	,	 'COŞKUNER'	,	23	,	 'ÇankırıKadikoy'	)	,\n" + 
							"(	510	,	 'MEHTAP'	,	 'IŞIK'	,	24	,	 'ÇorumKadikoy'	)	,\n" + 
							"(	511	,	 'EMRE'	,	 'UYGUR'	,	25	,	 'BurdurKadikoy'	)	,\n" + 
							"(	512	,	 'DUYGU'	,	 'SEYHAN'	,	26	,	 'DiyarbakırKadikoy'	)	,\n" + 
							"(	513	,	 'FİLİZ'	,	 'OLGEN'	,	27	,	 'DüzceKadikoy'	)	,\n" + 
							"(	514	,	 'SERKAN'	,	 'ELDEM'	,	28	,	 'EdirneKadikoy'	)	,\n" + 
							"(	515	,	 'EMRE MURAT'	,	 'SALTÜRK'	,	29	,	 'ElazığKadikoy'	)	,\n" + 
							"(	516	,	 'CEMRE'	,	 'GÜRDEMİR'	,	30	,	 'ErzincanKadikoy'	)	,\n" + 
							"(	517	,	 'EDA'	,	 'KAYA'	,	31	,	 'ErzurumKadikoy'	)	,\n" + 
							"(	518	,	 'EMRE'	,	 'AKYOL'	,	32	,	 'EskişehirKadikoy'	)	,\n" + 
							"(	519	,	 'KORAY'	,	 'ÖZAN SANHAL'	,	33	,	 'GaziantepKadikoy'	)	,\n" + 
							"(	520	,	 'NURAY'	,	 'EMRE'	,	34	,	 'GiresunKadikoy'	)	,\n" + 
							"(	521	,	 'FATMA ESİN'	,	 'ÖZCAN'	,	35	,	 'GümüşhaneKadikoy'	)	,\n" + 
							"(	522	,	 'KEMAL'	,	 'SARI'	,	36	,	 'HakkariKadikoy'	)	,\n" + 
							"(	523	,	 'MURAT'	,	 'EMRE'	,	37	,	 'HatayKadikoy'	)	,\n" + 
							"(	524	,	 'HİLAL'	,	 'EMRE'	,	38	,	 'IğdırKadikoy'	)	,\n" + 
							"(	525	,	 'İBRAHİM'	,	 'GERDAN'	,	39	,	 'IspartaKadikoy'	)	,\n" + 
							"(	526	,	 'YELDA'	,	 'AKSÖZ'	,	40	,	 'İstanbulKadikoy'	)	,\n" + 
							"(	527	,	 'FÜSUN'	,	 'TAY'	,	41	,	 'İzmirKadikoy'	)	,\n" + 
							"(	528	,	 'GÜLBERAT'	,	 'BAKAN'	,	42	,	 'KahramanmaraşKadikoy'	)	,\n" + 
							"(	529	,	 'İNANÇ'	,	 'ERASLAN'	,	43	,	 'KarabükKadikoy'	)	,\n" + 
							"(	530	,	 'SÜLEYMAN'	,	 'ATALAY'	,	44	,	 'KaramanKadikoy'	)	,\n" + 
							"(	531	,	 'DİLEK'	,	 'KAPAR'	,	45	,	 'KarsKadikoy'	)	,\n" + 
							"(	532	,	 'NURDAN'	,	 'ALTUNTAŞ'	,	46	,	 'KastamonuKadikoy'	)	,\n" + 
							"(	533	,	 'MUSTAFA'	,	 'ERASLAN'	,	47	,	 'KayseriKadikoy'	)	,\n" + 
							"(	534	,	 'ÖZGÜR'	,	 'ÖZTÜRK'	,	48	,	 'KırıkkaleKadikoy'	)	,\n" + 
							"(	535	,	 'SEMİH'	,	 'KILIÇ'	,	49	,	 'KırklareliKadikoy'	)	,\n" + 
							"(	536	,	 'SALİM'	,	 'ERASLAN'	,	50	,	 'KırşehirKadikoy'	)	,\n" + 
							"(	537	,	 'HATİCE'	,	 'ERASLAN'	,	51	,	 'KilisKadikoy'	)	,\n" + 
							"(	538	,	 'AYŞE'	,	 'ELBÜKEN'	,	52	,	 'KocaeliKadikoy'	)	,\n" + 
							"(	539	,	 'ÖZDEN'	,	 'ŞENCAN'	,	53	,	 'KonyaKadikoy'	)	,\n" + 
							"(	540	,	 'ÖMER FARUK'	,	 'ERASLAN'	,	54	,	 'KütahyaKadikoy'	)	,\n" + 
							"(	541	,	 'AYŞE CEREN'	,	 'ÇEÇEN'	,	55	,	 'MalatyaKadikoy'	)	,\n" + 
							"(	542	,	 'FATİH RIFAT'	,	 'AYDIN'	,	56	,	 'ManisaKadikoy'	)	,\n" + 
							"(	543	,	 'RAMAZAN FERHAD'	,	 'KILAVUZ'	,	57	,	 'MardinKadikoy'	)	,\n" + 
							"(	544	,	 'MUSTAFA'	,	 'AYDIN'	,	58	,	 'MersinKadikoy'	)	,\n" + 
							"(	545	,	 'FUAT'	,	 'AYAS'	,	59	,	 'MuğlaKadikoy'	)	,\n" + 
							"(	546	,	 'VAZİR AKBER'	,	 'SÖZEN'	,	60	,	 'MuşKadikoy'	)	,\n" + 
							"(	547	,	 'NİHAN'	,	 'AYDIN'	,	61	,	 'NevşehirKadikoy'	)	,\n" + 
							"(	548	,	 'HANDE'	,	 'AYDIN'	,	62	,	 'NiğdeKadikoy'	)	,\n" + 
							"(	549	,	 'TOLUNAY'	,	 'AYDIN'	,	63	,	 'OrduKadikoy'	)	,\n" + 
							"(	550	,	 'DİLEK'	,	 'KILIÇ'	,	64	,	 'OsmaniyeKadikoy'	)	,\n" + 
							"(	551	,	 'ESİN'	,	 'TUNCAY'	,	65	,	 'RizeKadikoy'	)	,\n" + 
							"(	552	,	 'AHMET BİLGEHAN'	,	 'DÖNMEZ'	,	66	,	 'SakaryaKadikoy'	)	,\n" + 
							"(	553	,	 'ONUR'	,	 'AYDIN'	,	67	,	 'SamsunKadikoy'	)	,\n" + 
							"(	554	,	 'EBRU'	,	 'AYDIN'	,	68	,	 'SiirtKadikoy'	)	,\n" + 
							"(	555	,	 'MAZLUM'	,	 'GENÇ'	,	69	,	 'SinopKadikoy'	)	,\n" + 
							"(	556	,	 'DİDEM'	,	 'ATILGAN'	,	70	,	 'SivasKadikoy'	)	,\n" + 
							"(	557	,	 'İDRİS BUGRA'	,	 'AYDIN'	,	71	,	 'ŞanlıurfaKadikoy'	)	,\n" + 
							"(	558	,	 'MEHMET'	,	 'AYDIN'	,	72	,	 'ŞırnakKadikoy'	)	,\n" + 
							"(	559	,	 'DENİZ'	,	 'AYDIN'	,	73	,	 'TekirdağKadikoy'	)	,\n" + 
							"(	560	,	 'EMRE'	,	 'PEYNİRCİ'	,	74	,	 'TokatKadikoy'	)	,\n" + 
							"(	561	,	 'CAN'	,	 'ÇELEN'	,	75	,	 'TrabzonKadikoy'	)	,\n" + 
							"(	562	,	 'NAİL'	,	 'GÜL ÖZMEN'	,	76	,	 'TunceliKadikoy'	)	,\n" + 
							"(	563	,	 'YAVUZ SELİM'	,	 'KARAİSMAİLOĞLU'	,	77	,	 'UşakKadikoy'	)	,\n" + 
							"(	564	,	 'AHMET CAN'	,	 'AYDIN UÇAR'	,	78	,	 'VanKadikoy'	)	,\n" + 
							"(	565	,	 'ZEYNEP'	,	 'AKKOYUNLU'	,	79	,	 'YalovaKadikoy'	)	,\n" + 
							"(	566	,	 'SERPİL'	,	 'NADASTEPE'	,	80	,	 'YozgatKadikoy'	)	,\n" + 
							"(	567	,	 'FEYZAHAN'	,	 'KARAİSMAİLOĞLU'	,	81	,	 'ZonguldakKadikoy'	)	,\n" + 
							"(	568	,	 'HALİL İBRAHİM'	,	 'İNCİ KENAR'	,	1	,	 'AdanaKadikoy'	)	,\n" + 
							"(	569	,	 'HÜMEYRA'	,	 'BAL'	,	2	,	 'AdıyamanKadikoy'	)	,\n" + 
							"(	570	,	 'EMRE'	,	 'DEMİRER'	,	3	,	 'AfyonkarahisarKadikoy'	)	,\n" + 
							"(	571	,	 'EMCED'	,	 'ÖZKAN'	,	4	,	 'AğrıKadikoy'	)	,\n" + 
							"(	572	,	 'MUSTAFA'	,	 'BEREKATOĞLU'	,	5	,	 'AksarayKadikoy'	)	,\n" + 
							"(	573	,	 'ALEVTİNA'	,	 'TAŞAR'	,	6	,	 'AmasyaKadikoy'	)	,\n" + 
							"(	574	,	 'MESUDE'	,	 'KOCA'	,	7	,	 'AnkaraKadikoy'	)	,\n" + 
							"(	575	,	 'İTİBAR'	,	 'ZAİM'	,	8	,	 'AntalyaKadikoy'	)	,\n" + 
							"(	576	,	 'HALİL'	,	 'TÜRKMEN ALBAYRAK'	,	9	,	 'ArdahanKadikoy'	)	,\n" + 
							"(	577	,	 'KEMAL KÜRŞAT'	,	 'VURGAN'	,	10	,	 'ArtvinKadikoy'	)	,\n" + 
							"(	578	,	 'CEM'	,	 'BAHÇECİ'	,	11	,	 'AydınKadikoy'	)	,\n" + 
							"(	579	,	 'MEHMET'	,	 'YURTDAŞ'	,	12	,	 'BalıkesirKadikoy'	)	,\n" + 
							"(	580	,	 'MUSTAFA BUĞRA'	,	 'KARA'	,	13	,	 'BartınKadikoy'	)	,\n" + 
							"(	581	,	 'BENGÜHAN'	,	 'ALTINSOY'	,	14	,	 'BatmanKadikoy'	)	,\n" + 
							"(	582	,	 'FUNDA'	,	 'ÖZGÜR'	,	15	,	 'BayburtKadikoy'	)	,\n" + 
							"(	583	,	 'BİNNUR'	,	 'ARSLAN'	,	16	,	 'BilecikKadikoy'	)	,\n" + 
							"(	584	,	 'FEVZİ FIRAT'	,	 'ARACI'	,	17	,	 'BingölKadikoy'	)	,\n" + 
							"(	585	,	 'TOLGAHAN'	,	 'POLAT'	,	18	,	 'BitlisKadikoy'	)	,\n" + 
							"(	586	,	 'AYŞEGÜL'	,	 'GÜLENAY SÜMER'	,	19	,	 'BoluKadikoy'	)	,\n" + 
							"(	587	,	 'GÜNEŞ'	,	 'DEMİRCAN'	,	20	,	 'DenizliKadikoy'	)	,\n" + 
							"(	588	,	 'VEDAT'	,	 'SEZEN'	,	21	,	 'BursaKadikoy'	)	,\n" + 
							"(	589	,	 'HASAN'	,	 'GÖKTEPE'	,	22	,	 'ÇanakkaleKadikoy'	)	,\n" + 
							"(	590	,	 'SEDA'	,	 'KARADAĞ'	,	23	,	 'ÇankırıKadikoy'	)	,\n" + 
							"(	591	,	 'ŞERİFE EZGİ'	,	 'YANCAR'	,	24	,	 'ÇorumKadikoy'	)	,\n" + 
							"(	592	,	 'EMRAH KEMAL'	,	 'KARAİSMAİLOĞLU'	,	25	,	 'BurdurKadikoy'	)	,\n" + 
							"(	593	,	 'MELİA'	,	 'KARAİSMAİLOĞLU'	,	26	,	 'DiyarbakırKadikoy'	)	,\n" + 
							"(	594	,	 'MAHMUT'	,	 'ÇİTİL'	,	27	,	 'DüzceKadikoy'	)	,\n" + 
							"(	595	,	 'DENİZ'	,	 'KARAİSMAİLOĞLU'	,	28	,	 'EdirneKadikoy'	)	,\n" + 
							"(	596	,	 'EMRAH'	,	 'ZAİM'	,	29	,	 'ElazığKadikoy'	)	,\n" + 
							"(	597	,	 'OSMAN'	,	 'ÖZAN SANHAL'	,	30	,	 'ErzincanKadikoy'	)	,\n" + 
							"(	598	,	 'ALİ SAİP'	,	 'KANNECİ'	,	31	,	 'ErzurumKadikoy'	)	,\n" + 
							"(	599	,	 'FATMA'	,	 'EROĞLU'	,	32	,	 'EskişehirKadikoy'	)	,\n" + 
							"(	600	,	 'MEHMET '	,	 'ŞAHİN'	,	33	,	 'GaziantepKadikoy'	)	,\n" + 
							"(	601	,	 'RIFAT'	,	 'BÖYÜK'	,	34	,	 'GiresunKadikoy'	)	,\n" + 
							"(	602	,	 'SELAHATTİN'	,	 'ÇELİK'	,	35	,	 'GümüşhaneKadikoy'	)	,\n" + 
							"(	603	,	 'EVREN'	,	 'KAYABAŞ'	,	36	,	 'HakkariKadikoy'	)	,\n" + 
							"(	604	,	 'SERPİL'	,	 '1'	,	37	,	 'HatayKadikoy'	)	,\n" + 
							"(	605	,	 'MEHMET '	,	 'SARIÇİÇEK'	,	38	,	 'IğdırKadikoy'	)	,\n" + 
							"(	606	,	 'İSHAK'	,	 'KOL'	,	39	,	 'IspartaKadikoy'	)	,\n" + 
							"(	607	,	 'ŞİRİN ÖZLEM'	,	 'ŞEN'	,	40	,	 'İstanbulKadikoy'	)	,\n" + 
							"(	608	,	 'ABDULSEMET'	,	 'ÖZDEMİR'	,	41	,	 'İzmirKadikoy'	)	,\n" + 
							"(	609	,	 'ŞİRİN'	,	 'AYDIN'	,	42	,	 'KahramanmaraşKadikoy'	)	,\n" + 
							"(	610	,	 'ŞİRİN '	,	 'BEKAR'	,	43	,	 'KarabükKadikoy'	)	,\n" + 
							"(	611	,	 'ZEHRA'	,	 'ÇETİN'	,	44	,	 'KaramanKadikoy'	)	,\n" + 
							"(	612	,	 'ŞİRİN'	,	 'ZAİM'	,	45	,	 'KarsKadikoy'	)	,\n" + 
							"(	613	,	 'ABDULLAH'	,	 'TOPALKARA'	,	46	,	 'KastamonuKadikoy'	)	,\n" + 
							"(	614	,	 'YASEMİN'	,	 'GÜNDÜZ'	,	47	,	 'KayseriKadikoy'	)	,\n" + 
							"(	615	,	 'BELGİN'	,	 'ÖZKAN'	,	48	,	 'KırıkkaleKadikoy'	)	,\n" + 
							"(	616	,	 'YASEMİN'	,	 'SÖZER'	,	49	,	 'KırklareliKadikoy'	)	,\n" + 
							"(	617	,	 'ARDA'	,	 'YASEMİN'	,	50	,	 'KırşehirKadikoy'	)	,\n" + 
							"(	618	,	 'YASEMİN'	,	 'BAYAM'	,	51	,	 'KilisKadikoy'	)	,\n" + 
							"(	619	,	 'ŞEYMA'	,	 'ÖZDEMİR'	,	52	,	 'KocaeliKadikoy'	)	,\n" + 
							"(	620	,	 'YASEMİN'	,	 'AKAY'	,	53	,	 'KonyaKadikoy'	)	,\n" + 
							"(	621	,	 'SAMET'	,	 'YASEMİN'	,	54	,	 'KütahyaKadikoy'	)	,\n" + 
							"(	622	,	 'YASEMİN'	,	 'TEMİZ'	,	55	,	 'MalatyaKadikoy'	)	,\n" + 
							"(	623	,	 'GÜLSÜM'	,	 'EŞFER'	,	56	,	 'ManisaKadikoy'	)	,\n" + 
							"(	624	,	 'KADİR'	,	 'YASEMİN'	,	57	,	 'MardinKadikoy'	)	,\n" + 
							"(	625	,	 'ÜMRAN'	,	 'YILDIZOĞLU'	,	58	,	 'MersinKadikoy'	)	,\n" + 
							"(	626	,	 'AYDIN'	,	 'İZGİ'	,	59	,	 'MuğlaKadikoy'	)	,\n" + 
							"(	627	,	 'ABDÜL'	,	 'ÜMRAN'	,	60	,	 'MuşKadikoy'	)	,\n" + 
							"(	628	,	 'BAYRAM'	,	 'BOLSOY'	,	61	,	 'NevşehirKadikoy'	)	,\n" + 
							"(	629	,	 'SAMET'	,	 'KARADEMİR'	,	62	,	 'NiğdeKadikoy'	)	,\n" + 
							"(	630	,	 'İSMAİL'	,	 'GÜNDÜZ'	,	63	,	 'OrduKadikoy'	)	,\n" + 
							"(	631	,	 'SEZİN'	,	 'SAMET'	,	64	,	 'OsmaniyeKadikoy'	)	,\n" + 
							"(	632	,	 'SEHER ÖZLEM'	,	 'KARA'	,	65	,	 'RizeKadikoy'	)	,\n" + 
							"(	633	,	 'SAMET'	,	 ' KURT'	,	66	,	 'SakaryaKadikoy'	)	,\n" + 
							"(	634	,	 'GAMZE'	,	 'AYDIN'	,	67	,	 'SamsunKadikoy'	)	,\n" + 
							"(	635	,	 'SU'	,	 'ÖZDEMİR'	,	68	,	 'SiirtKadikoy'	)	,\n" + 
							"(	636	,	 'ŞENOL'	,	 'SU'	,	69	,	 'SinopKadikoy'	)	,\n" + 
							"(	637	,	 'ÖMER '	,	 'KOÇER'	,	70	,	 'SivasKadikoy'	)	,\n" + 
							"(	638	,	 'SU'	,	 'SALTÜRK'	,	71	,	 'ŞanlıurfaKadikoy'	)	,\n" + 
							"(	639	,	 'BATURAY SU'	,	 'YAŞAR'	,	72	,	 'ŞırnakKadikoy'	)	,\n" + 
							"(	640	,	 'HATİCE'	,	 'TOPER'	,	73	,	 'TekirdağKadikoy'	)	,\n" + 
							"(	641	,	 'FARUK'	,	 'GÖKÇEK'	,	74	,	 'TokatKadikoy'	)	,\n" + 
							"(	642	,	 'HURİYE'	,	 'CAN'	,	75	,	 'TrabzonKadikoy'	)	,\n" + 
							"(	643	,	 'EMRULLAH'	,	 'FARUK'	,	76	,	 'TunceliKadikoy'	)	,\n" + 
							"(	644	,	 'FATİH'	,	 'BAYRAMOĞLU'	,	77	,	 'UşakKadikoy'	)	,\n" + 
							"(	645	,	 'FARUK'	,	 'ÇİÇEK'	,	78	,	 'VanKadikoy'	)	,\n" + 
							"(	646	,	 'ELİF '	,	 'DOĞAN'	,	79	,	 'YalovaKadikoy'	)	,\n" + 
							"(	647	,	 'MUHAMMED'	,	 'TUĞÇE'	,	80	,	 'YozgatKadikoy'	)	,\n" + 
							"(	648	,	 'SİNAN'	,	 'ÜNAL'	,	81	,	 'ZonguldakKadikoy'	)	,\n" + 
							"(	649	,	 'TUĞÇE '	,	 'DOĞAN'	,	1	,	 'AdanaKayisdagi'	)	,\n" + 
							"(	650	,	 'ÖMER'	,	 'ESEN'	,	2	,	 'AdıyamanKayisdagi'	)	,\n" + 
							"(	651	,	 'SEVİL ALEYNA'	,	 'OCAK'	,	3	,	 'AfyonkarahisarKayisdagi'	)	,\n" + 
							"(	652	,	 'ŞULE'	,	 'KILINÇ'	,	4	,	 'AğrıKayisdagi'	)	,\n" + 
							"(	653	,	 'SERHAN'	,	 'SEVİL'	,	5	,	 'AksarayKayisdagi'	)	,\n" + 
							"(	654	,	 'MUHAMMED'	,	 'ÇEVİRGEN'	,	6	,	 'AmasyaKayisdagi'	)	,\n" + 
							"(	655	,	 'BURAK'	,	 'SEVİL'	,	7	,	 'AnkaraKayisdagi'	)	,\n" + 
							"(	656	,	 'ÖZDEN'	,	 'KARADENİZ'	,	8	,	 'AntalyaKayisdagi'	)	,\n" + 
							"(	657	,	 'SEDAT'	,	 'ÖZDEMİR'	,	9	,	 'ArdahanKayisdagi'	)	,\n" + 
							"(	658	,	 'DERYA'	,	 'ÖZDEN'	,	10	,	 'ArtvinKayisdagi'	)	,\n" + 
							"(	659	,	 'ÖZDEN'	,	 'ŞİMŞEK'	,	11	,	 'AydınKayisdagi'	)	,\n" + 
							"(	660	,	 'AYCAN '	,	 'KARABULUT'	,	12	,	 'BalıkesirKayisdagi'	)	,\n" + 
							"(	661	,	 'BAYRAM'	,	 'KAYA'	,	13	,	 'BartınKayisdagi'	)	,\n" + 
							"(	662	,	 'SÜHEYLA'	,	 ' AKYOL'	,	14	,	 'BatmanKayisdagi'	)	,\n" + 
							"(	663	,	 'MURAT'	,	 'İLGEN'	,	15	,	 'BayburtKayisdagi'	)	,\n" + 
							"(	664	,	 'HİSAR CAN'	,	 'MELEKOĞLU'	,	16	,	 'BilecikKayisdagi'	)	,\n" + 
							"(	665	,	 'SÜRMEN '	,	 'ORHAN'	,	17	,	 'BingölKayisdagi'	)	,\n" + 
							"(	666	,	 'MURAT'	,	 'DÜNDAR'	,	18	,	 'BitlisKayisdagi'	)	,\n" + 
							"(	667	,	 'CAN'	,	 'ALBAY'	,	19	,	 'BoluKayisdagi'	)	,\n" + 
							"(	668	,	 'SEDA'	,	 'CAN'	,	20	,	 'DenizliKayisdagi'	)	,\n" + 
							"(	669	,	 'ESRA'	,	 'DİLLİ'	,	21	,	 'BursaKayisdagi'	)	,\n" + 
							"(	670	,	 'CAN'	,	 'ATBAŞ'	,	22	,	 'ÇanakkaleKayisdagi'	)	,\n" + 
							"(	671	,	 'CAN'	,	 'TOPRAK'	,	23	,	 'ÇankırıKayisdagi'	)	,\n" + 
							"(	672	,	 'YUSUF'	,	 'ÇEPNİ'	,	24	,	 'ÇorumKayisdagi'	)	,\n" + 
							"(	673	,	 'ÖKKEŞ YILMAZ'	,	 'ÇELEN'	,	25	,	 'BurdurKayisdagi'	)	,\n" + 
							"(	674	,	 'NURSEL'	,	 ' MİHRİMAH'	,	26	,	 'DiyarbakırKayisdagi'	)	,\n" + 
							"(	675	,	 'PINAR'	,	 'TOKTAŞ'	,	27	,	 'DüzceKayisdagi'	)	,\n" + 
							"(	676	,	 'SÜRMEN'	,	 'SUCAK'	,	28	,	 'EdirneKayisdagi'	)	,\n" + 
							"(	677	,	 'KADİR'	,	 'ALMALA'	,	29	,	 'ElazığKayisdagi'	)	,\n" + 
							"(	678	,	 'VOLKAN'	,	 'KARADUMAN'	,	30	,	 'ErzincanKayisdagi'	)	,\n" + 
							"(	679	,	 'ALMALA'	,	 'KARA'	,	31	,	 'ErzurumKayisdagi'	)	,\n" + 
							"(	680	,	 'MEHMET'	,	 'KURU'	,	32	,	 'EskişehirKayisdagi'	)	,\n" + 
							"(	681	,	 'TUBA'	,	 'TÜRKSOY'	,	33	,	 'GaziantepKayisdagi'	)	,\n" + 
							"(	682	,	 'SELAMİ'	,	 'GERDAN'	,	34	,	 'GiresunKayisdagi'	)	,\n" + 
							"(	683	,	 'RAMAZAN'	,	 'AKİF'	,	35	,	 'GümüşhaneKayisdagi'	)	,\n" + 
							"(	684	,	 'AKİF'	,	 'ÖZTÜRK'	,	36	,	 'HakkariKayisdagi'	)	,\n" + 
							"(	685	,	 'ŞAHİKA'	,	 'GÜNGÖR'	,	37	,	 'HatayKayisdagi'	)	,\n" + 
							"(	686	,	 'KARAKÖK'	,	 'GÖKTEN'	,	38	,	 'IğdırKayisdagi'	)	,\n" + 
							"(	687	,	 'ÇAĞLA'	,	 'GÖKÇEN'	,	39	,	 'IspartaKayisdagi'	)	,\n" + 
							"(	688	,	 'İLHAN'	,	 'KARAKÖK'	,	40	,	 'İstanbulKayisdagi'	)	,\n" + 
							"(	689	,	 'HAMDİYE'	,	 'YEL'	,	41	,	 'İzmirKayisdagi'	)	,\n" + 
							"(	690	,	 'KARAKÖK'	,	 'EVRENOS'	,	42	,	 'KahramanmaraşKayisdagi'	)	,\n" + 
							"(	691	,	 'BAYRAM'	,	 'KARAKÖK'	,	43	,	 'KarabükKayisdagi'	)	,\n" + 
							"(	692	,	 'BİLAL BARIŞ'	,	 'İNCEOĞLU'	,	44	,	 'KaramanKayisdagi'	)	,\n" + 
							"(	693	,	 'KALENDER'	,	 'ŞAHİN'	,	45	,	 'KarsKayisdagi'	)	,\n" + 
							"(	694	,	 'YURDAGÜL'	,	 'BAYRAMOĞLU'	,	46	,	 'KastamonuKayisdagi'	)	,\n" + 
							"(	695	,	 'EMEL CENNET'	,	 'BARAN'	,	47	,	 'KayseriKayisdagi'	)	,\n" + 
							"(	696	,	 'BESTE'	,	 'TUNÇ'	,	48	,	 'KırıkkaleKayisdagi'	)	,\n" + 
							"(	697	,	 'BULUT'	,	 'BARAN'	,	49	,	 'KırklareliKayisdagi'	)	,\n" + 
							"(	698	,	 'KÜBRA'	,	 'AKDEMİR'	,	50	,	 'KırşehirKayisdagi'	)	,\n" + 
							"(	699	,	 'İBRAHİM'	,	 'YILDIRIM'	,	51	,	 'KilisKayisdagi'	)	,\n" + 
							"(	700	,	 'ŞEYMA'	,	 'DEMİRTÜRK'	,	52	,	 'KocaeliKayisdagi'	)	,\n" + 
							"(	701	,	 'HALİL'	,	 'SALTÜRK'	,	53	,	 'KonyaKayisdagi'	)	,\n" + 
							"(	702	,	 'ERCAN'	,	 'HALİL'	,	54	,	 'KütahyaKayisdagi'	)	,\n" + 
							"(	703	,	 'ÖZGE'	,	 'SOLUK'	,	55	,	 'MalatyaKayisdagi'	)	,\n" + 
							"(	704	,	 'LEMAN'	,	 'ÖZTÜRKERİ'	,	56	,	 'ManisaKayisdagi'	)	,\n" + 
							"(	705	,	 'HATUN'	,	 'KARADAĞ GEÇGEL'	,	57	,	 'MardinKayisdagi'	)	,\n" + 
							"(	706	,	 'FATMA'	,	 'URUÇ'	,	58	,	 'MersinKayisdagi'	)	,\n" + 
							"(	707	,	 'HALİL'	,	 'YEŞİL'	,	59	,	 'MuğlaKayisdagi'	)	,\n" + 
							"(	708	,	 'ERKAN'	,	 'HALİL'	,	60	,	 'MuşKayisdagi'	)	,\n" + 
							"(	709	,	 'HÜSEYİN'	,	 'ESEN'	,	61	,	 'NevşehirKayisdagi'	)	,\n" + 
							"(	710	,	 'ERCAN'	,	 'KAPAR'	,	62	,	 'NiğdeKayisdagi'	)	,\n" + 
							"(	711	,	 'DİANA'	,	 'AKKOYUNLU'	,	63	,	 'OrduKayisdagi'	)	,\n" + 
							"(	712	,	 'YUSUF'	,	 'KALIPCI'	,	64	,	 'OsmaniyeKayisdagi'	)	,\n" + 
							"(	713	,	 'ÖZLEM'	,	 'SEZEN'	,	65	,	 'RizeKayisdagi'	)	,\n" + 
							"(	714	,	 'ERCAN '	,	 'BOLSOY'	,	66	,	 'SakaryaKayisdagi'	)	,\n" + 
							"(	715	,	 'YÜCEL'	,	 'BARAN'	,	67	,	 'SamsunKayisdagi'	)	,\n" + 
							"(	716	,	 'BESTE'	,	 'GERGER'	,	68	,	 'SiirtKayisdagi'	)	,\n" + 
							"(	717	,	 'EVREN'	,	 'AYDIN'	,	69	,	 'SinopKayisdagi'	)	,\n" + 
							"(	718	,	 'MAHMUT '	,	 'DÖNMEZ'	,	70	,	 'SivasKayisdagi'	)	,\n" + 
							"(	719	,	 'ARDA'	,	 'ÖRENÇ'	,	71	,	 'ŞanlıurfaKayisdagi'	)	,\n" + 
							"(	720	,	 'ÖZGÜR'	,	 'ARDA'	,	72	,	 'ŞırnakKayisdagi'	)	,\n" + 
							"(	721	,	 'TAYFUN'	,	 'ÇİLESİZ'	,	73	,	 'TekirdağKayisdagi'	)	,\n" + 
							"(	722	,	 'NEVAL'	,	 'DEMİRDAĞ'	,	74	,	 'TokatKayisdagi'	)	,\n" + 
							"(	723	,	 'CEM'	,	 'ARDA'	,	75	,	 'TrabzonKayisdagi'	)	,\n" + 
							"(	724	,	 'EZGİ '	,	 'YEŞİLDAĞER'	,	76	,	 'TunceliKayisdagi'	)	,\n" + 
							"(	725	,	 'EMİNE'	,	 'TAŞKIRAN'	,	77	,	 'UşakKayisdagi'	)	,\n" + 
							"(	726	,	 'GİZEM'	,	 ' SEZGİN'	,	78	,	 'VanKayisdagi'	)	,\n" + 
							"(	727	,	 'MELİKE'	,	 'GİZEM'	,	79	,	 'YalovaKayisdagi'	)	,\n" + 
							"(	728	,	 'ÖZLEM'	,	 'ÜNAL'	,	80	,	 'YozgatKayisdagi'	)	,\n" + 
							"(	729	,	 'YAVUZ'	,	 'ALBAYRAK'	,	81	,	 'ZonguldakKayisdagi'	)	,\n" + 
							"(	730	,	 'HALİM'	,	 'YAVUZ'	,	1	,	 'AdanaKayisdagi'	)	,\n" + 
							"(	731	,	 'EVRİM'	,	 'SEVİMLİ'	,	2	,	 'AdıyamanKayisdagi'	)	,\n" + 
							"(	732	,	 'YAVUZ'	,	 'KARKIN'	,	3	,	 'AfyonkarahisarKayisdagi'	)	,\n" + 
							"(	733	,	 'MEHMET'	,	 'YAVUZ'	,	4	,	 'AğrıKayisdagi'	)	,\n" + 
							"(	734	,	 'ADİL'	,	 'YILDIZ'	,	5	,	 'AksarayKayisdagi'	)	,\n" + 
							"(	735	,	 'HAMDİ'	,	 ' AKYOL'	,	6	,	 'AmasyaKayisdagi'	)	,\n" + 
							"(	736	,	 'ABDULLAH'	,	 'CANBOLAT'	,	7	,	 'AnkaraKayisdagi'	)	,\n" + 
							"(	737	,	 'NEZİH'	,	 'MERT'	,	8	,	 'AntalyaKayisdagi'	)	,\n" + 
							"(	738	,	 'SÜRMEN'	,	 'DİL'	,	9	,	 'ArdahanKayisdagi'	)	,\n" + 
							"(	739	,	 'MEHMET'	,	 'SÜRMEN'	,	10	,	 'ArtvinKayisdagi'	)	,\n" + 
							"(	740	,	 'CAHİT'	,	 'YILMAZ'	,	11	,	 'AydınKayisdagi'	)	,\n" + 
							"(	741	,	 'SÜRMEN'	,	 'ÇEPNİ'	,	12	,	 'BalıkesirKayisdagi'	)	,\n" + 
							"(	742	,	 'KÜBRA'	,	 'SÜRMEN'	,	13	,	 'BartınKayisdagi'	)	,\n" + 
							"(	743	,	 'CEYDA'	,	 'İNANÇ'	,	14	,	 'BatmanKayisdagi'	)	,\n" + 
							"(	744	,	 'HATİCE'	,	 'TEZER'	,	15	,	 'BayburtKayisdagi'	)	,\n" + 
							"(	745	,	 'MEHMET '	,	 'GENÇDAL'	,	16	,	 'BilecikKayisdagi'	)	,\n" + 
							"(	746	,	 'SEÇİL'	,	 'KILINÇ'	,	17	,	 'BingölKayisdagi'	)	,\n" + 
							"(	747	,	 'FATMA ESİN'	,	 'DEMİRTÜRK'	,	18	,	 'BitlisKayisdagi'	)	,\n" + 
							"(	748	,	 'AKİF'	,	 'EKİZ'	,	19	,	 'BoluKayisdagi'	)	,\n" + 
							"(	749	,	 'EMİNE'	,	 'BATMAZ'	,	20	,	 'DenizliKayisdagi'	)	,\n" + 
							"(	750	,	 'UFUK'	,	 'AKİF'	,	21	,	 'BursaKayisdagi'	)	,\n" + 
							"(	751	,	 'GÖKHAN'	,	 'AKSÖZ'	,	22	,	 'ÇanakkaleKayisdagi'	)	,\n" + 
							"(	752	,	 'VEYSİ'	,	 'DEMİR'	,	23	,	 'ÇankırıKayisdagi'	)	,\n" + 
							"(	753	,	 ' DİLEK'	,	 'ÖZKAYNAR'	,	24	,	 'ÇorumKayisdagi'	)	,\n" + 
							"(	754	,	 'MÜBERRA'	,	 'SALİHA'	,	25	,	 'BurdurKayisdagi'	)	,\n" + 
							"(	755	,	 'BİNNUR'	,	 'AVCI'	,	26	,	 'DiyarbakırKayisdagi'	)	,\n" + 
							"(	756	,	 'SALİHA'	,	 'GÜLEÇ'	,	27	,	 'DüzceKayisdagi'	)	,\n" + 
							"(	757	,	 'SEDAT'	,	 'KASAPOĞLU'	,	28	,	 'EdirneKayisdagi'	)	,\n" + 
							"(	758	,	 'SÜLEYMAN'	,	 'SALİHA'	,	29	,	 'ElazığKayisdagi'	)	,\n" + 
							"(	759	,	 'GAMZE'	,	 'DURAN'	,	30	,	 'ErzincanKayisdagi'	)	,\n" + 
							"(	760	,	 'MUSTAFA '	,	 ' AYGÜN'	,	31	,	 'ErzurumKayisdagi'	)	,\n" + 
							"(	761	,	 'MEHMET'	,	 'PEHLİVAN'	,	32	,	 'EskişehirKayisdagi'	)	,\n" + 
							"(	762	,	 'ÖZAVCI'	,	 'KORUCU'	,	33	,	 'GaziantepKayisdagi'	)	,\n" + 
							"(	763	,	 'İSMAİL'	,	 'NAFİZ'	,	34	,	 'GiresunKayisdagi'	)	,\n" + 
							"(	764	,	 'HASAN'	,	 'YUMURTAŞ'	,	35	,	 'GümüşhaneKayisdagi'	)	,\n" + 
							"(	765	,	 'NAFİZ'	,	 'DOĞAN'	,	36	,	 'HakkariKayisdagi'	)	,\n" + 
							"(	766	,	 'ERCAN'	,	 'NAFİZ'	,	37	,	 'HatayKayisdagi'	)	,\n" + 
							"(	767	,	 'MUSACİDE '	,	 'EMELİ'	,	38	,	 'IğdırKayisdagi'	)	,\n" + 
							"(	768	,	 'İBRAHİM'	,	 'YANIK'	,	39	,	 'IspartaKayisdagi'	)	,\n" + 
							"(	769	,	 'ZEHRA'	,	 'ACAR'	,	40	,	 'İstanbulKayisdagi'	)	,\n" + 
							"(	770	,	 'MELİKE'	,	 'ZEHRA'	,	41	,	 'İzmirKayisdagi'	)	,\n" + 
							"(	771	,	 'KEMAL KÜRŞAT'	,	 'İNSELÖZ'	,	42	,	 'KahramanmaraşKayisdagi'	)	,\n" + 
							"(	772	,	 'ZEHRA HASAN'	,	 'KILIÇ'	,	43	,	 'KarabükKayisdagi'	)	,\n" + 
							"(	773	,	 'ÜLKÜHAN'	,	 'ŞAHİN'	,	44	,	 'KaramanKayisdagi'	)	,\n" + 
							"(	774	,	 'OSMAN'	,	 'ÖZSAYGILI'	,	45	,	 'KarsKayisdagi'	)	,\n" + 
							"(	775	,	 'GİZEM'	,	 'KIZMAZ'	,	46	,	 'KastamonuKayisdagi'	)	,\n" + 
							"(	776	,	 'HASAN SERKAN'	,	 'PEKGÖZ'	,	47	,	 'KayseriKayisdagi'	)	,\n" + 
							"(	777	,	 'MUHAMMED ZEHRA'	,	 'KESKİN'	,	48	,	 'KırıkkaleKayisdagi'	)	,\n" + 
							"(	778	,	 'ÖMER'	,	 'TENEKECİ'	,	49	,	 'KırklareliKayisdagi'	)	,\n" + 
							"(	779	,	 'ZEHRA'	,	 'GÜRPINAR'	,	50	,	 'KırşehirKayisdagi'	)	,\n" + 
							"(	780	,	 'MÜMÜN FATİH'	,	 'YILMAZ'	,	51	,	 'KilisKayisdagi'	)	,\n" + 
							"(	781	,	 'PINAR'	,	 'KARA'	,	52	,	 'KocaeliKayisdagi'	)	,\n" + 
							"(	782	,	 'SERDAR'	,	 'IŞIK'	,	53	,	 'KonyaKayisdagi'	)	,\n" + 
							"(	783	,	 'MUSTAFA'	,	 'GÖKÇEK'	,	54	,	 'KütahyaKayisdagi'	)	,\n" + 
							"(	784	,	 'BERFİN'	,	 'SULTANOĞLU'	,	55	,	 'MalatyaKayisdagi'	)	,\n" + 
							"(	785	,	 'ONUR'	,	 'AYDIN'	,	56	,	 'ManisaKayisdagi'	)	,\n" + 
							"(	786	,	 'FİLİZ'	,	 'KAYA'	,	57	,	 'MardinKayisdagi'	)	,\n" + 
							"(	787	,	 'GÖKAY'	,	 'AYDIN'	,	58	,	 'MersinKayisdagi'	)	,\n" + 
							"(	788	,	 'ÜLKÜHAN'	,	 'GÜLTEKİN'	,	59	,	 'MuğlaKayisdagi'	)	,\n" + 
							"(	789	,	 'ELİF'	,	 'KARACAN'	,	60	,	 'MuşKayisdagi'	)	,\n" + 
							"(	790	,	 'ELİF'	,	 'AYDOĞAN'	,	61	,	 'NevşehirKayisdagi'	)	,\n" + 
							"(	791	,	 'HARUN'	,	 'DEMİR'	,	62	,	 'NiğdeKayisdagi'	)	,\n" + 
							"(	792	,	 'KIVANÇ'	,	 'ŞENCAN'	,	63	,	 'OrduKayisdagi'	)	,\n" + 
							"(	793	,	 'HANDE'	,	 'ASLAN'	,	64	,	 'OsmaniyeKayisdagi'	)	,\n" + 
							"(	794	,	 'HİLAL'	,	 'GÜNDOĞDU'	,	65	,	 'RizeKayisdagi'	)	,\n" + 
							"(	795	,	 'RAHMİ TUNA'	,	 'DOĞAN'	,	66	,	 'SakaryaKayisdagi'	)	,\n" + 
							"(	796	,	 'NAFİZ'	,	 'TEMURTAŞ'	,	67	,	 'SamsunKayisdagi'	)	,\n" + 
							"(	797	,	 'ZEYNEP'	,	 'BÖYÜK'	,	68	,	 'SiirtKayisdagi'	)	,\n" + 
							"(	798	,	 'AYŞE GİZEM'	,	 'VEZİROĞLU BİRDANE'	,	69	,	 'SinopKayisdagi'	)	,\n" + 
							"(	799	,	 'DİLEK'	,	 'KARAKÖSE'	,	70	,	 'SivasKayisdagi'	)	,\n" + 
							"(	800	,	 'İZZETTİN'	,	 'SEVİNGİL'	,	71	,	 'ŞanlıurfaKayisdagi'	)	,\n" + 
							"(	801	,	 'ZEHRA'	,	 'SÖZEN'	,	72	,	 'ŞırnakKayisdagi'	)	,\n" + 
							"(	802	,	 'DİLEK'	,	 'GAZİ'	,	73	,	 'TekirdağKayisdagi'	)	,\n" + 
							"(	803	,	 'YASEMİN'	,	 'SÜMER'	,	74	,	 'TokatKayisdagi'	)	,\n" + 
							"(	804	,	 'SERDAR'	,	 'EROĞLU'	,	75	,	 'TrabzonKayisdagi'	)	,\n" + 
							"(	805	,	 'GÖKÇE'	,	 'SERİN'	,	76	,	 'TunceliKayisdagi'	)	,\n" + 
							"(	806	,	 'ELİFCAN'	,	 'AYDIN'	,	77	,	 'UşakKayisdagi'	)	,\n" + 
							"(	807	,	 'DENİZ'	,	 'AKTAŞ'	,	78	,	 'VanKayisdagi'	)	,\n" + 
							"(	808	,	 'FATİH'	,	 'DURÇ ÖZTÜRK'	,	79	,	 'YalovaKayisdagi'	)	,\n" + 
							"(	809	,	 'CAHİT'	,	 'VURAL'	,	80	,	 'YozgatKayisdagi'	)	,\n" + 
							"(	810	,	 'RAMAZAN'	,	 'IŞIK'	,	81	,	 'ZonguldakKayisdagi'	)	,\n" + 
							"(	811	,	 'HASAN'	,	 'BARIŞAN'	,	1	,	 'AdanaKayisdagi'	)	,\n" + 
							"(	812	,	 'NİLAY'	,	 'ÇİTİL'	,	2	,	 'AdıyamanKayisdagi'	)	,\n" + 
							"(	813	,	 'SELCEN'	,	 'KAYA'	,	3	,	 'AfyonkarahisarKayisdagi'	)	,\n" + 
							"(	814	,	 'DERYA'	,	 'BALAL'	,	4	,	 'AğrıKayisdagi'	)	,\n" + 
							"(	815	,	 'MUSTAFA ALİCAN'	,	 'TAŞ'	,	5	,	 'AksarayKayisdagi'	)	,\n" + 
							"(	816	,	 'YUSUF'	,	 'ÇEKİÇ'	,	6	,	 'AmasyaKayisdagi'	)	,\n" + 
							"(	817	,	 'BURCU'	,	 'KANNECİ'	,	7	,	 'AnkaraKayisdagi'	)	,\n" + 
							"(	818	,	 'GÖKHAN'	,	 'KILINÇ'	,	8	,	 'AntalyaKayisdagi'	)	,\n" + 
							"(	819	,	 'MUSTAFA'	,	 'KUMBUL'	,	9	,	 'ArdahanKayisdagi'	)	,\n" + 
							"(	820	,	 'MUSTAFA'	,	 'GÜNDÜZ'	,	10	,	 'ArtvinKayisdagi'	)	,\n" + 
							"(	821	,	 'İBRAHİM BARIŞ'	,	 'ALBOĞA'	,	11	,	 'AydınKayisdagi'	)	,\n" + 
							"(	822	,	 'TUĞRUL'	,	 'UYSAL'	,	12	,	 'BalıkesirKayisdagi'	)	,\n" + 
							"(	823	,	 'SEVGİ'	,	 'TÜRE'	,	13	,	 'BartınKayisdagi'	)	,\n" + 
							"(	824	,	 'MERVE'	,	 'FİLİZ'	,	14	,	 'BatmanKayisdagi'	)	,\n" + 
							"(	825	,	 'NESLİHAN'	,	 'GELEGEN'	,	15	,	 'BayburtKayisdagi'	)	,\n" + 
							"(	826	,	 'OĞUZ KAĞAN'	,	 'ÇAĞIL'	,	16	,	 'BilecikKayisdagi'	)	,\n" + 
							"(	827	,	 'BARIŞ'	,	 'ŞENCAN'	,	17	,	 'BingölKayisdagi'	)	,\n" + 
							"(	828	,	 'HAMZA'	,	 'İVACIK'	,	18	,	 'BitlisKayisdagi'	)	,\n" + 
							"(	829	,	 'HİSAR CAN'	,	 'ÜNAL'	,	19	,	 'BoluKayisdagi'	)	,\n" + 
							"(	830	,	 'NAGİHAN'	,	 'ÇETİNTAŞ'	,	20	,	 'DenizliKayisdagi'	)	,\n" + 
							"(	831	,	 'YUSUF'	,	 'DURMUŞ'	,	21	,	 'BursaKayisdagi'	)	,\n" + 
							"(	832	,	 'EMRE'	,	 'KARAKILIÇ'	,	22	,	 'ÇanakkaleKayisdagi'	)	,\n" + 
							"(	833	,	 'EMİNE'	,	 'YILMAZ'	,	23	,	 'ÇankırıKayisdagi'	)	,\n" + 
							"(	834	,	 'ZÜLFİYE'	,	 'AKGÜL'	,	24	,	 'ÇorumKayisdagi'	)	,\n" + 
							"(	835	,	 'YILDIZ'	,	 'OĞUZ'	,	25	,	 'BurdurKayisdagi'	)	,\n" + 
							"(	836	,	 'SUNA'	,	 'KURTPINAR'	,	26	,	 'DiyarbakırKayisdagi'	)	,\n" + 
							"(	837	,	 'PELİN'	,	 'YILDIZ'	,	27	,	 'DüzceKayisdagi'	)	,\n" + 
							"(	838	,	 'SALMAN'	,	 'SONAY'	,	28	,	 'EdirneKayisdagi'	)	,\n" + 
							"(	839	,	 'ASLI'	,	 'KOCA'	,	29	,	 'ElazığKayisdagi'	)	,\n" + 
							"(	840	,	 'YENER'	,	 'TOPAK'	,	30	,	 'ErzincanKayisdagi'	)	,\n" + 
							"(	841	,	 'YİĞİT'	,	 'KILIÇ'	,	31	,	 'ErzurumKayisdagi'	)	,\n" + 
							"(	842	,	 'ABDULSEMET'	,	 'KAHRAMAN'	,	32	,	 'EskişehirKayisdagi'	)	,\n" + 
							"(	843	,	 'HALUK'	,	 'KILIÇ'	,	33	,	 'GaziantepKayisdagi'	)	,\n" + 
							"(	844	,	 'HAMZA'	,	 'KABAKUŞ'	,	34	,	 'GiresunKayisdagi'	)	,\n" + 
							"(	845	,	 'MURAT'	,	 'TİKİCİ'	,	35	,	 'GümüşhaneKayisdagi'	)	,\n" + 
							"(	846	,	 'ÖMER'	,	 'BAYRAMOĞLU'	,	36	,	 'HakkariKayisdagi'	)	,\n" + 
							"(	847	,	 'SANEM GÖKÇEN MERVE'	,	 'YURTDAŞ'	,	37	,	 'HatayKayisdagi'	)	,\n" + 
							"(	848	,	 'FERİDE'	,	 'DURSUN'	,	38	,	 'IğdırKayisdagi'	)	,\n" + 
							"(	849	,	 'REFİK'	,	 'MÜEZZİNOĞLU'	,	39	,	 'IspartaKayisdagi'	)	,\n" + 
							"(	850	,	 'EYÜP'	,	 'BAL'	,	40	,	 'İstanbulKayisdagi'	)	,\n" + 
							"(	851	,	 'ÖMER'	,	 'ÇELİK'	,	41	,	 'İzmirKayisdagi'	)	,\n" + 
							"(	852	,	 'ELİF'	,	 'ÇAKMAK'	,	42	,	 'KahramanmaraşKayisdagi'	)	,\n" + 
							"(	853	,	 'VEYSEL'	,	 'KAYA'	,	43	,	 'KarabükKayisdagi'	)	,\n" + 
							"(	854	,	 'BÜLENT'	,	 'DOKUMACIOĞLU'	,	44	,	 'KaramanKayisdagi'	)	,\n" + 
							"(	855	,	 'UĞUR'	,	 'KARAKAŞ'	,	45	,	 'KarsKayisdagi'	)	,\n" + 
							"(	856	,	 'AYŞE GİZEM'	,	 'KARAGÖZ'	,	46	,	 'KastamonuKayisdagi'	)	,\n" + 
							"(	857	,	 'ZEHRA BETÜL'	,	 'ÇAĞLAR'	,	47	,	 'KayseriKayisdagi'	)	,\n" + 
							"(	858	,	 'ASLIHAN ESRA'	,	 'AKDEMİR'	,	48	,	 'KırıkkaleKayisdagi'	)	,\n" + 
							"(	859	,	 'DERYA SEMA'	,	 'SÖZEN'	,	49	,	 'KırklareliKayisdagi'	)	,\n" + 
							"(	860	,	 'VOLKAN'	,	 'SAVRAN'	,	50	,	 'KırşehirKayisdagi'	)	,\n" + 
							"(	861	,	 'SEHER'	,	 'YILMAZ'	,	51	,	 'KilisKayisdagi'	)	,\n" + 
							"(	862	,	 'YÜKSEL UĞUR'	,	 'KHALİL'	,	52	,	 'KocaeliKayisdagi'	)	,\n" + 
							"(	863	,	 'NESRİN'	,	 'BOZPOLAT'	,	53	,	 'KonyaKayisdagi'	)	,\n" + 
							"(	864	,	 'İLKNUR'	,	 'NASUHBEYOĞLU'	,	54	,	 'KütahyaKayisdagi'	)	,\n" + 
							"(	865	,	 'MURAT'	,	 'TÜRKAY'	,	55	,	 'MalatyaKayisdagi'	)	,\n" + 
							"(	866	,	 'ABDULLAH'	,	 'YÜCE'	,	56	,	 'ManisaKayisdagi'	)	,\n" + 
							"(	867	,	 'ERSİN'	,	 'YILDIZ'	,	57	,	 'MardinKayisdagi'	)	,\n" + 
							"(	868	,	 'AYSUN'	,	 'BAYRAM'	,	58	,	 'MersinKayisdagi'	)	,\n" + 
							"(	869	,	 'BİRSEN'	,	 'ÖZDEMİR'	,	59	,	 'MuğlaKayisdagi'	)	,\n" + 
							"(	870	,	 'MEHMET FURKAN'	,	 'KARALAR'	,	60	,	 'MuşKayisdagi'	)	,\n" + 
							"(	871	,	 'MUSTAFA'	,	 'KARASU'	,	61	,	 'NevşehirKayisdagi'	)	,\n" + 
							"(	872	,	 'YETKİN'	,	 'ÖZÜAK'	,	62	,	 'NiğdeKayisdagi'	)	,\n" + 
							"(	873	,	 'MEHTAP'	,	 'YILMAZ'	,	63	,	 'OrduKayisdagi'	)	,\n" + 
							"(	874	,	 'CAFER'	,	 'EREL'	,	64	,	 'OsmaniyeKayisdagi'	)	,\n" + 
							"(	875	,	 'ÖZLEM'	,	 'OMAY'	,	65	,	 'RizeKayisdagi'	)	,\n" + 
							"(	876	,	 'EMRE'	,	 'ÖZKAN'	,	66	,	 'SakaryaKayisdagi'	)	,\n" + 
							"(	877	,	 'SAMİ'	,	 'APAYDIN'	,	67	,	 'SamsunKayisdagi'	)	,\n" + 
							"(	878	,	 'ESİN'	,	 'ÇİLESİZ'	,	68	,	 'SiirtKayisdagi'	)	,\n" + 
							"(	879	,	 'MEHMET AKİF'	,	 'ÇOPUR'	,	69	,	 'SinopKayisdagi'	)	,\n" + 
							"(	880	,	 'ŞEYMA'	,	 'AKTAŞ'	,	70	,	 'SivasKayisdagi'	)	,\n" + 
							"(	881	,	 'HÜSEYİN'	,	 'ÇELİKER'	,	71	,	 'ŞanlıurfaKayisdagi'	)	,\n" + 
							"(	882	,	 'GAMZE'	,	 'DİL'	,	72	,	 'ŞırnakKayisdagi'	)	,\n" + 
							"(	883	,	 'YURDUN'	,	 'ÖZDEMİR'	,	73	,	 'TekirdağKayisdagi'	)	,\n" + 
							"(	884	,	 'ASLIHAN'	,	 'ÜNÜVAR'	,	74	,	 'TokatKayisdagi'	)	,\n" + 
							"(	885	,	 'ŞADİ'	,	 'TAŞMALI'	,	75	,	 'TrabzonKayisdagi'	)	,\n" + 
							"(	886	,	 'TUFAN AKIN'	,	 'AYDIN'	,	76	,	 'TunceliKayisdagi'	)	,\n" + 
							"(	887	,	 'DAMLA'	,	 'ÇOBANYILDIZI'	,	77	,	 'UşakKayisdagi'	)	,\n" + 
							"(	888	,	 'BENGÜ'	,	 'ŞAHİN'	,	78	,	 'VanKayisdagi'	)	,\n" + 
							"(	889	,	 'MEHMET'	,	 'TUNÇ'	,	79	,	 'YalovaKayisdagi'	)	,\n" + 
							"(	890	,	 'MUSTAFA'	,	 'BURULDAY'	,	80	,	 'YozgatKayisdagi'	)	,\n" + 
							"(	891	,	 'ZELİHA'	,	 'IŞIKLI'	,	81	,	 'ZonguldakKayisdagi'	)	,\n" + 
							"(	892	,	 'MEHMET ALİ'	,	 'YARADILMIŞ'	,	1	,	 'AdanaKayisdagi'	)	,\n" + 
							"(	893	,	 'HALUK'	,	 'KAYA'	,	2	,	 'AdıyamanKayisdagi'	)	,\n" + 
							"(	894	,	 'NİHAL'	,	 'ŞİMŞEK'	,	3	,	 'AfyonkarahisarKayisdagi'	)	,\n" + 
							"(	895	,	 'MEHMET'	,	 'OYNAK'	,	4	,	 'AğrıKayisdagi'	)	,\n" + 
							"(	896	,	 'ÖZLEM'	,	 'KEBAPCILAR'	,	5	,	 'AksarayKayisdagi'	)	,\n" + 
							"(	897	,	 'SERHAT'	,	 'AKMEŞE'	,	6	,	 'AmasyaKayisdagi'	)	,\n" + 
							"(	898	,	 'İDRİS BUGRA'	,	 'TOPKARA'	,	7	,	 'AnkaraKayisdagi'	)	,\n" + 
							"(	899	,	 'FAİK'	,	 'AYDIN'	,	8	,	 'AntalyaKayisdagi'	)	,\n" + 
							"(	900	,	 'ATACAN'	,	 'KAYA'	,	9	,	 'ArdahanKayisdagi'	)	,\n" + 
							"(	901	,	 'BURCU'	,	 'BULUÇ'	,	10	,	 'ArtvinKayisdagi'	)	,\n" + 
							"(	902	,	 'MEHMET'	,	 'ŞANLIKAN'	,	11	,	 'AydınKayisdagi'	)	,\n" + 
							"(	903	,	 'ALPER'	,	 'İNCE'	,	12	,	 'BalıkesirKayisdagi'	)	,\n" + 
							"(	904	,	 'BERKAN'	,	 'AVŞAR'	,	13	,	 'BartınKayisdagi'	)	,\n" + 
							"(	905	,	 'MURAT'	,	 'AKDENİZ'	,	14	,	 'BatmanKayisdagi'	)	,\n" + 
							"(	906	,	 'HİDAYET'	,	 'TOPER'	,	15	,	 'BayburtKayisdagi'	)	,\n" + 
							"(	907	,	 'SÜMEYYE'	,	 'YILMAZ'	,	16	,	 'BilecikKayisdagi'	)	,\n" + 
							"(	908	,	 'EMİNE'	,	 'KARAGÖZ'	,	17	,	 'BingölKayisdagi'	)	,\n" + 
							"(	909	,	 'MERVE'	,	 'YÜREK'	,	18	,	 'BitlisKayisdagi'	)	,\n" + 
							"(	910	,	 'MEHMET VEHBİ'	,	 'DEMİR'	,	19	,	 'BoluKayisdagi'	)	,\n" + 
							"(	911	,	 'ŞAHİN'	,	 'AKAY'	,	20	,	 'DenizliKayisdagi'	)	,\n" + 
							"(	912	,	 'EBRU'	,	 'DÖNMEZ'	,	21	,	 'BursaKayisdagi'	)	,\n" + 
							"(	913	,	 'MERVE NUR'	,	 'MENTEŞ'	,	22	,	 'ÇanakkaleKayisdagi'	)	,\n" + 
							"(	914	,	 'İSMAİL EVREN'	,	 'AYKAN'	,	23	,	 'ÇankırıKayisdagi'	)	,\n" + 
							"(	915	,	 'SULTAN'	,	 'DANIŞOĞLU'	,	24	,	 'ÇorumKayisdagi'	)	,\n" + 
							"(	916	,	 'BURAK'	,	 'DEMİR'	,	25	,	 'BurdurKayisdagi'	)	,\n" + 
							"(	917	,	 'KORHAN'	,	 'YAĞCI'	,	26	,	 'DiyarbakırKayisdagi'	)	,\n" + 
							"(	918	,	 'FIRAT'	,	 'BÖLÜK'	,	27	,	 'DüzceKayisdagi'	)	,\n" + 
							"(	919	,	 'RIFAT'	,	 'YAZICI'	,	28	,	 'EdirneKayisdagi'	)	,\n" + 
							"(	920	,	 'KÜBRA'	,	 'BOZAN'	,	29	,	 'ElazığKayisdagi'	)	,\n" + 
							"(	921	,	 'MUHAMMED SAMİ'	,	 'GÜNGÖR'	,	30	,	 'ErzincanKayisdagi'	)	,\n" + 
							"(	922	,	 'VEYSEL'	,	 'TOMBUL'	,	31	,	 'ErzurumKayisdagi'	)	,\n" + 
							"(	923	,	 'TÜLAY'	,	 'FİŞEKCİ'	,	32	,	 'EskişehirKayisdagi'	)	,\n" + 
							"(	924	,	 'EVRİM'	,	 'DÜZCE'	,	33	,	 'GaziantepKayisdagi'	)	,\n" + 
							"(	925	,	 'ZAFER'	,	 'KARAHAN'	,	34	,	 'GiresunKayisdagi'	)	,\n" + 
							"(	926	,	 'SERKAN'	,	 'KAYA'	,	35	,	 'GümüşhaneKayisdagi'	)	,\n" + 
							"(	927	,	 'SEMİH'	,	 'DEMİR'	,	36	,	 'HakkariKayisdagi'	)	,\n" + 
							"(	928	,	 'ŞÜKRÜ'	,	 'YILMAZ'	,	37	,	 'HatayKayisdagi'	)	,\n" + 
							"(	929	,	 'BÜLENT'	,	 'ERDOĞAN'	,	38	,	 'IğdırKayisdagi'	)	,\n" + 
							"(	930	,	 'ERDAL'	,	 'ŞİMŞEK'	,	39	,	 'IspartaKayisdagi'	)	,\n" + 
							"(	931	,	 'NESRİN'	,	 'TÜRE'	,	40	,	 'İstanbulKayisdagi'	)	,\n" + 
							"(	932	,	 'MUSTAFA GÜVENÇ'	,	 'SEZEN'	,	41	,	 'İzmirKayisdagi'	)	,\n" + 
							"(	933	,	 'BEKİR'	,	 'VURGAN'	,	42	,	 'KahramanmaraşKayisdagi'	)	,\n" + 
							"(	934	,	 'MARUF'	,	 'BATGİ AZARKAN'	,	43	,	 'KarabükKayisdagi'	)	,\n" + 
							"(	935	,	 'ÖMER FARUK'	,	 'BAKLACI'	,	44	,	 'KaramanKayisdagi'	)	,\n" + 
							"(	936	,	 'EMRE'	,	 'TAN'	,	45	,	 'KarsKayisdagi'	)	,\n" + 
							"(	937	,	 'HİDİR'	,	 'DEMİRTAŞ'	,	46	,	 'KastamonuKayisdagi'	)	,\n" + 
							"(	938	,	 'EMEL CENNET'	,	 'SEZER'	,	47	,	 'KayseriKayisdagi'	)	,\n" + 
							"(	939	,	 'CEREN'	,	 'GÖKMEYDAN'	,	48	,	 'KırıkkaleKayisdagi'	)	,\n" + 
							"(	940	,	 'MUSTAFA'	,	 'KOLUŞ'	,	49	,	 'KırklareliKayisdagi'	)	,\n" + 
							"(	941	,	 'DİNÇER AYDIN'	,	 'KANNECİ'	,	50	,	 'KırşehirKayisdagi'	)	,\n" + 
							"(	942	,	 'DERYA SEMA'	,	 'GÖRKEM'	,	51	,	 'KilisKayisdagi'	)	,\n" + 
							"(	943	,	 'MUSTAFA KEMAL'	,	 'ARIKBOĞA'	,	52	,	 'KocaeliKayisdagi'	)	,\n" + 
							"(	944	,	 'MELDA'	,	 'GÜLENAY SÜMER'	,	53	,	 'KonyaKayisdagi'	)	,\n" + 
							"(	945	,	 'MURAT'	,	 'ATEŞ'	,	54	,	 'KütahyaKayisdagi'	)	,\n" + 
							"(	946	,	 'SERKAN FAZLI'	,	 'ERDOĞAN'	,	55	,	 'MalatyaKayisdagi'	)	,\n" + 
							"(	947	,	 'NEŞE'	,	 'ATILGAN'	,	56	,	 'ManisaKayisdagi'	)	,\n" + 
							"(	948	,	 'HATİCE'	,	 'IŞIKLI'	,	57	,	 'MardinKayisdagi'	)	,\n" + 
							"(	949	,	 'AHMET CEVDET'	,	 'ŞENCAN'	,	58	,	 'MersinKayisdagi'	)	,\n" + 
							"(	950	,	 'ELZEM'	,	 'ARARAT'	,	59	,	 'MuğlaKayisdagi'	)	,\n" + 
							"(	951	,	 'GÜLAY'	,	 'KIRAÇ'	,	60	,	 'MuşKayisdagi'	)	,\n" + 
							"(	952	,	 'EMEL'	,	 'BARÇA'	,	61	,	 'NevşehirKayisdagi'	)	,\n" + 
							"(	953	,	 'ÖMER AYKUT'	,	 'BARAN'	,	62	,	 'NiğdeKayisdagi'	)	,\n" + 
							"(	954	,	 'AHMET'	,	 'YILDIRIM'	,	63	,	 'OrduKayisdagi'	)	,\n" + 
							"(	955	,	 'UTKU'	,	 'EVRENOS'	,	64	,	 'OsmaniyeKayisdagi'	)	,\n" + 
							"(	956	,	 'OKTAY'	,	 'BOZPOLAT'	,	65	,	 'RizeKayisdagi'	)	,\n" + 
							"(	957	,	 'COŞKUN'	,	 'DİRİCAN'	,	66	,	 'SakaryaKayisdagi'	)	,\n" + 
							"(	958	,	 'HALİL'	,	 'MENEKŞE'	,	67	,	 'SamsunKayisdagi'	)	,\n" + 
							"(	959	,	 'İLKER'	,	 'ATALAY'	,	68	,	 'SiirtKayisdagi'	)	,\n" + 
							"(	960	,	 'ETHEM'	,	 'DADALI'	,	69	,	 'SinopKayisdagi'	)	,\n" + 
							"(	961	,	 'İBRAHİM'	,	 'MERHAMETSİZ'	,	70	,	 'SivasKayisdagi'	)	,\n" + 
							"(	962	,	 'ŞENAY'	,	 'AKKAYA'	,	71	,	 'ŞanlıurfaKayisdagi'	)	,\n" + 
							"(	963	,	 'DİLEK'	,	 'KIR'	,	72	,	 'ŞırnakKayisdagi'	)	,\n" + 
							"(	964	,	 'AYSUN'	,	 'TUNÇ'	,	73	,	 'TekirdağKayisdagi'	)	,\n" + 
							"(	965	,	 'KAMERCAN'	,	 'DEĞİRMENCİ AKAR'	,	74	,	 'TokatKayisdagi'	)	,\n" + 
							"(	966	,	 'YUSUF'	,	 'PAKSOY'	,	75	,	 'TrabzonKayisdagi'	)	,\n" + 
							"(	967	,	 'SUNA'	,	 'SADIÇ'	,	76	,	 'TunceliKayisdagi'	)	,\n" + 
							"(	968	,	 'ERSEN'	,	 'KARAGÖZ'	,	77	,	 'UşakKayisdagi'	)	,\n" + 
							"(	969	,	 'FAİK'	,	 'OĞUZ'	,	78	,	 'VanKayisdagi'	)	,\n" + 
							"(	970	,	 'AYBÜKE'	,	 'TUNÇ'	,	79	,	 'YalovaKayisdagi'	)	,\n" + 
							"(	971	,	 'EMEL'	,	 'ÖZMUK'	,	80	,	 'YozgatKayisdagi'	)	,\n" + 
							"(	972	,	 'GÖZDE'	,	 'USLUSOY'	,	81	,	 'ZonguldakKayisdagi'	)	,\n" + 
							"(	973	,	 'HANDE'	,	 'GÖKTEN'	,	1	,	 'AdanaUmraniye'	)	,\n" + 
							"(	974	,	 'NURAY'	,	 'ÇİÇEK'	,	2	,	 'AdıyamanUmraniye'	)	,\n" + 
							"(	975	,	 'ARZU'	,	 'AYDOĞAN'	,	3	,	 'AfyonkarahisarUmraniye'	)	,\n" + 
							"(	976	,	 'REMZİYE'	,	 'GÜLTEKİN'	,	4	,	 'AğrıUmraniye'	)	,\n" + 
							"(	977	,	 'ÖZGÜR'	,	 'BALCI'	,	5	,	 'AksarayUmraniye'	)	,\n" + 
							"(	978	,	 'ZEHRA'	,	 'GÜLBAHAR'	,	6	,	 'AmasyaUmraniye'	)	,\n" + 
							"(	979	,	 'MERVE'	,	 'GÖKSEL'	,	7	,	 'AnkaraUmraniye'	)	,\n" + 
							"(	980	,	 'SEMA'	,	 'ÇAVLI'	,	8	,	 'AntalyaUmraniye'	)	,\n" + 
							"(	981	,	 'TAYLAN'	,	 'CAN'	,	9	,	 'ArdahanUmraniye'	)	,\n" + 
							"(	982	,	 'NURULLAH'	,	 'AYCAN'	,	10	,	 'ArtvinUmraniye'	)	,\n" + 
							"(	983	,	 'ABDULKERİM'	,	 'NASUHBEYOĞLU'	,	11	,	 'AydınUmraniye'	)	,\n" + 
							"(	984	,	 'UFUK'	,	 'TAZEOĞLU'	,	12	,	 'BalıkesirUmraniye'	)	,\n" + 
							"(	985	,	 'LEYLA'	,	 'ÖZBEK'	,	13	,	 'BartınUmraniye'	)	,\n" + 
							"(	986	,	 'NİMET'	,	 'CELTEMEN'	,	14	,	 'BatmanUmraniye'	)	,\n" + 
							"(	987	,	 'FATIMA İLAY'	,	 'KOYUNCU'	,	15	,	 'BayburtUmraniye'	)	,\n" + 
							"(	988	,	 'SAİD'	,	 'OĞUZ'	,	16	,	 'BilecikUmraniye'	)	,\n" + 
							"(	989	,	 'SULTAN'	,	 'YILDIRIM'	,	17	,	 'BingölUmraniye'	)	,\n" + 
							"(	990	,	 'DOĞAN'	,	 'ELÇİ'	,	18	,	 'BitlisUmraniye'	)	,\n" + 
							"(	991	,	 'ZİYA'	,	 'CÖMERT'	,	19	,	 'BoluUmraniye'	)	,\n" + 
							"(	992	,	 'ECE'	,	 'KARAHAN'	,	20	,	 'DenizliUmraniye'	)	,\n" + 
							"(	993	,	 'HÜSEYİN'	,	 'ÜNAL'	,	21	,	 'BursaUmraniye'	)	,\n" + 
							"(	994	,	 'CEM'	,	 'EMELİ'	,	22	,	 'ÇanakkaleUmraniye'	)	,\n" + 
							"(	995	,	 'UFUK'	,	 'DÜZCE'	,	23	,	 'ÇankırıUmraniye'	)	,\n" + 
							"(	996	,	 'EMİNE'	,	 'BAKAN'	,	24	,	 'ÇorumUmraniye'	)	,\n" + 
							"(	997	,	 'SONGÜL'	,	 'AVSEREN'	,	25	,	 'BurdurUmraniye'	)	,\n" + 
							"(	998	,	 'SÜLEYMAN SERDAR'	,	 'TEN'	,	26	,	 'DiyarbakırUmraniye'	)	,\n" + 
							"(	999	,	 'HAÇÇE'	,	 'BAŞDAŞ'	,	27	,	 'DüzceUmraniye'	)	,\n" + 
							"(	1000	,	 'EMİR MURAT'	,	 'BABA'	,	28	,	 'EdirneUmraniye'	)	,\n" + 
							"(	1001	,	 'MERVE'	,	 'KURU'	,	29	,	 'ElazığUmraniye'	)	,\n" + 
							"(	1002	,	 'NİHAL'	,	 'DİKOĞLU'	,	30	,	 'ErzincanUmraniye'	)	,\n" + 
							"(	1003	,	 'HATİCE'	,	 'BERENT'	,	31	,	 'ErzurumUmraniye'	)	,\n" + 
							"(	1004	,	 'ELİF'	,	 'ÖZTÜRK'	,	32	,	 'EskişehirUmraniye'	)	,\n" + 
							"(	1005	,	 'NESLİHAN'	,	 'GÖKTAŞ'	,	33	,	 'GaziantepUmraniye'	)	,\n" + 
							"(	1006	,	 'İRFAN'	,	 'GÜZEL'	,	34	,	 'GiresunUmraniye'	)	,\n" + 
							"(	1007	,	 'DAMLA'	,	 'İNSELÖZ'	,	35	,	 'GümüşhaneUmraniye'	)	,\n" + 
							"(	1008	,	 'AHMET'	,	 'ERSOY'	,	36	,	 'HakkariUmraniye'	)	,\n" + 
							"(	1009	,	 'SELAHATTİN'	,	 'GÜVEN'	,	37	,	 'HatayUmraniye'	)	,\n" + 
							"(	1010	,	 'MUZAFFER OĞUZ'	,	 'KURALAY'	,	38	,	 'IğdırUmraniye'	)	,\n" + 
							"(	1011	,	 'CİHAN'	,	 'ELBÜKEN'	,	39	,	 'IspartaUmraniye'	)	,\n" + 
							"(	1012	,	 'ÖMÜR'	,	 'SAKA'	,	40	,	 'İstanbulUmraniye'	)	,\n" + 
							"(	1013	,	 'CEM'	,	 'ÖZBEK'	,	41	,	 'İzmirUmraniye'	)	,\n" + 
							"(	1014	,	 'BETÜL'	,	 'GÜNEŞ'	,	42	,	 'KahramanmaraşUmraniye'	)	,\n" + 
							"(	1015	,	 'HÜSEYİN'	,	 'GÜLENAY SÜMER'	,	43	,	 'KarabükUmraniye'	)	,\n" + 
							"(	1016	,	 'GÜLŞAH'	,	 'YILDIZ'	,	44	,	 'KaramanUmraniye'	)	,\n" + 
							"(	1017	,	 'MUSTAFA'	,	 'ATEŞ'	,	45	,	 'KarsUmraniye'	)	,\n" + 
							"(	1018	,	 'FATİH AVNİ'	,	 'SUCAK'	,	46	,	 'KastamonuUmraniye'	)	,\n" + 
							"(	1019	,	 'İBRAHİM'	,	 'ÇAĞLAR'	,	47	,	 'KayseriUmraniye'	)	,\n" + 
							"(	1020	,	 'CİHAN'	,	 'TEN'	,	48	,	 'KırıkkaleUmraniye'	)	,\n" + 
							"(	1021	,	 'ÇAĞDAŞ'	,	 'YÜCEL'	,	49	,	 'KırklareliUmraniye'	)	,\n" + 
							"(	1022	,	 'OKAN'	,	 'PULAT'	,	50	,	 'KırşehirUmraniye'	)	,\n" + 
							"(	1023	,	 'MUHAMMET FATİH'	,	 'KIZANOĞLU'	,	51	,	 'KilisUmraniye'	)	,\n" + 
							"(	1024	,	 'ÇAĞDAŞ'	,	 'ŞANLIER'	,	52	,	 'KocaeliUmraniye'	)	,\n" + 
							"(	1025	,	 'FATİH NAZMİ'	,	 'BOZPOLAT'	,	53	,	 'KonyaUmraniye'	)	,\n" + 
							"(	1026	,	 'GİZEM'	,	 'ÇAKMAK'	,	54	,	 'KütahyaUmraniye'	)	,\n" + 
							"(	1027	,	 'YAVUZ SELİM'	,	 'BAKIRCI'	,	55	,	 'MalatyaUmraniye'	)	,\n" + 
							"(	1028	,	 'NEVİN'	,	 'DİL'	,	56	,	 'ManisaUmraniye'	)	,\n" + 
							"(	1029	,	 'ŞENOL'	,	 'ÖZEN'	,	57	,	 'MardinUmraniye'	)	,\n" + 
							"(	1030	,	 'CEM'	,	 'BAŞARGAN'	,	58	,	 'MersinUmraniye'	)	,\n" + 
							"(	1031	,	 'EMRAH'	,	 'KARAKAYA'	,	59	,	 'MuğlaUmraniye'	)	,\n" + 
							"(	1032	,	 'HAMZA'	,	 'İNCEOĞLU'	,	60	,	 'MuşUmraniye'	)	,\n" + 
							"(	1033	,	 'SEZGİN'	,	 'SEVER'	,	61	,	 'NevşehirUmraniye'	)	,\n" + 
							"(	1034	,	 'MUSTAFA FERHAT'	,	 'UYSAL'	,	62	,	 'NiğdeUmraniye'	)	,\n" + 
							"(	1035	,	 'MUSTAFA'	,	 'TEKİN'	,	63	,	 'OrduUmraniye'	)	,\n" + 
							"(	1036	,	 'EMRE'	,	 'GÜNEŞ'	,	64	,	 'OsmaniyeUmraniye'	)	,\n" + 
							"(	1037	,	 'ENES TAHİR'	,	 'KARATAŞ'	,	65	,	 'RizeUmraniye'	)	,\n" + 
							"(	1038	,	 'BERNA'	,	 'TOMBUL'	,	66	,	 'SakaryaUmraniye'	)	,\n" + 
							"(	1039	,	 'OĞUZ'	,	 'TIRAŞ'	,	67	,	 'SamsunUmraniye'	)	,\n" + 
							"(	1040	,	 'MEVLÜT'	,	 'ONAY'	,	68	,	 'SiirtUmraniye'	)	,\n" + 
							"(	1041	,	 'İBRAHİM'	,	 'BOĞAN'	,	69	,	 'SinopUmraniye'	)	,\n" + 
							"(	1042	,	 'MEHMET'	,	 'ARAZ SERVER'	,	70	,	 'SivasUmraniye'	)	,\n" + 
							"(	1043	,	 'MUSTAFA'	,	 'SINICI'	,	71	,	 'ŞanlıurfaUmraniye'	)	,\n" + 
							"(	1044	,	 'DUÇEM'	,	 'EKEN'	,	72	,	 'ŞırnakUmraniye'	)	,\n" + 
							"(	1045	,	 'MUSTAFA ASIM'	,	 'TAYFUR'	,	73	,	 'TekirdağUmraniye'	)	,\n" + 
							"(	1046	,	 'YUSUF EMRE'	,	 'YILDIRIM'	,	74	,	 'TokatUmraniye'	)	,\n" + 
							"(	1047	,	 'MÜNEVER'	,	 'KAYA'	,	75	,	 'TrabzonUmraniye'	)	,\n" + 
							"(	1048	,	 'ARDA NERMİN'	,	 'DEMİRCAN'	,	76	,	 'TunceliUmraniye'	)	,\n" + 
							"(	1049	,	 'ŞEYMA'	,	 'TURAÇ'	,	77	,	 'UşakUmraniye'	)	,\n" + 
							"(	1050	,	 'İBRAHİM'	,	 'BAYTAN'	,	78	,	 'VanUmraniye'	)	,\n" + 
							"(	1051	,	 'HİDAYET'	,	 'GÖKMEYDAN'	,	79	,	 'YalovaUmraniye'	)	,\n" + 
							"(	1052	,	 'ENES TAHİR'	,	 'TÜFENK'	,	80	,	 'YozgatUmraniye'	)	,\n" + 
							"(	1053	,	 'MERVE'	,	 'CORUT'	,	81	,	 'ZonguldakUmraniye'	)	,\n" + 
							"(	1054	,	 'FERDA'	,	 'TOLU'	,	1	,	 'AdanaUmraniye'	)	,\n" + 
							"(	1055	,	 'ÖKKEŞ YILMAZ'	,	 'AKMEŞE'	,	2	,	 'AdıyamanUmraniye'	)	,\n" + 
							"(	1056	,	 'GÜLDEHEN'	,	 'KARAKUŞ'	,	3	,	 'AfyonkarahisarUmraniye'	)	,\n" + 
							"(	1057	,	 'HAYATİ CAN'	,	 'TÜRE'	,	4	,	 'AğrıUmraniye'	)	,\n" + 
							"(	1058	,	 'PINAR'	,	 'GÜNEŞ'	,	5	,	 'AksarayUmraniye'	)	,\n" + 
							"(	1059	,	 'BİRSEN'	,	 'ASLAN'	,	6	,	 'AmasyaUmraniye'	)	,\n" + 
							"(	1060	,	 'AHMET'	,	 'ÖZİŞ'	,	7	,	 'AnkaraUmraniye'	)	,\n" + 
							"(	1061	,	 'ERKAN'	,	 'GÖRMELİ'	,	8	,	 'AntalyaUmraniye'	)	,\n" + 
							"(	1062	,	 'ZİYA'	,	 'KARABULUT'	,	9	,	 'ArdahanUmraniye'	)	,\n" + 
							"(	1063	,	 'ALİŞAN'	,	 'ATALAY'	,	10	,	 'ArtvinUmraniye'	)	,\n" + 
							"(	1064	,	 'SERDAR'	,	 'BACAK'	,	11	,	 'AydınUmraniye'	)	,\n" + 
							"(	1065	,	 'SERAP'	,	 'KOÇ'	,	12	,	 'BalıkesirUmraniye'	)	,\n" + 
							"(	1066	,	 'YUSUF'	,	 'ÖZDEMİR'	,	13	,	 'BartınUmraniye'	)	,\n" + 
							"(	1067	,	 'MUSTAFA RAŞİD'	,	 'YAKUT'	,	14	,	 'BatmanUmraniye'	)	,\n" + 
							"(	1068	,	 'CUNDULLAH'	,	 'KELEŞ'	,	15	,	 'BayburtUmraniye'	)	,\n" + 
							"(	1069	,	 'MEHMET'	,	 'İNCEOĞLU'	,	16	,	 'BilecikUmraniye'	)	,\n" + 
							"(	1070	,	 'AHMET'	,	 'DEMİRTAŞ'	,	17	,	 'BingölUmraniye'	)	,\n" + 
							"(	1071	,	 'NESLİHAN'	,	 'GÜRAKAN'	,	18	,	 'BitlisUmraniye'	)	,\n" + 
							"(	1072	,	 'ŞAFAK'	,	 'AKTAN'	,	19	,	 'BoluUmraniye'	)	,\n" + 
							"(	1073	,	 'MANSUR KÜRŞAD'	,	 'KILAVUZ'	,	20	,	 'DenizliUmraniye'	)	,\n" + 
							"(	1074	,	 'SEMA'	,	 'ÖZDİL'	,	21	,	 'BursaUmraniye'	)	,\n" + 
							"(	1075	,	 'BÜŞRA'	,	 'SOBAY'	,	22	,	 'ÇanakkaleUmraniye'	)	,\n" + 
							"(	1076	,	 'LATİFE'	,	 'ŞANLIKAN'	,	23	,	 'ÇankırıUmraniye'	)	,\n" + 
							"(	1077	,	 'SEMA NİLAY'	,	 'DEMİRTAŞ'	,	24	,	 'ÇorumUmraniye'	)	,\n" + 
							"(	1078	,	 'FULYA'	,	 'DENİZ'	,	25	,	 'BurdurUmraniye'	)	,\n" + 
							"(	1079	,	 'CEM İNAN'	,	 'YENİÇERİ'	,	26	,	 'DiyarbakırUmraniye'	)	,\n" + 
							"(	1080	,	 'MEHMET HAZBİN'	,	 'GÜNDOĞDU'	,	27	,	 'DüzceUmraniye'	)	,\n" + 
							"(	1081	,	 'ERHAN'	,	 'ÖZER'	,	28	,	 'EdirneUmraniye'	)	,\n" + 
							"(	1082	,	 'ELA'	,	 'KARAGÖZ'	,	29	,	 'ElazığUmraniye'	)	,\n" + 
							"(	1083	,	 'MUSTAFA'	,	 'ORDULU ŞAHİN'	,	30	,	 'ErzincanUmraniye'	)	,\n" + 
							"(	1084	,	 'ERHAN'	,	 'AKGÜL'	,	31	,	 'ErzurumUmraniye'	)	,\n" + 
							"(	1085	,	 'MEHMET ZİYA'	,	 'GÖKMEYDAN'	,	32	,	 'EskişehirUmraniye'	)	,\n" + 
							"(	1086	,	 'MELEK'	,	 'OSMANCA'	,	33	,	 'GaziantepUmraniye'	)	,\n" + 
							"(	1087	,	 'HASAN'	,	 'KAYA'	,	34	,	 'GiresunUmraniye'	)	,\n" + 
							"(	1088	,	 'MEHMET'	,	 'YÜCEL'	,	35	,	 'GümüşhaneUmraniye'	)	,\n" + 
							"(	1089	,	 'AHMET BİLGEHAN'	,	 'KAÇER'	,	36	,	 'HakkariUmraniye'	)	,\n" + 
							"(	1090	,	 'BATURAY KANSU'	,	 'ŞAHİNER'	,	37	,	 'HatayUmraniye'	)	,\n" + 
							"(	1091	,	 'İTİBAR'	,	 'DİL'	,	38	,	 'IğdırUmraniye'	)	,\n" + 
							"(	1092	,	 'MERAL LEMAN'	,	 'BİRİ'	,	39	,	 'IspartaUmraniye'	)	,\n" + 
							"(	1093	,	 'DENİZ'	,	 'GÜNDÜZ'	,	40	,	 'İstanbulUmraniye'	)	,\n" + 
							"(	1094	,	 'YUSUF'	,	 'DEMİR'	,	41	,	 'İzmirUmraniye'	)	,\n" + 
							"(	1095	,	 'SERDAL'	,	 'DAL'	,	42	,	 'KahramanmaraşUmraniye'	)	,\n" + 
							"(	1096	,	 'ŞADİ'	,	 'ASİL'	,	43	,	 'KarabükUmraniye'	)	,\n" + 
							"(	1097	,	 'CEYHUN'	,	 'DİRİCAN'	,	44	,	 'KaramanUmraniye'	)	,\n" + 
							"(	1098	,	 'TUBA'	,	 'BAKIRCI'	,	45	,	 'KarsUmraniye'	)	,\n" + 
							"(	1099	,	 'CEYHUN'	,	 'CILIZ BASHEER'	,	46	,	 'KastamonuUmraniye'	)	,\n" + 
							"(	1100	,	 'HAKAN'	,	 'ÖZALP'	,	47	,	 'KayseriUmraniye'	)	,\n" + 
							"(	1101	,	 'SERDAR'	,	 'SAKA'	,	48	,	 'KırıkkaleUmraniye'	)	,\n" + 
							"(	1102	,	 'MEHTAP'	,	 'PEYNİRCİ'	,	49	,	 'KırklareliUmraniye'	)	,\n" + 
							"(	1103	,	 'MAHMUT ARDA'	,	 'ÖZSAYIM'	,	50	,	 'KırşehirUmraniye'	)	,\n" + 
							"(	1104	,	 'VOLKAN'	,	 'YILMAZ'	,	51	,	 'KilisUmraniye'	)	,\n" + 
							"(	1105	,	 'DİLEK'	,	 'SARIKAYA'	,	52	,	 'KocaeliUmraniye'	)	,\n" + 
							"(	1106	,	 'PINAR'	,	 'OĞUZ'	,	53	,	 'KonyaUmraniye'	)	,\n" + 
							"(	1107	,	 'BİŞAR'	,	 'ZEYBEK'	,	54	,	 'KütahyaUmraniye'	)	,\n" + 
							"(	1108	,	 'SEYFİ CEM'	,	 'ÇAKMAK'	,	55	,	 'MalatyaUmraniye'	)	,\n" + 
							"(	1109	,	 'YAVUZ'	,	 'KARALAR'	,	56	,	 'ManisaUmraniye'	)	,\n" + 
							"(	1110	,	 'BERNA'	,	 'YAKUT'	,	57	,	 'MardinUmraniye'	)	,\n" + 
							"(	1111	,	 'GAMZE'	,	 'YILMAZ'	,	58	,	 'MersinUmraniye'	)	,\n" + 
							"(	1112	,	 'EMRE'	,	 'ŞİMŞEK'	,	59	,	 'MuğlaUmraniye'	)	,\n" + 
							"(	1113	,	 'ÖVÜNÇ'	,	 'CELİLOĞLU'	,	60	,	 'MuşUmraniye'	)	,\n" + 
							"(	1114	,	 'HASAN'	,	 'ÇEVİKER'	,	61	,	 'NevşehirUmraniye'	)	,\n" + 
							"(	1115	,	 'ZAHİDE'	,	 'BAL'	,	62	,	 'NiğdeUmraniye'	)	,\n" + 
							"(	1116	,	 'NİLGÜN'	,	 'KOYUNCU'	,	63	,	 'OrduUmraniye'	)	,\n" + 
							"(	1117	,	 'BÜNYAMİN'	,	 'BÖYÜK'	,	64	,	 'OsmaniyeUmraniye'	)	,\n" + 
							"(	1118	,	 'ANDAÇ'	,	 'BÜLBÜL'	,	65	,	 'RizeUmraniye'	)	,\n" + 
							"(	1119	,	 'ŞUAYIP'	,	 'GÜNDÜZ'	,	66	,	 'SakaryaUmraniye'	)	,\n" + 
							"(	1120	,	 'SANEM GÖKÇEN MERVE'	,	 'BAYAR'	,	67	,	 'SamsunUmraniye'	)	,\n" + 
							"(	1121	,	 'ÖNDER TURGUT'	,	 'ÖZDİL'	,	68	,	 'SiirtUmraniye'	)	,\n" + 
							"(	1122	,	 'SONGÜL'	,	 'KOCABIYIK'	,	69	,	 'SinopUmraniye'	)	,\n" + 
							"(	1123	,	 'HASAN'	,	 'TAŞMALI'	,	70	,	 'SivasUmraniye'	)	,\n" + 
							"(	1124	,	 'MÜJDAT'	,	 'AKMEŞE'	,	71	,	 'ŞanlıurfaUmraniye'	)	,\n" + 
							"(	1125	,	 'ASLI'	,	 'YILMAZ'	,	72	,	 'ŞırnakUmraniye'	)	,\n" + 
							"(	1126	,	 'NURİ ANIL'	,	 'AKDEMİR'	,	73	,	 'TekirdağUmraniye'	)	,\n" + 
							"(	1127	,	 'TANSU'	,	 'GÜNDÜZ'	,	74	,	 'TokatUmraniye'	)	,\n" + 
							"(	1128	,	 'MERVE'	,	 'DOĞAN'	,	75	,	 'TrabzonUmraniye'	)	,\n" + 
							"(	1129	,	 'NİHAT BERKAY'	,	 'ÖKTEM'	,	76	,	 'TunceliUmraniye'	)	,\n" + 
							"(	1130	,	 'MUSTAFA KEMAL'	,	 'YERAL'	,	77	,	 'UşakUmraniye'	)	,\n" + 
							"(	1131	,	 'KENAN SELÇUK'	,	 'GENÇDAL'	,	78	,	 'VanUmraniye'	)	,\n" + 
							"(	1132	,	 'MUTLU'	,	 'SEYREKOĞLU'	,	79	,	 'YalovaUmraniye'	)	,\n" + 
							"(	1133	,	 'ESRA'	,	 'ERZURUM'	,	80	,	 'YozgatUmraniye'	)	,\n" + 
							"(	1134	,	 'İSMAİL MİKDAT'	,	 'KARAALP'	,	81	,	 'ZonguldakUmraniye'	)	,\n" + 
							"(	1135	,	 'KIVANÇ'	,	 'BİNNETOĞLU'	,	1	,	 'AdanaUmraniye'	)	,\n" + 
							"(	1136	,	 'HANDE'	,	 'ŞENCAN'	,	2	,	 'AdıyamanUmraniye'	)	,\n" + 
							"(	1137	,	 'ERKAN'	,	 'ÇAĞLAR'	,	3	,	 'AfyonkarahisarUmraniye'	)	,\n" + 
							"(	1138	,	 'İBRAHİM'	,	 'ILGIN'	,	4	,	 'AğrıUmraniye'	)	,\n" + 
							"(	1139	,	 'ÖZEN ÖZLEM'	,	 'ERDOĞAN'	,	5	,	 'AksarayUmraniye'	)	,\n" + 
							"(	1140	,	 'EMRAH'	,	 'ERDEM'	,	6	,	 'AmasyaUmraniye'	)	,\n" + 
							"(	1141	,	 'BELGİN'	,	 'AYDIN'	,	7	,	 'AnkaraUmraniye'	)	,\n" + 
							"(	1142	,	 'OSMAN'	,	 'SARGIN'	,	8	,	 'AntalyaUmraniye'	)	,\n" + 
							"(	1143	,	 'ERKİN'	,	 'MERHAMETSİZ'	,	9	,	 'ArdahanUmraniye'	)	,\n" + 
							"(	1144	,	 'MAHMUT'	,	 'FİLİZAY'	,	10	,	 'ArtvinUmraniye'	)	,\n" + 
							"(	1145	,	 'TUBA'	,	 'KIRLI'	,	11	,	 'AydınUmraniye'	)	,\n" + 
							"(	1146	,	 'LATİFE'	,	 'KARAKUŞ'	,	12	,	 'BalıkesirUmraniye'	)	,\n" + 
							"(	1147	,	 'EMİNE'	,	 'SERTOĞLU'	,	13	,	 'BartınUmraniye'	)	,\n" + 
							"(	1148	,	 'KENAN AHMET'	,	 'ILGIN'	,	14	,	 'BatmanUmraniye'	)	,\n" + 
							"(	1149	,	 'İBRAHİM'	,	 'BALSAK'	,	15	,	 'BayburtUmraniye'	)	,\n" + 
							"(	1150	,	 'GÖKHAN'	,	 'YERAL'	,	16	,	 'BilecikUmraniye'	)	,\n" + 
							"(	1151	,	 'RUKİYE ÖZDEN'	,	 'SAYİNER'	,	17	,	 'BingölUmraniye'	)	,\n" + 
							"(	1152	,	 'ÖZGÜR'	,	 'ALBOĞA'	,	18	,	 'BitlisUmraniye'	)	,\n" + 
							"(	1153	,	 'ŞEHMUS'	,	 'ÖZDOĞAN KAVZOĞLU'	,	19	,	 'BoluUmraniye'	)	,\n" + 
							"(	1154	,	 'YASEMİN'	,	 'AKYOL'	,	20	,	 'DenizliUmraniye'	)	,\n" + 
							"(	1155	,	 'DİLAN'	,	 'ORMAN'	,	21	,	 'BursaUmraniye'	)	,\n" + 
							"(	1156	,	 'DERYA'	,	 'SUBARİ'	,	22	,	 'ÇanakkaleUmraniye'	)	,\n" + 
							"(	1157	,	 'SİNAN'	,	 'TAN'	,	23	,	 'ÇankırıUmraniye'	)	,\n" + 
							"(	1158	,	 'KADİR'	,	 'DEMİR'	,	24	,	 'ÇorumUmraniye'	)	,\n" + 
							"(	1159	,	 'NİHAL'	,	 'ERDOĞAN'	,	25	,	 'BurdurUmraniye'	)	,\n" + 
							"(	1160	,	 'SAMET'	,	 'ÖZMEN'	,	26	,	 'DiyarbakırUmraniye'	)	,\n" + 
							"(	1161	,	 'SEDA'	,	 'GÖRMÜŞ'	,	27	,	 'DüzceUmraniye'	)	,\n" + 
							"(	1162	,	 'NESLİHAN'	,	 'DÜZGÜN'	,	28	,	 'EdirneUmraniye'	)	,\n" + 
							"(	1163	,	 'SERKAN'	,	 'BULUT'	,	29	,	 'ElazığUmraniye'	)	,\n" + 
							"(	1164	,	 'SERKAN'	,	 'VEZİROĞLU BİRDANE'	,	30	,	 'ErzincanUmraniye'	)	,\n" + 
							"(	1165	,	 'AYDIN'	,	 'BÖRTA'	,	31	,	 'ErzurumUmraniye'	)	,\n" + 
							"(	1166	,	 'REŞİT VOLKAN'	,	 'SARICA DAROL'	,	32	,	 'EskişehirUmraniye'	)	,\n" + 
							"(	1167	,	 'MUSTAFA'	,	 'ŞİRİN'	,	33	,	 'GaziantepUmraniye'	)	,\n" + 
							"(	1168	,	 'HALİL'	,	 'YALÇIN'	,	34	,	 'GiresunUmraniye'	)	,\n" + 
							"(	1169	,	 'ONUR'	,	 'ÇETİN'	,	35	,	 'GümüşhaneUmraniye'	)	,\n" + 
							"(	1170	,	 'ÖMER AYKUT'	,	 'KARCIOĞLU'	,	36	,	 'HakkariUmraniye'	)	,\n" + 
							"(	1171	,	 'SİNAN'	,	 'ÖZTÜRKERİ'	,	37	,	 'HatayUmraniye'	)	,\n" + 
							"(	1172	,	 'MEVSİM'	,	 'VURAL'	,	38	,	 'IğdırUmraniye'	)	,\n" + 
							"(	1173	,	 'ERTAN'	,	 'BULUÇ'	,	39	,	 'IspartaUmraniye'	)	,\n" + 
							"(	1174	,	 'ABDURRAHMAN'	,	 'BEREKATOĞLU'	,	40	,	 'İstanbulUmraniye'	)	,\n" + 
							"(	1175	,	 'MEHTAP'	,	 'KAYA'	,	41	,	 'İzmirUmraniye'	)	,\n" + 
							"(	1176	,	 'ŞENAY'	,	 'TOKTAŞ'	,	42	,	 'KahramanmaraşUmraniye'	)	,\n" + 
							"(	1177	,	 'BURCU'	,	 'GÜNBEY'	,	43	,	 'KarabükUmraniye'	)	,\n" + 
							"(	1178	,	 'ÖZNUR'	,	 'BARIŞAN'	,	44	,	 'KaramanUmraniye'	)	,\n" + 
							"(	1179	,	 'EVREN'	,	 'ŞENER'	,	45	,	 'KarsUmraniye'	)	,\n" + 
							"(	1180	,	 'MEHMET GÖKÇE'	,	 'KOÇARSLAN'	,	46	,	 'KastamonuUmraniye'	)	,\n" + 
							"(	1181	,	 'HASAN'	,	 'AKYÜREK'	,	47	,	 'KayseriUmraniye'	)	,\n" + 
							"(	1182	,	 'ÖZLEM'	,	 'ASLAN'	,	48	,	 'KırıkkaleUmraniye'	)	,\n" + 
							"(	1183	,	 'ENDER'	,	 'SEZEN'	,	49	,	 'KırklareliUmraniye'	)	,\n" + 
							"(	1184	,	 'ABİDİN'	,	 'VATANSEVER'	,	50	,	 'KırşehirUmraniye'	)	,\n" + 
							"(	1185	,	 'İLYAS'	,	 'TOY'	,	51	,	 'KilisUmraniye'	)	,\n" + 
							"(	1186	,	 'TURGAY'	,	 'DURSUN'	,	52	,	 'KocaeliUmraniye'	)	,\n" + 
							"(	1187	,	 'SERDAL'	,	 'KARÇİN'	,	53	,	 'KonyaUmraniye'	)	,\n" + 
							"(	1188	,	 'ÖZLEM'	,	 'AVCU'	,	54	,	 'KütahyaUmraniye'	)	,\n" + 
							"(	1189	,	 'AYŞEGÜL'	,	 'TEKİN'	,	55	,	 'MalatyaUmraniye'	)	,\n" + 
							"(	1190	,	 'SEHER ÖZLEM'	,	 'SÜVERAN'	,	56	,	 'ManisaUmraniye'	)	,\n" + 
							"(	1191	,	 'TEVFİK'	,	 'ÖZSAYGILI'	,	57	,	 'MardinUmraniye'	)	,\n" + 
							"(	1192	,	 'CEREN'	,	 'YEL'	,	58	,	 'MersinUmraniye'	)	,\n" + 
							"(	1193	,	 'PINAR'	,	 'DAL'	,	59	,	 'MuğlaUmraniye'	)	,\n" + 
							"(	1194	,	 'TESLİME NAZLI'	,	 'TİKİCİ'	,	60	,	 'MuşUmraniye'	)	,\n" + 
							"(	1195	,	 'YASİN'	,	 'DESTEGÜL'	,	61	,	 'NevşehirUmraniye'	)	,\n" + 
							"(	1196	,	 'MUZAFFER OĞUZ'	,	 'EROL'	,	62	,	 'NiğdeUmraniye'	)	,\n" + 
							"(	1197	,	 'BURÇİN'	,	 'DEMİRKAPI'	,	63	,	 'OrduUmraniye'	)	,\n" + 
							"(	1198	,	 'YAVUZ'	,	 'DOĞAN'	,	64	,	 'OsmaniyeUmraniye'	)	,\n" + 
							"(	1199	,	 'HASAN'	,	 'ÜNAL'	,	65	,	 'RizeUmraniye'	)	,\n" + 
							"(	1200	,	 'BİLGE'	,	 'EROL'	,	66	,	 'SakaryaUmraniye'	)	,\n" + 
							"(	1201	,	 'MEHMET'	,	 'TUNCER'	,	67	,	 'SamsunUmraniye'	)	,\n" + 
							"(	1202	,	 'YASEMİN'	,	 'USLUBAŞ'	,	68	,	 'SiirtUmraniye'	)	,\n" + 
							"(	1203	,	 'MURAT'	,	 'EROĞLU'	,	69	,	 'SinopUmraniye'	)	,\n" + 
							"(	1204	,	 'BENGÜHAN'	,	 'ATALAY'	,	70	,	 'SivasUmraniye'	)	,\n" + 
							"(	1205	,	 'BETÜL'	,	 'POLAT'	,	71	,	 'ŞanlıurfaUmraniye'	)	,\n" + 
							"(	1206	,	 'CİHAN'	,	 'ÜNALAN'	,	72	,	 'ŞırnakUmraniye'	)	,\n" + 
							"(	1207	,	 'İREM'	,	 'OZAN'	,	73	,	 'TekirdağUmraniye'	)	,\n" + 
							"(	1208	,	 'KÜBRA'	,	 'GÜNGÖR'	,	74	,	 'TokatUmraniye'	)	,\n" + 
							"(	1209	,	 'GÖKHAN'	,	 'ÖZER'	,	75	,	 'TrabzonUmraniye'	)	,\n" + 
							"(	1210	,	 'MÜMÜNE'	,	 'ÖZSAYGILI'	,	76	,	 'TunceliUmraniye'	)	,\n" + 
							"(	1211	,	 'ESEN'	,	 'BARAN'	,	77	,	 'UşakUmraniye'	)	,\n" + 
							"(	1212	,	 'ELA'	,	 'YAŞAN'	,	78	,	 'VanUmraniye'	)	,\n" + 
							"(	1213	,	 'GÜLSEREN'	,	 'ÇETİNKAYA'	,	79	,	 'YalovaUmraniye'	)	,\n" + 
							"(	1214	,	 'MEHMET NURİ'	,	 'PAKÖZ'	,	80	,	 'YozgatUmraniye'	)	,\n" + 
							"(	1215	,	 'MEHMET ÖZGÜR'	,	 'YILDIRIM'	,	81	,	 'ZonguldakUmraniye'	)	,\n" + 
							"(	1216	,	 'EMİNE'	,	 'KARAKAYA'	,	1	,	 'AdanaUmraniye'	)	,\n" + 
							"(	1217	,	 'MEHMET'	,	 'SAÇLI'	,	2	,	 'AdıyamanUmraniye'	)	,\n" + 
							"(	1218	,	 'EVREN'	,	 'GÜLCAN'	,	3	,	 'AfyonkarahisarUmraniye'	)	,\n" + 
							"(	1219	,	 'ZARİFE'	,	 'ÜÇER'	,	4	,	 'AğrıUmraniye'	)	,\n" + 
							"(	1220	,	 'YASİN'	,	 'UZUN'	,	5	,	 'AksarayUmraniye'	)	,\n" + 
							"(	1221	,	 'ESRA'	,	 'AL'	,	6	,	 'AmasyaUmraniye'	)	,\n" + 
							"(	1222	,	 'NAGİHAN'	,	 'GÜVEN'	,	7	,	 'AnkaraUmraniye'	)	,\n" + 
							"(	1223	,	 'İZZET'	,	 'YAVUZ SEZGİN'	,	8	,	 'AntalyaUmraniye'	)	,\n" + 
							"(	1224	,	 'BURAK'	,	 'GÜNEBAKAN'	,	9	,	 'ArdahanUmraniye'	)	,\n" + 
							"(	1225	,	 'NURAN'	,	 'ALTAŞ'	,	10	,	 'ArtvinUmraniye'	)	,\n" + 
							"(	1226	,	 'ÜMMÜ GÜLSÜM'	,	 'KÖKSAL'	,	11	,	 'AydınUmraniye'	)	,\n" + 
							"(	1227	,	 'GÖZDE KÜBRA'	,	 'GÜLŞAN'	,	12	,	 'BalıkesirUmraniye'	)	,\n" + 
							"(	1228	,	 'AYLA'	,	 'BOZAN'	,	13	,	 'BartınUmraniye'	)	,\n" + 
							"(	1229	,	 'AHMET SERKAN'	,	 'DEMİR'	,	14	,	 'BatmanUmraniye'	)	,\n" + 
							"(	1230	,	 'BELGİN EMİNE'	,	 'KARAALP'	,	15	,	 'BayburtUmraniye'	)	,\n" + 
							"(	1231	,	 'HAMDİ'	,	 'TEKİN'	,	16	,	 'BilecikUmraniye'	)	,\n" + 
							"(	1232	,	 'EMRAH'	,	 'ÇİFTCİ'	,	17	,	 'BingölUmraniye'	)	,\n" + 
							"(	1233	,	 'AYŞEGÜL'	,	 'TIRAŞ'	,	18	,	 'BitlisUmraniye'	)	,\n" + 
							"(	1234	,	 'NURDAN'	,	 'GÜLCAN'	,	19	,	 'BoluUmraniye'	)	,\n" + 
							"(	1235	,	 'HASAN YAVUZHAN'	,	 'İLERİ'	,	20	,	 'DenizliUmraniye'	)	,\n" + 
							"(	1236	,	 'ATİLLA SÜLEYMAN'	,	 'EVREN'	,	21	,	 'BursaUmraniye'	)	,\n" + 
							"(	1237	,	 'ŞÜKRİYE TUĞÇE'	,	 'TAŞMALI'	,	22	,	 'ÇanakkaleUmraniye'	)	,\n" + 
							"(	1238	,	 'RECEP'	,	 'YABUL'	,	23	,	 'ÇankırıUmraniye'	)	,\n" + 
							"(	1239	,	 'MEHMET'	,	 'ÖZTÜRK'	,	24	,	 'ÇorumUmraniye'	)	,\n" + 
							"(	1240	,	 'ÖZDEN'	,	 'TOY'	,	25	,	 'BurdurUmraniye'	)	,\n" + 
							"(	1241	,	 'MURAT'	,	 'CÖMERT'	,	26	,	 'DiyarbakırUmraniye'	)	,\n" + 
							"(	1242	,	 'EMRE'	,	 'KURTULUŞ'	,	27	,	 'DüzceUmraniye'	)	,\n" + 
							"(	1243	,	 'ALİ'	,	 'SAÇLI'	,	28	,	 'EdirneUmraniye'	)	,\n" + 
							"(	1244	,	 'AHMET TUNÇ'	,	 'COŞAR'	,	29	,	 'ElazığUmraniye'	)	,\n" + 
							"(	1245	,	 'REYHAN'	,	 'AKIN'	,	30	,	 'ErzincanUmraniye'	)	,\n" + 
							"(	1246	,	 'HÜMEYRA'	,	 'KÜTÜKCÜ'	,	31	,	 'ErzurumUmraniye'	)	,\n" + 
							"(	1247	,	 'FÜSUN'	,	 'ÖNCEL'	,	32	,	 'EskişehirUmraniye'	)	,\n" + 
							"(	1248	,	 'ESRA'	,	 'ÇELİK'	,	33	,	 'GaziantepUmraniye'	)	,\n" + 
							"(	1249	,	 'ASIM'	,	 'DEMİRER'	,	34	,	 'GiresunUmraniye'	)	,\n" + 
							"(	1250	,	 'YILDIRIM'	,	 'DAL'	,	35	,	 'GümüşhaneUmraniye'	)	,\n" + 
							"(	1251	,	 'BURAK'	,	 'BARÇA'	,	36	,	 'HakkariUmraniye'	)	,\n" + 
							"(	1252	,	 'ALİ HASAN'	,	 'DİKOĞLU'	,	37	,	 'HatayUmraniye'	)	,\n" + 
							"(	1253	,	 'BENHUR ŞİRVAN'	,	 'YAKUT'	,	38	,	 'IğdırUmraniye'	)	,\n" + 
							"(	1254	,	 'TÜLAY'	,	 'DEVELİ'	,	39	,	 'IspartaUmraniye'	)	,\n" + 
							"(	1255	,	 'EBRU'	,	 'DÜNDAR'	,	40	,	 'İstanbulUmraniye'	)	,\n" + 
							"(	1256	,	 'KÜBRA'	,	 'ÇELİK'	,	41	,	 'İzmirUmraniye'	)	,\n" + 
							"(	1257	,	 'SERKAN'	,	 'ÇİÇEK'	,	42	,	 'KahramanmaraşUmraniye'	)	,\n" + 
							"(	1258	,	 'EYYUP SABRİ'	,	 'SEYREK'	,	43	,	 'KarabükUmraniye'	)	,\n" + 
							"(	1259	,	 'CEYHAN'	,	 'UTLU'	,	44	,	 'KaramanUmraniye'	)	,\n" + 
							"(	1260	,	 'EMRE'	,	 'ŞAHİN'	,	45	,	 'KarsUmraniye'	)	,\n" + 
							"(	1261	,	 'HAKAN'	,	 'BABA'	,	46	,	 'KastamonuUmraniye'	)	,\n" + 
							"(	1262	,	 'MUSTAFA ERSAGUN'	,	 'KAYKI'	,	47	,	 'KayseriUmraniye'	)	,\n" + 
							"(	1263	,	 'MUSTAFA'	,	 'GÜLLÜ'	,	48	,	 'KırıkkaleUmraniye'	)	,\n" + 
							"(	1264	,	 'İRFAN YILDIRIM'	,	 'KARPUZ'	,	49	,	 'KırklareliUmraniye'	)	,\n" + 
							"(	1265	,	 'AYBÜKE'	,	 'KÜÇÜKGÖNCÜ'	,	50	,	 'KırşehirUmraniye'	)	,\n" + 
							"(	1266	,	 'ALİ BURÇ'	,	 'SERTOĞLU'	,	51	,	 'KilisUmraniye'	)	,\n" + 
							"(	1267	,	 'HÜSEYİN'	,	 'DEDE'	,	52	,	 'KocaeliUmraniye'	)	,\n" + 
							"(	1268	,	 'CEYLAN'	,	 'KARA'	,	53	,	 'KonyaUmraniye'	)	,\n" + 
							"(	1269	,	 'MEHMET'	,	 'SARIKAYA'	,	54	,	 'KütahyaUmraniye'	)	,\n" + 
							"(	1270	,	 'CAN'	,	 'ÇEÇEN'	,	55	,	 'MalatyaUmraniye'	)	,\n" + 
							"(	1271	,	 'BURCU'	,	 'ÖZTÜRKERİ'	,	56	,	 'ManisaUmraniye'	)	,\n" + 
							"(	1272	,	 'İLHAN'	,	 'KÖKSAL'	,	57	,	 'MardinUmraniye'	)	,\n" + 
							"(	1273	,	 'SERHAT'	,	 'DEMİR'	,	58	,	 'MersinUmraniye'	)	,\n" + 
							"(	1274	,	 'MUSTAFA RAŞİD'	,	 'KARAAĞAÇ'	,	59	,	 'MuğlaUmraniye'	)	,\n" + 
							"(	1275	,	 'EMİN TONYUKUK'	,	 'ASİL'	,	60	,	 'MuşUmraniye'	)	,\n" + 
							"(	1276	,	 'ARZU'	,	 'ULU'	,	61	,	 'NevşehirUmraniye'	)	,\n" + 
							"(	1277	,	 'MERVE'	,	 'BAYRAK'	,	62	,	 'NiğdeUmraniye'	)	,\n" + 
							"(	1278	,	 'MESUT'	,	 'TÜREMENOĞULLARI'	,	63	,	 'OrduUmraniye'	)	,\n" + 
							"(	1279	,	 'BURCU'	,	 'KARA'	,	64	,	 'OsmaniyeUmraniye'	)	,\n" + 
							"(	1280	,	 'ORÇUN'	,	 'KARAİSMAİLOĞLU'	,	65	,	 'RizeUmraniye'	)	,\n" + 
							"(	1281	,	 'ÖKKEŞ'	,	 'CANTÜRK'	,	66	,	 'SakaryaUmraniye'	)	,\n" + 
							"(	1282	,	 'ÖZLEM'	,	 'KIRCALI'	,	67	,	 'SamsunUmraniye'	)	,\n" + 
							"(	1283	,	 'DAMLA'	,	 'AÇIKGÖZ'	,	68	,	 'SiirtUmraniye'	)	,\n" + 
							"(	1284	,	 'HİDAYET'	,	 'AKDEMİR'	,	69	,	 'SinopUmraniye'	)	,\n" + 
							"(	1285	,	 'ÖMER'	,	 'POLAT'	,	70	,	 'SivasUmraniye'	)	,\n" + 
							"(	1286	,	 'ONUR'	,	 'ÇAKIR'	,	71	,	 'ŞanlıurfaUmraniye'	)	,\n" + 
							"(	1287	,	 'MAHMUT'	,	 'MERCAN'	,	72	,	 'ŞırnakUmraniye'	)	,\n" + 
							"(	1288	,	 'SİBEL'	,	 'KIRLI'	,	73	,	 'TekirdağUmraniye'	)	,\n" + 
							"(	1289	,	 'ASLI'	,	 'BALTACI'	,	74	,	 'TokatUmraniye'	)	,\n" + 
							"(	1290	,	 'MUHAMMED'	,	 'ŞAHİN'	,	75	,	 'TrabzonUmraniye'	)	,\n" + 
							"(	1291	,	 'SEZAİ'	,	 'KUSERLİ'	,	76	,	 'TunceliUmraniye'	)	,\n" + 
							"(	1292	,	 'MEHMET SELAHATTİN'	,	 'AKKOYUNLU'	,	77	,	 'UşakUmraniye'	)	,\n" + 
							"(	1293	,	 'NEBİL'	,	 'ÇOBAN'	,	78	,	 'VanUmraniye'	)	,\n" + 
							"(	1294	,	 'MUHAMMED'	,	 'TAŞKIRAN'	,	79	,	 'YalovaUmraniye'	)	,\n" + 
							"(	1295	,	 'ERDEM'	,	 'KARAİSMAİLOĞLU'	,	80	,	 'YozgatUmraniye'	)	,\n" + 
							"(	1296	,	 'ÖZLEM'	,	 'İNER KÖKSAL'	,	81	,	 'ZonguldakUmraniye'	)	,\n" + 
							"(	1297	,	 'ERHAN'	,	 'ŞANLIKAN'	,	1	,	 'AdanaModa'	)	,\n" + 
							"(	1298	,	 'MUTLU'	,	 'SERT'	,	2	,	 'AdıyamanModa'	)	,\n" + 
							"(	1299	,	 'İBRAHİM'	,	 'EROL'	,	3	,	 'AfyonkarahisarModa'	)	,\n" + 
							"(	1300	,	 'HANİFE TUĞÇE'	,	 'BARATALI'	,	4	,	 'AğrıModa'	)	,\n" + 
							"(	1301	,	 'GÜLBAHAR'	,	 'TÜRKAY'	,	5	,	 'AksarayModa'	)	,\n" + 
							"(	1302	,	 'YILDIRIM'	,	 'SAKARYA'	,	6	,	 'AmasyaModa'	)	,\n" + 
							"(	1303	,	 'MURAT'	,	 'BEKAR'	,	7	,	 'AnkaraModa'	)	,\n" + 
							"(	1304	,	 'GÜLDEN'	,	 'ÖZER ÇELİK'	,	8	,	 'AntalyaModa'	)	,\n" + 
							"(	1305	,	 'NURDAN'	,	 'BURULDAY'	,	9	,	 'ArdahanModa'	)	,\n" + 
							"(	1306	,	 'ÜMMÜ GÜLSÜM'	,	 'SARICANBAZ'	,	10	,	 'ArtvinModa'	)	,\n" + 
							"(	1307	,	 'NİLAY'	,	 'UZUN'	,	11	,	 'AydınModa'	)	,\n" + 
							"(	1308	,	 'OĞUZ'	,	 'BAYRAM'	,	12	,	 'BalıkesirModa'	)	,\n" + 
							"(	1309	,	 'SEVDA'	,	 'GÖKTAŞ'	,	13	,	 'BartınModa'	)	,\n" + 
							"(	1310	,	 'OKAN'	,	 'KAÇIRA'	,	14	,	 'BatmanModa'	)	,\n" + 
							"(	1311	,	 'İRFAN'	,	 'AYIK'	,	15	,	 'BayburtModa'	)	,\n" + 
							"(	1312	,	 'İZZETTİN'	,	 'UYSAL'	,	16	,	 'BilecikModa'	)	,\n" + 
							"(	1313	,	 'MUSTAFA'	,	 'ÇETİN'	,	17	,	 'BingölModa'	)	,\n" + 
							"(	1314	,	 'AHMET EMRE'	,	 'SEYREKOĞLU'	,	18	,	 'BitlisModa'	)	,\n" + 
							"(	1315	,	 'MUSTAFA NAFİZ'	,	 'GÖKTEPE'	,	19	,	 'BoluModa'	)	,\n" + 
							"(	1316	,	 'MUHAMMED FATİH'	,	 'KAYA'	,	20	,	 'DenizliModa'	)	,\n" + 
							"(	1317	,	 'ELİF'	,	 'KIZMAZ'	,	21	,	 'BursaModa'	)	,\n" + 
							"(	1318	,	 'MAKBULE SEDA'	,	 'ÇAKIR'	,	22	,	 'ÇanakkaleModa'	)	,\n" + 
							"(	1319	,	 'ÖZNUR'	,	 'SEYREK'	,	23	,	 'ÇankırıModa'	)	,\n" + 
							"(	1320	,	 'MÜNEVER'	,	 'KARADAVUT'	,	24	,	 'ÇorumModa'	)	,\n" + 
							"(	1321	,	 'İLYAS'	,	 'KARSLI'	,	25	,	 'BurdurModa'	)	,\n" + 
							"(	1322	,	 'DERYA SEMA'	,	 'KELEŞ'	,	26	,	 'DiyarbakırModa'	)	,\n" + 
							"(	1323	,	 'MUSTAFA'	,	 'ÖZTÜRK'	,	27	,	 'DüzceModa'	)	,\n" + 
							"(	1324	,	 'YUSUF'	,	 'ALABALIK'	,	28	,	 'EdirneModa'	)	,\n" + 
							"(	1325	,	 'BENGÜ'	,	 'KOÇAR'	,	29	,	 'ElazığModa'	)	,\n" + 
							"(	1326	,	 'EMİR KAAN'	,	 'TUNÇ'	,	30	,	 'ErzincanModa'	)	,\n" + 
							"(	1327	,	 'MERAL'	,	 'TOPRAK'	,	31	,	 'ErzurumModa'	)	,\n" + 
							"(	1328	,	 'ALPER'	,	 'DOĞAN'	,	32	,	 'EskişehirModa'	)	,\n" + 
							"(	1329	,	 'FATİH'	,	 'KOTTAŞ'	,	33	,	 'GaziantepModa'	)	,\n" + 
							"(	1330	,	 'MURAT'	,	 'DOĞAN'	,	34	,	 'GiresunModa'	)	,\n" + 
							"(	1331	,	 'KAMİL'	,	 'DEMİRTAŞ'	,	35	,	 'GümüşhaneModa'	)	,\n" + 
							"(	1332	,	 'EMİNE'	,	 'ULU'	,	36	,	 'HakkariModa'	)	,\n" + 
							"(	1333	,	 'İTİBAR'	,	 'BAL'	,	37	,	 'HatayModa'	)	,\n" + 
							"(	1334	,	 'FATİH'	,	 'GÜNEBAKAN'	,	38	,	 'IğdırModa'	)	,\n" + 
							"(	1335	,	 'CANSU'	,	 'GÜREL'	,	39	,	 'IspartaModa'	)	,\n" + 
							"(	1336	,	 'BERFU'	,	 'YANMAZ'	,	40	,	 'İstanbulModa'	)	,\n" + 
							"(	1337	,	 'VELİT'	,	 'UZUN'	,	41	,	 'İzmirModa'	)	,\n" + 
							"(	1338	,	 'GÜLPERİ'	,	 'BARÇA'	,	42	,	 'KahramanmaraşModa'	)	,\n" + 
							"(	1339	,	 'EMEL CENNET'	,	 'YILMAZ'	,	43	,	 'KarabükModa'	)	,\n" + 
							"(	1340	,	 'GAMZE'	,	 'BAŞARAN'	,	44	,	 'KaramanModa'	)	,\n" + 
							"(	1341	,	 'AYŞEGÜL'	,	 'ÇELİK'	,	45	,	 'KarsModa'	)	,\n" + 
							"(	1342	,	 'HÜSEYİN'	,	 'KALEM'	,	46	,	 'KastamonuModa'	)	,\n" + 
							"(	1343	,	 'SERKAN'	,	 'ÇİÇEK'	,	47	,	 'KayseriModa'	)	,\n" + 
							"(	1344	,	 'EBRU'	,	 'BAYRAKÇI'	,	48	,	 'KırıkkaleModa'	)	,\n" + 
							"(	1345	,	 'MUHAMMED'	,	 'ATAK'	,	49	,	 'KırklareliModa'	)	,\n" + 
							"(	1346	,	 'LEZİZ'	,	 'ALBAŞ'	,	50	,	 'KırşehirModa'	)	,\n" + 
							"(	1347	,	 'DUYGU'	,	 'KARTAL'	,	51	,	 'KilisModa'	)	,\n" + 
							"(	1348	,	 'FATİH'	,	 'TOLU'	,	52	,	 'KocaeliModa'	)	,\n" + 
							"(	1349	,	 'MEHMED UĞUR'	,	 'DEMİRER'	,	53	,	 'KonyaModa'	)	,\n" + 
							"(	1350	,	 'TUĞBA'	,	 'AYKAN'	,	54	,	 'KütahyaModa'	)	,\n" + 
							"(	1351	,	 'ASUMAN'	,	 'İLERİ'	,	55	,	 'MalatyaModa'	)	,\n" + 
							"(	1352	,	 'ALPER'	,	 'KARAİSMAİLOĞLU'	,	56	,	 'ManisaModa'	)	,\n" + 
							"(	1353	,	 'FATİH'	,	 'BAYRAK'	,	57	,	 'MardinModa'	)	,\n" + 
							"(	1354	,	 'TİMUÇİN'	,	 'VATANSEVER'	,	58	,	 'MersinModa'	)	,\n" + 
							"(	1355	,	 'BARIŞ'	,	 'ÖZDEMİR'	,	59	,	 'MuğlaModa'	)	,\n" + 
							"(	1356	,	 'NURAY'	,	 'SOBAY'	,	60	,	 'MuşModa'	)	,\n" + 
							"(	1357	,	 'FATMA'	,	 'AYDIN'	,	61	,	 'NevşehirModa'	)	,\n" + 
							"(	1358	,	 'İLKNUR'	,	 'KARAGÖZ'	,	62	,	 'NiğdeModa'	)	,\n" + 
							"(	1359	,	 'GÖKHAN'	,	 'AYDOĞAN'	,	63	,	 'OrduModa'	)	,\n" + 
							"(	1360	,	 'AYSU'	,	 'ERSOY'	,	64	,	 'OsmaniyeModa'	)	,\n" + 
							"(	1361	,	 'DİLBER'	,	 'SEVÜK'	,	65	,	 'RizeModa'	)	,\n" + 
							"(	1362	,	 'ONUR'	,	 'IŞIK'	,	66	,	 'SakaryaModa'	)	,\n" + 
							"(	1363	,	 'ERTAN'	,	 'KADAK'	,	67	,	 'SamsunModa'	)	,\n" + 
							"(	1364	,	 'SERPİL'	,	 'KESKİN'	,	68	,	 'SiirtModa'	)	,\n" + 
							"(	1365	,	 'YUSUF KENAN'	,	 '1'	,	69	,	 'SinopModa'	)	,\n" + 
							"(	1366	,	 'DENİZ'	,	 'BİLGİÇ'	,	70	,	 'SivasModa'	)	,\n" + 
							"(	1367	,	 'AYŞEGÜL'	,	 'KAYA'	,	71	,	 'ŞanlıurfaModa'	)	,\n" + 
							"(	1368	,	 'MARİA'	,	 'ÇELİK'	,	72	,	 'ŞırnakModa'	)	,\n" + 
							"(	1369	,	 'CAN'	,	 'ÇAĞLAR'	,	73	,	 'TekirdağModa'	)	,\n" + 
							"(	1370	,	 'EREN'	,	 'SEZGİN'	,	74	,	 'TokatModa'	)	,\n" + 
							"(	1371	,	 'DİDEM'	,	 'ARIKAN'	,	75	,	 'TrabzonModa'	)	,\n" + 
							"(	1372	,	 'ERGÜN'	,	 'BERENT'	,	76	,	 'TunceliModa'	)	,\n" + 
							"(	1373	,	 'HASAN'	,	 'TUNCAY'	,	77	,	 'UşakModa'	)	,\n" + 
							"(	1374	,	 'FAİK'	,	 'YILMAZ'	,	78	,	 'VanModa'	)	,\n" + 
							"(	1375	,	 'YELDA'	,	 'AYCAN'	,	79	,	 'YalovaModa'	)	,\n" + 
							"(	1376	,	 'BURAK'	,	 'SEZEN'	,	80	,	 'YozgatModa'	)	,\n" + 
							"(	1377	,	 'VEYSEL'	,	 'YILMAZ'	,	81	,	 'ZonguldakModa'	)	,\n" + 
							"(	1378	,	 'UMUT CAN'	,	 'SEVİNÇ'	,	1	,	 'AdanaModa'	)	,\n" + 
							"(	1379	,	 'MARİA'	,	 'YETKİNŞEKERCİ'	,	2	,	 'AdıyamanModa'	)	,\n" + 
							"(	1380	,	 'SELKAN MURAD'	,	 'KHALİL'	,	3	,	 'AfyonkarahisarModa'	)	,\n" + 
							"(	1381	,	 'MUHAMMET TAYYİP'	,	 'BAKLACI'	,	4	,	 'AğrıModa'	)	,\n" + 
							"(	1382	,	 'ÖYKÜ'	,	 'KÖKSAL'	,	5	,	 'AksarayModa'	)	,\n" + 
							"(	1383	,	 'YÜCE'	,	 'DOĞAN'	,	6	,	 'AmasyaModa'	)	,\n" + 
							"(	1384	,	 'ÖVÜNÇ'	,	 'BARATALI'	,	7	,	 'AnkaraModa'	)	,\n" + 
							"(	1385	,	 'ELİF'	,	 'ŞAHİN'	,	8	,	 'AntalyaModa'	)	,\n" + 
							"(	1386	,	 'ASLI'	,	 'ÖZCAN'	,	9	,	 'ArdahanModa'	)	,\n" + 
							"(	1387	,	 'İLKNUR'	,	 'ÇEPNİ'	,	10	,	 'ArtvinModa'	)	,\n" + 
							"(	1388	,	 'ŞERİFE YASEMİN'	,	 'KÖKSAL'	,	11	,	 'AydınModa'	)	,\n" + 
							"(	1389	,	 'FETHİYE'	,	 'ERDOĞAN'	,	12	,	 'BalıkesirModa'	)	,\n" + 
							"(	1390	,	 'ADİL'	,	 'AKSÖZ'	,	13	,	 'BartınModa'	)	,\n" + 
							"(	1391	,	 'EMEL CENNET'	,	 'ERDOĞMUŞ'	,	14	,	 'BatmanModa'	)	,\n" + 
							"(	1392	,	 'NEŞE'	,	 'SAYIN'	,	15	,	 'BayburtModa'	)	,\n" + 
							"(	1393	,	 'ENDER'	,	 'KÜÇÜKGÖNCÜ'	,	16	,	 'BilecikModa'	)	,\n" + 
							"(	1394	,	 'SÜLEYMAN'	,	 'ÇOBAN'	,	17	,	 'BingölModa'	)	,\n" + 
							"(	1395	,	 'RAMAZAN'	,	 'GÜNBEY'	,	18	,	 'BitlisModa'	)	,\n" + 
							"(	1396	,	 'ABDULLAH'	,	 'KAPLAN'	,	19	,	 'BoluModa'	)	,\n" + 
							"(	1397	,	 'SEÇİL'	,	 'ŞİMŞEK'	,	20	,	 'DenizliModa'	)	,\n" + 
							"(	1398	,	 'ÖZLEM'	,	 'YILDIZ'	,	21	,	 'BursaModa'	)	,\n" + 
							"(	1399	,	 'ALİ HALUK'	,	 'KEMİK'	,	22	,	 'ÇanakkaleModa'	)	,\n" + 
							"(	1400	,	 'MEHMET'	,	 'KERİMOĞLU'	,	23	,	 'ÇankırıModa'	)	,\n" + 
							"(	1401	,	 'EMEL'	,	 'TOPER'	,	24	,	 'ÇorumModa'	)	,\n" + 
							"(	1402	,	 'ÖZLEM'	,	 'SOYTAŞ'	,	25	,	 'BurdurModa'	)	,\n" + 
							"(	1403	,	 'HARUN'	,	 'ÇOBAN'	,	26	,	 'DiyarbakırModa'	)	,\n" + 
							"(	1404	,	 'HAMZA'	,	 'KÜTÜK'	,	27	,	 'DüzceModa'	)	,\n" + 
							"(	1405	,	 'MEHMET AKİF'	,	 'KARAALP'	,	28	,	 'EdirneModa'	)	,\n" + 
							"(	1406	,	 'HALİL CAN'	,	 'MENTEŞ'	,	29	,	 'ElazığModa'	)	,\n" + 
							"(	1407	,	 'FUAT ERNİS'	,	 'ERDAL'	,	30	,	 'ErzincanModa'	)	,\n" + 
							"(	1408	,	 'ERKAN'	,	 'KALEM'	,	31	,	 'ErzurumModa'	)	,\n" + 
							"(	1409	,	 'HATİCE'	,	 'KARABULUT'	,	32	,	 'EskişehirModa'	)	,\n" + 
							"(	1410	,	 'UĞUR'	,	 'CANPOLAT'	,	33	,	 'GaziantepModa'	)	,\n" + 
							"(	1411	,	 'ÇAĞLAR'	,	 'DÖNMEZ'	,	34	,	 'GiresunModa'	)	,\n" + 
							"(	1412	,	 'AYŞEGÜL'	,	 'TOPALKARA'	,	35	,	 'GümüşhaneModa'	)	,\n" + 
							"(	1413	,	 'SİBEL'	,	 'DEĞİRMENCİ'	,	36	,	 'HakkariModa'	)	,\n" + 
							"(	1414	,	 'NEZİH'	,	 'GÜRSOY'	,	37	,	 'HatayModa'	)	,\n" + 
							"(	1415	,	 'ESER'	,	 'USUL'	,	38	,	 'IğdırModa'	)	,\n" + 
							"(	1416	,	 'ÇİĞDEM'	,	 'VURGAN'	,	39	,	 'IspartaModa'	)	,\n" + 
							"(	1417	,	 'MUSTAFA'	,	 'GÜNGÖR'	,	40	,	 'İstanbulModa'	)	,\n" + 
							"(	1418	,	 'MUSTAFA'	,	 'YILMAZ'	,	41	,	 'İzmirModa'	)	,\n" + 
							"(	1419	,	 'RAHİME'	,	 'SAĞLAM'	,	42	,	 'KahramanmaraşModa'	)	,\n" + 
							"(	1420	,	 'YELDA'	,	 'KARPUZ'	,	43	,	 'KarabükModa'	)	,\n" + 
							"(	1421	,	 'DOĞAN'	,	 'SARI'	,	44	,	 'KaramanModa'	)	,\n" + 
							"(	1422	,	 'EMRAH'	,	 'AKGÜL'	,	45	,	 'KarsModa'	)	,\n" + 
							"(	1423	,	 'MELTEM'	,	 'KIRIŞ'	,	46	,	 'KastamonuModa'	)	,\n" + 
							"(	1424	,	 'SELİN'	,	 'KURTULUŞ'	,	47	,	 'KayseriModa'	)	,\n" + 
							"(	1425	,	 'FATİH'	,	 'KILIÇ'	,	48	,	 'KırıkkaleModa'	)	,\n" + 
							"(	1426	,	 'ÖZLEM'	,	 'OZAN'	,	49	,	 'KırklareliModa'	)	,\n" + 
							"(	1427	,	 'KERİM'	,	 'ÖLKER'	,	50	,	 'KırşehirModa'	)	,\n" + 
							"(	1428	,	 'AYKUT'	,	 'ÖZALP'	,	51	,	 'KilisModa'	)	,\n" + 
							"(	1429	,	 'AYSU'	,	 'AYDEMİR'	,	52	,	 'KocaeliModa'	)	,\n" + 
							"(	1430	,	 'AHMET'	,	 'ALTIN'	,	53	,	 'KonyaModa'	)	,\n" + 
							"(	1431	,	 'SAVAŞ'	,	 'SEYREKOĞLU'	,	54	,	 'KütahyaModa'	)	,\n" + 
							"(	1432	,	 'ZEHRA'	,	 'KARAKUŞ'	,	55	,	 'MalatyaModa'	)	,\n" + 
							"(	1433	,	 'GAMZE PINAR'	,	 'CANDANER'	,	56	,	 'ManisaModa'	)	,\n" + 
							"(	1434	,	 'GÜLSÜM'	,	 'EMRE'	,	57	,	 'MardinModa'	)	,\n" + 
							"(	1435	,	 'HAÇÇE'	,	 'ÖZLÜ'	,	58	,	 'MersinModa'	)	,\n" + 
							"(	1436	,	 'SEMİH'	,	 'YEŞİLOVA'	,	59	,	 'MuğlaModa'	)	,\n" + 
							"(	1437	,	 'ZEYNEP'	,	 'EREL'	,	60	,	 'MuşModa'	)	,\n" + 
							"(	1438	,	 'ARZU'	,	 'BAKLACI'	,	61	,	 'NevşehirModa'	)	,\n" + 
							"(	1439	,	 'AHMET'	,	 'BAYRAK'	,	62	,	 'NiğdeModa'	)	,\n" + 
							"(	1440	,	 'AHMET FURKAN'	,	 'KÖKSAL'	,	63	,	 'OrduModa'	)	,\n" + 
							"(	1441	,	 'AKSEL'	,	 'BABAYİĞİT'	,	64	,	 'OsmaniyeModa'	)	,\n" + 
							"(	1442	,	 'AHMET CEVDET'	,	 'ASLAN'	,	65	,	 'RizeModa'	)	,\n" + 
							"(	1443	,	 'FEVZİYE'	,	 'ÖZMUK'	,	66	,	 'SakaryaModa'	)	,\n" + 
							"(	1444	,	 'MUSTAFA GÜRHAN'	,	 'BİÇER'	,	67	,	 'SamsunModa'	)	,\n" + 
							"(	1445	,	 'RESA'	,	 'KARABULUT'	,	68	,	 'SiirtModa'	)	,\n" + 
							"(	1446	,	 'KURTULUŞ'	,	 'TOLU'	,	69	,	 'SinopModa'	)	,\n" + 
							"(	1447	,	 'AHMET EMRE'	,	 'ÜNAL'	,	70	,	 'SivasModa'	)	,\n" + 
							"(	1448	,	 'MÜRŞİT'	,	 'BACAKSIZ'	,	71	,	 'ŞanlıurfaModa'	)	,\n" + 
							"(	1449	,	 'EMEL'	,	 'GENCAN'	,	72	,	 'ŞırnakModa'	)	,\n" + 
							"(	1450	,	 'ESEN'	,	 'GÜRDAL'	,	73	,	 'TekirdağModa'	)	,\n" + 
							"(	1451	,	 'ÖMER'	,	 'ÖZ'	,	74	,	 'TokatModa'	)	,\n" + 
							"(	1452	,	 'ÖMER'	,	 'ADIGÜZEL'	,	75	,	 'TrabzonModa'	)	,\n" + 
							"(	1453	,	 'GAMZE'	,	 'ATEŞ'	,	76	,	 'TunceliModa'	)	,\n" + 
							"(	1454	,	 'GÖKHAN'	,	 'YILMAZ'	,	77	,	 'UşakModa'	)	,\n" + 
							"(	1455	,	 'RECEP'	,	 'GÖKGÜL'	,	78	,	 'VanModa'	)	,\n" + 
							"(	1456	,	 'FATİH'	,	 'UTLU'	,	79	,	 'YalovaModa'	)	,\n" + 
							"(	1457	,	 'ARİF'	,	 'KIRAÇ'	,	80	,	 'YozgatModa'	)	,\n" + 
							"(	1458	,	 'AHMET'	,	 'EKEN'	,	81	,	 'ZonguldakModa'	)	,\n" + 
							"(	1459	,	 'MARUF'	,	 'COŞAR'	,	1	,	 'AdanaModa'	)	,\n" + 
							"(	1460	,	 'DİDEM'	,	 'KARACAN'	,	2	,	 'AdıyamanModa'	)	,\n" + 
							"(	1461	,	 'YUSUF EMRE'	,	 'DÖKMECİ'	,	3	,	 'AfyonkarahisarModa'	)	,\n" + 
							"(	1462	,	 'HASAN'	,	 'BİNNETOĞLU'	,	4	,	 'AğrıModa'	)	,\n" + 
							"(	1463	,	 'MEHMET'	,	 'PULAT'	,	5	,	 'AksarayModa'	)	,\n" + 
							"(	1464	,	 'BARIŞ'	,	 'AKGÜL'	,	6	,	 'AmasyaModa'	)	,\n" + 
							"(	1465	,	 'SERDAR'	,	 'GÜNGÖR'	,	7	,	 'AnkaraModa'	)	,\n" + 
							"(	1466	,	 'NURDAN'	,	 'KACEMER'	,	8	,	 'AntalyaModa'	)	,\n" + 
							"(	1467	,	 'AHMET'	,	 'CAN'	,	9	,	 'ArdahanModa'	)	,\n" + 
							"(	1468	,	 'EYLEM'	,	 'ÖZGÜR'	,	10	,	 'ArtvinModa'	)	,\n" + 
							"(	1469	,	 'NURDAN'	,	 'TEOMAN'	,	11	,	 'AydınModa'	)	,\n" + 
							"(	1470	,	 'ŞEHMUS'	,	 'GÖKKOCA'	,	12	,	 'BalıkesirModa'	)	,\n" + 
							"(	1471	,	 'MERVE'	,	 'ALICI'	,	13	,	 'BartınModa'	)	,\n" + 
							"(	1472	,	 'MEHTAP'	,	 'POLAT'	,	14	,	 'BatmanModa'	)	,\n" + 
							"(	1473	,	 'SEDA ELÇİM'	,	 'MERSİN'	,	15	,	 'BayburtModa'	)	,\n" + 
							"(	1474	,	 'ENES TAHİR'	,	 'İNCE'	,	16	,	 'BilecikModa'	)	,\n" + 
							"(	1475	,	 'UMUT'	,	 'KURT'	,	17	,	 'BingölModa'	)	,\n" + 
							"(	1476	,	 'CEMİLE ÇİĞDEM'	,	 'ŞAHİN'	,	18	,	 'BitlisModa'	)	,\n" + 
							"(	1477	,	 'TUĞSEM'	,	 'ÇETİNTAŞ'	,	19	,	 'BoluModa'	)	,\n" + 
							"(	1478	,	 'HÜSEYİN KALKAN'	,	 'GÜLBAHAR'	,	20	,	 'DenizliModa'	)	,\n" + 
							"(	1479	,	 'EMRE'	,	 'ÇOBAN'	,	21	,	 'BursaModa'	)	,\n" + 
							"(	1480	,	 'AHMET MERT'	,	 'DURSUN'	,	22	,	 'ÇanakkaleModa'	)	,\n" + 
							"(	1481	,	 'ELİF'	,	 'KARATAŞ'	,	23	,	 'ÇankırıModa'	)	,\n" + 
							"(	1482	,	 'TÜRKER'	,	 'ÇELİK'	,	24	,	 'ÇorumModa'	)	,\n" + 
							"(	1483	,	 'AHMET ALİ'	,	 'ÇİMEN'	,	25	,	 'BurdurModa'	)	,\n" + 
							"(	1484	,	 'ORHAN'	,	 'BOZPOLAT'	,	26	,	 'DiyarbakırModa'	)	,\n" + 
							"(	1485	,	 'GÖKHAN'	,	 'DEMİREL'	,	27	,	 'DüzceModa'	)	,\n" + 
							"(	1486	,	 'NUR'	,	 'KILAVUZ'	,	28	,	 'EdirneModa'	)	,\n" + 
							"(	1487	,	 'ÖZLEM'	,	 'ARIK'	,	29	,	 'ElazığModa'	)	,\n" + 
							"(	1488	,	 'AHMET MELİH'	,	 'SEVİNÇ'	,	30	,	 'ErzincanModa'	)	,\n" + 
							"(	1489	,	 'DENİZ'	,	 'KIRIŞ'	,	31	,	 'ErzurumModa'	)	,\n" + 
							"(	1490	,	 'MERYEM'	,	 'ÖZCAN'	,	32	,	 'EskişehirModa'	)	,\n" + 
							"(	1491	,	 'EMİNE'	,	 'ÜNGÜR'	,	33	,	 'GaziantepModa'	)	,\n" + 
							"(	1492	,	 'SERAP'	,	 'KARSLI'	,	34	,	 'GiresunModa'	)	,\n" + 
							"(	1493	,	 'FUAT'	,	 'KILIÇ'	,	35	,	 'GümüşhaneModa'	)	,\n" + 
							"(	1494	,	 'ALİ BURÇ'	,	 'ATEŞ'	,	36	,	 'HakkariModa'	)	,\n" + 
							"(	1495	,	 'GÖKHAN'	,	 'KARAALP'	,	37	,	 'HatayModa'	)	,\n" + 
							"(	1496	,	 'NİMET DİDEM'	,	 'TOY'	,	38	,	 'IğdırModa'	)	,\n" + 
							"(	1497	,	 'EMİNE'	,	 'KULAKSIZ'	,	39	,	 'IspartaModa'	)	,\n" + 
							"(	1498	,	 'VOLKAN'	,	 'YILDIRIM'	,	40	,	 'İstanbulModa'	)	,\n" + 
							"(	1499	,	 'MEHMET EVREN'	,	 'KARAKÖSE'	,	41	,	 'İzmirModa'	)	,\n" + 
							"(	1500	,	 'ÜLKÜHAN'	,	 'BARAN'	,	42	,	 'KahramanmaraşModa'	)	,\n" + 
							"(	1501	,	 'MEHTAP'	,	 'ÖZAVCI AYGÜN'	,	43	,	 'KarabükModa'	)	,\n" + 
							"(	1502	,	 'ALİ SEÇKİN'	,	 'TOY'	,	44	,	 'KaramanModa'	)	,\n" + 
							"(	1503	,	 'ÖZLEM'	,	 'KARSLI'	,	45	,	 'KarsModa'	)	,\n" + 
							"(	1504	,	 'NURMUHAMMET'	,	 'KABAKUŞ'	,	46	,	 'KastamonuModa'	)	,\n" + 
							"(	1505	,	 'AYTAÇ'	,	 'KAYA'	,	47	,	 'KayseriModa'	)	,\n" + 
							"(	1506	,	 'ZEYNEP'	,	 'KÖKSAL'	,	48	,	 'KırıkkaleModa'	)	,\n" + 
							"(	1507	,	 'OZAN'	,	 'ADIGÜZEL'	,	49	,	 'KırklareliModa'	)	,\n" + 
							"(	1508	,	 'PINAR'	,	 'YEGİN'	,	50	,	 'KırşehirModa'	)	,\n" + 
							"(	1509	,	 'MEHMET'	,	 'ÇOPUR'	,	51	,	 'KilisModa'	)	,\n" + 
							"(	1510	,	 'İSMAİL'	,	 'ŞAHBAZ'	,	52	,	 'KocaeliModa'	)	,\n" + 
							"(	1511	,	 'AYDOĞAN'	,	 'KACEMER'	,	53	,	 'KonyaModa'	)	,\n" + 
							"(	1512	,	 'SERTAÇ'	,	 'BAHÇECİ'	,	54	,	 'KütahyaModa'	)	,\n" + 
							"(	1513	,	 'BURAK'	,	 'ALTUNA'	,	55	,	 'MalatyaModa'	)	,\n" + 
							"(	1514	,	 'YAHYA'	,	 'EMET'	,	56	,	 'ManisaModa'	)	,\n" + 
							"(	1515	,	 'HÜSEYİN'	,	 'BARAN'	,	57	,	 'MardinModa'	)	,\n" + 
							"(	1516	,	 'BERFİN CAN'	,	 'YERLİKAYA'	,	58	,	 'MersinModa'	)	,\n" + 
							"(	1517	,	 'SEDEF'	,	 'AKDEMİR'	,	59	,	 'MuğlaModa'	)	,\n" + 
							"(	1518	,	 'FUNDA'	,	 'ALICI'	,	60	,	 'MuşModa'	)	,\n" + 
							"(	1519	,	 'YUSUF ZİYA'	,	 'KARAKAŞ'	,	61	,	 'NevşehirModa'	)	,\n" + 
							"(	1520	,	 'SÜMEYYE'	,	 'GÖRKEM'	,	62	,	 'NiğdeModa'	)	,\n" + 
							"(	1521	,	 'EMİNE'	,	 'KILAVUZ'	,	63	,	 'OrduModa'	)	,\n" + 
							"(	1522	,	 'EMRE'	,	 'HAMDEMİRCİ'	,	64	,	 'OsmaniyeModa'	)	,\n" + 
							"(	1523	,	 'SİNAN'	,	 'SÖNMEZER'	,	65	,	 'RizeModa'	)	,\n" + 
							"(	1524	,	 'ABİDİN'	,	 'ÖRDEK'	,	66	,	 'SakaryaModa'	)	,\n" + 
							"(	1525	,	 'İSHAK'	,	 'BULAKÇI'	,	67	,	 'SamsunModa'	)	,\n" + 
							"(	1526	,	 'EBRU'	,	 'YAKUT'	,	68	,	 'SiirtModa'	)	,\n" + 
							"(	1527	,	 'İHSAN'	,	 'GÖNCÜ'	,	69	,	 'SinopModa'	)	,\n" + 
							"(	1528	,	 'BÜNYAMİN'	,	 'AYDIN'	,	70	,	 'SivasModa'	)	,\n" + 
							"(	1529	,	 'CAHİT'	,	 'BARDAKÇI'	,	71	,	 'ŞanlıurfaModa'	)	,\n" + 
							"(	1530	,	 'MUHAMMED HASAN'	,	 'BARATALI'	,	72	,	 'ŞırnakModa'	)	,\n" + 
							"(	1531	,	 'FATİH'	,	 'TEKİN'	,	73	,	 'TekirdağModa'	)	,\n" + 
							"(	1532	,	 'HALİM'	,	 'GÖRÜNMEZ'	,	74	,	 'TokatModa'	)	,\n" + 
							"(	1533	,	 'RUMEYSA'	,	 'GÜNDÜZ'	,	75	,	 'TrabzonModa'	)	,\n" + 
							"(	1534	,	 'ESRA'	,	 'GÜRPINAR'	,	76	,	 'TunceliModa'	)	,\n" + 
							"(	1535	,	 'GÖKHAN'	,	 'ORAK'	,	77	,	 'UşakModa'	)	,\n" + 
							"(	1536	,	 'ŞAFAK'	,	 'AKŞAHİN'	,	78	,	 'VanModa'	)	,\n" + 
							"(	1537	,	 'BERFİN'	,	 'ORMAN'	,	79	,	 'YalovaModa'	)	,\n" + 
							"(	1538	,	 'VAHDETTİN TALHA'	,	 'TOKAR'	,	80	,	 'YozgatModa'	)	,\n" + 
							"(	1539	,	 'MERVE'	,	 'AKSAKAL'	,	81	,	 'ZonguldakModa'	)	,\n" + 
							"(	1540	,	 'SEDEF'	,	 'KARLI'	,	1	,	 'AdanaModa'	)	,\n" + 
							"(	1541	,	 'MUSTAFA'	,	 'BALSAK'	,	2	,	 'AdıyamanModa'	)	,\n" + 
							"(	1542	,	 'MÜBECCEL'	,	 'KOÇAR'	,	3	,	 'AfyonkarahisarModa'	)	,\n" + 
							"(	1543	,	 'NURMUHAMMET'	,	 'ULUBAŞOĞLU'	,	4	,	 'AğrıModa'	)	,\n" + 
							"(	1544	,	 'ŞİRİN'	,	 'YÜCE'	,	5	,	 'AksarayModa'	)	,\n" + 
							"(	1545	,	 'ESRA'	,	 'ŞİMŞEK'	,	6	,	 'AmasyaModa'	)	,\n" + 
							"(	1546	,	 'ÖMER'	,	 'ÖZCAN'	,	7	,	 'AnkaraModa'	)	,\n" + 
							"(	1547	,	 'EKİN'	,	 'TÜRKOĞLU'	,	8	,	 'AntalyaModa'	)	,\n" + 
							"(	1548	,	 'MUSTAFA ABDULLAH'	,	 'ÖZDEN'	,	9	,	 'ArdahanModa'	)	,\n" + 
							"(	1549	,	 'HARUN'	,	 'GÜLEÇ'	,	10	,	 'ArtvinModa'	)	,\n" + 
							"(	1550	,	 'REZZAN'	,	 'IŞIK'	,	11	,	 'AydınModa'	)	,\n" + 
							"(	1551	,	 'CUNDULLAH'	,	 'KAPÇAK'	,	12	,	 'BalıkesirModa'	)	,\n" + 
							"(	1552	,	 'MUSTAFA ULAŞ'	,	 'AKKAYA'	,	13	,	 'BartınModa'	)	,\n" + 
							"(	1553	,	 'ERSİN'	,	 'ŞAŞMAZ'	,	14	,	 'BatmanModa'	)	,\n" + 
							"(	1554	,	 'FATİH'	,	 'KILIÇ'	,	15	,	 'BayburtModa'	)	,\n" + 
							"(	1555	,	 'NİLGÜN'	,	 'ELBÜKEN'	,	16	,	 'BilecikModa'	)	,\n" + 
							"(	1556	,	 'ÇAĞLAR'	,	 'ÖZKAN'	,	17	,	 'BingölModa'	)	,\n" + 
							"(	1557	,	 'SAVAŞ'	,	 'KÖROĞLU'	,	18	,	 'BitlisModa'	)	,\n" + 
							"(	1558	,	 'FATİH'	,	 'CÖMERT'	,	19	,	 'BoluModa'	)	,\n" + 
							"(	1559	,	 'ÖKKEŞ CELİL'	,	 'AKBAŞ ÖNCEL'	,	20	,	 'DenizliModa'	)	,\n" + 
							"(	1560	,	 'FATİH'	,	 'MERSİN'	,	21	,	 'BursaModa'	)	,\n" + 
							"(	1561	,	 'RUKİYE ÖZDEN'	,	 'SEVİNÇ'	,	22	,	 'ÇanakkaleModa'	)	,\n" + 
							"(	1562	,	 'ALİ'	,	 'YORGANCI'	,	23	,	 'ÇankırıModa'	)	,\n" + 
							"(	1563	,	 'TOLGAHAN'	,	 'KANDEMİR'	,	24	,	 'ÇorumModa'	)	,\n" + 
							"(	1564	,	 'LEYLA'	,	 'KOÇ'	,	25	,	 'BurdurModa'	)	,\n" + 
							"(	1565	,	 'ELİF'	,	 'AKGÜL'	,	26	,	 'DiyarbakırModa'	)	,\n" + 
							"(	1566	,	 'AYŞEGÜL'	,	 'ORDULU ŞAHİN'	,	27	,	 'DüzceModa'	)	,\n" + 
							"(	1567	,	 'MEHMET ALİ'	,	 'DEMİR'	,	28	,	 'EdirneModa'	)	,\n" + 
							"(	1568	,	 'BÜŞRA SULTAN'	,	 'KURU'	,	29	,	 'ElazığModa'	)	,\n" + 
							"(	1569	,	 'SÜLEYMAN'	,	 'KILIÇ'	,	30	,	 'ErzincanModa'	)	,\n" + 
							"(	1570	,	 'MUSTAFA'	,	 'BOZKURT'	,	31	,	 'ErzurumModa'	)	,\n" + 
							"(	1571	,	 'DENİZ'	,	 'HASSAN'	,	32	,	 'EskişehirModa'	)	,\n" + 
							"(	1572	,	 'RABİA'	,	 'ÇELİK'	,	33	,	 'GaziantepModa'	)	,\n" + 
							"(	1573	,	 'ELA'	,	 'KEKLİKÇİOĞLU'	,	34	,	 'GiresunModa'	)	,\n" + 
							"(	1574	,	 'EMİNE'	,	 'ÇETİN'	,	35	,	 'GümüşhaneModa'	)	,\n" + 
							"(	1575	,	 'ELİF'	,	 'ZEYLİ'	,	36	,	 'HakkariModa'	)	,\n" + 
							"(	1576	,	 'KEMAL'	,	 'ELDEM'	,	37	,	 'HatayModa'	)	,\n" + 
							"(	1577	,	 'SEMA'	,	 'AYDOS'	,	38	,	 'IğdırModa'	)	,\n" + 
							"(	1578	,	 'TUĞBA'	,	 'SU KURT'	,	39	,	 'IspartaModa'	)	,\n" + 
							"(	1579	,	 'ÖZLEM'	,	 'ÇELİK'	,	40	,	 'İstanbulModa'	)	,\n" + 
							"(	1580	,	 'FATMA ECE'	,	 'KÖKSAL'	,	41	,	 'İzmirModa'	)	,\n" + 
							"(	1581	,	 'HASAN'	,	 'KILAVUZ'	,	42	,	 'KahramanmaraşModa'	)	,\n" + 
							"(	1582	,	 'NAGİHAN'	,	 'KEŞKEK'	,	43	,	 'KarabükModa'	)	,\n" + 
							"(	1583	,	 'EMİN TONYUKUK'	,	 'EREN'	,	44	,	 'KaramanModa'	)	,\n" + 
							"(	1584	,	 'ERSİN'	,	 'ÖZEK'	,	45	,	 'KarsModa'	)	,\n" + 
							"(	1585	,	 'ESRA'	,	 'OĞUZ'	,	46	,	 'KastamonuModa'	)	,\n" + 
							"(	1586	,	 'GÜLBERAT'	,	 'POLAT'	,	47	,	 'KayseriModa'	)	,\n" + 
							"(	1587	,	 'MURAT'	,	 'YAKUT'	,	48	,	 'KırıkkaleModa'	)	,\n" + 
							"(	1588	,	 'VASFİYE'	,	 'DAL'	,	49	,	 'KırklareliModa'	)	,\n" + 
							"(	1589	,	 'FİLİZ'	,	 'BAKAY'	,	50	,	 'KırşehirModa'	)	,\n" + 
							"(	1590	,	 'KEMAL'	,	 'KIVRAK'	,	51	,	 'KilisModa'	)	,\n" + 
							"(	1591	,	 'NİHAL'	,	 'AL'	,	52	,	 'KocaeliModa'	)	,\n" + 
							"(	1592	,	 'İSMAİL ŞENOL'	,	 'AYHAN'	,	53	,	 'KonyaModa'	)	,\n" + 
							"(	1593	,	 'ERKİN'	,	 'TEHLİ'	,	54	,	 'KütahyaModa'	)	,\n" + 
							"(	1594	,	 'ÜMİT'	,	 'ARARAT'	,	55	,	 'MalatyaModa'	)	,\n" + 
							"(	1595	,	 'İLKAY'	,	 'ÖZSAYIM'	,	56	,	 'ManisaModa'	)	,\n" + 
							"(	1596	,	 'İLHAN'	,	 'GÜVEN'	,	57	,	 'MardinModa'	)	,\n" + 
							"(	1597	,	 'MURAT'	,	 'ÜNAL'	,	58	,	 'MersinModa'	)	,\n" + 
							"(	1598	,	 'SELCEN'	,	 'BULUÇ'	,	59	,	 'MuğlaModa'	)	,\n" + 
							"(	1599	,	 'İZZETTİN'	,	 'AKKOYUNLU'	,	60	,	 'MuşModa'	)	,\n" + 
							"(	1600	,	 'AHMET SERKAN'	,	 'KIYAK'	,	61	,	 'NevşehirModa'	)	,\n" + 
							"(	1601	,	 'YURDUN'	,	 'YAVUZ SEZGİN'	,	62	,	 'NiğdeModa'	)	,\n" + 
							"(	1602	,	 'CEYHUN'	,	 'ALP'	,	63	,	 'OrduModa'	)	,\n" + 
							"(	1603	,	 'ŞADİYE SELİN'	,	 'TOKAR'	,	64	,	 'OsmaniyeModa'	)	,\n" + 
							"(	1604	,	 'İLKNUR'	,	 'KULAKSIZ'	,	65	,	 'RizeModa'	)	,\n" + 
							"(	1605	,	 'HAYRİYE'	,	 'ARIK'	,	66	,	 'SakaryaModa'	)	,\n" + 
							"(	1606	,	 'GAMZE'	,	 'AKTAN'	,	67	,	 'SamsunModa'	)	,\n" + 
							"(	1607	,	 'UFUK'	,	 'BAL'	,	68	,	 'SiirtModa'	)	,\n" + 
							"(	1608	,	 'İSMAİL'	,	 'YAKUT'	,	69	,	 'SinopModa'	)	,\n" + 
							"(	1609	,	 'ABDULKADİR'	,	 'TAZEOĞLU'	,	70	,	 'SivasModa'	)	,\n" + 
							"(	1610	,	 'ADEM'	,	 'BARÇA'	,	71	,	 'ŞanlıurfaModa'	)	,\n" + 
							"(	1611	,	 'İBRAHİM'	,	 'ULUBAŞOĞLU'	,	72	,	 'ŞırnakModa'	)	,\n" + 
							"(	1612	,	 'MERVE'	,	 'DÖNERTAŞ'	,	73	,	 'TekirdağModa'	)	,\n" + 
							"(	1613	,	 'HASAN'	,	 'KILIÇOĞLU'	,	74	,	 'TokatModa'	)	,\n" + 
							"(	1614	,	 'SIDDIKA'	,	 'ÖNDER'	,	75	,	 'TrabzonModa'	)	,\n" + 
							"(	1615	,	 'YELDA'	,	 'SERT'	,	76	,	 'TunceliModa'	)	,\n" + 
							"(	1616	,	 'GÖKSEL'	,	 'ÖZ'	,	77	,	 'UşakModa'	)	,\n" + 
							"(	1617	,	 'RABİA'	,	 'BAŞDAŞ'	,	78	,	 'VanModa'	)	,\n" + 
							"(	1618	,	 'AHMET'	,	 'ULU'	,	79	,	 'YalovaModa'	)	,\n" + 
							"(	1619	,	 'HALUK'	,	 'YAZICI'	,	80	,	 'YozgatModa'	)	,\n" + 
							"(	1620	,	 'ZEHRA'	,	 'PEKGÖZ'	,	81	,	 'ZonguldakModa'	)	;" ;
					String insertTables10="\n" + 
							"INSERT INTO `SALESMAN_INFO` (`salesman_no`, `salesman_name`, `salesman_surname`, `country_id`, `branch_name`) VALUES\n" + 
							"\n" + 
							"(	1	,	 'MÜRSEL'	,	 'DEVECİ'	,	1	,	 'AdanaAtasehir'	)	,\n" + 
							"(	2	,	 'BURCU'	,	 'BARAN'	,	2	,	 'AdıyamanAtasehir'	)	,\n" + 
							"(	3	,	 'SUNA'	,	 'ÖZTÜRK'	,	3	,	 'AfyonkarahisarAtasehir'	)	,\n" + 
							"(	4	,	 'MUSTAFA'	,	 'YAZICI'	,	4	,	 'AğrıAtasehir'	)	,\n" + 
							"(	5	,	 'SÜMEYRA'	,	 'URUÇ'	,	5	,	 'AksarayAtasehir'	)	,\n" + 
							"(	6	,	 'ENDER'	,	 'İNER KÖKSAL'	,	6	,	 'AmasyaAtasehir'	)	,\n" + 
							"(	7	,	 'RECEP '	,	 'GANİ'	,	7	,	 'AnkaraAtasehir'	)	,\n" + 
							"(	8	,	 'DEMET'	,	 'KUSERLİ'	,	8	,	 'AntalyaAtasehir'	)	,\n" + 
							"(	9	,	 'MUSTAFA'	,	 'SAKA'	,	9	,	 'ArdahanAtasehir'	)	,\n" + 
							"(	10	,	 'SEMİH'	,	 'ÇEKİÇ'	,	10	,	 'ArtvinAtasehir'	)	,\n" + 
							"(	11	,	 'MUSTAFA'	,	 'NADASTEPE'	,	11	,	 'AydınAtasehir'	)	,\n" + 
							"(	12	,	 'FEVZİ FIRAT'	,	 'DÖNMEZ'	,	12	,	 'BalıkesirAtasehir'	)	,\n" + 
							"(	13	,	 'ZEYNEP '	,	 'GÖKÇE'	,	13	,	 'BartınAtasehir'	)	,\n" + 
							"(	14	,	 'AHMET KÜRŞAD'	,	 'ÖLKER'	,	14	,	 'BatmanAtasehir'	)	,\n" + 
							"(	15	,	 'ÇAĞLA'	,	 'KELEŞ'	,	15	,	 'BayburtAtasehir'	)	,\n" + 
							"(	16	,	 'ATİYE MELTEM'	,	 'İNCE'	,	16	,	 'BilecikAtasehir'	)	,\n" + 
							"(	17	,	 'MEHMET'	,	 'AYMAN'	,	17	,	 'BingölAtasehir'	)	,\n" + 
							"(	18	,	 'YASEMİN'	,	 'ERAT'	,	18	,	 'BitlisAtasehir'	)	,\n" + 
							"(	19	,	 'AHMET EMRE'	,	 'SARIKAYA'	,	19	,	 'BoluAtasehir'	)	,\n" + 
							"(	20	,	 'BAŞAK'	,	 'OCAK'	,	20	,	 'DenizliAtasehir'	)	,\n" + 
							"(	21	,	 'İSMAİL'	,	 'SU DUR'	,	21	,	 'BursaAtasehir'	)	,\n" + 
							"(	22	,	 'KIYMET'	,	 'MERT'	,	22	,	 'ÇanakkaleAtasehir'	)	,\n" + 
							"(	23	,	 'MUHAMMET DEVRAN'	,	 'GÜRDAL'	,	23	,	 'ÇankırıAtasehir'	)	,\n" + 
							"(	24	,	 'RECEP'	,	 'AKYÜREK'	,	24	,	 'ÇorumAtasehir'	)	,\n" + 
							"(	25	,	 'MUHAMMED'	,	 'ŞEKERLER'	,	25	,	 'BurdurAtasehir'	)	,\n" + 
							"(	26	,	 'ALİ'	,	 'ANIK'	,	26	,	 'DiyarbakırAtasehir'	)	,\n" + 
							"(	27	,	 'EMİNE'	,	 'ARGON'	,	27	,	 'DüzceAtasehir'	)	,\n" + 
							"(	28	,	 'MUSTAFA GÜVENÇ'	,	 'GÖKMEYDAN'	,	28	,	 'EdirneAtasehir'	)	,\n" + 
							"(	29	,	 'ŞENAY'	,	 'KARLI'	,	29	,	 'ElazığAtasehir'	)	,\n" + 
							"(	30	,	 'İBRAHİM FUAT'	,	 'KARAMEŞE'	,	30	,	 'ErzincanAtasehir'	)	,\n" + 
							"(	31	,	 'EVRİM'	,	 'AYDEMİR'	,	31	,	 'ErzurumAtasehir'	)	,\n" + 
							"(	32	,	 'ÇETİN'	,	 'BARÇA'	,	32	,	 'EskişehirAtasehir'	)	,\n" + 
							"(	33	,	 'MEHMET'	,	 'KUŞAKÇI'	,	33	,	 'GaziantepAtasehir'	)	,\n" + 
							"(	34	,	 'EMİNE'	,	 'ALTIN'	,	34	,	 'GiresunAtasehir'	)	,\n" + 
							"(	35	,	 'ESEN İBRAHİM'	,	 'BULUT'	,	35	,	 'GümüşhaneAtasehir'	)	,\n" + 
							"(	36	,	 'YUNUS EMRE'	,	 'KAYKI'	,	36	,	 'HakkariAtasehir'	)	,\n" + 
							"(	37	,	 'CEM'	,	 'HAMDEMİRCİ'	,	37	,	 'HatayAtasehir'	)	,\n" + 
							"(	38	,	 'ORHAN'	,	 'ÖZDEMİR'	,	38	,	 'IğdırAtasehir'	)	,\n" + 
							"(	39	,	 'CEBRAİL'	,	 'KARAKAYA'	,	39	,	 'IspartaAtasehir'	)	,\n" + 
							"(	40	,	 'ŞİRİN'	,	 'ZEYBEK'	,	40	,	 'İstanbulAtasehir'	)	,\n" + 
							"(	41	,	 'ÇAĞRI'	,	 'ÖZDEMİR'	,	41	,	 'İzmirAtasehir'	)	,\n" + 
							"(	42	,	 'GÜL'	,	 'SARIÇİÇEK'	,	42	,	 'KahramanmaraşAtasehir'	)	,\n" + 
							"(	43	,	 'ENVER'	,	 'TURAÇ'	,	43	,	 'KarabükAtasehir'	)	,\n" + 
							"(	44	,	 'OĞUZ KAĞAN'	,	 'KAYA'	,	44	,	 'KaramanAtasehir'	)	,\n" + 
							"(	45	,	 'SEDAT'	,	 'TOY'	,	45	,	 'KarsAtasehir'	)	,\n" + 
							"(	46	,	 'İSMAİL'	,	 'ALTAŞ'	,	46	,	 'KastamonuAtasehir'	)	,\n" + 
							"(	47	,	 'SÜREYYA'	,	 'ALTUN'	,	47	,	 'KayseriAtasehir'	)	,\n" + 
							"(	48	,	 'GÖZDE'	,	 'BALSAK'	,	48	,	 'KırıkkaleAtasehir'	)	,\n" + 
							"(	49	,	 'ETHEM'	,	 'KARAMEŞE'	,	49	,	 'KırklareliAtasehir'	)	,\n" + 
							"(	50	,	 'HÜSEYİN YAVUZ'	,	 'SALDIRAY'	,	50	,	 'KırşehirAtasehir'	)	,\n" + 
							"(	51	,	 'İLKNUR'	,	 'OKUR'	,	51	,	 'KilisAtasehir'	)	,\n" + 
							"(	52	,	 'İLKNUR'	,	 'GÖKGÜL'	,	52	,	 'KocaeliAtasehir'	)	,\n" + 
							"(	53	,	 'İLKER'	,	 'DUMLUDAĞ'	,	53	,	 'KonyaAtasehir'	)	,\n" + 
							"(	54	,	 'TURGAY'	,	 'İPEK'	,	54	,	 'KütahyaAtasehir'	)	,\n" + 
							"(	55	,	 'MUSTAFA'	,	 'YILMAZ'	,	55	,	 'MalatyaAtasehir'	)	,\n" + 
							"(	56	,	 'MUSTAFA GÜRHAN'	,	 'ÇİNPOLAT'	,	56	,	 'ManisaAtasehir'	)	,\n" + 
							"(	57	,	 'DENİZ'	,	 'ÇETİN'	,	57	,	 'MardinAtasehir'	)	,\n" + 
							"(	58	,	 'BELGİN EMİNE'	,	 'ONAT'	,	58	,	 'MersinAtasehir'	)	,\n" + 
							"(	59	,	 'ŞERİFE EZGİ'	,	 'ARIKBOĞA'	,	59	,	 'MuğlaAtasehir'	)	,\n" + 
							"(	60	,	 'CEREN'	,	 'KOTTAŞ'	,	60	,	 'MuşAtasehir'	)	,\n" + 
							"(	61	,	 'ÖMER'	,	 'GÜRPINAR'	,	61	,	 'NevşehirAtasehir'	)	,\n" + 
							"(	62	,	 'OKAN'	,	 'GÜRDAL'	,	62	,	 'NiğdeAtasehir'	)	,\n" + 
							"(	63	,	 'DİLARA'	,	 'SAKARYA'	,	63	,	 'OrduAtasehir'	)	,\n" + 
							"(	64	,	 'KURTULUŞ'	,	 'VURGAN'	,	64	,	 'OsmaniyeAtasehir'	)	,\n" + 
							"(	65	,	 'KADİR'	,	 'DARAMAN'	,	65	,	 'RizeAtasehir'	)	,\n" + 
							"(	66	,	 'ÖZGÜR'	,	 'ÖLKER'	,	66	,	 'SakaryaAtasehir'	)	,\n" + 
							"(	67	,	 'DENİZ'	,	 'KARADAĞ'	,	67	,	 'SamsunAtasehir'	)	,\n" + 
							"(	68	,	 'TOLGAHAN'	,	 'HATİPOĞLU'	,	68	,	 'SiirtAtasehir'	)	,\n" + 
							"(	69	,	 'AHMET'	,	 'KİRİŞCİ'	,	69	,	 'SinopAtasehir'	)	,\n" + 
							"(	70	,	 'YAKUP'	,	 'DOĞAN'	,	70	,	 'SivasAtasehir'	)	,\n" + 
							"(	71	,	 'EMİŞ'	,	 'BAL'	,	71	,	 'ŞanlıurfaAtasehir'	)	,\n" + 
							"(	72	,	 'TOLGAHAN'	,	 'ATILGAN'	,	72	,	 'ŞırnakAtasehir'	)	,\n" + 
							"(	73	,	 'TİMUÇİN'	,	 'ÖZTÜRK'	,	73	,	 'TekirdağAtasehir'	)	,\n" + 
							"(	74	,	 'BÜNYAMİN'	,	 'KALIPCI'	,	74	,	 'TokatAtasehir'	)	,\n" + 
							"(	75	,	 'NEVAL'	,	 'ÖZKAN'	,	75	,	 'TrabzonAtasehir'	)	,\n" + 
							"(	76	,	 'OSMAN'	,	 'ŞAHİN'	,	76	,	 'TunceliAtasehir'	)	,\n" + 
							"(	77	,	 'ŞULE MİNE'	,	 'AKDEMİR'	,	77	,	 'UşakAtasehir'	)	,\n" + 
							"(	78	,	 'NAZAN'	,	 'KAYMAN KÖSE'	,	78	,	 'VanAtasehir'	)	,\n" + 
							"(	79	,	 'AYŞE GÜL'	,	 'ONRAT'	,	79	,	 'YalovaAtasehir'	)	,\n" + 
							"(	80	,	 'MEHMET SELAHATTİN'	,	 'ŞEKERLER'	,	80	,	 'YozgatAtasehir'	)	,\n" + 
							"(	81	,	 'SERHAT'	,	 'ÇELİKTEN'	,	81	,	 'ZonguldakAtasehir'	)	,\n" + 
							"(	82	,	 'DERYA'	,	 'ALP'	,	1	,	 'AdanaAtasehir'	)	,\n" + 
							"(	83	,	 'EDA'	,	 'KARA'	,	2	,	 'AdıyamanAtasehir'	)	,\n" + 
							"(	84	,	 'CEYDA'	,	 'HAMDEMİRCİ'	,	3	,	 'AfyonkarahisarAtasehir'	)	,\n" + 
							"(	85	,	 'ASENA'	,	 'CANDAN'	,	4	,	 'AğrıAtasehir'	)	,\n" + 
							"(	86	,	 'ÇİLE'	,	 'ÖZDOĞAN KAVZOĞLU'	,	5	,	 'AksarayAtasehir'	)	,\n" + 
							"(	87	,	 'ÖZTAN'	,	 'ÇEVİKER'	,	6	,	 'AmasyaAtasehir'	)	,\n" + 
							"(	88	,	 'İBRAHİM'	,	 'ŞİRİN'	,	7	,	 'AnkaraAtasehir'	)	,\n" + 
							"(	89	,	 'EVREN'	,	 'SADIÇ'	,	8	,	 'AntalyaAtasehir'	)	,\n" + 
							"(	90	,	 'KURTULUŞ'	,	 'BAHÇECİ'	,	9	,	 'ArdahanAtasehir'	)	,\n" + 
							"(	91	,	 'TOLGAHAN'	,	 'KESGİN'	,	10	,	 'ArtvinAtasehir'	)	,\n" + 
							"(	92	,	 'BAHRİ'	,	 'SERT'	,	11	,	 'AydınAtasehir'	)	,\n" + 
							"(	93	,	 'EBRU'	,	 'GÜLŞAN'	,	12	,	 'BalıkesirAtasehir'	)	,\n" + 
							"(	94	,	 'ÖZEN ÖZLEM'	,	 'DEMİR'	,	13	,	 'BartınAtasehir'	)	,\n" + 
							"(	95	,	 'SONGÜL'	,	 'ÇİMEN'	,	14	,	 'BatmanAtasehir'	)	,\n" + 
							"(	96	,	 'GÖKMEN ALPASLAN'	,	 'ÖZDEMİRKIRAN'	,	15	,	 'BayburtAtasehir'	)	,\n" + 
							"(	97	,	 'EMİNE'	,	 'ÇELİK'	,	16	,	 'BilecikAtasehir'	)	,\n" + 
							"(	98	,	 'FATMA'	,	 'ŞAŞMAZ'	,	17	,	 'BingölAtasehir'	)	,\n" + 
							"(	99	,	 'MEHMET'	,	 'ŞANLIKAN'	,	18	,	 'BitlisAtasehir'	)	,\n" + 
							"(	100	,	 'EMİNE'	,	 'DEMİR'	,	19	,	 'BoluAtasehir'	)	,\n" + 
							"(	101	,	 'HALİME'	,	 'ÜNÜVAR'	,	20	,	 'DenizliAtasehir'	)	,\n" + 
							"(	102	,	 'FEYZAHAN'	,	 'OKULU'	,	21	,	 'BursaAtasehir'	)	,\n" + 
							"(	103	,	 'CEM'	,	 'ORHAN'	,	22	,	 'ÇanakkaleAtasehir'	)	,\n" + 
							"(	104	,	 'AYSU'	,	 'TUNCAY'	,	23	,	 'ÇankırıAtasehir'	)	,\n" + 
							"(	105	,	 'MUSTAFA'	,	 'ZAİM'	,	24	,	 'ÇorumAtasehir'	)	,\n" + 
							"(	106	,	 'MEHMET REŞİT'	,	 'ACAR'	,	25	,	 'BurdurAtasehir'	)	,\n" + 
							"(	107	,	 'HİDAYET'	,	 'AKTAŞ'	,	26	,	 'DiyarbakırAtasehir'	)	,\n" + 
							"(	108	,	 'MESUT'	,	 'CANTÜRK'	,	27	,	 'DüzceAtasehir'	)	,\n" + 
							"(	109	,	 'DERYA'	,	 'KABAKUŞ'	,	28	,	 'EdirneAtasehir'	)	,\n" + 
							"(	110	,	 'TAYFUN'	,	 'KURT'	,	29	,	 'ElazığAtasehir'	)	,\n" + 
							"(	111	,	 'YİĞİT'	,	 'YURDAKÖK'	,	30	,	 'ErzincanAtasehir'	)	,\n" + 
							"(	112	,	 'DEMİR'	,	 'ÇELİK'	,	31	,	 'ErzurumAtasehir'	)	,\n" + 
							"(	113	,	 'JÜLİDE ZEHRA'	,	 'SAKARYA'	,	32	,	 'EskişehirAtasehir'	)	,\n" + 
							"(	114	,	 'MUHAMMET TAYYİP'	,	 'TOPRAK'	,	33	,	 'GaziantepAtasehir'	)	,\n" + 
							"(	115	,	 'MAHSUM'	,	 'ÇİÇEK'	,	34	,	 'GiresunAtasehir'	)	,\n" + 
							"(	116	,	 'HÜSEYİN'	,	 'ARMAĞAN'	,	35	,	 'GümüşhaneAtasehir'	)	,\n" + 
							"(	117	,	 'ONUR'	,	 'ELBÜKEN'	,	36	,	 'HakkariAtasehir'	)	,\n" + 
							"(	118	,	 'HÜSEYİN'	,	 'KANYILMAZ'	,	37	,	 'HatayAtasehir'	)	,\n" + 
							"(	119	,	 'MARİA'	,	 'YILDIRIM'	,	38	,	 'IğdırAtasehir'	)	,\n" + 
							"(	120	,	 'NAZAN'	,	 'TUNCER'	,	39	,	 'IspartaAtasehir'	)	,\n" + 
							"(	121	,	 'HÜSEYİN CAHİT'	,	 'BOZKURT'	,	40	,	 'İstanbulAtasehir'	)	,\n" + 
							"(	122	,	 'İSHAK'	,	 'ÖZGÜROL'	,	41	,	 'İzmirAtasehir'	)	,\n" + 
							"(	123	,	 'ZEHRA'	,	 'KOL'	,	42	,	 'KahramanmaraşAtasehir'	)	,\n" + 
							"(	124	,	 'ALİŞAN'	,	 'DİKİCİ'	,	43	,	 'KarabükAtasehir'	)	,\n" + 
							"(	125	,	 'AYTAÇ'	,	 'ÜÇER'	,	44	,	 'KaramanAtasehir'	)	,\n" + 
							"(	126	,	 'EMİNE DİLEK'	,	 'ILGIN'	,	45	,	 'KarsAtasehir'	)	,\n" + 
							"(	127	,	 'ERCAN'	,	 'AKTEMUR'	,	46	,	 'KastamonuAtasehir'	)	,\n" + 
							"(	128	,	 'GÜNDEM'	,	 'YILDIZ'	,	47	,	 'KayseriAtasehir'	)	,\n" + 
							"(	129	,	 'FATİH'	,	 'KOTTAŞ'	,	48	,	 'KırıkkaleAtasehir'	)	,\n" + 
							"(	130	,	 'İLYAS'	,	 'TUNÇ'	,	49	,	 'KırklareliAtasehir'	)	,\n" + 
							"(	131	,	 'MUHAMMET MURAT'	,	 'GÜNDÜZ'	,	50	,	 'KırşehirAtasehir'	)	,\n" + 
							"(	132	,	 'TİMUR'	,	 'ÜNAL'	,	51	,	 'KilisAtasehir'	)	,\n" + 
							"(	133	,	 'İBRAHİM'	,	 'KÜÇÜKGÖNCÜ'	,	52	,	 'KocaeliAtasehir'	)	,\n" + 
							"(	134	,	 'ERGÜL'	,	 'ERZURUM'	,	53	,	 'KonyaAtasehir'	)	,\n" + 
							"(	135	,	 'AHMET BURAK'	,	 'TÜRKAY'	,	54	,	 'KütahyaAtasehir'	)	,\n" + 
							"(	136	,	 'SEDA'	,	 'TURMUŞ'	,	55	,	 'MalatyaAtasehir'	)	,\n" + 
							"(	137	,	 'ERKİN'	,	 'CANATAN'	,	56	,	 'ManisaAtasehir'	)	,\n" + 
							"(	138	,	 'MUSTAFA'	,	 'YILDIZ'	,	57	,	 'MardinAtasehir'	)	,\n" + 
							"(	139	,	 'ALPER'	,	 'ÇAĞLAR'	,	58	,	 'MersinAtasehir'	)	,\n" + 
							"(	140	,	 'IŞIL'	,	 'BAŞ'	,	59	,	 'MuğlaAtasehir'	)	,\n" + 
							"(	141	,	 'NURULLAH'	,	 'GÖKÇEN'	,	60	,	 'MuşAtasehir'	)	,\n" + 
							"(	142	,	 'EMEL'	,	 'CEBECİ'	,	61	,	 'NevşehirAtasehir'	)	,\n" + 
							"(	143	,	 'CEYHUN'	,	 'ÇAĞIL'	,	62	,	 'NiğdeAtasehir'	)	,\n" + 
							"(	144	,	 'AYŞE CEREN'	,	 'EROĞLU'	,	63	,	 'OrduAtasehir'	)	,\n" + 
							"(	145	,	 'MURAT'	,	 'GÜRSOY'	,	64	,	 'OsmaniyeAtasehir'	)	,\n" + 
							"(	146	,	 'TUĞBA'	,	 'SEVÜK'	,	65	,	 'RizeAtasehir'	)	,\n" + 
							"(	147	,	 'ESRA CAN'	,	 'SABAZ'	,	66	,	 'SakaryaAtasehir'	)	,\n" + 
							"(	148	,	 'AHMET GÖKHAN'	,	 'TOPER'	,	67	,	 'SamsunAtasehir'	)	,\n" + 
							"(	149	,	 'ALİ'	,	 'YÜCEL'	,	68	,	 'SiirtAtasehir'	)	,\n" + 
							"(	150	,	 'ÖKKEŞ CELİL'	,	 'AKBUDAK'	,	69	,	 'SinopAtasehir'	)	,\n" + 
							"(	151	,	 'SALİHA'	,	 'YAZICI'	,	70	,	 'SivasAtasehir'	)	,\n" + 
							"(	152	,	 'CENGİZ'	,	 'SARICA DAROL'	,	71	,	 'ŞanlıurfaAtasehir'	)	,\n" + 
							"(	153	,	 'İREM'	,	 'KADAK'	,	72	,	 'ŞırnakAtasehir'	)	,\n" + 
							"(	154	,	 'YASEMİN'	,	 'ŞAHİN'	,	73	,	 'TekirdağAtasehir'	)	,\n" + 
							"(	155	,	 'DENİZ'	,	 'ÜNAL'	,	74	,	 'TokatAtasehir'	)	,\n" + 
							"(	156	,	 'GÜLTEKİN  GÜNHAN'	,	 'GÜRPINAR'	,	75	,	 'TrabzonAtasehir'	)	,\n" + 
							"(	157	,	 'HÜMEYRA'	,	 'ÖZEK'	,	76	,	 'TunceliAtasehir'	)	,\n" + 
							"(	158	,	 'HASAN'	,	 'EROL'	,	77	,	 'UşakAtasehir'	)	,\n" + 
							"(	159	,	 'NAZIM'	,	 'KESKİN'	,	78	,	 'VanAtasehir'	)	,\n" + 
							"(	160	,	 'ERKAN'	,	 'ULU'	,	79	,	 'YalovaAtasehir'	)	,\n" + 
							"(	161	,	 'SEZAİ'	,	 'BACAK'	,	80	,	 'YozgatAtasehir'	)	,\n" + 
							"(	162	,	 'AHMET ÇAĞRI'	,	 'DURAN'	,	81	,	 'ZonguldakAtasehir'	)	,\n" + 
							"(	163	,	 'ÖZGÜL'	,	 'KARPUZ'	,	1	,	 'AdanaAtasehir'	)	,\n" + 
							"(	164	,	 'SİBEL'	,	 'ÇELİK'	,	2	,	 'AdıyamanAtasehir'	)	,\n" + 
							"(	165	,	 'CEYHUN'	,	 'YILMAZ'	,	3	,	 'AfyonkarahisarAtasehir'	)	,\n" + 
							"(	166	,	 'SUAT'	,	 'CAN'	,	4	,	 'AğrıAtasehir'	)	,\n" + 
							"(	167	,	 'ŞİRİN'	,	 'BAYTAN'	,	5	,	 'AksarayAtasehir'	)	,\n" + 
							"(	168	,	 'ZEYNALABİDİN'	,	 'İVACIK'	,	6	,	 'AmasyaAtasehir'	)	,\n" + 
							"(	169	,	 'SUAT'	,	 'ÇAĞIL'	,	7	,	 'AnkaraAtasehir'	)	,\n" + 
							"(	170	,	 'TEYFİK'	,	 'DOĞAN'	,	8	,	 'AntalyaAtasehir'	)	,\n" + 
							"(	171	,	 'FATMA'	,	 'ÇOBAN'	,	9	,	 'ArdahanAtasehir'	)	,\n" + 
							"(	172	,	 'KAMİL'	,	 'AL'	,	10	,	 'ArtvinAtasehir'	)	,\n" + 
							"(	173	,	 'İLYAS'	,	 'BABAYİĞİT'	,	11	,	 'AydınAtasehir'	)	,\n" + 
							"(	174	,	 'ÖZLEM'	,	 'ÇİFT'	,	12	,	 'BalıkesirAtasehir'	)	,\n" + 
							"(	175	,	 'SELİN'	,	 'ADIGÜZEL'	,	13	,	 'BartınAtasehir'	)	,\n" + 
							"(	176	,	 'ALİ'	,	 'APAYDIN'	,	14	,	 'BatmanAtasehir'	)	,\n" + 
							"(	177	,	 'NİHAL'	,	 'GÜNDÜZ'	,	15	,	 'BayburtAtasehir'	)	,\n" + 
							"(	178	,	 'FADIL'	,	 'ÇELİKTEN'	,	16	,	 'BilecikAtasehir'	)	,\n" + 
							"(	179	,	 'İLKER'	,	 'KARA'	,	17	,	 'BingölAtasehir'	)	,\n" + 
							"(	180	,	 'İKLİL'	,	 'ÖZLÜ'	,	18	,	 'BitlisAtasehir'	)	,\n" + 
							"(	181	,	 'HASAN'	,	 'DURÇ ÖZTÜRK'	,	19	,	 'BoluAtasehir'	)	,\n" + 
							"(	182	,	 'EZGİ GİZEM'	,	 '1'	,	20	,	 'DenizliAtasehir'	)	,\n" + 
							"(	183	,	 'ONUR'	,	 'KOCA'	,	21	,	 'BursaAtasehir'	)	,\n" + 
							"(	184	,	 'MUSTAFA'	,	 'YARADILMIŞ'	,	22	,	 'ÇanakkaleAtasehir'	)	,\n" + 
							"(	185	,	 'NURİ'	,	 'COŞAR'	,	23	,	 'ÇankırıAtasehir'	)	,\n" + 
							"(	186	,	 'ÜMİT'	,	 'KAYA'	,	24	,	 'ÇorumAtasehir'	)	,\n" + 
							"(	187	,	 'KORAY'	,	 'GÖKALP'	,	25	,	 'BurdurAtasehir'	)	,\n" + 
							"(	188	,	 'SULTAN'	,	 'DİLLİ'	,	26	,	 'DiyarbakırAtasehir'	)	,\n" + 
							"(	189	,	 'SEZGİ'	,	 'ALTUNTAŞ'	,	27	,	 'DüzceAtasehir'	)	,\n" + 
							"(	190	,	 'AYŞEGÜL'	,	 'GÜLTEKİN'	,	28	,	 'EdirneAtasehir'	)	,\n" + 
							"(	191	,	 'HÜSEYİN KUNTER'	,	 'AKTAŞ'	,	29	,	 'ElazığAtasehir'	)	,\n" + 
							"(	192	,	 'BARIŞ'	,	 'KILIÇ'	,	30	,	 'ErzincanAtasehir'	)	,\n" + 
							"(	193	,	 'GAMZE'	,	 'DÖNERTAŞ'	,	31	,	 'ErzurumAtasehir'	)	,\n" + 
							"(	194	,	 'ZÜHAL'	,	 'ARIKBOĞA'	,	32	,	 'EskişehirAtasehir'	)	,\n" + 
							"(	195	,	 'MUSTAFA KEMAL'	,	 'ÖZTÜRK'	,	33	,	 'GaziantepAtasehir'	)	,\n" + 
							"(	196	,	 'MESUT'	,	 'ÇAKIR'	,	34	,	 'GiresunAtasehir'	)	,\n" + 
							"(	197	,	 'ORHAN'	,	 'GÜNEBAKAN'	,	35	,	 'GümüşhaneAtasehir'	)	,\n" + 
							"(	198	,	 'GÖKHAN'	,	 'BAKIRCI'	,	36	,	 'HakkariAtasehir'	)	,\n" + 
							"(	199	,	 'ESMA'	,	 'KÜTÜK'	,	37	,	 'HatayAtasehir'	)	,\n" + 
							"(	200	,	 'AYDIN'	,	 'KAYA'	,	38	,	 'IğdırAtasehir'	)	,\n" + 
							"(	201	,	 'YUSUF'	,	 'ÖZDEMİR'	,	39	,	 'IspartaAtasehir'	)	,\n" + 
							"(	202	,	 'EMRAH'	,	 'ÇOKER'	,	40	,	 'İstanbulAtasehir'	)	,\n" + 
							"(	203	,	 'MUSTAFA'	,	 'ÇEÇEN'	,	41	,	 'İzmirAtasehir'	)	,\n" + 
							"(	204	,	 'İLYAS'	,	 'KIRHAN'	,	42	,	 'KahramanmaraşAtasehir'	)	,\n" + 
							"(	205	,	 'İBRAHİM TAYFUN'	,	 'DENİZ'	,	43	,	 'KarabükAtasehir'	)	,\n" + 
							"(	206	,	 'AHMET ÇAĞRI'	,	 'ÖZALP'	,	44	,	 'KaramanAtasehir'	)	,\n" + 
							"(	207	,	 'FİLİZ'	,	 'AYDIN'	,	45	,	 'KarsAtasehir'	)	,\n" + 
							"(	208	,	 'SEVAL'	,	 'GÖKTAŞ'	,	46	,	 'KastamonuAtasehir'	)	,\n" + 
							"(	209	,	 'GÜLŞAH'	,	 'EVREN'	,	47	,	 'KayseriAtasehir'	)	,\n" + 
							"(	210	,	 'EMEL'	,	 'BİLİCİ'	,	48	,	 'KırıkkaleAtasehir'	)	,\n" + 
							"(	211	,	 'HÜSEYİN'	,	 'TUNCER'	,	49	,	 'KırklareliAtasehir'	)	,\n" + 
							"(	212	,	 'EBRU'	,	 'ÖZCANLI'	,	50	,	 'KırşehirAtasehir'	)	,\n" + 
							"(	213	,	 'GÜLŞAH'	,	 'HATİPOĞLU'	,	51	,	 'KilisAtasehir'	)	,\n" + 
							"(	214	,	 'PINAR'	,	 'TOY'	,	52	,	 'KocaeliAtasehir'	)	,\n" + 
							"(	215	,	 'SERKAN FAZLI'	,	 'GELEGEN'	,	53	,	 'KonyaAtasehir'	)	,\n" + 
							"(	216	,	 'LEMAN'	,	 'ALTUN'	,	54	,	 'KütahyaAtasehir'	)	,\n" + 
							"(	217	,	 'NİLÜFER'	,	 'ŞAŞMAZ'	,	55	,	 'MalatyaAtasehir'	)	,\n" + 
							"(	218	,	 'TUBA'	,	 'ÇOPUR'	,	56	,	 'ManisaAtasehir'	)	,\n" + 
							"(	219	,	 'ŞEHMUS'	,	 'AVCU'	,	57	,	 'MardinAtasehir'	)	,\n" + 
							"(	220	,	 'HAMİT'	,	 'DEMİRCAN'	,	58	,	 'MersinAtasehir'	)	,\n" + 
							"(	221	,	 'BURAK'	,	 'TUNCER'	,	59	,	 'MuğlaAtasehir'	)	,\n" + 
							"(	222	,	 'MESUT'	,	 'ERTAŞ'	,	60	,	 'MuşAtasehir'	)	,\n" + 
							"(	223	,	 'KÜBRA'	,	 'OLGAÇ'	,	61	,	 'NevşehirAtasehir'	)	,\n" + 
							"(	224	,	 'AYCAN ÖZDEN'	,	 'MERDEN'	,	62	,	 'NiğdeAtasehir'	)	,\n" + 
							"(	225	,	 'SERHAT'	,	 'BAYRAK'	,	63	,	 'OrduAtasehir'	)	,\n" + 
							"(	226	,	 'RİFAT CAN'	,	 'YAKUT'	,	64	,	 'OsmaniyeAtasehir'	)	,\n" + 
							"(	227	,	 'BAYRAM'	,	 'OLGEN'	,	65	,	 'RizeAtasehir'	)	,\n" + 
							"(	228	,	 'MEHRİ'	,	 'KAYNAK'	,	66	,	 'SakaryaAtasehir'	)	,\n" + 
							"(	229	,	 'SAMET'	,	 'ÇİNPOLAT'	,	67	,	 'SamsunAtasehir'	)	,\n" + 
							"(	230	,	 'MUSTAFA'	,	 'TENEKECİ'	,	68	,	 'SiirtAtasehir'	)	,\n" + 
							"(	231	,	 'TUNCAY'	,	 'CEYLAN'	,	69	,	 'SinopAtasehir'	)	,\n" + 
							"(	232	,	 'ULAŞ'	,	 'POLAT'	,	70	,	 'SivasAtasehir'	)	,\n" + 
							"(	233	,	 'OSMAN ERSEGUN'	,	 'ATAK'	,	71	,	 'ŞanlıurfaAtasehir'	)	,\n" + 
							"(	234	,	 'HANDE'	,	 'KARAKAYA'	,	72	,	 'ŞırnakAtasehir'	)	,\n" + 
							"(	235	,	 'FATİH'	,	 'SELVAN'	,	73	,	 'TekirdağAtasehir'	)	,\n" + 
							"(	236	,	 'DİDEM'	,	 'ÇELİKTEN'	,	74	,	 'TokatAtasehir'	)	,\n" + 
							"(	237	,	 'ALİ'	,	 'AYDOĞAN'	,	75	,	 'TrabzonAtasehir'	)	,\n" + 
							"(	238	,	 'NİMET'	,	 'DOĞAN'	,	76	,	 'TunceliAtasehir'	)	,\n" + 
							"(	239	,	 'TUNA'	,	 'KOYUNCU'	,	77	,	 'UşakAtasehir'	)	,\n" + 
							"(	240	,	 'BEYZA'	,	 'DİKOĞLU'	,	78	,	 'VanAtasehir'	)	,\n" + 
							"(	241	,	 'ABDURRAHMAN'	,	 'KANKILIÇ'	,	79	,	 'YalovaAtasehir'	)	,\n" + 
							"(	242	,	 'MUSTAFA'	,	 'GÖKSEL'	,	80	,	 'YozgatAtasehir'	)	,\n" + 
							"(	243	,	 'METİN'	,	 'KAYA'	,	81	,	 'ZonguldakAtasehir'	)	,\n" + 
							"(	244	,	 'HAMZA'	,	 'KABİL KUCUR'	,	1	,	 'AdanaAtasehir'	)	,\n" + 
							"(	245	,	 'TUBA'	,	 'GÜZEL'	,	2	,	 'AdıyamanAtasehir'	)	,\n" + 
							"(	246	,	 'CANSEN'	,	 'TEPE'	,	3	,	 'AfyonkarahisarAtasehir'	)	,\n" + 
							"(	247	,	 'ŞAHABETTİN'	,	 'KAYA'	,	4	,	 'AğrıAtasehir'	)	,\n" + 
							"(	248	,	 'ABDULAZİZ'	,	 'ÇİLESİZ'	,	5	,	 'AksarayAtasehir'	)	,\n" + 
							"(	249	,	 'SİNAN'	,	 'GÜNDOĞDU'	,	6	,	 'AmasyaAtasehir'	)	,\n" + 
							"(	250	,	 'HAYRİ'	,	 'GÜVEN'	,	7	,	 'AnkaraAtasehir'	)	,\n" + 
							"(	251	,	 'MUSTAFA GÜRHAN'	,	 'BAŞARGAN'	,	8	,	 'AntalyaAtasehir'	)	,\n" + 
							"(	252	,	 'TOLUNAY'	,	 'OFLAZOĞLU'	,	9	,	 'ArdahanAtasehir'	)	,\n" + 
							"(	253	,	 'ŞİFA'	,	 'GÜZEL'	,	10	,	 'ArtvinAtasehir'	)	,\n" + 
							"(	254	,	 'EMEL'	,	 'KIRBAŞ'	,	11	,	 'AydınAtasehir'	)	,\n" + 
							"(	255	,	 'YASİN'	,	 'ARSLAN'	,	12	,	 'BalıkesirAtasehir'	)	,\n" + 
							"(	256	,	 'ORHAN'	,	 'GELEGEN'	,	13	,	 'BartınAtasehir'	)	,\n" + 
							"(	257	,	 'KASIM'	,	 'KIRLANGIÇ'	,	14	,	 'BatmanAtasehir'	)	,\n" + 
							"(	258	,	 'MUHAMMET DEVRAN'	,	 'CORUT'	,	15	,	 'BayburtAtasehir'	)	,\n" + 
							"(	259	,	 'BARIŞ'	,	 'DEMİR'	,	16	,	 'BilecikAtasehir'	)	,\n" + 
							"(	260	,	 'UTKU'	,	 'KARADAĞ GEÇGEL'	,	17	,	 'BingölAtasehir'	)	,\n" + 
							"(	261	,	 'SERHAT'	,	 'TUNÇ'	,	18	,	 'BitlisAtasehir'	)	,\n" + 
							"(	262	,	 'TURĞUT'	,	 'GÖZÜGÜL'	,	19	,	 'BoluAtasehir'	)	,\n" + 
							"(	263	,	 'SONGÜL'	,	 'EMİRLİOĞLU'	,	20	,	 'DenizliAtasehir'	)	,\n" + 
							"(	264	,	 'LEYLA'	,	 'GÜNEYSU'	,	21	,	 'BursaAtasehir'	)	,\n" + 
							"(	265	,	 'HİDAYET'	,	 'KAYA'	,	22	,	 'ÇanakkaleAtasehir'	)	,\n" + 
							"(	266	,	 'ABDULLAH'	,	 'ARSLAN'	,	23	,	 'ÇankırıAtasehir'	)	,\n" + 
							"(	267	,	 'YÜCE'	,	 'ÇAĞIL'	,	24	,	 'ÇorumAtasehir'	)	,\n" + 
							"(	268	,	 'ESRA'	,	 'ŞAHİN'	,	25	,	 'BurdurAtasehir'	)	,\n" + 
							"(	269	,	 'EBRU'	,	 'KILAVUZ'	,	26	,	 'DiyarbakırAtasehir'	)	,\n" + 
							"(	270	,	 'ÖMER FARUK'	,	 'TOPRAK'	,	27	,	 'DüzceAtasehir'	)	,\n" + 
							"(	271	,	 'AHMET'	,	 'ŞAHİN'	,	28	,	 'EdirneAtasehir'	)	,\n" + 
							"(	272	,	 'RESA'	,	 'ÖZDEMİR'	,	29	,	 'ElazığAtasehir'	)	,\n" + 
							"(	273	,	 'BARIŞ'	,	 'KAYA'	,	30	,	 'ErzincanAtasehir'	)	,\n" + 
							"(	274	,	 'EVREN'	,	 'UTLU'	,	31	,	 'ErzurumAtasehir'	)	,\n" + 
							"(	275	,	 'AYŞE'	,	 'BABA'	,	32	,	 'EskişehirAtasehir'	)	,\n" + 
							"(	276	,	 'ALİ'	,	 'BEKAR'	,	33	,	 'GaziantepAtasehir'	)	,\n" + 
							"(	277	,	 'ŞEYMA'	,	 'YILMAZ'	,	34	,	 'GiresunAtasehir'	)	,\n" + 
							"(	278	,	 'DENİZ'	,	 'KISA KARAKAYA'	,	35	,	 'GümüşhaneAtasehir'	)	,\n" + 
							"(	279	,	 'BERFU'	,	 'ÖZAN SANHAL'	,	36	,	 'HakkariAtasehir'	)	,\n" + 
							"(	280	,	 'ABDULKADİR'	,	 'YILMAZ'	,	37	,	 'HatayAtasehir'	)	,\n" + 
							"(	281	,	 'OSMAN'	,	 'GÜNDÜZ'	,	38	,	 'IğdırAtasehir'	)	,\n" + 
							"(	282	,	 'KÜBRA'	,	 'ÇOKER'	,	39	,	 'IspartaAtasehir'	)	,\n" + 
							"(	283	,	 'OSMAN'	,	 'GÖKTEN'	,	40	,	 'İstanbulAtasehir'	)	,\n" + 
							"(	284	,	 'MUSTAFA ABDULLAH'	,	 'KAYMAN KÖSE'	,	41	,	 'İzmirAtasehir'	)	,\n" + 
							"(	285	,	 'SERKAN'	,	 'ŞENTÜRK'	,	42	,	 'KahramanmaraşAtasehir'	)	,\n" + 
							"(	286	,	 'MUSTAFA ARİF'	,	 'ŞAHİN'	,	43	,	 'KarabükAtasehir'	)	,\n" + 
							"(	287	,	 'SEDA'	,	 'ÖZTÜRK'	,	44	,	 'KaramanAtasehir'	)	,\n" + 
							"(	288	,	 'FUNDA'	,	 'ATLANOĞLU'	,	45	,	 'KarsAtasehir'	)	,\n" + 
							"(	289	,	 'DENİZ'	,	 'KOL'	,	46	,	 'KastamonuAtasehir'	)	,\n" + 
							"(	290	,	 'BARIŞ'	,	 'ÖZDEMİR'	,	47	,	 'KayseriAtasehir'	)	,\n" + 
							"(	291	,	 'MESUDE'	,	 'TÜRKAY'	,	48	,	 'KırıkkaleAtasehir'	)	,\n" + 
							"(	292	,	 'ELİF'	,	 'KIR'	,	49	,	 'KırklareliAtasehir'	)	,\n" + 
							"(	293	,	 'İRFAN YILDIRIM'	,	 'KARAMEŞE'	,	50	,	 'KırşehirAtasehir'	)	,\n" + 
							"(	294	,	 'YURDAGÜL'	,	 'ŞANLIKAN'	,	51	,	 'KilisAtasehir'	)	,\n" + 
							"(	295	,	 'LALE'	,	 'KURT GÜNEY'	,	52	,	 'KocaeliAtasehir'	)	,\n" + 
							"(	296	,	 'TUNA'	,	 'KOÇAR'	,	53	,	 'KonyaAtasehir'	)	,\n" + 
							"(	297	,	 'EMİNE'	,	 'DÜZCE'	,	54	,	 'KütahyaAtasehir'	)	,\n" + 
							"(	298	,	 'İBRAHİM'	,	 'YÜCE'	,	55	,	 'MalatyaAtasehir'	)	,\n" + 
							"(	299	,	 'PINAR'	,	 'BÜBER'	,	56	,	 'ManisaAtasehir'	)	,\n" + 
							"(	300	,	 'GÜLDEHEN'	,	 'GÜREL'	,	57	,	 'MardinAtasehir'	)	,\n" + 
							"(	301	,	 'ZEYNEP'	,	 'VEZİROĞLU BİRDANE'	,	58	,	 'MersinAtasehir'	)	,\n" + 
							"(	302	,	 'KEZBAN'	,	 'KIRLI'	,	59	,	 'MuğlaAtasehir'	)	,\n" + 
							"(	303	,	 'ESRA'	,	 'OCAK'	,	60	,	 'MuşAtasehir'	)	,\n" + 
							"(	304	,	 'ZÜHAL GÜLSÜM'	,	 'ÇINKIT'	,	61	,	 'NevşehirAtasehir'	)	,\n" + 
							"(	305	,	 'HALİME'	,	 'TUNCER'	,	62	,	 'NiğdeAtasehir'	)	,\n" + 
							"(	306	,	 'YASEMİN'	,	 'KÜTÜK'	,	63	,	 'OrduAtasehir'	)	,\n" + 
							"(	307	,	 'SONGÜL'	,	 'YENİDÜNYA'	,	64	,	 'OsmaniyeAtasehir'	)	,\n" + 
							"(	308	,	 'NEZAKET'	,	 'BİLGİÇ'	,	65	,	 'RizeAtasehir'	)	,\n" + 
							"(	309	,	 'BELMA'	,	 'SAĞCAN'	,	66	,	 'SakaryaAtasehir'	)	,\n" + 
							"(	310	,	 'MURAT'	,	 'ALBEN'	,	67	,	 'SamsunAtasehir'	)	,\n" + 
							"(	311	,	 'NUMAN'	,	 'ATİLLA'	,	68	,	 'SiirtAtasehir'	)	,\n" + 
							"(	312	,	 'FIRAT'	,	 'TÜFENK'	,	69	,	 'SinopAtasehir'	)	,\n" + 
							"(	313	,	 'AYLİN'	,	 'YILDIRIM'	,	70	,	 'SivasAtasehir'	)	,\n" + 
							"(	314	,	 'ADNAN'	,	 'KAYA'	,	71	,	 'ŞanlıurfaAtasehir'	)	,\n" + 
							"(	315	,	 'MİNE'	,	 'ÇİNPOLAT'	,	72	,	 'ŞırnakAtasehir'	)	,\n" + 
							"(	316	,	 'CEYLAN'	,	 'KEŞKEK'	,	73	,	 'TekirdağAtasehir'	)	,\n" + 
							"(	317	,	 'MUZAFFER OĞUZ'	,	 'DÜZEL'	,	74	,	 'TokatAtasehir'	)	,\n" + 
							"(	318	,	 'SAADET NİLAY'	,	 'EVREN'	,	75	,	 'TrabzonAtasehir'	)	,\n" + 
							"(	319	,	 'AYŞE'	,	 'ŞEN GÖKÇEİMAM'	,	76	,	 'TunceliAtasehir'	)	,\n" + 
							"(	320	,	 'FATİH'	,	 'SOMAY'	,	77	,	 'UşakAtasehir'	)	,\n" + 
							"(	321	,	 'EVREN'	,	 'YALÇIN'	,	78	,	 'VanAtasehir'	)	,\n" + 
							"(	322	,	 'HÜSEYİN'	,	 'YENİLMEZ'	,	79	,	 'YalovaAtasehir'	)	,\n" + 
							"(	323	,	 'SAMİ'	,	 'DEMİR'	,	80	,	 'YozgatAtasehir'	)	,\n" + 
							"(	324	,	 'DERYA'	,	 'ÖZTAŞ'	,	81	,	 'ZonguldakAtasehir'	)	,\n" + 
							"(	325	,	 'ABDURRAHMAN FUAT'	,	 'BAYRAMOĞLU'	,	1	,	 'AdanaKadikoy'	)	,\n" + 
							"(	326	,	 'ABDULKADİR'	,	 'TEL KANKILIÇ'	,	2	,	 'AdıyamanKadikoy'	)	,\n" + 
							"(	327	,	 'EBRU'	,	 'EŞFER'	,	3	,	 'AfyonkarahisarKadikoy'	)	,\n" + 
							"(	328	,	 'EDİP GÜVENÇ'	,	 'DEVECİ'	,	4	,	 'AğrıKadikoy'	)	,\n" + 
							"(	329	,	 'SELÇUK'	,	 'TAYYAR'	,	5	,	 'AksarayKadikoy'	)	,\n" + 
							"(	330	,	 'YASEMİN'	,	 'ÇELİK'	,	6	,	 'AmasyaKadikoy'	)	,\n" + 
							"(	331	,	 'ELİF'	,	 'ULU'	,	7	,	 'AnkaraKadikoy'	)	,\n" + 
							"(	332	,	 'MAHİR'	,	 'ŞAİR'	,	8	,	 'AntalyaKadikoy'	)	,\n" + 
							"(	333	,	 'ÖZNUR'	,	 'KAÇER'	,	9	,	 'ArdahanKadikoy'	)	,\n" + 
							"(	334	,	 'DUYGU'	,	 'YILMAZ'	,	10	,	 'ArtvinKadikoy'	)	,\n" + 
							"(	335	,	 'AZİZ'	,	 'BAŞAR'	,	11	,	 'AydınKadikoy'	)	,\n" + 
							"(	336	,	 'BAVER'	,	 'OCAK'	,	12	,	 'BalıkesirKadikoy'	)	,\n" + 
							"(	337	,	 'MUSTAFA GÜVENÇ'	,	 'SEYHAN'	,	13	,	 'BartınKadikoy'	)	,\n" + 
							"(	338	,	 'SEMRA'	,	 'GENÇ'	,	14	,	 'BatmanKadikoy'	)	,\n" + 
							"(	339	,	 'YUSUF ALPER'	,	 'TATAR'	,	15	,	 'BayburtKadikoy'	)	,\n" + 
							"(	340	,	 'ÖVGÜ ANIL'	,	 'NAR'	,	16	,	 'BilecikKadikoy'	)	,\n" + 
							"(	341	,	 'AYDIN'	,	 'TEOMAN'	,	17	,	 'BingölKadikoy'	)	,\n" + 
							"(	342	,	 'ŞERİF'	,	 'ALTUN'	,	18	,	 'BitlisKadikoy'	)	,\n" + 
							"(	343	,	 'ÖKKEŞ YILMAZ'	,	 'DEMİRTAŞ'	,	19	,	 'BoluKadikoy'	)	,\n" + 
							"(	344	,	 'ŞULE'	,	 'DEMİRTAŞ'	,	20	,	 'DenizliKadikoy'	)	,\n" + 
							"(	345	,	 'SERKAN'	,	 'YANMAZ'	,	21	,	 'BursaKadikoy'	)	,\n" + 
							"(	346	,	 'REŞAT'	,	 'CEYLAN'	,	22	,	 'ÇanakkaleKadikoy'	)	,\n" + 
							"(	347	,	 'SEMA'	,	 'DOĞAN'	,	23	,	 'ÇankırıKadikoy'	)	,\n" + 
							"(	348	,	 'ÖZNUR'	,	 'KARAKUŞ'	,	24	,	 'ÇorumKadikoy'	)	,\n" + 
							"(	349	,	 'EVRE'	,	 'ŞAHİN'	,	25	,	 'BurdurKadikoy'	)	,\n" + 
							"(	350	,	 'DENİZ'	,	 'GÖRMELİ'	,	26	,	 'DiyarbakırKadikoy'	)	,\n" + 
							"(	351	,	 'MURAT'	,	 'CANSEVER'	,	27	,	 'DüzceKadikoy'	)	,\n" + 
							"(	352	,	 'ÖMER'	,	 'KURTULUŞ'	,	28	,	 'EdirneKadikoy'	)	,\n" + 
							"(	353	,	 'GÖKNUR'	,	 'OZAN'	,	29	,	 'ElazığKadikoy'	)	,\n" + 
							"(	354	,	 'GÜNDEM'	,	 'İNER KÖKSAL'	,	30	,	 'ErzincanKadikoy'	)	,\n" + 
							"(	355	,	 'MURAT'	,	 'ERYILMAZ'	,	31	,	 'ErzurumKadikoy'	)	,\n" + 
							"(	356	,	 'SİNAN DİNÇER'	,	 'AKSOY'	,	32	,	 'EskişehirKadikoy'	)	,\n" + 
							"(	357	,	 'ÜMİT'	,	 'AYDIN'	,	33	,	 'GaziantepKadikoy'	)	,\n" + 
							"(	358	,	 'ESRA'	,	 'UÇAR'	,	34	,	 'GiresunKadikoy'	)	,\n" + 
							"(	359	,	 'MAHMUT'	,	 'GÜRER'	,	35	,	 'GümüşhaneKadikoy'	)	,\n" + 
							"(	360	,	 'REMZİYE'	,	 'İNER KÖKSAL'	,	36	,	 'HakkariKadikoy'	)	,\n" + 
							"(	361	,	 'ÖKKEŞ CELİL'	,	 'DEMİRTAŞ'	,	37	,	 'HatayKadikoy'	)	,\n" + 
							"(	362	,	 'SABAHATTİN'	,	 'CANTÜRK'	,	38	,	 'IğdırKadikoy'	)	,\n" + 
							"(	363	,	 'AYŞE'	,	 'KARADAĞ'	,	39	,	 'IspartaKadikoy'	)	,\n" + 
							"(	364	,	 'MEHMET ÖZER'	,	 'SERTKAYAOĞLU'	,	40	,	 'İstanbulKadikoy'	)	,\n" + 
							"(	365	,	 'MELİKE'	,	 'ŞAHİN'	,	41	,	 'İzmirKadikoy'	)	,\n" + 
							"(	366	,	 'EVREN'	,	 'ERDEM'	,	42	,	 'KahramanmaraşKadikoy'	)	,\n" + 
							"(	367	,	 'MUSTAFA'	,	 'KÖROĞLU'	,	43	,	 'KarabükKadikoy'	)	,\n" + 
							"(	368	,	 'MÜCAHİT'	,	 'SEYREKOĞLU'	,	44	,	 'KaramanKadikoy'	)	,\n" + 
							"(	369	,	 'CEREN'	,	 'IŞIKLI'	,	45	,	 'KarsKadikoy'	)	,\n" + 
							"(	370	,	 'OSMAN'	,	 'UZUN'	,	46	,	 'KastamonuKadikoy'	)	,\n" + 
							"(	371	,	 'EBRU'	,	 'BAHÇECİ'	,	47	,	 'KayseriKadikoy'	)	,\n" + 
							"(	372	,	 'MUSTAFA'	,	 'YEŞİLKAYA'	,	48	,	 'KırıkkaleKadikoy'	)	,\n" + 
							"(	373	,	 'SEDAT'	,	 'KAYA'	,	49	,	 'KırklareliKadikoy'	)	,\n" + 
							"(	374	,	 'ALİ SAİD'	,	 'YERLİKAYA'	,	50	,	 'KırşehirKadikoy'	)	,\n" + 
							"(	375	,	 'DUYGU'	,	 'KARAPIÇAK'	,	51	,	 'KilisKadikoy'	)	,\n" + 
							"(	376	,	 'MUTLU'	,	 'ÖZDEMİR'	,	52	,	 'KocaeliKadikoy'	)	,\n" + 
							"(	377	,	 'EVREN'	,	 'SÖZEN'	,	53	,	 'KonyaKadikoy'	)	,\n" + 
							"(	378	,	 'REZAN'	,	 'YEŞİLOVA'	,	54	,	 'KütahyaKadikoy'	)	,\n" + 
							"(	379	,	 'EMİNE'	,	 'ERASLAN'	,	55	,	 'MalatyaKadikoy'	)	,\n" + 
							"(	380	,	 'ORHAN'	,	 'ACAR'	,	56	,	 'ManisaKadikoy'	)	,\n" + 
							"(	381	,	 'TUĞBA'	,	 'SARICA DAROL'	,	57	,	 'MardinKadikoy'	)	,\n" + 
							"(	382	,	 'YÜCEL'	,	 'NİZAM'	,	58	,	 'MersinKadikoy'	)	,\n" + 
							"(	383	,	 'EKREM'	,	 'ÇİÇEKBİLEK'	,	59	,	 'MuğlaKadikoy'	)	,\n" + 
							"(	384	,	 'ARİF'	,	 'ABAT'	,	60	,	 'MuşKadikoy'	)	,\n" + 
							"(	385	,	 'FATİH'	,	 'KARA'	,	61	,	 'NevşehirKadikoy'	)	,\n" + 
							"(	386	,	 'İSMAİL'	,	 'GÖKTAŞ'	,	62	,	 'NiğdeKadikoy'	)	,\n" + 
							"(	387	,	 'MEHMET AKİF'	,	 'YILDIRIM'	,	63	,	 'OrduKadikoy'	)	,\n" + 
							"(	388	,	 'EMİNE'	,	 'AYCAN'	,	64	,	 'OsmaniyeKadikoy'	)	,\n" + 
							"(	389	,	 'NURDAN'	,	 'CİNBİZ'	,	65	,	 'RizeKadikoy'	)	,\n" + 
							"(	390	,	 'NURCAN'	,	 'KARDAŞ'	,	66	,	 'SakaryaKadikoy'	)	,\n" + 
							"(	391	,	 'ENGİN'	,	 'SÜVERAN'	,	67	,	 'SamsunKadikoy'	)	,\n" + 
							"(	392	,	 'EREN'	,	 'DURÇ ÖZTÜRK'	,	68	,	 'SiirtKadikoy'	)	,\n" + 
							"(	393	,	 'BEDRİYE MÜGE'	,	 'ŞAHAN'	,	69	,	 'SinopKadikoy'	)	,\n" + 
							"(	394	,	 'MEHMET RAŞİT'	,	 'KARLI'	,	70	,	 'SivasKadikoy'	)	,\n" + 
							"(	395	,	 'JALE'	,	 'KARACA'	,	71	,	 'ŞanlıurfaKadikoy'	)	,\n" + 
							"(	396	,	 'EKREM'	,	 'NASUHBEYOĞLU'	,	72	,	 'ŞırnakKadikoy'	)	,\n" + 
							"(	397	,	 'EMİN'	,	 'KARCIOĞLU'	,	73	,	 'TekirdağKadikoy'	)	,\n" + 
							"(	398	,	 'YAKUP ONUR'	,	 'CELİLOĞLU'	,	74	,	 'TokatKadikoy'	)	,\n" + 
							"(	399	,	 'KAMERCAN'	,	 'BİRİ'	,	75	,	 'TrabzonKadikoy'	)	,\n" + 
							"(	400	,	 'RABİA'	,	 'ERSOY'	,	76	,	 'TunceliKadikoy'	)	,\n" + 
							"(	401	,	 'EVRİM'	,	 'DURAN'	,	77	,	 'UşakKadikoy'	)	,\n" + 
							"(	402	,	 'OKTAY'	,	 'KILIÇ'	,	78	,	 'VanKadikoy'	)	,\n" + 
							"(	403	,	 'GÜLŞAH'	,	 'DEDE'	,	79	,	 'YalovaKadikoy'	)	,\n" + 
							"(	404	,	 'MEHMET RAŞİT'	,	 'DALYAN CİLO'	,	80	,	 'YozgatKadikoy'	)	,\n" + 
							"(	405	,	 'NİMET DİDEM'	,	 'ALTIN'	,	81	,	 'ZonguldakKadikoy'	)	,\n" + 
							"(	406	,		'ULAŞ ', 'SARIKAYA'		,	20	,	 'AdanaKadikoy'	)	,\n" + 
							"(	407	,	 'KEMAL'	,	 'ETLEÇ'	,	2	,	 'AdıyamanKadikoy'	)	,\n" + 
							"(	408	,	 'AYLİA'	,	 'BAKAN'	,	3	,	 'AfyonkarahisarKadikoy'	)	,\n" + 
							"(	409	,	 'OĞUZ'	,	 'TİKİCİ'	,	4	,	 'AğrıKadikoy'	)	,\n" + 
							"(	410	,	 'ZEYNEP'	,	 'ÖZDEMİR'	,	5	,	 'AksarayKadikoy'	)	,\n" + 
							"(	411	,	 'YILDIRAY'	,	 'SANHAL'	,	6	,	 'AmasyaKadikoy'	)	,\n" + 
							"(	412	,	 'BELGİN'	,	 'ATİLLA'	,	7	,	 'AnkaraKadikoy'	)	,\n" + 
							"(	413	,	 'SÜLEYMAN'	,	 'ÖNCEL'	,	8	,	 'AntalyaKadikoy'	)	,\n" + 
							"(	414	,	 'TÜMAY'	,	 'GÖRMELİ'	,	9	,	 'ArdahanKadikoy'	)	,\n" + 
							"(	415	,	 'MEHMET'	,	 'HALİS'	,	10	,	 'ArtvinKadikoy'	)	,\n" + 
							"(	416	,	 'PELİN'	,	 'ÖZATEŞ'	,	11	,	 'AydınKadikoy'	)	,\n" + 
							"(	417	,	 'MEHMET'	,	 'BERBER'	,	12	,	 'BalıkesirKadikoy'	)	,\n" + 
							"(	418	,	 'MEHMET VEHBİ'	,	 'KAYA'	,	13	,	 'BartınKadikoy'	)	,\n" + 
							"(	419	,	 'DİDEM'	,	 'MÜFTÜOĞLU'	,	14	,	 'BatmanKadikoy'	)	,\n" + 
							"(	420	,	 'ARİF'	,	 'KANKILIÇ'	,	15	,	 'BayburtKadikoy'	)	,\n" + 
							"(	421	,	 'ŞAHABETTİN'	,	 'AKHUN'	,	16	,	 'BilecikKadikoy'	)	,\n" + 
							"(	422	,	 'FERHAT'	,	 'ÇOBAN'	,	17	,	 'BingölKadikoy'	)	,\n" + 
							"(	423	,	 'VELAT'	,	 'ÖZCAN'	,	18	,	 'BitlisKadikoy'	)	,\n" + 
							"(	424	,	 'AHMET'	,	 'ÖZSAYIM'	,	19	,	 'BoluKadikoy'	)	,\n" + 
							"(	425	,	 'DİDEM'	,	 'ÇEVİRGEN'	,	20	,	 'DenizliKadikoy'	)	,\n" + 
							"(	426	,	 'ORHAN'	,	 'KARPUZ'	,	21	,	 'BursaKadikoy'	)	,\n" + 
							"(	427	,	 'MELİKE'	,	 'TUNCER'	,	22	,	 'ÇanakkaleKadikoy'	)	,\n" + 
							"(	428	,	 'BİLAL BARIŞ'	,	 'AKKOYUNLU'	,	23	,	 'ÇankırıKadikoy'	)	,\n" + 
							"(	429	,	 'YUSUF'	,	 'YAYIKÇI'	,	24	,	 'ÇorumKadikoy'	)	,\n" + 
							"(	430	,	 'GÖKTEKİN'	,	 'İNANMAZ'	,	25	,	 'BurdurKadikoy'	)	,\n" + 
							"(	431	,	 'HATİCE'	,	 'ELÇİÇEK'	,	26	,	 'DiyarbakırKadikoy'	)	,\n" + 
							"(	432	,	 'ELİF'	,	 'ÖZATEŞ'	,	27	,	 'DüzceKadikoy'	)	,\n" + 
							"(	433	,	 'VOLKAN'	,	 'DARAMAN'	,	28	,	 'EdirneKadikoy'	)	,\n" + 
							"(	434	,	 'SERDAR'	,	 'CANBOLAT'	,	29	,	 'ElazığKadikoy'	)	,\n" + 
							"(	435	,	 'ÖZDEN'	,	 'UTLU'	,	30	,	 'ErzincanKadikoy'	)	,\n" + 
							"(	436	,	 'ŞEBNEM'	,	 'KARA'	,	31	,	 'ErzurumKadikoy'	)	,\n" + 
							"(	437	,	 'PINAR'	,	 'SERT'	,	32	,	 'EskişehirKadikoy'	)	,\n" + 
							"(	438	,	 'ELİF'	,	 'VURAL'	,	33	,	 'GaziantepKadikoy'	)	,\n" + 
							"(	439	,	 'İSA'	,	 'YALÇIN'	,	34	,	 'GiresunKadikoy'	)	,\n" + 
							"(	440	,	 'ERKAN'	,	 'ÖZEK'	,	35	,	 'GümüşhaneKadikoy'	)	,\n" + 
							"(	441	,	 'ÖZTAN'	,	 'AKIN'	,	36	,	 'HakkariKadikoy'	)	,\n" + 
							"(	442	,	 'SONAY'	,	 'ŞAHİN'	,	37	,	 'HatayKadikoy'	)	,\n" + 
							"(	443	,	 'SEMA'	,	 'YEŞİL'	,	38	,	 'IğdırKadikoy'	)	,\n" + 
							"(	444	,	 'MEHMET'	,	 'GÖNCÜ'	,	39	,	 'IspartaKadikoy'	)	,\n" + 
							"(	445	,	 'AHMET'	,	 'MERTOL'	,	40	,	 'İstanbulKadikoy'	)	,\n" + 
							"(	446	,	 'DENİZ'	,	 'ARIKAN'	,	41	,	 'İzmirKadikoy'	)	,\n" + 
							"(	447	,	 'FERDA'	,	 'YILMAZ'	,	42	,	 'KahramanmaraşKadikoy'	)	,\n" + 
							"(	448	,	 'EMİR KAAN'	,	 'YARADILMIŞ'	,	43	,	 'KarabükKadikoy'	)	,\n" + 
							"(	449	,	 'TUĞBA'	,	 'KARAGÖZ'	,	44	,	 'KaramanKadikoy'	)	,\n" + 
							"(	450	,	 'ABDULKADİR'	,	 'ÖZKAN'	,	45	,	 'KarsKadikoy'	)	,\n" + 
							"(	451	,	 'İBRAHİM'	,	 'ÜNAL'	,	46	,	 'KastamonuKadikoy'	)	,\n" + 
							"(	452	,	 'CÜNEYT'	,	 'ATLANOĞLU'	,	47	,	 'KayseriKadikoy'	)	,\n" + 
							"(	453	,	 'GÖZDE GİZEM'	,	 'AKYILMAZ'	,	48	,	 'KırıkkaleKadikoy'	)	,\n" + 
							"(	454	,	 'İLKER'	,	 'DÖKMECİ'	,	49	,	 'KırklareliKadikoy'	)	,\n" + 
							"(	455	,	 'ESRA NUR'	,	 'ÜSTÜNDAĞ'	,	50	,	 'KırşehirKadikoy'	)	,\n" + 
							"(	456	,	 'HASAN'	,	 'SEĞMEN'	,	51	,	 'KilisKadikoy'	)	,\n" + 
							"(	457	,	 'SÜLEYMAN'	,	 'DEMİRTAŞ'	,	52	,	 'KocaeliKadikoy'	)	,\n" + 
							"(	458	,	 'RAZİYE DAMLA'	,	 'DOĞAN'	,	53	,	 'KonyaKadikoy'	)	,\n" + 
							"(	459	,	 'AHMET MELİH'	,	 'PARLAK'	,	54	,	 'KütahyaKadikoy'	)	,\n" + 
							"(	460	,	 'ADEM'	,	 'YAZICI'	,	55	,	 'MalatyaKadikoy'	)	,\n" + 
							"(	461	,	 'MURAT'	,	 'OLCAR'	,	56	,	 'ManisaKadikoy'	)	,\n" + 
							"(	462	,	 'BURÇİN MERYEM'	,	 'DEMİR'	,	57	,	 'MardinKadikoy'	)	,\n" + 
							"(	463	,	 'HASAN SERKAN'	,	 'TEKİŞ'	,	58	,	 'MersinKadikoy'	)	,\n" + 
							"(	464	,	 'FULYA'	,	 'SAVRAN'	,	59	,	 'MuğlaKadikoy'	)	,\n" + 
							"(	465	,	 'MAHSUM'	,	 'KAYA'	,	60	,	 'MuşKadikoy'	)	,\n" + 
							"(	466	,	 'MURAT'	,	 'AZAP'	,	61	,	 'NevşehirKadikoy'	)	,\n" + 
							"(	467	,	 'ŞENAY'	,	 'GÜZEL'	,	62	,	 'NiğdeKadikoy'	)	,\n" + 
							"(	468	,	 'MUHAMMET MUSTAFA'	,	 'DOĞAN'	,	63	,	 'OrduKadikoy'	)	,\n" + 
							"(	469	,	 'AHMET CEVDET'	,	 'İPEK'	,	64	,	 'OsmaniyeKadikoy'	)	,\n" + 
							"(	470	,	 'EVREN'	,	 'KARABULUT'	,	65	,	 'RizeKadikoy'	)	,\n" + 
							"(	471	,	 'NEBİ'	,	 'KIRBAŞ'	,	66	,	 'SakaryaKadikoy'	)	,\n" + 
							"(	472	,	 'OĞUZ KAĞAN'	,	 'ÜNLÜ'	,	67	,	 'SamsunKadikoy'	)	,\n" + 
							"(	473	,	 'HAKAN'	,	 'GÖRKEM'	,	68	,	 'SiirtKadikoy'	)	,\n" + 
							"(	474	,	 'MAHMUT NURİ'	,	 'CORUT'	,	69	,	 'SinopKadikoy'	)	,\n" + 
							"(	475	,	 'NUR'	,	 'BAŞARAN'	,	70	,	 'SivasKadikoy'	)	,\n" + 
							"(	476	,	 'AHMET'	,	 'ATMIŞ'	,	71	,	 'ŞanlıurfaKadikoy'	)	,\n" + 
							"(	477	,	 'HANDE'	,	 'ÖZTÜRK'	,	72	,	 'ŞırnakKadikoy'	)	,\n" + 
							"(	478	,	 'HAMZA'	,	 'HAMZAOGLU'	,	73	,	 'TekirdağKadikoy'	)	,\n" + 
							"(	479	,	 'BARAN'	,	 'KANYILMAZ'	,	74	,	 'TokatKadikoy'	)	,\n" + 
							"(	480	,	 'TİMUR'	,	 'AKBUDAK'	,	75	,	 'TrabzonKadikoy'	)	,\n" + 
							"(	481	,	 'İLKER'	,	 'DENİZ'	,	76	,	 'TunceliKadikoy'	)	,\n" + 
							"(	482	,	 'NEFİSE'	,	 'SARIGÜL'	,	77	,	 'UşakKadikoy'	)	,\n" + 
							"(	483	,	 'SÜLEYMAN'	,	 'KINDIR'	,	78	,	 'VanKadikoy'	)	,\n" + 
							"(	484	,	 'HASAN'	,	 'SARIKAYA'	,	79	,	 'YalovaKadikoy'	)	,\n" + 
							"(	485	,	 'EBRU'	,	 'DEMİRTAŞ'	,	80	,	 'YozgatKadikoy'	)	,\n" + 
							"(	486	,	 'HÜSEYİN'	,	 'SAĞLAM'	,	81	,	 'ZonguldakKadikoy'	)	,\n" + 
							"(	487	,	 'CUMHUR'	,	 'COŞKUN'	,	1	,	 'AdanaKadikoy'	)	,\n" + 
							"(	488	,	 'ELA'	,	 'AÇAR'	,	2	,	 'AdıyamanKadikoy'	)	,\n" + 
							"(	489	,	 'ORHAN'	,	 'AKDEMİR'	,	3	,	 'AfyonkarahisarKadikoy'	)	,\n" + 
							"(	490	,	 'MUSTAFA TURAN'	,	 'DİLLİ'	,	4	,	 'AğrıKadikoy'	)	,\n" + 
							"(	491	,	 'YASİN'	,	 'SOYDAN'	,	5	,	 'AksarayKadikoy'	)	,\n" + 
							"(	492	,	 'MEHMET HİLMİ'	,	 'EKEN'	,	6	,	 'AmasyaKadikoy'	)	,\n" + 
							"(	493	,	 'GÖKHAN'	,	 'AVCU'	,	7	,	 'AnkaraKadikoy'	)	,\n" + 
							"(	494	,	 'SERDAL'	,	 'GÜRBOSTAN'	,	8	,	 'AntalyaKadikoy'	)	,\n" + 
							"(	495	,	 'ÖZLEM'	,	 'KIRLANGIÇ'	,	9	,	 'ArdahanKadikoy'	)	,\n" + 
							"(	496	,	 'UĞUR'	,	 'KARAKAN'	,	10	,	 'ArtvinKadikoy'	)	,\n" + 
							"(	497	,	 'FUNDA'	,	 'ZENGİN'	,	11	,	 'AydınKadikoy'	)	,\n" + 
							"(	498	,	 'ADNAN'	,	 'ZEYBEK'	,	12	,	 'BalıkesirKadikoy'	)	,\n" + 
							"(	499	,	 'ERKAN'	,	 'KARAOĞLANOĞLU'	,	13	,	 'BartınKadikoy'	)	,\n" + 
							"(	500	,	 'MUHAMMED MUCAHİD'	,	 'BOZKURT'	,	14	,	 'BatmanKadikoy'	)	,\n" + 
							"(	501	,	 'ABİDİN'	,	 'ORAL'	,	15	,	 'BayburtKadikoy'	)	,\n" + 
							"(	502	,	 'ÜMİT'	,	 'SÜMER'	,	16	,	 'BilecikKadikoy'	)	,\n" + 
							"(	503	,	 'OKAN'	,	 'KOCUBEYOĞLU'	,	17	,	 'BingölKadikoy'	)	,\n" + 
							"(	504	,	 'MUHAMMET FATİH'	,	 'KUŞAKÇI'	,	18	,	 'BitlisKadikoy'	)	,\n" + 
							"(	505	,	 'BEYZA'	,	 'YILMAZ'	,	19	,	 'BoluKadikoy'	)	,\n" + 
							"(	506	,	 'ÖMER'	,	 'YAVUZ'	,	20	,	 'DenizliKadikoy'	)	,\n" + 
							"(	507	,	 'KÜBRA'	,	 'DOĞAN'	,	21	,	 'BursaKadikoy'	)	,\n" + 
							"(	508	,	 'HASAN'	,	 'ATILGAN'	,	22	,	 'ÇanakkaleKadikoy'	)	,\n" + 
							"(	509	,	 'FATİH'	,	 'AÇAR'	,	23	,	 'ÇankırıKadikoy'	)	,\n" + 
							"(	510	,	 'İPEK'	,	 'BAYRAK'	,	24	,	 'ÇorumKadikoy'	)	,\n" + 
							"(	511	,	 'NURAY'	,	 'BİRİ'	,	25	,	 'BurdurKadikoy'	)	,\n" + 
							"(	512	,	 'NEZİR'	,	 'ÇATUK'	,	26	,	 'DiyarbakırKadikoy'	)	,\n" + 
							"(	513	,	 'EMRAH'	,	 'GÜNDÜZ'	,	27	,	 'DüzceKadikoy'	)	,\n" + 
							"(	514	,	 'ADEM'	,	 'KÜTÜKOĞLU'	,	28	,	 'EdirneKadikoy'	)	,\n" + 
							"(	515	,	 'SALMAN'	,	 'KARA'	,	29	,	 'ElazığKadikoy'	)	,\n" + 
							"(	516	,	 'İSHAK'	,	 'GENÇ'	,	30	,	 'ErzincanKadikoy'	)	,\n" + 
							"(	517	,	 'CÜNEYT'	,	 'YILMAZ'	,	31	,	 'ErzurumKadikoy'	)	,\n" + 
							"(	518	,	 'BÜNYAMİN'	,	 'ÖZDEMİR'	,	32	,	 'EskişehirKadikoy'	)	,\n" + 
							"(	519	,	 'DUYGU'	,	 'KÖKSAL'	,	33	,	 'GaziantepKadikoy'	)	,\n" + 
							"(	520	,	 'MEHMET'	,	 'ÇEÇEN'	,	34	,	 'GiresunKadikoy'	)	,\n" + 
							"(	521	,	 'MEHMET'	,	 'ATEŞ'	,	35	,	 'GümüşhaneKadikoy'	)	,\n" + 
							"(	522	,	 'HÜSEYİN'	,	 'ERZURUM'	,	36	,	 'HakkariKadikoy'	)	,\n" + 
							"(	523	,	 'ÖZLEM'	,	 'SEZER'	,	37	,	 'HatayKadikoy'	)	,\n" + 
							"(	524	,	 'BÜLENT'	,	 'EYİSOY'	,	38	,	 'IğdırKadikoy'	)	,\n" + 
							"(	525	,	 'ÖZGÜR'	,	 'ÇÖREKLİ'	,	39	,	 'IspartaKadikoy'	)	,\n" + 
							"(	526	,	 'SERKAN'	,	 'BÖRTA'	,	40	,	 'İstanbulKadikoy'	)	,\n" + 
							"(	527	,	 'YASEMİN'	,	 'KILIÇOĞLU'	,	41	,	 'İzmirKadikoy'	)	,\n" + 
							"(	528	,	 'EMİNE'	,	 'BAYRAM'	,	42	,	 'KahramanmaraşKadikoy'	)	,\n" + 
							"(	529	,	 'GÖKSEL'	,	 'YEŞİLKAYA'	,	43	,	 'KarabükKadikoy'	)	,\n" + 
							"(	530	,	 'ALİ RIZA'	,	 'ÇAĞLAR'	,	44	,	 'KaramanKadikoy'	)	,\n" + 
							"(	531	,	 'MEHMET'	,	 'ÖZKANLI'	,	45	,	 'KarsKadikoy'	)	,\n" + 
							"(	532	,	 'GÜL'	,	 'İNCE'	,	46	,	 'KastamonuKadikoy'	)	,\n" + 
							"(	533	,	 'KÜBRA'	,	 'ATEŞ'	,	47	,	 'KayseriKadikoy'	)	,\n" + 
							"(	534	,	 'ONUR KADİR'	,	 'DEMİR'	,	48	,	 'KırıkkaleKadikoy'	)	,\n" + 
							"(	535	,	 'AYŞE AHSEN'	,	 'ŞANLIER'	,	49	,	 'KırklareliKadikoy'	)	,\n" + 
							"(	536	,	 'NESLİHAN'	,	 'TÜRKMEN ALBAYRAK'	,	50	,	 'KırşehirKadikoy'	)	,\n" + 
							"(	537	,	 'ENGİN'	,	 'KAYA'	,	51	,	 'KilisKadikoy'	)	,\n" + 
							"(	538	,	 'UFUK'	,	 'GÜMÜŞÇÜ'	,	52	,	 'KocaeliKadikoy'	)	,\n" + 
							"(	539	,	 'NİHAL'	,	 'ERGÖZ'	,	53	,	 'KonyaKadikoy'	)	,\n" + 
							"(	540	,	 'KEZBAN'	,	 'IŞIK'	,	54	,	 'KütahyaKadikoy'	)	,\n" + 
							"(	541	,	 'MUSTAFA'	,	 'ÜREYEN'	,	55	,	 'MalatyaKadikoy'	)	,\n" + 
							"(	542	,	 'TUBA'	,	 'AKKAYA'	,	56	,	 'ManisaKadikoy'	)	,\n" + 
							"(	543	,	 'PINAR'	,	 'ŞAŞMAZ'	,	57	,	 'MardinKadikoy'	)	,\n" + 
							"(	544	,	 'FATMA ESRA'	,	 'ÜREYEN'	,	58	,	 'MersinKadikoy'	)	,\n" + 
							"(	545	,	 'ALİ SEÇKİN'	,	 'ÖZTOPRAK'	,	59	,	 'MuğlaKadikoy'	)	,\n" + 
							"(	546	,	 'FEYZA'	,	 'ÖZTÜRK'	,	60	,	 'MuşKadikoy'	)	,\n" + 
							"(	547	,	 'HÜSEYİN KUNTER'	,	 'BAL'	,	61	,	 'NevşehirKadikoy'	)	,\n" + 
							"(	548	,	 'İLKNUR'	,	 'GÜLER'	,	62	,	 'NiğdeKadikoy'	)	,\n" + 
							"(	549	,	 'HÜSEYİN'	,	 'AKBULUT'	,	63	,	 'OrduKadikoy'	)	,\n" + 
							"(	550	,	 'ÖZHAN'	,	 'YILDIRIM'	,	64	,	 'OsmaniyeKadikoy'	)	,\n" + 
							"(	551	,	 'BEYZA'	,	 'SAVRAN'	,	65	,	 'RizeKadikoy'	)	,\n" + 
							"(	552	,	 'YUNUS'	,	 'SU DUR'	,	66	,	 'SakaryaKadikoy'	)	,\n" + 
							"(	553	,	 'YASEMİN'	,	 'GÜREL'	,	67	,	 'SamsunKadikoy'	)	,\n" + 
							"(	554	,	 'PINAR'	,	 'KARAKAYA'	,	68	,	 'SiirtKadikoy'	)	,\n" + 
							"(	555	,	 'AYKUT'	,	 'BALCI'	,	69	,	 'SinopKadikoy'	)	,\n" + 
							"(	556	,	 'KEZBAN'	,	 'YILMAZ'	,	70	,	 'SivasKadikoy'	)	,\n" + 
							"(	557	,	 'ALİ RIZA'	,	 'TOY'	,	71	,	 'ŞanlıurfaKadikoy'	)	,\n" + 
							"(	558	,	 'HACER'	,	 'CANTÜRK'	,	72	,	 'ŞırnakKadikoy'	)	,\n" + 
							"(	559	,	 'FATMA'	,	 'ARSLAN'	,	73	,	 'TekirdağKadikoy'	)	,\n" + 
							"(	560	,	 'YELDA'	,	 'ÇELİKER'	,	74	,	 'TokatKadikoy'	)	,\n" + 
							"(	561	,	 'ADEM'	,	 'SARICANBAZ'	,	75	,	 'TrabzonKadikoy'	)	,\n" + 
							"(	562	,	 'ERCAN'	,	 'ARMAĞAN'	,	76	,	 'TunceliKadikoy'	)	,\n" + 
							"(	563	,	 'RAMAZAN'	,	 'YILDIRIM'	,	77	,	 'UşakKadikoy'	)	,\n" + 
							"(	564	,	 'DEMET'	,	 'ERDOĞMUŞ'	,	78	,	 'VanKadikoy'	)	,\n" + 
							"(	565	,	 'BETÜL'	,	 'AKSUN'	,	79	,	 'YalovaKadikoy'	)	,\n" + 
							"(	566	,	 'HAZEL'	,	 'ÇİÇEK'	,	80	,	 'YozgatKadikoy'	)	,\n" + 
							"(	567	,	 'ERSİN'	,	 'FINDIK GÜVENDİ'	,	81	,	 'ZonguldakKadikoy'	)	,\n" + 
							"(	568	,	 'YUSUF'	,	 'ARMAĞAN'	,	1	,	 'AdanaKadikoy'	)	,\n" + 
							"(	569	,	 'ŞULE'	,	 'GENÇ'	,	2	,	 'AdıyamanKadikoy'	)	,\n" + 
							"(	570	,	 'ÖZLEM'	,	 'KILINÇ'	,	3	,	 'AfyonkarahisarKadikoy'	)	,\n" + 
							"(	571	,	 'MEHMET'	,	 'TOY'	,	4	,	 'AğrıKadikoy'	)	,\n" + 
							"(	572	,	 'SERHAT'	,	 'ÖZBEK'	,	5	,	 'AksarayKadikoy'	)	,\n" + 
							"(	573	,	 'SEVAL'	,	 'GÜNDÜZ'	,	6	,	 'AmasyaKadikoy'	)	,\n" + 
							"(	574	,	 'SEVİNÇ'	,	 'GÖRDÜK'	,	7	,	 'AnkaraKadikoy'	)	,\n" + 
							"(	575	,	 'EMİNE'	,	 'ÖZGÜR'	,	8	,	 'AntalyaKadikoy'	)	,\n" + 
							"(	576	,	 'EMRAH'	,	 'ERDEM'	,	9	,	 'ArdahanKadikoy'	)	,\n" + 
							"(	577	,	 'ASUDAN TUĞÇE'	,	 'ATABAY'	,	10	,	 'ArtvinKadikoy'	)	,\n" + 
							"(	578	,	 'DENİZ'	,	 'KARABULUT'	,	11	,	 'AydınKadikoy'	)	,\n" + 
							"(	579	,	 'ÇAĞLA'	,	 'YILMAZ'	,	12	,	 'BalıkesirKadikoy'	)	,\n" + 
							"(	580	,	 'MURAT'	,	 'TÜRKMEN ALBAYRAK'	,	13	,	 'BartınKadikoy'	)	,\n" + 
							"(	581	,	 'AHMET'	,	 'BAYRAMOĞLU'	,	14	,	 'BatmanKadikoy'	)	,\n" + 
							"(	582	,	 'ESİN SEREN'	,	 'KUŞAKÇI'	,	15	,	 'BayburtKadikoy'	)	,\n" + 
							"(	583	,	 'ŞİRİN'	,	 'OĞUZ'	,	16	,	 'BilecikKadikoy'	)	,\n" + 
							"(	584	,	 'ÇAĞRI SERDAR'	,	 'İNER KÖKSAL'	,	17	,	 'BingölKadikoy'	)	,\n" + 
							"(	585	,	 'ÖMER FARUK'	,	 'SADIÇ'	,	18	,	 'BitlisKadikoy'	)	,\n" + 
							"(	586	,	 'SUAT'	,	 'YILDIZOĞLU'	,	19	,	 'BoluKadikoy'	)	,\n" + 
							"(	587	,	 'İBRAHİM'	,	 'GÜLCAN'	,	20	,	 'DenizliKadikoy'	)	,\n" + 
							"(	588	,	 'AYHAN'	,	 'AKMEŞE'	,	21	,	 'BursaKadikoy'	)	,\n" + 
							"(	589	,	 'HASAN CIVAN'	,	 'YAYIKÇI'	,	22	,	 'ÇanakkaleKadikoy'	)	,\n" + 
							"(	590	,	 'MELAHAT'	,	 'SÖKMEN'	,	23	,	 'ÇankırıKadikoy'	)	,\n" + 
							"(	591	,	 'TUĞBA'	,	 'VATANSEVER'	,	24	,	 'ÇorumKadikoy'	)	,\n" + 
							"(	592	,	 'YAKUP İLKER'	,	 'BARAN'	,	25	,	 'BurdurKadikoy'	)	,\n" + 
							"(	593	,	 'HASAN'	,	 'KENDİRLİ'	,	26	,	 'DiyarbakırKadikoy'	)	,\n" + 
							"(	594	,	 'AHMET MELİH'	,	 'UYSAL'	,	27	,	 'DüzceKadikoy'	)	,\n" + 
							"(	595	,	 'AYŞEN'	,	 'ŞARLAK'	,	28	,	 'EdirneKadikoy'	)	,\n" + 
							"(	596	,	 'ABDULSAMET'	,	 'BURULDAY'	,	29	,	 'ElazığKadikoy'	)	,\n" + 
							"(	597	,	 'ERKAN'	,	 'AKMEŞE'	,	30	,	 'ErzincanKadikoy'	)	,\n" + 
							"(	598	,	 'İSMAİL'	,	 'EKEN'	,	31	,	 'ErzurumKadikoy'	)	,\n" + 
							"(	599	,	 'DENİZ'	,	 'DENİZ'	,	32	,	 'EskişehirKadikoy'	)	,\n" + 
							"(	600	,	 'TUBA'	,	 'SARICA DAROL'	,	33	,	 'GaziantepKadikoy'	)	,\n" + 
							"(	601	,	 'ERDEM'	,	 'YILMAZ'	,	34	,	 'GiresunKadikoy'	)	,\n" + 
							"(	602	,	 'GÜL'	,	 'ÖZALP'	,	35	,	 'GümüşhaneKadikoy'	)	,\n" + 
							"(	603	,	 'ORHAN'	,	 'CANDAN'	,	36	,	 'HakkariKadikoy'	)	,\n" + 
							"(	604	,	 'FUNDA'	,	 'OLGEN'	,	37	,	 'HatayKadikoy'	)	,\n" + 
							"(	605	,	 'HASAN SERKAN'	,	 'YEL'	,	38	,	 'IğdırKadikoy'	)	,\n" + 
							"(	606	,	 'CİHAN'	,	 'KAYA'	,	39	,	 'IspartaKadikoy'	)	,\n" + 
							"(	607	,	 'MİNE'	,	 'KUSERLİ'	,	40	,	 'İstanbulKadikoy'	)	,\n" + 
							"(	608	,	 'SALİH'	,	 'YILDIZ'	,	41	,	 'İzmirKadikoy'	)	,\n" + 
							"(	609	,	 'NAGİHAN'	,	 'BOZOĞLU'	,	42	,	 'KahramanmaraşKadikoy'	)	,\n" + 
							"(	610	,	 'FATİH'	,	 'BAYRAKTAROĞLU'	,	43	,	 'KarabükKadikoy'	)	,\n" + 
							"(	611	,	 'ALİ RIZA'	,	 'SÜRMEN AKYOL'	,	44	,	 'KaramanKadikoy'	)	,\n" + 
							"(	612	,	 'SEDAT'	,	 'KILIÇ'	,	45	,	 'KarsKadikoy'	)	,\n" + 
							"(	613	,	 'NEBİL'	,	 'YALÇIN'	,	46	,	 'KastamonuKadikoy'	)	,\n" + 
							"(	614	,	 'İSMAİL YAVUZ'	,	 'KILIÇ'	,	47	,	 'KayseriKadikoy'	)	,\n" + 
							"(	615	,	 'MUSTAFA'	,	 'SÖNMEZER'	,	48	,	 'KırıkkaleKadikoy'	)	,\n" + 
							"(	616	,	 'ETHEM'	,	 'KANDEMİR'	,	49	,	 'KırklareliKadikoy'	)	,\n" + 
							"(	617	,	 'BAHADIR'	,	 'ALBEN'	,	50	,	 'KırşehirKadikoy'	)	,\n" + 
							"(	618	,	 'MEHMET HÜSEYİN'	,	 'BÜLBÜL'	,	51	,	 'KilisKadikoy'	)	,\n" + 
							"(	619	,	 'ADNAN'	,	 'GÜLEÇ'	,	52	,	 'KocaeliKadikoy'	)	,\n" + 
							"(	620	,	 'EMİN TONYUKUK'	,	 'BARAN'	,	53	,	 'KonyaKadikoy'	)	,\n" + 
							"(	621	,	 'HALİL'	,	 'TATAR'	,	54	,	 'KütahyaKadikoy'	)	,\n" + 
							"(	622	,	 'EMEL'	,	 'CEYLAN'	,	55	,	 'MalatyaKadikoy'	)	,\n" + 
							"(	623	,	 'SÜLEYMAN SERDAR'	,	 'KABİL KUCUR'	,	56	,	 'ManisaKadikoy'	)	,\n" + 
							"(	624	,	 'TUĞBA'	,	 'BİLGİÇ'	,	57	,	 'MardinKadikoy'	)	,\n" + 
							"(	625	,	 'YÜCEL'	,	 'ÖZDEMİR'	,	58	,	 'MersinKadikoy'	)	,\n" + 
							"(	626	,	 'HÜSEYİN'	,	 'EVREN'	,	59	,	 'MuğlaKadikoy'	)	,\n" + 
							"(	627	,	 'MUAMMER MÜSLİM'	,	 'BAKLACI'	,	60	,	 'MuşKadikoy'	)	,\n" + 
							"(	628	,	 'EVREN'	,	 'KOR'	,	61	,	 'NevşehirKadikoy'	)	,\n" + 
							"(	629	,	 'SEMİNE'	,	 'SEVİNGİL'	,	62	,	 'NiğdeKadikoy'	)	,\n" + 
							"(	630	,	 'TUĞBA'	,	 'TALAS'	,	63	,	 'OrduKadikoy'	)	,\n" + 
							"(	631	,	 'TUBA'	,	 'YILMAZ'	,	64	,	 'OsmaniyeKadikoy'	)	,\n" + 
							"(	632	,	 'ŞİRİN'	,	 'KARACA'	,	65	,	 'RizeKadikoy'	)	,\n" + 
							"(	633	,	 'UĞUR'	,	 'KÖKSAL'	,	66	,	 'SakaryaKadikoy'	)	,\n" + 
							"(	634	,	 'FUAT ERNİS'	,	 'YAZICI EROL'	,	67	,	 'SamsunKadikoy'	)	,\n" + 
							"(	635	,	 'AZİZ'	,	 'EROĞLU'	,	68	,	 'SiirtKadikoy'	)	,\n" + 
							"(	636	,	 'ÖZGÜR'	,	 'DEMİR'	,	69	,	 'SinopKadikoy'	)	,\n" + 
							"(	637	,	 'PINAR'	,	 'DANIŞOĞLU'	,	70	,	 'SivasKadikoy'	)	,\n" + 
							"(	638	,	 'BORA'	,	 'BAŞAR'	,	71	,	 'ŞanlıurfaKadikoy'	)	,\n" + 
							"(	639	,	 'SULTAN'	,	 'UFACIK'	,	72	,	 'ŞırnakKadikoy'	)	,\n" + 
							"(	640	,	 'SEVİNÇ'	,	 'GÜRDAL'	,	73	,	 'TekirdağKadikoy'	)	,\n" + 
							"(	641	,	 'ERKAN'	,	 'OCAK'	,	74	,	 'TokatKadikoy'	)	,\n" + 
							"(	642	,	 'CEYDA'	,	 'BOĞAN'	,	75	,	 'TrabzonKadikoy'	)	,\n" + 
							"(	643	,	 'GÖZDE GİZEM'	,	 'DEMİRELLİ'	,	76	,	 'TunceliKadikoy'	)	,\n" + 
							"(	644	,	 'ÖMER FARUK'	,	 'ÖZEN'	,	77	,	 'UşakKadikoy'	)	,\n" + 
							"(	645	,	 'EMRE'	,	 'GÖKSOY'	,	78	,	 'VanKadikoy'	)	,\n" + 
							"(	646	,	 'ÖZEN'	,	 'TEHLİ'	,	79	,	 'YalovaKadikoy'	)	,\n" + 
							"(	647	,	 'DERMAN'	,	 'HİÇDURMAZ'	,	80	,	 'YozgatKadikoy'	)	,\n" + 
							"(	648	,	 'SEZGİN'	,	 'ÜSTÜNDAĞ'	,	81	,	 'ZonguldakKadikoy'	)	,\n" + 
							"(	649	,	 'SERDAR'	,	 'ARACI'	,	1	,	 'AdanaKayisdagi'	)	,\n" + 
							"(	650	,	 'EBRU'	,	 'GÖZCÜ'	,	2	,	 'AdıyamanKayisdagi'	)	,\n" + 
							"(	651	,	 'YAVUZ'	,	 'ŞAHİN'	,	3	,	 'AfyonkarahisarKayisdagi'	)	,\n" + 
							"(	652	,	 'ÇAĞLAR'	,	 'KARDAŞ'	,	4	,	 'AğrıKayisdagi'	)	,\n" + 
							"(	653	,	 'YÜCEL'	,	 'BAŞAK'	,	5	,	 'AksarayKayisdagi'	)	,\n" + 
							"(	654	,	 'ERHAN'	,	 'ÖZSAYIM'	,	6	,	 'AmasyaKayisdagi'	)	,\n" + 
							"(	655	,	 'MEHMET HİLMİ'	,	 'KIRLI'	,	7	,	 'AnkaraKayisdagi'	)	,\n" + 
							"(	656	,	 'EMİNE'	,	 'YILMABAŞAR'	,	8	,	 'AntalyaKayisdagi'	)	,\n" + 
							"(	657	,	 'ELİFCAN'	,	 'ÇINKIT'	,	9	,	 'ArdahanKayisdagi'	)	,\n" + 
							"(	658	,	 'GÖKÇEN'	,	 'OLMAZ'	,	10	,	 'ArtvinKayisdagi'	)	,\n" + 
							"(	659	,	 'AHMET'	,	 'GÖKÇE'	,	11	,	 'AydınKayisdagi'	)	,\n" + 
							"(	660	,	 'HASAN'	,	 'KAYA'	,	12	,	 'BalıkesirKayisdagi'	)	,\n" + 
							"(	661	,	 'HALİS'	,	 'GÜMÜŞÇÜ'	,	13	,	 'BartınKayisdagi'	)	,\n" + 
							"(	662	,	 'GÜLÇİN'	,	 'KILIÇ'	,	14	,	 'BatmanKayisdagi'	)	,\n" + 
							"(	663	,	 'MUSTAFA'	,	 'TOKAR'	,	15	,	 'BayburtKayisdagi'	)	,\n" + 
							"(	664	,	 'ÖZGÜR'	,	 'ÇİMEN'	,	16	,	 'BilecikKayisdagi'	)	,\n" + 
							"(	665	,	 'BERFİN'	,	 'BÜYÜKKAL'	,	17	,	 'BingölKayisdagi'	)	,\n" + 
							"(	666	,	 'YUSUF'	,	 'ÇELİKER'	,	18	,	 'BitlisKayisdagi'	)	,\n" + 
							"(	667	,	 'KENAN'	,	 'ÇİÇEK'	,	19	,	 'BoluKayisdagi'	)	,\n" + 
							"(	668	,	 'OĞUZ KAAN'	,	 'ERDEM'	,	20	,	 'DenizliKayisdagi'	)	,\n" + 
							"(	669	,	 'ÖMER'	,	 'ÖZER'	,	21	,	 'BursaKayisdagi'	)	,\n" + 
							"(	670	,	 'MELTEM'	,	 'HÜSEYNİ'	,	22	,	 'ÇanakkaleKayisdagi'	)	,\n" + 
							"(	671	,	 'URAL'	,	 'YÜCEL'	,	23	,	 'ÇankırıKayisdagi'	)	,\n" + 
							"(	672	,	 'RUKİYE'	,	 'DÖKMECİ'	,	24	,	 'ÇorumKayisdagi'	)	,\n" + 
							"(	673	,	 'MEHMET'	,	 'SAÇLI'	,	25	,	 'BurdurKayisdagi'	)	,\n" + 
							"(	674	,	 'İBRAHİM FUAT'	,	 'DEMİRTÜRK'	,	26	,	 'DiyarbakırKayisdagi'	)	,\n" + 
							"(	675	,	 'ABDULAZİZ'	,	 'KARAHAN'	,	27	,	 'DüzceKayisdagi'	)	,\n" + 
							"(	676	,	 'NURDAN'	,	 'ÇETİN'	,	28	,	 'EdirneKayisdagi'	)	,\n" + 
							"(	677	,	 'HATİCE'	,	 'EROĞLU'	,	29	,	 'ElazığKayisdagi'	)	,\n" + 
							"(	678	,	 'HATİCE'	,	 'FİLİZ'	,	30	,	 'ErzincanKayisdagi'	)	,\n" + 
							"(	679	,	 'MEHMET'	,	 'AKKAŞ'	,	31	,	 'ErzurumKayisdagi'	)	,\n" + 
							"(	680	,	 'CEM'	,	 'BAŞARAN'	,	32	,	 'EskişehirKayisdagi'	)	,\n" + 
							"(	681	,	 'FATMA BEGÜM'	,	 'BAKIRCI'	,	33	,	 'GaziantepKayisdagi'	)	,\n" + 
							"(	682	,	 'MÜRSEL'	,	 'SERT'	,	34	,	 'GiresunKayisdagi'	)	,\n" + 
							"(	683	,	 'OĞUZ'	,	 'PARLAK'	,	35	,	 'GümüşhaneKayisdagi'	)	,\n" + 
							"(	684	,	 'BÜŞRA SULTAN'	,	 'AKYILMAZ'	,	36	,	 'HakkariKayisdagi'	)	,\n" + 
							"(	685	,	 'ATİLLA SÜLEYMAN'	,	 'KOÇYİĞİT'	,	37	,	 'HatayKayisdagi'	)	,\n" + 
							"(	686	,	 'ŞEYHMUS'	,	 'ÇEÇEN'	,	38	,	 'IğdırKayisdagi'	)	,\n" + 
							"(	687	,	 'UTKU'	,	 'DEMİRDAĞ'	,	39	,	 'IspartaKayisdagi'	)	,\n" + 
							"(	688	,	 'ÖZGE'	,	 'CANTÜRK'	,	40	,	 'İstanbulKayisdagi'	)	,\n" + 
							"(	689	,	 'ELİF'	,	 'HEYBET'	,	41	,	 'İzmirKayisdagi'	)	,\n" + 
							"(	690	,	 'NAİME SILA'	,	 '1'	,	42	,	 'KahramanmaraşKayisdagi'	)	,\n" + 
							"(	691	,	 'BERİL GÜLÜŞ'	,	 'ÇELİK'	,	43	,	 'KarabükKayisdagi'	)	,\n" + 
							"(	692	,	 'KEZİBAN'	,	 'SAKARYA'	,	44	,	 'KaramanKayisdagi'	)	,\n" + 
							"(	693	,	 'MELTEM'	,	 'KARABULUT'	,	45	,	 'KarsKayisdagi'	)	,\n" + 
							"(	694	,	 'ELİF'	,	 'GÜNGÖR'	,	46	,	 'KastamonuKayisdagi'	)	,\n" + 
							"(	695	,	 'MERVE NUR'	,	 'DESTEGÜL'	,	47	,	 'KayseriKayisdagi'	)	,\n" + 
							"(	696	,	 'HANDAN'	,	 'ÖZLÜ'	,	48	,	 'KırıkkaleKayisdagi'	)	,\n" + 
							"(	697	,	 'YUSUF ALPER'	,	 'ÖZER'	,	49	,	 'KırklareliKayisdagi'	)	,\n" + 
							"(	698	,	 'AYDOĞAN'	,	 'YÜCETÜRK'	,	50	,	 'KırşehirKayisdagi'	)	,\n" + 
							"(	699	,	 'PELİN'	,	 'KARAALP'	,	51	,	 'KilisKayisdagi'	)	,\n" + 
							"(	700	,	 'ESMA'	,	 'COŞKUN'	,	52	,	 'KocaeliKayisdagi'	)	,\n" + 
							"(	701	,	 'DERYA'	,	 'ELBÜKEN'	,	53	,	 'KonyaKayisdagi'	)	,\n" + 
							"(	702	,	 'DEMET'	,	 'MENEKŞE'	,	54	,	 'KütahyaKayisdagi'	)	,\n" + 
							"(	703	,	 'İBRAHİM'	,	 'NADASTEPE'	,	55	,	 'MalatyaKayisdagi'	)	,\n" + 
							"(	704	,	 'ALİ'	,	 'SARIKAYA'	,	56	,	 'ManisaKayisdagi'	)	,\n" + 
							"(	705	,	 'MUTLU'	,	 'ERSOY'	,	57	,	 'MardinKayisdagi'	)	,\n" + 
							"(	706	,	 'ÜBEYDULLAH'	,	 'ANIK'	,	58	,	 'MersinKayisdagi'	)	,\n" + 
							"(	707	,	 'FATMA'	,	 'NADASTEPE'	,	59	,	 'MuğlaKayisdagi'	)	,\n" + 
							"(	708	,	 'TÜLAY'	,	 'ÜNLÜ'	,	60	,	 'MuşKayisdagi'	)	,\n" + 
							"(	709	,	 'ONUR KADİR'	,	 'ATBİNİCİ'	,	61	,	 'NevşehirKayisdagi'	)	,\n" + 
							"(	710	,	 'NESLİHAN'	,	 'YÖRÜK'	,	62	,	 'NiğdeKayisdagi'	)	,\n" + 
							"(	711	,	 'FATMA ESRA'	,	 'BÜYÜKDOĞAN'	,	63	,	 'OrduKayisdagi'	)	,\n" + 
							"(	712	,	 'HAZAN'	,	 'ÖZEN'	,	64	,	 'OsmaniyeKayisdagi'	)	,\n" + 
							"(	713	,	 'DİLEK'	,	 'KÜÇÜKGÖNCÜ'	,	65	,	 'RizeKayisdagi'	)	,\n" + 
							"(	714	,	 'GONCA'	,	 'BAYRAKTAR'	,	66	,	 'SakaryaKayisdagi'	)	,\n" + 
							"(	715	,	 'İBRAHİM'	,	 'YILDIRIM'	,	67	,	 'SamsunKayisdagi'	)	,\n" + 
							"(	716	,	 'MURAT'	,	 'BAKIRCI'	,	68	,	 'SiirtKayisdagi'	)	,\n" + 
							"(	717	,	 'GÜLDEHEN'	,	 'KARAHAN'	,	69	,	 'SinopKayisdagi'	)	,\n" + 
							"(	718	,	 'MEHMET ALİ'	,	 'YÖRÜK'	,	70	,	 'SivasKayisdagi'	)	,\n" + 
							"(	719	,	 'ŞAHİN'	,	 'AYDIN'	,	71	,	 'ŞanlıurfaKayisdagi'	)	,\n" + 
							"(	720	,	 'ESRA'	,	 'GÖRMELİ'	,	72	,	 'ŞırnakKayisdagi'	)	,\n" + 
							"(	721	,	 'DERYA'	,	 'ASLAN'	,	73	,	 'TekirdağKayisdagi'	)	,\n" + 
							"(	722	,	 'AYHAN'	,	 'YÜCEL'	,	74	,	 'TokatKayisdagi'	)	,\n" + 
							"(	723	,	 'SERPİL'	,	 'ALPSAN GÖKMEN'	,	75	,	 'TrabzonKayisdagi'	)	,\n" + 
							"(	724	,	 'TURGAY YILMAZ'	,	 'ŞAHİN'	,	76	,	 'TunceliKayisdagi'	)	,\n" + 
							"(	725	,	 'ÜMİT'	,	 'GÜRER'	,	77	,	 'UşakKayisdagi'	)	,\n" + 
							"(	726	,	 'BİROL'	,	 'ÇAKMAK'	,	78	,	 'VanKayisdagi'	)	,\n" + 
							"(	727	,	 'HATİCE ÖZGE'	,	 'GÜNGÖR'	,	79	,	 'YalovaKayisdagi'	)	,\n" + 
							"(	728	,	 'KUBİLAY'	,	 'SAVAŞ'	,	80	,	 'YozgatKayisdagi'	)	,\n" + 
							"(	729	,	 'TUBA'	,	 'BABA'	,	81	,	 'ZonguldakKayisdagi'	)	,\n" + 
							"(	730	,	 'PINAR'	,	 'YURDSEVEN'	,	1	,	 'AdanaKayisdagi'	)	,\n" + 
							"(	731	,	 'PINAR'	,	 'ARAZ SERVER'	,	2	,	 'AdıyamanKayisdagi'	)	,\n" + 
							"(	732	,	 'EMEL'	,	 'ŞAHİN'	,	3	,	 'AfyonkarahisarKayisdagi'	)	,\n" + 
							"(	733	,	 'SİMENDER'	,	 'DEMİR'	,	4	,	 'AğrıKayisdagi'	)	,\n" + 
							"(	734	,	 'MEHMET GÖKÇE'	,	 'ILGIN'	,	5	,	 'AksarayKayisdagi'	)	,\n" + 
							"(	735	,	 'SAMET SANCAR'	,	 'DEMİREL'	,	6	,	 'AmasyaKayisdagi'	)	,\n" + 
							"(	736	,	 'FAİK'	,	 'BAKAY'	,	7	,	 'AnkaraKayisdagi'	)	,\n" + 
							"(	737	,	 'MELTEM'	,	 'MERT'	,	8	,	 'AntalyaKayisdagi'	)	,\n" + 
							"(	738	,	 'AHMET EMRE'	,	 'ZAİM'	,	9	,	 'ArdahanKayisdagi'	)	,\n" + 
							"(	739	,	 'DAVUT'	,	 'SERTKAYAOĞLU'	,	10	,	 'ArtvinKayisdagi'	)	,\n" + 
							"(	740	,	 'TÜRKER'	,	 'HOŞER'	,	11	,	 'AydınKayisdagi'	)	,\n" + 
							"(	741	,	 'HİLAL'	,	 'OMAY'	,	12	,	 'BalıkesirKayisdagi'	)	,\n" + 
							"(	742	,	 'FARUK'	,	 'YEGEN YILMAZ'	,	13	,	 'BartınKayisdagi'	)	,\n" + 
							"(	743	,	 'BAYRAM'	,	 'YILDIZ'	,	14	,	 'BatmanKayisdagi'	)	,\n" + 
							"(	744	,	 'CEM YAŞAR'	,	 'KAÇER'	,	15	,	 'BayburtKayisdagi'	)	,\n" + 
							"(	745	,	 'ÖZLEM'	,	 'ONAY'	,	16	,	 'BilecikKayisdagi'	)	,\n" + 
							"(	746	,	 'PINAR'	,	 'AYDIN'	,	17	,	 'BingölKayisdagi'	)	,\n" + 
							"(	747	,	 'NİLÜFER'	,	 'BAKAN'	,	18	,	 'BitlisKayisdagi'	)	,\n" + 
							"(	748	,	 'NURMUHAMMET'	,	 'ATEŞ'	,	19	,	 'BoluKayisdagi'	)	,\n" + 
							"(	749	,	 'MURAT'	,	 'ASIG'	,	20	,	 'DenizliKayisdagi'	)	,\n" + 
							"(	750	,	 'HANDAN'	,	 'ŞAHİN'	,	21	,	 'BursaKayisdagi'	)	,\n" + 
							"(	751	,	 'SONER'	,	 'CÖMERT'	,	22	,	 'ÇanakkaleKayisdagi'	)	,\n" + 
							"(	752	,	 'REZZAN'	,	 'HALİS'	,	23	,	 'ÇankırıKayisdagi'	)	,\n" + 
							"(	753	,	 'ÖMER'	,	 'ÇOBANOĞLU'	,	24	,	 'ÇorumKayisdagi'	)	,\n" + 
							"(	754	,	 'MEHMET'	,	 'KURTPINAR'	,	25	,	 'BurdurKayisdagi'	)	,\n" + 
							"(	755	,	 'LEVENT'	,	 'DOĞAN'	,	26	,	 'DiyarbakırKayisdagi'	)	,\n" + 
							"(	756	,	 'HASAN SAMİ'	,	 'OKUR'	,	27	,	 'DüzceKayisdagi'	)	,\n" + 
							"(	757	,	 'SELÇUK'	,	 'GÜLEÇ'	,	28	,	 'EdirneKayisdagi'	)	,\n" + 
							"(	758	,	 'TEVFİK'	,	 'TÜRE'	,	29	,	 'ElazığKayisdagi'	)	,\n" + 
							"(	759	,	 'MUSTAFA KEMAL'	,	 'ERDEM'	,	30	,	 'ErzincanKayisdagi'	)	,\n" + 
							"(	760	,	 'OĞUZ KAAN'	,	 'CAN'	,	31	,	 'ErzurumKayisdagi'	)	,\n" + 
							"(	761	,	 'HASAN'	,	 'SUCAK'	,	32	,	 'EskişehirKayisdagi'	)	,\n" + 
							"(	762	,	 'CEREN'	,	 'ÜREYEN'	,	33	,	 'GaziantepKayisdagi'	)	,\n" + 
							"(	763	,	 'MEHMET HİLMİ'	,	 'ŞAİR'	,	34	,	 'GiresunKayisdagi'	)	,\n" + 
							"(	764	,	 'HALİL İBRAHİM'	,	 'AKHUN'	,	35	,	 'GümüşhaneKayisdagi'	)	,\n" + 
							"(	765	,	 'UĞURAY'	,	 'HAMDEMİRCİ'	,	36	,	 'HakkariKayisdagi'	)	,\n" + 
							"(	766	,	 'İREM'	,	 'CÖMERT'	,	37	,	 'HatayKayisdagi'	)	,\n" + 
							"(	767	,	 'SELİN'	,	 'DEMİR'	,	38	,	 'IğdırKayisdagi'	)	,\n" + 
							"(	768	,	 'AYŞEGÜL'	,	 'KADAK'	,	39	,	 'IspartaKayisdagi'	)	,\n" + 
							"(	769	,	 'TUĞRUL'	,	 'KOCASARAÇ'	,	40	,	 'İstanbulKayisdagi'	)	,\n" + 
							"(	770	,	 'ONUR'	,	 'GÜNDÜZ'	,	41	,	 'İzmirKayisdagi'	)	,\n" + 
							"(	771	,	 'OSMAN'	,	 'KIRLANGIÇ'	,	42	,	 'KahramanmaraşKayisdagi'	)	,\n" + 
							"(	772	,	 'DERVİŞ'	,	 'AYDEMİR'	,	43	,	 'KarabükKayisdagi'	)	,\n" + 
							"(	773	,	 'AYŞE GÜLÇİN'	,	 'IŞIK'	,	44	,	 'KaramanKayisdagi'	)	,\n" + 
							"(	774	,	 'EMİN TONYUKUK'	,	 'GÖKALP'	,	45	,	 'KarsKayisdagi'	)	,\n" + 
							"(	775	,	 'MUSTAFA'	,	 'ÜREYEN'	,	46	,	 'KastamonuKayisdagi'	)	,\n" + 
							"(	776	,	 'HALİL'	,	 'AKKAN'	,	47	,	 'KayseriKayisdagi'	)	,\n" + 
							"(	777	,	 'GÜLDEN SİNEM'	,	 'SÜVERAN'	,	48	,	 'KırıkkaleKayisdagi'	)	,\n" + 
							"(	778	,	 'İLKER'	,	 'IŞIK'	,	49	,	 'KırklareliKayisdagi'	)	,\n" + 
							"(	779	,	 'SEVGİ'	,	 'DEMİRTAŞ'	,	50	,	 'KırşehirKayisdagi'	)	,\n" + 
							"(	780	,	 'HÜSEYİN KUNTER'	,	 'KURT'	,	51	,	 'KilisKayisdagi'	)	,\n" + 
							"(	781	,	 'GÜL'	,	 'AKSAKAL'	,	52	,	 'KocaeliKayisdagi'	)	,\n" + 
							"(	782	,	 'EBRU'	,	 'BİRİ'	,	53	,	 'KonyaKayisdagi'	)	,\n" + 
							"(	783	,	 'BİLGİN'	,	 'ÇETİN'	,	54	,	 'KütahyaKayisdagi'	)	,\n" + 
							"(	784	,	 'SİBEL'	,	 'ÇELİKER'	,	55	,	 'MalatyaKayisdagi'	)	,\n" + 
							"(	785	,	 'YUSUF ZİYA'	,	 'HÜSEYİNOĞLU'	,	56	,	 'ManisaKayisdagi'	)	,\n" + 
							"(	786	,	 'MEHMET'	,	 'GENÇ'	,	57	,	 'MardinKayisdagi'	)	,\n" + 
							"(	787	,	 'OSMAN ERSEGUN'	,	 'ATAY'	,	58	,	 'MersinKayisdagi'	)	,\n" + 
							"(	788	,	 'AYKUT'	,	 'YAZAK'	,	59	,	 'MuğlaKayisdagi'	)	,\n" + 
							"(	789	,	 'İLKNUR'	,	 'AKTAN'	,	60	,	 'MuşKayisdagi'	)	,\n" + 
							"(	790	,	 'ABDULLAH'	,	 'YAŞAN'	,	61	,	 'NevşehirKayisdagi'	)	,\n" + 
							"(	791	,	 'FATİH NAZMİ'	,	 'KARAARSLAN'	,	62	,	 'NiğdeKayisdagi'	)	,\n" + 
							"(	792	,	 'GÖKSEL'	,	 'GÜVEN'	,	63	,	 'OrduKayisdagi'	)	,\n" + 
							"(	793	,	 'SERKAN'	,	 'KOÇYİĞİT'	,	64	,	 'OsmaniyeKayisdagi'	)	,\n" + 
							"(	794	,	 'TUĞBA'	,	 'DEMİR'	,	65	,	 'RizeKayisdagi'	)	,\n" + 
							"(	795	,	 'ÖZLEM'	,	 'YILDIRIM'	,	66	,	 'SakaryaKayisdagi'	)	,\n" + 
							"(	796	,	 'BİNNUR'	,	 'ERDAL'	,	67	,	 'SamsunKayisdagi'	)	,\n" + 
							"(	797	,	 'MELİHA ESRA'	,	 'SEVÜK'	,	68	,	 'SiirtKayisdagi'	)	,\n" + 
							"(	798	,	 'PELİN'	,	 'AYDIN'	,	69	,	 'SinopKayisdagi'	)	,\n" + 
							"(	799	,	 'İBRAHİM'	,	 'AKGÜL'	,	70	,	 'SivasKayisdagi'	)	,\n" + 
							"(	800	,	 'ŞEBNEM'	,	 'KAN'	,	71	,	 'ŞanlıurfaKayisdagi'	)	,\n" + 
							"(	801	,	 'UYGAR'	,	 'ÖZEN'	,	72	,	 'ŞırnakKayisdagi'	)	,\n" + 
							"(	802	,	 'VEDAT'	,	 'KIRCALI'	,	73	,	 'TekirdağKayisdagi'	)	,\n" + 
							"(	803	,	 'NURCAN'	,	 'OĞUZ'	,	74	,	 'TokatKayisdagi'	)	,\n" + 
							"(	804	,	 'SEVİL'	,	 'POLAT'	,	75	,	 'TrabzonKayisdagi'	)	,\n" + 
							"(	805	,	 'ORHAN'	,	 'KARABULUT'	,	76	,	 'TunceliKayisdagi'	)	,\n" + 
							"(	806	,	 'HANDE'	,	 'KURU'	,	77	,	 'UşakKayisdagi'	)	,\n" + 
							"(	807	,	 'MEHMET'	,	 'TEHLİ'	,	78	,	 'VanKayisdagi'	)	,\n" + 
							"(	808	,	 'ÖVÜNÇ'	,	 'ÖZMEN'	,	79	,	 'YalovaKayisdagi'	)	,\n" + 
							"(	809	,	 'GÖKNUR'	,	 'KARDAŞ'	,	80	,	 'YozgatKayisdagi'	)	,\n" + 
							"(	810	,	 'İHSAN BURAK'	,	 'ORAL'	,	81	,	 'ZonguldakKayisdagi'	)	,\n" + 
							"(	811	,	 'MEHMET ÖZER'	,	 'GÖKSOY'	,	1	,	 'AdanaKayisdagi'	)	,\n" + 
							"(	812	,	 'EDA'	,	 'DEMİRTÜRK'	,	2	,	 'AdıyamanKayisdagi'	)	,\n" + 
							"(	813	,	 'HARUN'	,	 'AÇAR'	,	3	,	 'AfyonkarahisarKayisdagi'	)	,\n" + 
							"(	814	,	 'İREM'	,	 'CAN BORAN'	,	4	,	 'AğrıKayisdagi'	)	,\n" + 
							"(	815	,	 'MUSTAFA'	,	 'GENÇPINAR'	,	5	,	 'AksarayKayisdagi'	)	,\n" + 
							"(	816	,	 'KAAN SUAT'	,	 'BEREKET'	,	6	,	 'AmasyaKayisdagi'	)	,\n" + 
							"(	817	,	 'ERHAN'	,	 'UÇAR'	,	7	,	 'AnkaraKayisdagi'	)	,\n" + 
							"(	818	,	 'MEHMET'	,	 'BARÇA'	,	8	,	 'AntalyaKayisdagi'	)	,\n" + 
							"(	819	,	 'MUSTAFA'	,	 'ILGIN'	,	9	,	 'ArdahanKayisdagi'	)	,\n" + 
							"(	820	,	 'BARIŞ'	,	 'SÜRMEN AKYOL'	,	10	,	 'ArtvinKayisdagi'	)	,\n" + 
							"(	821	,	 'YILDIRAY'	,	 'COŞKUNER'	,	11	,	 'AydınKayisdagi'	)	,\n" + 
							"(	822	,	 'HALİL İBRAHİM'	,	 'YILDIZ BULUT'	,	12	,	 'BalıkesirKayisdagi'	)	,\n" + 
							"(	823	,	 'HATİCE'	,	 'TOY'	,	13	,	 'BartınKayisdagi'	)	,\n" + 
							"(	824	,	 'AHMET ÇAĞRI'	,	 'YILDIZ'	,	14	,	 'BatmanKayisdagi'	)	,\n" + 
							"(	825	,	 'BÜNYAMİN'	,	 'KARKIN'	,	15	,	 'BayburtKayisdagi'	)	,\n" + 
							"(	826	,	 'YASEMİN'	,	 'AĞCA'	,	16	,	 'BilecikKayisdagi'	)	,\n" + 
							"(	827	,	 'BULUT'	,	 'DURAN'	,	17	,	 'BingölKayisdagi'	)	,\n" + 
							"(	828	,	 'EMRAH'	,	 'BAL'	,	18	,	 'BitlisKayisdagi'	)	,\n" + 
							"(	829	,	 'FERHAT'	,	 'İPEK'	,	19	,	 'BoluKayisdagi'	)	,\n" + 
							"(	830	,	 'IŞIL'	,	 'GÜMÜŞÇÜ'	,	20	,	 'DenizliKayisdagi'	)	,\n" + 
							"(	831	,	 'ONUR'	,	 'KARADEMİR'	,	21	,	 'BursaKayisdagi'	)	,\n" + 
							"(	832	,	 'MURAT'	,	 'SONAY'	,	22	,	 'ÇanakkaleKayisdagi'	)	,\n" + 
							"(	833	,	 'HİSAR CAN'	,	 'GÖRÜNMEZ'	,	23	,	 'ÇankırıKayisdagi'	)	,\n" + 
							"(	834	,	 'SEHER ÖZLEM'	,	 'ÖZTÜRK'	,	24	,	 'ÇorumKayisdagi'	)	,\n" + 
							"(	835	,	 'RAZİYE DAMLA'	,	 'YALÇIN'	,	25	,	 'BurdurKayisdagi'	)	,\n" + 
							"(	836	,	 'HÜSEYİN KALKAN'	,	 'BÜBER'	,	26	,	 'DiyarbakırKayisdagi'	)	,\n" + 
							"(	837	,	 'MUHAMMET BAĞBUR'	,	 'BİLGİÇ'	,	27	,	 'DüzceKayisdagi'	)	,\n" + 
							"(	838	,	 'HAÇÇE'	,	 'BEREKET'	,	28	,	 'EdirneKayisdagi'	)	,\n" + 
							"(	839	,	 'AYSEL'	,	 'ARSLAN'	,	29	,	 'ElazığKayisdagi'	)	,\n" + 
							"(	840	,	 'PINAR'	,	 'GÜRBOSTAN'	,	30	,	 'ErzincanKayisdagi'	)	,\n" + 
							"(	841	,	 'MURAT'	,	 'DEMİREL'	,	31	,	 'ErzurumKayisdagi'	)	,\n" + 
							"(	842	,	 'SERKAN'	,	 'ÜÇGÜL'	,	32	,	 'EskişehirKayisdagi'	)	,\n" + 
							"(	843	,	 'ALİ'	,	 'DEDE'	,	33	,	 'GaziantepKayisdagi'	)	,\n" + 
							"(	844	,	 'AHMET ALİ'	,	 'KILINÇ'	,	34	,	 'GiresunKayisdagi'	)	,\n" + 
							"(	845	,	 'RUKİYE'	,	 'TOLU'	,	35	,	 'GümüşhaneKayisdagi'	)	,\n" + 
							"(	846	,	 'MİRAY'	,	 'YENİLMEZ'	,	36	,	 'HakkariKayisdagi'	)	,\n" + 
							"(	847	,	 'ŞEYHMUS'	,	 'TUNCAY'	,	37	,	 'HatayKayisdagi'	)	,\n" + 
							"(	848	,	 'ÜMİT'	,	 'AKIN'	,	38	,	 'IğdırKayisdagi'	)	,\n" + 
							"(	849	,	 'MUTLU'	,	 'YILMAZ'	,	39	,	 'IspartaKayisdagi'	)	,\n" + 
							"(	850	,	 'AHMET'	,	 'TEL KANKILIÇ'	,	40	,	 'İstanbulKayisdagi'	)	,\n" + 
							"(	851	,	 'OSMAN'	,	 'ŞAHİN'	,	41	,	 'İzmirKayisdagi'	)	,\n" + 
							"(	852	,	 'NAİME SILA'	,	 'ALPSAN GÖKMEN'	,	42	,	 'KahramanmaraşKayisdagi'	)	,\n" + 
							"(	853	,	 'DİDEM'	,	 'AKGÜL'	,	43	,	 'KarabükKayisdagi'	)	,\n" + 
							"(	854	,	 'HASAN'	,	 'DEMİRTAŞ'	,	44	,	 'KaramanKayisdagi'	)	,\n" + 
							"(	855	,	 'YÜCEL'	,	 'GÖKSOY'	,	45	,	 'KarsKayisdagi'	)	,\n" + 
							"(	856	,	 'MUHSİN'	,	 'BAYAM'	,	46	,	 'KastamonuKayisdagi'	)	,\n" + 
							"(	857	,	 'HİCRAN'	,	 'SAĞLAM'	,	47	,	 'KayseriKayisdagi'	)	,\n" + 
							"(	858	,	 'GÜNEŞ'	,	 'GÜVERCİN'	,	48	,	 'KırıkkaleKayisdagi'	)	,\n" + 
							"(	859	,	 'RENGİN ASLIHAN'	,	 'KULAKSIZ'	,	49	,	 'KırklareliKayisdagi'	)	,\n" + 
							"(	860	,	 'ELÇİN'	,	 'AVCI'	,	50	,	 'KırşehirKayisdagi'	)	,\n" + 
							"(	861	,	 'BÜLENT'	,	 'TEKİN'	,	51	,	 'KilisKayisdagi'	)	,\n" + 
							"(	862	,	 'SELİM'	,	 'SU KURT'	,	52	,	 'KocaeliKayisdagi'	)	,\n" + 
							"(	863	,	 'KERİM'	,	 'SÖNMEZ'	,	53	,	 'KonyaKayisdagi'	)	,\n" + 
							"(	864	,	 'EDA'	,	 'İLGEN'	,	54	,	 'KütahyaKayisdagi'	)	,\n" + 
							"(	865	,	 'AYŞE'	,	 'KARADAĞ'	,	55	,	 'MalatyaKayisdagi'	)	,\n" + 
							"(	866	,	 'IŞIL'	,	 'KILIÇOĞLU'	,	56	,	 'ManisaKayisdagi'	)	,\n" + 
							"(	867	,	 'SEVGÜL'	,	 'ÖZKAN'	,	57	,	 'MardinKayisdagi'	)	,\n" + 
							"(	868	,	 'İLKER'	,	 'PAKÖZ'	,	58	,	 'MersinKayisdagi'	)	,\n" + 
							"(	869	,	 'HALE'	,	 'TUNCER'	,	59	,	 'MuğlaKayisdagi'	)	,\n" + 
							"(	870	,	 'ÖZNUR'	,	 'ÖZKIRIŞ'	,	60	,	 'MuşKayisdagi'	)	,\n" + 
							"(	871	,	 'TUĞBA'	,	 'OLGEN'	,	61	,	 'NevşehirKayisdagi'	)	,\n" + 
							"(	872	,	 'GÖZDE KÜBRA'	,	 'ÖZDEMİRKIRAN'	,	62	,	 'NiğdeKayisdagi'	)	,\n" + 
							"(	873	,	 'MERAL'	,	 'GÜNEBAKAN'	,	63	,	 'OrduKayisdagi'	)	,\n" + 
							"(	874	,	 'AYDOĞAN'	,	 'DEMİRTAŞ'	,	64	,	 'OsmaniyeKayisdagi'	)	,\n" + 
							"(	875	,	 'MEHMET HAZBİN'	,	 'SÜMER'	,	65	,	 'RizeKayisdagi'	)	,\n" + 
							"(	876	,	 'PINAR'	,	 'AYDIN'	,	66	,	 'SakaryaKayisdagi'	)	,\n" + 
							"(	877	,	 'EMRAH'	,	 'TUNCAY'	,	67	,	 'SamsunKayisdagi'	)	,\n" + 
							"(	878	,	 'MEHMET VEHBİ'	,	 'KAYKI'	,	68	,	 'SiirtKayisdagi'	)	,\n" + 
							"(	879	,	 'NEBİ'	,	 'ÖZDOĞAN KAVZOĞLU'	,	69	,	 'SinopKayisdagi'	)	,\n" + 
							"(	880	,	 'BEDRİYE MÜGE'	,	 'KÜTÜK'	,	70	,	 'SivasKayisdagi'	)	,\n" + 
							"(	881	,	 'HANDE'	,	 'ÜLGEN'	,	71	,	 'ŞanlıurfaKayisdagi'	)	,\n" + 
							"(	882	,	 'TÜMAY'	,	 'KAHYA'	,	72	,	 'ŞırnakKayisdagi'	)	,\n" + 
							"(	883	,	 'ASUDAN TUĞÇE'	,	 'TURAN'	,	73	,	 'TekirdağKayisdagi'	)	,\n" + 
							"(	884	,	 'SİNAN DİNÇER'	,	 'SEĞMEN'	,	74	,	 'TokatKayisdagi'	)	,\n" + 
							"(	885	,	 'ÖMER'	,	 'KONURALP'	,	75	,	 'TrabzonKayisdagi'	)	,\n" + 
							"(	886	,	 'SAYGIN'	,	 'MUMCUOĞLU'	,	76	,	 'TunceliKayisdagi'	)	,\n" + 
							"(	887	,	 'MURAT'	,	 'VATANSEVER'	,	77	,	 'UşakKayisdagi'	)	,\n" + 
							"(	888	,	 'SALİHA'	,	 'AKGÜL'	,	78	,	 'VanKayisdagi'	)	,\n" + 
							"(	889	,	 'YETKİN'	,	 'ARDA'	,	79	,	 'YalovaKayisdagi'	)	,\n" + 
							"(	890	,	 'MAHMUT'	,	 'ŞENCAN'	,	80	,	 'YozgatKayisdagi'	)	,\n" + 
							"(	891	,	 'ZEHRA'	,	 'ULU'	,	81	,	 'ZonguldakKayisdagi'	)	,\n" + 
							"(	892	,	 'BURCU'	,	 'KASKALAN'	,	1	,	 'AdanaKayisdagi'	)	,\n" + 
							"(	893	,	 'ABDULLATİF'	,	 'KAYA'	,	2	,	 'AdıyamanKayisdagi'	)	,\n" + 
							"(	894	,	 'MUHAMMED MUCAHİD'	,	 'OCAK'	,	3	,	 'AfyonkarahisarKayisdagi'	)	,\n" + 
							"(	895	,	 'SEBAHAT'	,	 'YORGANCI'	,	4	,	 'AğrıKayisdagi'	)	,\n" + 
							"(	896	,	 'BAVER'	,	 'DİRİCAN'	,	5	,	 'AksarayKayisdagi'	)	,\n" + 
							"(	897	,	 'MEHMET MURAT'	,	 'YÜCETÜRK'	,	6	,	 'AmasyaKayisdagi'	)	,\n" + 
							"(	898	,	 'HALİL İBRAHİM'	,	 'CEYLAN'	,	7	,	 'AnkaraKayisdagi'	)	,\n" + 
							"(	899	,	 'YELİZ'	,	 'KOR'	,	8	,	 'AntalyaKayisdagi'	)	,\n" + 
							"(	900	,	 'ADNAN'	,	 'ULUSOY'	,	9	,	 'ArdahanKayisdagi'	)	,\n" + 
							"(	901	,	 'SAVAŞ'	,	 'KARA'	,	10	,	 'ArtvinKayisdagi'	)	,\n" + 
							"(	902	,	 'MERVE'	,	 'ERDAL'	,	11	,	 'AydınKayisdagi'	)	,\n" + 
							"(	903	,	 'BİNNUR'	,	 'KANKILIÇ'	,	12	,	 'BalıkesirKayisdagi'	)	,\n" + 
							"(	904	,	 'TURĞUT'	,	 'ÜNALAN'	,	13	,	 'BartınKayisdagi'	)	,\n" + 
							"(	905	,	 'ÖZGE'	,	 'VATANSEVER'	,	14	,	 'BatmanKayisdagi'	)	,\n" + 
							"(	906	,	 'BELMA'	,	 'ÜLKEVAN'	,	15	,	 'BayburtKayisdagi'	)	,\n" + 
							"(	907	,	 'RUKİYE'	,	 'DOĞAN'	,	16	,	 'BilecikKayisdagi'	)	,\n" + 
							"(	908	,	 'MEHMET ALİ'	,	 'OZAN'	,	17	,	 'BingölKayisdagi'	)	,\n" + 
							"(	909	,	 'GÖKSEL'	,	 'KARAKILIÇ'	,	18	,	 'BitlisKayisdagi'	)	,\n" + 
							"(	910	,	 'IŞIK'	,	 'KARDAŞ'	,	19	,	 'BoluKayisdagi'	)	,\n" + 
							"(	911	,	 'KÜBRA'	,	 'CÖMERT'	,	20	,	 'DenizliKayisdagi'	)	,\n" + 
							"(	912	,	 'UMUT'	,	 'KARADENİZ'	,	21	,	 'BursaKayisdagi'	)	,\n" + 
							"(	913	,	 'AHMET CEVDET'	,	 'KARAKÖK GÜNGÖR'	,	22	,	 'ÇanakkaleKayisdagi'	)	,\n" + 
							"(	914	,	 'MURAT'	,	 'SİL'	,	23	,	 'ÇankırıKayisdagi'	)	,\n" + 
							"(	915	,	 'HALE'	,	 'YAVUZ'	,	24	,	 'ÇorumKayisdagi'	)	,\n" + 
							"(	916	,	 'SELİM'	,	 'AKOVA'	,	25	,	 'BurdurKayisdagi'	)	,\n" + 
							"(	917	,	 'YÜCE'	,	 'ORHAN'	,	26	,	 'DiyarbakırKayisdagi'	)	,\n" + 
							"(	918	,	 'EROL'	,	 'IŞIK'	,	27	,	 'DüzceKayisdagi'	)	,\n" + 
							"(	919	,	 'ABİDE MERVE'	,	 'DURÇ ÖZTÜRK'	,	28	,	 'EdirneKayisdagi'	)	,\n" + 
							"(	920	,	 'MELİHA ESRA'	,	 'ELDEM'	,	29	,	 'ElazığKayisdagi'	)	,\n" + 
							"(	921	,	 'MERVE'	,	 'KORKUT'	,	30	,	 'ErzincanKayisdagi'	)	,\n" + 
							"(	922	,	 'MUSTAFA ARİF'	,	 'KAPLAN'	,	31	,	 'ErzurumKayisdagi'	)	,\n" + 
							"(	923	,	 'SERDAR'	,	 'KARALAR'	,	32	,	 'EskişehirKayisdagi'	)	,\n" + 
							"(	924	,	 'SANEM GÖKÇEN MERVE'	,	 'KAYA'	,	33	,	 'GaziantepKayisdagi'	)	,\n" + 
							"(	925	,	 'ŞEYMA'	,	 'TOPRAK'	,	34	,	 'GiresunKayisdagi'	)	,\n" + 
							"(	926	,	 'TAYYAR ALP'	,	 'TOKTAŞ'	,	35	,	 'GümüşhaneKayisdagi'	)	,\n" + 
							"(	927	,	 'BETÜL EMİNE'	,	 'GÜVEN MEŞE'	,	36	,	 'HakkariKayisdagi'	)	,\n" + 
							"(	928	,	 'BAHADIR'	,	 'DİLMEN'	,	37	,	 'HatayKayisdagi'	)	,\n" + 
							"(	929	,	 'OSMAN'	,	 'BİCAN'	,	38	,	 'IğdırKayisdagi'	)	,\n" + 
							"(	930	,	 'NİHAN'	,	 'KÖROĞLU'	,	39	,	 'IspartaKayisdagi'	)	,\n" + 
							"(	931	,	 'GÖKTEKİN'	,	 'KARAHAN'	,	40	,	 'İstanbulKayisdagi'	)	,\n" + 
							"(	932	,	 'BERKAN'	,	 'ÖZSAYGILI'	,	41	,	 'İzmirKayisdagi'	)	,\n" + 
							"(	933	,	 'ZEHRA'	,	 'KARAKULAK'	,	42	,	 'KahramanmaraşKayisdagi'	)	,\n" + 
							"(	934	,	 'LEMAN'	,	 'DOĞAN'	,	43	,	 'KarabükKayisdagi'	)	,\n" + 
							"(	935	,	 'OĞUZ'	,	 'KILINÇ'	,	44	,	 'KaramanKayisdagi'	)	,\n" + 
							"(	936	,	 'MEHMET ALİ'	,	 'GÖKALP'	,	45	,	 'KarsKayisdagi'	)	,\n" + 
							"(	937	,	 'EMİN'	,	 'ÇEVİKER'	,	46	,	 'KastamonuKayisdagi'	)	,\n" + 
							"(	938	,	 'ESİN'	,	 'TOPER'	,	47	,	 'KayseriKayisdagi'	)	,\n" + 
							"(	939	,	 'EKREM'	,	 'SARIÇİÇEK'	,	48	,	 'KırıkkaleKayisdagi'	)	,\n" + 
							"(	940	,	 'NEFİSE'	,	 'ALTUN'	,	49	,	 'KırklareliKayisdagi'	)	,\n" + 
							"(	941	,	 'AHMET CAN'	,	 'DEDE'	,	50	,	 'KırşehirKayisdagi'	)	,\n" + 
							"(	942	,	 'SONGÜL'	,	 'SEYHAN'	,	51	,	 'KilisKayisdagi'	)	,\n" + 
							"(	943	,	 'ADEM'	,	 'YAĞCIZEYBEK'	,	52	,	 'KocaeliKayisdagi'	)	,\n" + 
							"(	944	,	 'MUSTAFA RAŞİD'	,	 'SÜMER'	,	53	,	 'KonyaKayisdagi'	)	,\n" + 
							"(	945	,	 'ÖZLEM'	,	 'YERAL'	,	54	,	 'KütahyaKayisdagi'	)	,\n" + 
							"(	946	,	 'AYŞE CEREN'	,	 'ÖZDEMİR'	,	55	,	 'MalatyaKayisdagi'	)	,\n" + 
							"(	947	,	 'ELZEM'	,	 'SUCAK'	,	56	,	 'ManisaKayisdagi'	)	,\n" + 
							"(	948	,	 'MERYEM'	,	 'SONAY'	,	57	,	 'MardinKayisdagi'	)	,\n" + 
							"(	949	,	 'NAGİHAN'	,	 'ERZURUM'	,	58	,	 'MersinKayisdagi'	)	,\n" + 
							"(	950	,	 'YUSUF'	,	 'ÖZCAN'	,	59	,	 'MuğlaKayisdagi'	)	,\n" + 
							"(	951	,	 'SELÇUK'	,	 'YILMAZ GELEBEK'	,	60	,	 'MuşKayisdagi'	)	,\n" + 
							"(	952	,	 'ZEKİ'	,	 'BAYRAK'	,	61	,	 'NevşehirKayisdagi'	)	,\n" + 
							"(	953	,	 'İLKER'	,	 'ÖZDEMİR'	,	62	,	 'NiğdeKayisdagi'	)	,\n" + 
							"(	954	,	 'İDRİS BUGRA'	,	 'KUŞAKÇI'	,	63	,	 'OrduKayisdagi'	)	,\n" + 
							"(	955	,	 'NEVROZ'	,	 'KARACA'	,	64	,	 'OsmaniyeKayisdagi'	)	,\n" + 
							"(	956	,	 'EZGİ'	,	 'SEVİNÇ'	,	65	,	 'RizeKayisdagi'	)	,\n" + 
							"(	957	,	 'SERDAR'	,	 'ERZURUM'	,	66	,	 'SakaryaKayisdagi'	)	,\n" + 
							"(	958	,	 'İRFAN'	,	 'TÜRKOĞLU'	,	67	,	 'SamsunKayisdagi'	)	,\n" + 
							"(	959	,	 'ÖZLEM'	,	 'MUMCUOĞLU'	,	68	,	 'SiirtKayisdagi'	)	,\n" + 
							"(	960	,	 'İSMAİL'	,	 'EMET'	,	69	,	 'SinopKayisdagi'	)	,\n" + 
							"(	961	,	 'İSA'	,	 'AYHAN'	,	70	,	 'SivasKayisdagi'	)	,\n" + 
							"(	962	,	 'YALÇIN'	,	 'IŞIK'	,	71	,	 'ŞanlıurfaKayisdagi'	)	,\n" + 
							"(	963	,	 'MUSTAFA RAŞİD'	,	 'ÖZMEN'	,	72	,	 'ŞırnakKayisdagi'	)	,\n" + 
							"(	964	,	 'ŞEYDA'	,	 'ATAY'	,	73	,	 'TekirdağKayisdagi'	)	,\n" + 
							"(	965	,	 'FATMA ESRA'	,	 'PEYNİRCİ'	,	74	,	 'TokatKayisdagi'	)	,\n" + 
							"(	966	,	 'MUHAMMET BAĞBUR'	,	 'BARDAKÇI'	,	75	,	 'TrabzonKayisdagi'	)	,\n" + 
							"(	967	,	 'MEHMET'	,	 'AKBAŞ'	,	76	,	 'TunceliKayisdagi'	)	,\n" + 
							"(	968	,	 'MELİKE'	,	 'PEHLİVAN'	,	77	,	 'UşakKayisdagi'	)	,\n" + 
							"(	969	,	 'ZEYNEP'	,	 'GÜLŞAN'	,	78	,	 'VanKayisdagi'	)	,\n" + 
							"(	970	,	 'CEBRAİL'	,	 'YILDIZ'	,	79	,	 'YalovaKayisdagi'	)	,\n" + 
							"(	971	,	 'REZZAN'	,	 'KOL'	,	80	,	 'YozgatKayisdagi'	)	,\n" + 
							"(	972	,	 'MEHMET HÜSEYİN'	,	 'ÇELİK'	,	81	,	 'ZonguldakKayisdagi'	)	,\n" + 
							"(	973	,	 'ELİF'	,	 'ASLAN'	,	1	,	 'AdanaUmraniye'	)	,\n" + 
							"(	974	,	 'RAMAZAN'	,	 'KARAHAN'	,	2	,	 'AdıyamanUmraniye'	)	,\n" + 
							"(	975	,	 'ELİF TUĞÇE'	,	 'BÜYÜKKAL'	,	3	,	 'AfyonkarahisarUmraniye'	)	,\n" + 
							"(	976	,	 'UĞURAY'	,	 'ŞAHİN'	,	4	,	 'AğrıUmraniye'	)	,\n" + 
							"(	977	,	 'MUSTAFA'	,	 'ÇAKMAK'	,	5	,	 'AksarayUmraniye'	)	,\n" + 
							"(	978	,	 'DERYA'	,	 'TEOMAN'	,	6	,	 'AmasyaUmraniye'	)	,\n" + 
							"(	979	,	 'SERTAÇ'	,	 'SANHAL'	,	7	,	 'AnkaraUmraniye'	)	,\n" + 
							"(	980	,	 'BURAK'	,	 'YILDIRIM'	,	8	,	 'AntalyaUmraniye'	)	,\n" + 
							"(	981	,	 'SANEM GÖKÇEN MERVE'	,	 'OFLAZ'	,	9	,	 'ArdahanUmraniye'	)	,\n" + 
							"(	982	,	 'NURDAN'	,	 'ÖZDEMİR'	,	10	,	 'ArtvinUmraniye'	)	,\n" + 
							"(	983	,	 'NİMET'	,	 'BAZ'	,	11	,	 'AydınUmraniye'	)	,\n" + 
							"(	984	,	 'GÜLŞAH'	,	 'BİLİCİ'	,	12	,	 'BalıkesirUmraniye'	)	,\n" + 
							"(	985	,	 'EZGİ GİZEM'	,	 'YILDIZ'	,	13	,	 'BartınUmraniye'	)	,\n" + 
							"(	986	,	 'MEHMET'	,	 'AYDOĞAN'	,	14	,	 'BatmanUmraniye'	)	,\n" + 
							"(	987	,	 'SEVDE NUR'	,	 'BÖCÜ'	,	15	,	 'BayburtUmraniye'	)	,\n" + 
							"(	988	,	 'BUĞRA'	,	 'YILDIRIM'	,	16	,	 'BilecikUmraniye'	)	,\n" + 
							"(	989	,	 'ERHAN'	,	 'KESGİN'	,	17	,	 'BingölUmraniye'	)	,\n" + 
							"(	990	,	 'İLKNUR'	,	 'YANIK'	,	18	,	 'BitlisUmraniye'	)	,\n" + 
							"(	991	,	 'MEHMET GÖKÇE'	,	 'YACI'	,	19	,	 'BoluUmraniye'	)	,\n" + 
							"(	992	,	 'MELDA'	,	 'KILAVUZ'	,	20	,	 'DenizliUmraniye'	)	,\n" + 
							"(	993	,	 'BURHAN'	,	 'BAYRAM'	,	21	,	 'BursaUmraniye'	)	,\n" + 
							"(	994	,	 'DENİZ'	,	 'YUMURTAŞ'	,	22	,	 'ÇanakkaleUmraniye'	)	,\n" + 
							"(	995	,	 'HASAN BİLEN'	,	 'BAŞTÜRK AYHAN'	,	23	,	 'ÇankırıUmraniye'	)	,\n" + 
							"(	996	,	 'GÜLŞAH'	,	 'KARKIN'	,	24	,	 'ÇorumUmraniye'	)	,\n" + 
							"(	997	,	 'ELİF'	,	 'YAVUZ'	,	25	,	 'BurdurUmraniye'	)	,\n" + 
							"(	998	,	 'ERDEM'	,	 'ÇAKMAK'	,	26	,	 'DiyarbakırUmraniye'	)	,\n" + 
							"(	999	,	 'MEHMET'	,	 'ÖZDEMİR'	,	27	,	 'DüzceUmraniye'	)	,\n" + 
							"(	1000	,	 'RİFAT CAN'	,	 'GÜRBOSTAN'	,	28	,	 'EdirneUmraniye'	)	,\n" + 
							"(	1001	,	 'EMİN'	,	 'DİRİCAN'	,	29	,	 'ElazığUmraniye'	)	,\n" + 
							"(	1002	,	 'ORGÜL DERYA'	,	 'GEDİKLİ'	,	30	,	 'ErzincanUmraniye'	)	,\n" + 
							"(	1003	,	 'AHMET ALİ'	,	 'CÖMERT'	,	31	,	 'ErzurumUmraniye'	)	,\n" + 
							"(	1004	,	 'METE CAN'	,	 'BOZAN'	,	32	,	 'EskişehirUmraniye'	)	,\n" + 
							"(	1005	,	 'EMRAH'	,	 'ÖZDEN'	,	33	,	 'GaziantepUmraniye'	)	,\n" + 
							"(	1006	,	 'ŞİRİN'	,	 'USLU'	,	34	,	 'GiresunUmraniye'	)	,\n" + 
							"(	1007	,	 'MESUT'	,	 'BOLAT'	,	35	,	 'GümüşhaneUmraniye'	)	,\n" + 
							"(	1008	,	 'ÖZGE'	,	 'KİRİŞCİ'	,	36	,	 'HakkariUmraniye'	)	,\n" + 
							"(	1009	,	 'ÖMER'	,	 'KIYAK'	,	37	,	 'HatayUmraniye'	)	,\n" + 
							"(	1010	,	 'UMUT CAN'	,	 'GÖKGÜL'	,	38	,	 'IğdırUmraniye'	)	,\n" + 
							"(	1011	,	 'ALİ'	,	 'AYDOS'	,	39	,	 'IspartaUmraniye'	)	,\n" + 
							"(	1012	,	 'SERKAN'	,	 'KOCA'	,	40	,	 'İstanbulUmraniye'	)	,\n" + 
							"(	1013	,	 'GÖKAY'	,	 'BABAYİĞİT'	,	41	,	 'İzmirUmraniye'	)	,\n" + 
							"(	1014	,	 'HİDAYET'	,	 'ÜÇER'	,	42	,	 'KahramanmaraşUmraniye'	)	,\n" + 
							"(	1015	,	 'EMRAH'	,	 'GÜRDEMİR'	,	43	,	 'KarabükUmraniye'	)	,\n" + 
							"(	1016	,	 'SELİM'	,	 'ÖZAVCI AYGÜN'	,	44	,	 'KaramanUmraniye'	)	,\n" + 
							"(	1017	,	 'BERNA'	,	 'YILMAZ'	,	45	,	 'KarsUmraniye'	)	,\n" + 
							"(	1018	,	 'KONURALP'	,	 'KACEMER'	,	46	,	 'KastamonuUmraniye'	)	,\n" + 
							"(	1019	,	 'ÜMİT'	,	 'DESTEGÜL'	,	47	,	 'KayseriUmraniye'	)	,\n" + 
							"(	1020	,	 'SANEM GÖKÇEN MERVE'	,	 'PAKSOY'	,	48	,	 'KırıkkaleUmraniye'	)	,\n" + 
							"(	1021	,	 'GAMZE'	,	 'TOY'	,	49	,	 'KırklareliUmraniye'	)	,\n" + 
							"(	1022	,	 'DENİZ'	,	 'ILGIN'	,	50	,	 'KırşehirUmraniye'	)	,\n" + 
							"(	1023	,	 'SEDA'	,	 'YILMAZ'	,	51	,	 'KilisUmraniye'	)	,\n" + 
							"(	1024	,	 'METİN'	,	 'İŞGÖREN'	,	52	,	 'KocaeliUmraniye'	)	,\n" + 
							"(	1025	,	 'ÖZLEM'	,	 'KOCABIYIK'	,	53	,	 'KonyaUmraniye'	)	,\n" + 
							"(	1026	,	 'ARMAN'	,	 'BARIŞAN'	,	54	,	 'KütahyaUmraniye'	)	,\n" + 
							"(	1027	,	 'MERVE NUR'	,	 'BARAN'	,	55	,	 'MalatyaUmraniye'	)	,\n" + 
							"(	1028	,	 'DOĞAN'	,	 'AKTAŞ'	,	56	,	 'ManisaUmraniye'	)	,\n" + 
							"(	1029	,	 'MERYEM'	,	 'SERBEST'	,	57	,	 'MardinUmraniye'	)	,\n" + 
							"(	1030	,	 'CİHAN'	,	 'GÖRMELİ'	,	58	,	 'MersinUmraniye'	)	,\n" + 
							"(	1031	,	 'ERKİN'	,	 'SERİN'	,	59	,	 'MuğlaUmraniye'	)	,\n" + 
							"(	1032	,	 'HAMZA'	,	 'DİKOĞLU'	,	60	,	 'MuşUmraniye'	)	,\n" + 
							"(	1033	,	 'MURAT'	,	 'KOCASARAÇ'	,	61	,	 'NevşehirUmraniye'	)	,\n" + 
							"(	1034	,	 'IŞIN'	,	 'YENİÇERİ'	,	62	,	 'NiğdeUmraniye'	)	,\n" + 
							"(	1035	,	 'KAMİL'	,	 'ESMERAY'	,	63	,	 'OrduUmraniye'	)	,\n" + 
							"(	1036	,	 'SELİM'	,	 'EFE'	,	64	,	 'OsmaniyeUmraniye'	)	,\n" + 
							"(	1037	,	 'FATİH'	,	 'BAKLACI'	,	65	,	 'RizeUmraniye'	)	,\n" + 
							"(	1038	,	 'İLKAY'	,	 'EROĞLU'	,	66	,	 'SakaryaUmraniye'	)	,\n" + 
							"(	1039	,	 'MUSTAFA'	,	 'ÜNAL'	,	67	,	 'SamsunUmraniye'	)	,\n" + 
							"(	1040	,	 'ABDUL AZİM'	,	 'AKSAKAL'	,	68	,	 'SiirtUmraniye'	)	,\n" + 
							"(	1041	,	 'NURİ ANIL'	,	 'YILDIZ'	,	69	,	 'SinopUmraniye'	)	,\n" + 
							"(	1042	,	 'SÜMEYRA'	,	 'ŞAŞMAZ'	,	70	,	 'SivasUmraniye'	)	,\n" + 
							"(	1043	,	 'SERVET'	,	 'ŞAŞMAZ'	,	71	,	 'ŞanlıurfaUmraniye'	)	,\n" + 
							"(	1044	,	 'KAMİL'	,	 'KELEŞ'	,	72	,	 'ŞırnakUmraniye'	)	,\n" + 
							"(	1045	,	 'RAMAZAN'	,	 'ÇELİKTEN'	,	73	,	 'TekirdağUmraniye'	)	,\n" + 
							"(	1046	,	 'İRFAN'	,	 'SİL'	,	74	,	 'TokatUmraniye'	)	,\n" + 
							"(	1047	,	 'ABİDE MERVE'	,	 'KURTULUŞ'	,	75	,	 'TrabzonUmraniye'	)	,\n" + 
							"(	1048	,	 'ŞULE'	,	 'BAKAY'	,	76	,	 'TunceliUmraniye'	)	,\n" + 
							"(	1049	,	 'NECMİYE GÜL'	,	 'KACEMER'	,	77	,	 'UşakUmraniye'	)	,\n" + 
							"(	1050	,	 'MERT METİN'	,	 'ÜNLÜ'	,	78	,	 'VanUmraniye'	)	,\n" + 
							"(	1051	,	 'IŞIN'	,	 'DEMİRTÜRK'	,	79	,	 'YalovaUmraniye'	)	,\n" + 
							"(	1052	,	 'MUSTAFA'	,	 'UYSAL'	,	80	,	 'YozgatUmraniye'	)	,\n" + 
							"(	1053	,	 'CEYHUN'	,	 'KARLI'	,	81	,	 'ZonguldakUmraniye'	)	,\n" + 
							"(	1054	,	 'AHMET ÇAĞRI'	,	 'KARAKÖSE'	,	1	,	 'AdanaUmraniye'	)	,\n" + 
							"(	1055	,	 'TUĞBA'	,	 'KARA'	,	2	,	 'AdıyamanUmraniye'	)	,\n" + 
							"(	1056	,	 'HÜSEYİN YAVUZ'	,	 'GÖKÇE'	,	3	,	 'AfyonkarahisarUmraniye'	)	,\n" + 
							"(	1057	,	 'ERKAN'	,	 'ATİLA'	,	4	,	 'AğrıUmraniye'	)	,\n" + 
							"(	1058	,	 'KADİR'	,	 'ÖZASLAN'	,	5	,	 'AksarayUmraniye'	)	,\n" + 
							"(	1059	,	 'ZEYNEP EZGİ'	,	 'DEMİR'	,	6	,	 'AmasyaUmraniye'	)	,\n" + 
							"(	1060	,	 'UFUK'	,	 'ALTIN'	,	7	,	 'AnkaraUmraniye'	)	,\n" + 
							"(	1061	,	 'MEHMET SUPHİ'	,	 'AKBAŞ ÖNCEL'	,	8	,	 'AntalyaUmraniye'	)	,\n" + 
							"(	1062	,	 'MELİHA ESRA'	,	 'GÜLLÜ'	,	9	,	 'ArdahanUmraniye'	)	,\n" + 
							"(	1063	,	 'EMİNE'	,	 'GÜNGÖR'	,	10	,	 'ArtvinUmraniye'	)	,\n" + 
							"(	1064	,	 'NİLÜFER'	,	 'KÖKSAL'	,	11	,	 'AydınUmraniye'	)	,\n" + 
							"(	1065	,	 'ŞEYHMUS'	,	 'KARASU'	,	12	,	 'BalıkesirUmraniye'	)	,\n" + 
							"(	1066	,	 'İSMAİL ŞENOL'	,	 'TOPRAK'	,	13	,	 'BartınUmraniye'	)	,\n" + 
							"(	1067	,	 'YILDIRIM'	,	 'ERDOĞAN'	,	14	,	 'BatmanUmraniye'	)	,\n" + 
							"(	1068	,	 'HÜSEYİN'	,	 'BAYTAN'	,	15	,	 'BayburtUmraniye'	)	,\n" + 
							"(	1069	,	 'NAFİYE'	,	 'KURT'	,	16	,	 'BilecikUmraniye'	)	,\n" + 
							"(	1070	,	 'SİNAN'	,	 'YALÇIN'	,	17	,	 'BingölUmraniye'	)	,\n" + 
							"(	1071	,	 'HİLAL'	,	 'YAŞAR'	,	18	,	 'BitlisUmraniye'	)	,\n" + 
							"(	1072	,	 'EREN'	,	 'ÇETİN'	,	19	,	 'BoluUmraniye'	)	,\n" + 
							"(	1073	,	 'ÖMER FARUK'	,	 'İNSELÖZ'	,	20	,	 'DenizliUmraniye'	)	,\n" + 
							"(	1074	,	 'ÖMER'	,	 'ABAT'	,	21	,	 'BursaUmraniye'	)	,\n" + 
							"(	1075	,	 'EMİNE'	,	 'TÜRKMEN ALBAYRAK'	,	22	,	 'ÇanakkaleUmraniye'	)	,\n" + 
							"(	1076	,	 'MÜMTAZ'	,	 'MALÇOK'	,	23	,	 'ÇankırıUmraniye'	)	,\n" + 
							"(	1077	,	 'ÖZLEM'	,	 'AYDUĞAN'	,	24	,	 'ÇorumUmraniye'	)	,\n" + 
							"(	1078	,	 'HİDAYET'	,	 'YILMAZ GELEBEK'	,	25	,	 'BurdurUmraniye'	)	,\n" + 
							"(	1079	,	 'ÜLKÜHAN'	,	 'ALTUN'	,	26	,	 'DiyarbakırUmraniye'	)	,\n" + 
							"(	1080	,	 'AYHAN'	,	 'KALEM'	,	27	,	 'DüzceUmraniye'	)	,\n" + 
							"(	1081	,	 'MÜRSEL'	,	 'BAL'	,	28	,	 'EdirneUmraniye'	)	,\n" + 
							"(	1082	,	 'İLKAY'	,	 'KILIÇ'	,	29	,	 'ElazığUmraniye'	)	,\n" + 
							"(	1083	,	 'İLKNUR'	,	 'ÇEKİÇ'	,	30	,	 'ErzincanUmraniye'	)	,\n" + 
							"(	1084	,	 'HASAN'	,	 'DENİZ'	,	31	,	 'ErzurumUmraniye'	)	,\n" + 
							"(	1085	,	 'OSMAN ERSEGUN'	,	 'OĞUZ'	,	32	,	 'EskişehirUmraniye'	)	,\n" + 
							"(	1086	,	 'KORHAN'	,	 'KABİL KUCUR'	,	33	,	 'GaziantepUmraniye'	)	,\n" + 
							"(	1087	,	 'MÜŞERREF'	,	 'ELÇİÇEK'	,	34	,	 'GiresunUmraniye'	)	,\n" + 
							"(	1088	,	 'SEMA'	,	 'ASIG'	,	35	,	 'GümüşhaneUmraniye'	)	,\n" + 
							"(	1089	,	 'MUSTAFA CİHAD'	,	 'KIRHAN'	,	36	,	 'HakkariUmraniye'	)	,\n" + 
							"(	1090	,	 'SALİHA SANEM'	,	 'TOPÇU'	,	37	,	 'HatayUmraniye'	)	,\n" + 
							"(	1091	,	 'MUKADDES'	,	 'YETKİNŞEKERCİ'	,	38	,	 'IğdırUmraniye'	)	,\n" + 
							"(	1092	,	 'YENER'	,	 'GÜNEYSU'	,	39	,	 'IspartaUmraniye'	)	,\n" + 
							"(	1093	,	 'EMEL'	,	 'KARADENİZ'	,	40	,	 'İstanbulUmraniye'	)	,\n" + 
							"(	1094	,	 'İPEK'	,	 'YILMAZ'	,	41	,	 'İzmirUmraniye'	)	,\n" + 
							"(	1095	,	 'OSMAN'	,	 'KARATAŞ'	,	42	,	 'KahramanmaraşUmraniye'	)	,\n" + 
							"(	1096	,	 'ERHAN'	,	 'KARADAVUT'	,	43	,	 'KarabükUmraniye'	)	,\n" + 
							"(	1097	,	 'CANSU'	,	 'BATGİ AZARKAN'	,	44	,	 'KaramanUmraniye'	)	,\n" + 
							"(	1098	,	 'ÖZGE'	,	 'BİRİ'	,	45	,	 'KarsUmraniye'	)	,\n" + 
							"(	1099	,	 'SEYFİ CEM'	,	 'KAPLAN'	,	46	,	 'KastamonuUmraniye'	)	,\n" + 
							"(	1100	,	 'BURCU'	,	 'BAYRAK'	,	47	,	 'KayseriUmraniye'	)	,\n" + 
							"(	1101	,	 'BERNA'	,	 'BAYRAK'	,	48	,	 'KırıkkaleUmraniye'	)	,\n" + 
							"(	1102	,	 'BURAK'	,	 'ESEN'	,	49	,	 'KırklareliUmraniye'	)	,\n" + 
							"(	1103	,	 'TUĞBA'	,	 'ORDULU ŞAHİN'	,	50	,	 'KırşehirUmraniye'	)	,\n" + 
							"(	1104	,	 'FİLİZ'	,	 'SEZER'	,	51	,	 'KilisUmraniye'	)	,\n" + 
							"(	1105	,	 'METİN'	,	 'ÖZDEMİR'	,	52	,	 'KocaeliUmraniye'	)	,\n" + 
							"(	1106	,	 'SİBEL'	,	 'UÇAR'	,	53	,	 'KonyaUmraniye'	)	,\n" + 
							"(	1107	,	 'MEHMET REŞİT'	,	 'ONAT'	,	54	,	 'KütahyaUmraniye'	)	,\n" + 
							"(	1108	,	 'FEZA'	,	 'AKGÜL'	,	55	,	 'MalatyaUmraniye'	)	,\n" + 
							"(	1109	,	 'ASUDAN TUĞÇE'	,	 'DEMİRCAN'	,	56	,	 'ManisaUmraniye'	)	,\n" + 
							"(	1110	,	 'NURSEL'	,	 'MUMCUOĞLU'	,	57	,	 'MardinUmraniye'	)	,\n" + 
							"(	1111	,	 'ELİF'	,	 'ŞAHİN'	,	58	,	 'MersinUmraniye'	)	,\n" + 
							"(	1112	,	 'RAMAZAN'	,	 'ONRAT'	,	59	,	 'MuğlaUmraniye'	)	,\n" + 
							"(	1113	,	 'ESMERALDA'	,	 'HÜSEYİNOĞLU'	,	60	,	 'MuşUmraniye'	)	,\n" + 
							"(	1114	,	 'FATMA BEGÜM'	,	 'PEKGÖZ'	,	61	,	 'NevşehirUmraniye'	)	,\n" + 
							"(	1115	,	 'DENİZ'	,	 'SERTOĞLU'	,	62	,	 'NiğdeUmraniye'	)	,\n" + 
							"(	1116	,	 'BETÜL'	,	 'KUŞAKÇI'	,	63	,	 'OrduUmraniye'	)	,\n" + 
							"(	1117	,	 'EFTAL MURAT'	,	 'KAYNAK'	,	64	,	 'OsmaniyeUmraniye'	)	,\n" + 
							"(	1118	,	 'NURULLAH'	,	 'DENİZ'	,	65	,	 'RizeUmraniye'	)	,\n" + 
							"(	1119	,	 'YASİN'	,	 'AKKAŞ'	,	66	,	 'SakaryaUmraniye'	)	,\n" + 
							"(	1120	,	 'AHMET ALİ'	,	 'BAYRAM'	,	67	,	 'SamsunUmraniye'	)	,\n" + 
							"(	1121	,	 'ABDULKADİR'	,	 'ÖĞÜTMEN KOÇ'	,	68	,	 'SiirtUmraniye'	)	,\n" + 
							"(	1122	,	 'MEHMET'	,	 'ONAY'	,	69	,	 'SinopUmraniye'	)	,\n" + 
							"(	1123	,	 'METİN'	,	 'KAPAR'	,	70	,	 'SivasUmraniye'	)	,\n" + 
							"(	1124	,	 'CEYHAN'	,	 'BAŞARAN'	,	71	,	 'ŞanlıurfaUmraniye'	)	,\n" + 
							"(	1125	,	 'NAZAN'	,	 'ŞİMŞEK'	,	72	,	 'ŞırnakUmraniye'	)	,\n" + 
							"(	1126	,	 'EVRE'	,	 'SEVİNÇ'	,	73	,	 'TekirdağUmraniye'	)	,\n" + 
							"(	1127	,	 'HÜSEYİN'	,	 'DEDE'	,	74	,	 'TokatUmraniye'	)	,\n" + 
							"(	1128	,	 'ALİŞAN'	,	 'YAZICI'	,	75	,	 'TrabzonUmraniye'	)	,\n" + 
							"(	1129	,	 'GÖKNUR'	,	 'ATEŞ'	,	76	,	 'TunceliUmraniye'	)	,\n" + 
							"(	1130	,	 'AYCAN'	,	 'ŞENCAN'	,	77	,	 'UşakUmraniye'	)	,\n" + 
							"(	1131	,	 'SÜLEYMAN'	,	 'GÖK'	,	78	,	 'VanUmraniye'	)	,\n" + 
							"(	1132	,	 'FULYA'	,	 'ŞAHİN'	,	79	,	 'YalovaUmraniye'	)	,\n" + 
							"(	1133	,	 'MUSTAFA'	,	 'CAN'	,	80	,	 'YozgatUmraniye'	)	,\n" + 
							"(	1134	,	 'EMEL'	,	 'PULAT'	,	81	,	 'ZonguldakUmraniye'	)	,\n" + 
							"(	1135	,	 'DİLEK'	,	 'KOCABIYIK'	,	1	,	 'AdanaUmraniye'	)	,\n" + 
							"(	1136	,	 'RIDVAN'	,	 'BİNNETOĞLU'	,	2	,	 'AdıyamanUmraniye'	)	,\n" + 
							"(	1137	,	 'VOLKAN'	,	 'YILDIZ'	,	3	,	 'AfyonkarahisarUmraniye'	)	,\n" + 
							"(	1138	,	 'TAYYAR ALP'	,	 'KURT'	,	4	,	 'AğrıUmraniye'	)	,\n" + 
							"(	1139	,	 'AYŞE'	,	 'OCAK'	,	5	,	 'AksarayUmraniye'	)	,\n" + 
							"(	1140	,	 'NİMET'	,	 'YÜCETÜRK'	,	6	,	 'AmasyaUmraniye'	)	,\n" + 
							"(	1141	,	 'MEHMET'	,	 'YEGEN YILMAZ'	,	7	,	 'AnkaraUmraniye'	)	,\n" + 
							"(	1142	,	 'AYLİN SEVİL'	,	 'ŞİRİN'	,	8	,	 'AntalyaUmraniye'	)	,\n" + 
							"(	1143	,	 'ÜBEYDULLAH'	,	 'BERENT'	,	9	,	 'ArdahanUmraniye'	)	,\n" + 
							"(	1144	,	 'CEM ATAKAN'	,	 'BAYRAK'	,	10	,	 'ArtvinUmraniye'	)	,\n" + 
							"(	1145	,	 'FULYA'	,	 'TOY'	,	11	,	 'AydınUmraniye'	)	,\n" + 
							"(	1146	,	 'MEHMED UĞUR'	,	 'ŞAHİN'	,	12	,	 'BalıkesirUmraniye'	)	,\n" + 
							"(	1147	,	 'BİLGİN'	,	 'MENTEŞ'	,	13	,	 'BartınUmraniye'	)	,\n" + 
							"(	1148	,	 'TUNCAY'	,	 'KILINÇ'	,	14	,	 'BatmanUmraniye'	)	,\n" + 
							"(	1149	,	 'İBRAHİM'	,	 'OLGEN'	,	15	,	 'BayburtUmraniye'	)	,\n" + 
							"(	1150	,	 'ORGÜL DERYA'	,	 'KOR'	,	16	,	 'BilecikUmraniye'	)	,\n" + 
							"(	1151	,	 'SERKAN'	,	 'KÜTÜK'	,	17	,	 'BingölUmraniye'	)	,\n" + 
							"(	1152	,	 'SERDAR'	,	 'DADALI'	,	18	,	 'BitlisUmraniye'	)	,\n" + 
							"(	1153	,	 'HALİM'	,	 'ELDEM'	,	19	,	 'BoluUmraniye'	)	,\n" + 
							"(	1154	,	 'ONUR SALİH'	,	 'KARAKULAK'	,	20	,	 'DenizliUmraniye'	)	,\n" + 
							"(	1155	,	 'İZZET'	,	 'OSMANCA'	,	21	,	 'BursaUmraniye'	)	,\n" + 
							"(	1156	,	 'TAYLAN UĞUR'	,	 'KEBAPCILAR'	,	22	,	 'ÇanakkaleUmraniye'	)	,\n" + 
							"(	1157	,	 'ASIM'	,	 'KAYAOĞLU'	,	23	,	 'ÇankırıUmraniye'	)	,\n" + 
							"(	1158	,	 'ŞENOL'	,	 'KAYAOĞLU'	,	24	,	 'ÇorumUmraniye'	)	,\n" + 
							"(	1159	,	 'AYŞE AHSEN'	,	 'TİKİCİ'	,	25	,	 'BurdurUmraniye'	)	,\n" + 
							"(	1160	,	 'BUŞRA'	,	 'TUNÇ'	,	26	,	 'DiyarbakırUmraniye'	)	,\n" + 
							"(	1161	,	 'AYŞE'	,	 'ŞANLIKAN'	,	27	,	 'DüzceUmraniye'	)	,\n" + 
							"(	1162	,	 'MÜNEVER'	,	 'KAYA'	,	28	,	 'EdirneUmraniye'	)	,\n" + 
							"(	1163	,	 'EMRAH'	,	 'ZEYLİ'	,	29	,	 'ElazığUmraniye'	)	,\n" + 
							"(	1164	,	 'PELİN'	,	 'ÇEVİRGEN'	,	30	,	 'ErzincanUmraniye'	)	,\n" + 
							"(	1165	,	 'BİRSEN'	,	 'ÇOBANOĞLU'	,	31	,	 'ErzurumUmraniye'	)	,\n" + 
							"(	1166	,	 'AYSUN'	,	 'SU'	,	32	,	 'EskişehirUmraniye'	)	,\n" + 
							"(	1167	,	 'FERİDE'	,	 'HAKYOL'	,	33	,	 'GaziantepUmraniye'	)	,\n" + 
							"(	1168	,	 'AKSEL'	,	 'ÖZDEMİR AKDUR'	,	34	,	 'GiresunUmraniye'	)	,\n" + 
							"(	1169	,	 'SERAP'	,	 'ÜNALAN'	,	35	,	 'GümüşhaneUmraniye'	)	,\n" + 
							"(	1170	,	 'ÖZEN ÖZLEM'	,	 'GÜNGÖRMEZ'	,	36	,	 'HakkariUmraniye'	)	,\n" + 
							"(	1171	,	 'ELİF CEREN'	,	 'AKTAŞ'	,	37	,	 'HatayUmraniye'	)	,\n" + 
							"(	1172	,	 'AHMET'	,	 'ÇAVLI'	,	38	,	 'IğdırUmraniye'	)	,\n" + 
							"(	1173	,	 'NEBİ'	,	 'KILINÇ'	,	39	,	 'IspartaUmraniye'	)	,\n" + 
							"(	1174	,	 'ESER'	,	 'DİRİCAN'	,	40	,	 'İstanbulUmraniye'	)	,\n" + 
							"(	1175	,	 'EMİNE DİLEK'	,	 'DÜZGÜN'	,	41	,	 'İzmirUmraniye'	)	,\n" + 
							"(	1176	,	 'MEHMET'	,	 'KARAGÖZ'	,	42	,	 'KahramanmaraşUmraniye'	)	,\n" + 
							"(	1177	,	 'ERDEM'	,	 'AKSOY'	,	43	,	 'KarabükUmraniye'	)	,\n" + 
							"(	1178	,	 'BERAY'	,	 'ÇELEN'	,	44	,	 'KaramanUmraniye'	)	,\n" + 
							"(	1179	,	 'TUĞBA'	,	 'ÖKTEM'	,	45	,	 'KarsUmraniye'	)	,\n" + 
							"(	1180	,	 'AHMET'	,	 'KARAOĞLANOĞLU'	,	46	,	 'KastamonuUmraniye'	)	,\n" + 
							"(	1181	,	 'KADİR'	,	 'ŞAHİN'	,	47	,	 'KayseriUmraniye'	)	,\n" + 
							"(	1182	,	 'ÖZGE'	,	 'İNANMAZ'	,	48	,	 'KırıkkaleUmraniye'	)	,\n" + 
							"(	1183	,	 'MURAT'	,	 'ETLEÇ'	,	49	,	 'KırklareliUmraniye'	)	,\n" + 
							"(	1184	,	 'MUSTAFA'	,	 'TÜFENK'	,	50	,	 'KırşehirUmraniye'	)	,\n" + 
							"(	1185	,	 'SAMET'	,	 'SARIKAYA'	,	51	,	 'KilisUmraniye'	)	,\n" + 
							"(	1186	,	 'HALUK'	,	 'AYDIN'	,	52	,	 'KocaeliUmraniye'	)	,\n" + 
							"(	1187	,	 'DUYGU'	,	 'ÜLGEN'	,	53	,	 'KonyaUmraniye'	)	,\n" + 
							"(	1188	,	 'GÖKMEN ALPASLAN'	,	 'ÖZ'	,	54	,	 'KütahyaUmraniye'	)	,\n" + 
							"(	1189	,	 'MUSTAFA'	,	 'KARAKAYA'	,	55	,	 'MalatyaUmraniye'	)	,\n" + 
							"(	1190	,	 'MÜRSEL'	,	 'ÇELİK'	,	56	,	 'ManisaUmraniye'	)	,\n" + 
							"(	1191	,	 'MUHAMMED FURKAN'	,	 'ÇETİN'	,	57	,	 'MardinUmraniye'	)	,\n" + 
							"(	1192	,	 'MUSTAFA'	,	 'ÇEÇEN'	,	58	,	 'MersinUmraniye'	)	,\n" + 
							"(	1193	,	 'SERPİL'	,	 'KIRAÇ'	,	59	,	 'MuğlaUmraniye'	)	,\n" + 
							"(	1194	,	 'CANSEN'	,	 'İŞGÖREN'	,	60	,	 'MuşUmraniye'	)	,\n" + 
							"(	1195	,	 'HİCRAN'	,	 'ÇOPUR'	,	61	,	 'NevşehirUmraniye'	)	,\n" + 
							"(	1196	,	 'MURAT'	,	 'POSTALLI'	,	62	,	 'NiğdeUmraniye'	)	,\n" + 
							"(	1197	,	 'TESLİME NAZLI'	,	 'ÇAKIR'	,	63	,	 'OrduUmraniye'	)	,\n" + 
							"(	1198	,	 'MUSTAFA'	,	 'ŞAHİN'	,	64	,	 'OsmaniyeUmraniye'	)	,\n" + 
							"(	1199	,	 'KURTULUŞ'	,	 'SEVEN'	,	65	,	 'RizeUmraniye'	)	,\n" + 
							"(	1200	,	 'AYTAÇ'	,	 'GÜNGÖR'	,	66	,	 'SakaryaUmraniye'	)	,\n" + 
							"(	1201	,	 'ERCAN'	,	 'YACI'	,	67	,	 'SamsunUmraniye'	)	,\n" + 
							"(	1202	,	 'MUSTAFA'	,	 'PINARBAŞILI'	,	68	,	 'SiirtUmraniye'	)	,\n" + 
							"(	1203	,	 'İSMAİL MİKDAT'	,	 'ARGON'	,	69	,	 'SinopUmraniye'	)	,\n" + 
							"(	1204	,	 'MEHMET İKBAL'	,	 'GÖDE'	,	70	,	 'SivasUmraniye'	)	,\n" + 
							"(	1205	,	 'MEHMET NURİ'	,	 'GÖKALP'	,	71	,	 'ŞanlıurfaUmraniye'	)	,\n" + 
							"(	1206	,	 'İLKER'	,	 'KIRIŞ'	,	72	,	 'ŞırnakUmraniye'	)	,\n" + 
							"(	1207	,	 'AHMET GÖKHAN'	,	 'LEVENT'	,	73	,	 'TekirdağUmraniye'	)	,\n" + 
							"(	1208	,	 'DİLARA'	,	 'DOKUMACIOĞLU'	,	74	,	 'TokatUmraniye'	)	,\n" + 
							"(	1209	,	 'KEMAL'	,	 'AKTÜRK'	,	75	,	 'TrabzonUmraniye'	)	,\n" + 
							"(	1210	,	 'EMİNE'	,	 'KESGİN'	,	76	,	 'TunceliUmraniye'	)	,\n" + 
							"(	1211	,	 'ÖZLEM'	,	 'ŞEN'	,	77	,	 'UşakUmraniye'	)	,\n" + 
							"(	1212	,	 'HATİCE'	,	 'CANPOLAT'	,	78	,	 'VanUmraniye'	)	,\n" + 
							"(	1213	,	 'OĞUZ'	,	 'KHALİL'	,	79	,	 'YalovaUmraniye'	)	,\n" + 
							"(	1214	,	 'SÜLEYMAN'	,	 'SU KURT'	,	80	,	 'YozgatUmraniye'	)	,\n" + 
							"(	1215	,	 'OSMAN'	,	 'POLAT'	,	81	,	 'ZonguldakUmraniye'	)	,\n" + 
							"(	1216	,	 'MEHMET'	,	 'ESEN'	,	1	,	 'AdanaUmraniye'	)	,\n" + 
							"(	1217	,	 'BİLGE'	,	 'YERAL'	,	2	,	 'AdıyamanUmraniye'	)	,\n" + 
							"(	1218	,	 'DENİZ'	,	 'ALICI'	,	3	,	 'AfyonkarahisarUmraniye'	)	,\n" + 
							"(	1219	,	 'HACI KEMAL'	,	 'YILMAZ'	,	4	,	 'AğrıUmraniye'	)	,\n" + 
							"(	1220	,	 'ERDAL'	,	 'CEYLAN'	,	5	,	 'AksarayUmraniye'	)	,\n" + 
							"(	1221	,	 'EBRU'	,	 'GÖKTAŞ'	,	6	,	 'AmasyaUmraniye'	)	,\n" + 
							"(	1222	,	 'FATMA'	,	 'ÖZDEMİR'	,	7	,	 'AnkaraUmraniye'	)	,\n" + 
							"(	1223	,	 'MİNE CANSU'	,	 'KITAY'	,	8	,	 'AntalyaUmraniye'	)	,\n" + 
							"(	1224	,	 'ÖMER'	,	 'ŞAHBAZ'	,	9	,	 'ArdahanUmraniye'	)	,\n" + 
							"(	1225	,	 'MEHMET SELAHATTİN'	,	 'KÖKSAL'	,	10	,	 'ArtvinUmraniye'	)	,\n" + 
							"(	1226	,	 'ÇAĞRI'	,	 'YILMAZ'	,	11	,	 'AydınUmraniye'	)	,\n" + 
							"(	1227	,	 'KORHAN'	,	 'TOŞUR'	,	12	,	 'BalıkesirUmraniye'	)	,\n" + 
							"(	1228	,	 'MERVE'	,	 'ÖZLÜ'	,	13	,	 'BartınUmraniye'	)	,\n" + 
							"(	1229	,	 'HAKAN'	,	 'KADAK'	,	14	,	 'BatmanUmraniye'	)	,\n" + 
							"(	1230	,	 'EMİNE'	,	 'ORAL'	,	15	,	 'BayburtUmraniye'	)	,\n" + 
							"(	1231	,	 'ESİN'	,	 'KARACA'	,	16	,	 'BilecikUmraniye'	)	,\n" + 
							"(	1232	,	 'HACI MURAT'	,	 'ÇINKIR'	,	17	,	 'BingölUmraniye'	)	,\n" + 
							"(	1233	,	 'ADEM'	,	 'ÇELİK'	,	18	,	 'BitlisUmraniye'	)	,\n" + 
							"(	1234	,	 'AYTAÇ'	,	 'DEMİRTAŞ'	,	19	,	 'BoluUmraniye'	)	,\n" + 
							"(	1235	,	 'DENİZ'	,	 'ÖZDEMİR'	,	20	,	 'DenizliUmraniye'	)	,\n" + 
							"(	1236	,	 'BAŞAK'	,	 'TEHLİ'	,	21	,	 'BursaUmraniye'	)	,\n" + 
							"(	1237	,	 'ASLAN'	,	 'ÖZTÜRK'	,	22	,	 'ÇanakkaleUmraniye'	)	,\n" + 
							"(	1238	,	 'ÇAĞLA'	,	 'ÖZDEMİR'	,	23	,	 'ÇankırıUmraniye'	)	,\n" + 
							"(	1239	,	 'YUSUF EMRE'	,	 'TUNCER'	,	24	,	 'ÇorumUmraniye'	)	,\n" + 
							"(	1240	,	 'FULYA'	,	 'TOKAR'	,	25	,	 'BurdurUmraniye'	)	,\n" + 
							"(	1241	,	 'CEYDA'	,	 'ŞAİR'	,	26	,	 'DiyarbakırUmraniye'	)	,\n" + 
							"(	1242	,	 'FATİH'	,	 'BATGİ AZARKAN'	,	27	,	 'DüzceUmraniye'	)	,\n" + 
							"(	1243	,	 'HAMZA'	,	 'MÜEZZİNOĞLU'	,	28	,	 'EdirneUmraniye'	)	,\n" + 
							"(	1244	,	 'ÖZGÜR SİNAN'	,	 'CÖMERT'	,	29	,	 'ElazığUmraniye'	)	,\n" + 
							"(	1245	,	 'MAHİR'	,	 'AZAP'	,	30	,	 'ErzincanUmraniye'	)	,\n" + 
							"(	1246	,	 'AYŞE'	,	 'HÜSEYNİ'	,	31	,	 'ErzurumUmraniye'	)	,\n" + 
							"(	1247	,	 'SONGÜL'	,	 'BOZKURT'	,	32	,	 'EskişehirUmraniye'	)	,\n" + 
							"(	1248	,	 'MEHTAP'	,	 'SUVARİ'	,	33	,	 'GaziantepUmraniye'	)	,\n" + 
							"(	1249	,	 'ENGİN'	,	 'TÜREMENOĞULLARI'	,	34	,	 'GiresunUmraniye'	)	,\n" + 
							"(	1250	,	 'NURDAN'	,	 'BİLGİÇ'	,	35	,	 'GümüşhaneUmraniye'	)	,\n" + 
							"(	1251	,	 'SALİHA '	,	 'SANEM'	,	36	,	 'HakkariUmraniye'	)	,\n" + 
							"(	1252	,	 'DİLŞAH'	,	 'TEZER'	,	37	,	 'HatayUmraniye'	)	,\n" + 
							"(	1253	,	 'BURAK'	,	 'HALICI'	,	38	,	 'IğdırUmraniye'	)	,\n" + 
							"(	1254	,	 'HALE'	,	 'SEVİMLİ'	,	39	,	 'IspartaUmraniye'	)	,\n" + 
							"(	1255	,	 'AYSUN'	,	 'IŞIKALAN'	,	40	,	 'İstanbulUmraniye'	)	,\n" + 
							"(	1256	,	 'YUNUS EMRE'	,	 'ÖZCAN'	,	41	,	 'İzmirUmraniye'	)	,\n" + 
							"(	1257	,	 'ÖZLEM'	,	 'ÖZ'	,	42	,	 'KahramanmaraşUmraniye'	)	,\n" + 
							"(	1258	,	 'PELİN'	,	 'DEMİR'	,	43	,	 'KarabükUmraniye'	)	,\n" + 
							"(	1259	,	 'ALİ'	,	 'CAMCI'	,	44	,	 'KaramanUmraniye'	)	,\n" + 
							"(	1260	,	 'AYŞE'	,	 'KARADEMİR'	,	45	,	 'KarsUmraniye'	)	,\n" + 
							"(	1261	,	 'PELİN'	,	 'YILMAZ'	,	46	,	 'KastamonuUmraniye'	)	,\n" + 
							"(	1262	,	 'FARİS'	,	 'ŞAHİN'	,	47	,	 'KayseriUmraniye'	)	,\n" + 
							"(	1263	,	 'ŞEYMA MELİHA'	,	 'GÜLCAN'	,	48	,	 'KırıkkaleUmraniye'	)	,\n" + 
							"(	1264	,	 'SEZİN'	,	 'KULAKSIZ'	,	49	,	 'KırklareliUmraniye'	)	,\n" + 
							"(	1265	,	 'URAL'	,	 'KAYHAN'	,	50	,	 'KırşehirUmraniye'	)	,\n" + 
							"(	1266	,	 'BURCU'	,	 'BARAN'	,	51	,	 'KilisUmraniye'	)	,\n" + 
							"(	1267	,	 'URAL'	,	 'CILIZ BASHEER'	,	52	,	 'KocaeliUmraniye'	)	,\n" + 
							"(	1268	,	 'GÜLAY'	,	 'ÇETİN'	,	53	,	 'KonyaUmraniye'	)	,\n" + 
							"(	1269	,	 'HASAN BİLEN'	,	 'SARICA DAROL'	,	54	,	 'KütahyaUmraniye'	)	,\n" + 
							"(	1270	,	 'ESİN'	,	 'ASLAN'	,	55	,	 'MalatyaUmraniye'	)	,\n" + 
							"(	1271	,	 'AZİZ'	,	 'ONAT'	,	56	,	 'ManisaUmraniye'	)	,\n" + 
							"(	1272	,	 'EMİNE'	,	 'KITAY'	,	57	,	 'MardinUmraniye'	)	,\n" + 
							"(	1273	,	 'MİRAY'	,	 'TOPÇU'	,	58	,	 'MersinUmraniye'	)	,\n" + 
							"(	1274	,	 'MUSTAFA'	,	 'EKEN'	,	59	,	 'MuğlaUmraniye'	)	,\n" + 
							"(	1275	,	 'TAHİR'	,	 'ERGÜN'	,	60	,	 'MuşUmraniye'	)	,\n" + 
							"(	1276	,	 'EMRAH'	,	 'ÜLGEN'	,	61	,	 'NevşehirUmraniye'	)	,\n" + 
							"(	1277	,	 'TEVHİD'	,	 'ŞİMŞEK'	,	62	,	 'NiğdeUmraniye'	)	,\n" + 
							"(	1278	,	 'HATİCE'	,	 'BAŞARAN'	,	63	,	 'OrduUmraniye'	)	,\n" + 
							"(	1279	,	 'CEYDA'	,	 'KILIÇOĞLU'	,	64	,	 'OsmaniyeUmraniye'	)	,\n" + 
							"(	1280	,	 'İHSAN'	,	 'KEŞKEK'	,	65	,	 'RizeUmraniye'	)	,\n" + 
							"(	1281	,	 'ALİ'	,	 'BAŞAR'	,	66	,	 'SakaryaUmraniye'	)	,\n" + 
							"(	1282	,	 'DİLBER'	,	 'YÖRÜK'	,	67	,	 'SamsunUmraniye'	)	,\n" + 
							"(	1283	,	 'NEBİL'	,	 'TURAÇ'	,	68	,	 'SiirtUmraniye'	)	,\n" + 
							"(	1284	,	 'OKAN'	,	 'GELEGEN'	,	69	,	 'SinopUmraniye'	)	,\n" + 
							"(	1285	,	 'ŞAFAK'	,	 'BATMAZ'	,	70	,	 'SivasUmraniye'	)	,\n" + 
							"(	1286	,	 'BURÇİN MERYEM'	,	 'ŞİMŞEK'	,	71	,	 'ŞanlıurfaUmraniye'	)	,\n" + 
							"(	1287	,	 'SALİM'	,	 'AVCU'	,	72	,	 'ŞırnakUmraniye'	)	,\n" + 
							"(	1288	,	 'EMRAH KEMAL'	,	 'KARADUMAN'	,	73	,	 'TekirdağUmraniye'	)	,\n" + 
							"(	1289	,	 'İLKAY'	,	 'HIDIROĞLU'	,	74	,	 'TokatUmraniye'	)	,\n" + 
							"(	1290	,	 'CUMA'	,	 'TÜRKAY'	,	75	,	 'TrabzonUmraniye'	)	,\n" + 
							"(	1291	,	 'ASLAN'	,	 'TÜRE'	,	76	,	 'TunceliUmraniye'	)	,\n" + 
							"(	1292	,	 'HATİCE'	,	 'KOTTAŞ'	,	77	,	 'UşakUmraniye'	)	,\n" + 
							"(	1293	,	 'HALUK'	,	 'CAMGÖZ'	,	78	,	 'VanUmraniye'	)	,\n" + 
							"(	1294	,	 'DERYA'	,	 'KARAİSMAİLOĞLU'	,	79	,	 'YalovaUmraniye'	)	,\n" + 
							"(	1295	,	 'YUSUF'	,	 'DURAN'	,	80	,	 'YozgatUmraniye'	)	,\n" + 
							"(	1296	,	 'SİBEL'	,	 'KARAKAYA'	,	81	,	 'ZonguldakUmraniye'	)	,\n" + 
							"(	1297	,	 'MUSTAFA TURAN'	,	 'KHALİL'	,	1	,	 'AdanaModa'	)	,\n" + 
							"(	1298	,	 'UMUT'	,	 'GÖKALP'	,	2	,	 'AdıyamanModa'	)	,\n" + 
							"(	1299	,	 'DİLEK'	,	 'ÖZMUK'	,	3	,	 'AfyonkarahisarModa'	)	,\n" + 
							"(	1300	,	 'CEM ATAKAN'	,	 'TÜRKOĞLU'	,	4	,	 'AğrıModa'	)	,\n" + 
							"(	1301	,	 'YAVUZ SELİM'	,	 'BOBUŞOĞLU'	,	5	,	 'AksarayModa'	)	,\n" + 
							"(	1302	,	 'YUNUS'	,	 'HAKYOL'	,	6	,	 'AmasyaModa'	)	,\n" + 
							"(	1303	,	 'PELİN'	,	 'YAKUT'	,	7	,	 'AnkaraModa'	)	,\n" + 
							"(	1304	,	 'NURAN'	,	 'SAÇLI'	,	8	,	 'AntalyaModa'	)	,\n" + 
							"(	1305	,	 'REZAN'	,	 'BAKAY'	,	9	,	 'ArdahanModa'	)	,\n" + 
							"(	1306	,	 'KERİM'	,	 'KARDAŞ'	,	10	,	 'ArtvinModa'	)	,\n" + 
							"(	1307	,	 'AYSEL'	,	 'FİLİZ'	,	11	,	 'AydınModa'	)	,\n" + 
							"(	1308	,	 'MEHMET'	,	 'DİKİCİ'	,	12	,	 'BalıkesirModa'	)	,\n" + 
							"(	1309	,	 'DAVUT'	,	 'ÖZ'	,	13	,	 'BartınModa'	)	,\n" + 
							"(	1310	,	 'MAHMUT EMRE'	,	 'BABADAĞI'	,	14	,	 'BatmanModa'	)	,\n" + 
							"(	1311	,	 'HATİKE'	,	 'ÖZDEMİR'	,	15	,	 'BayburtModa'	)	,\n" + 
							"(	1312	,	 'NİMET'	,	 'GÖKTAŞ'	,	16	,	 'BilecikModa'	)	,\n" + 
							"(	1313	,	 'SELAHATTİN'	,	 'AKYOL'	,	17	,	 'BingölModa'	)	,\n" + 
							"(	1314	,	 'İSA'	,	 'BAKIRCI'	,	18	,	 'BitlisModa'	)	,\n" + 
							"(	1315	,	 'RAMAZAN'	,	 'HEYBET'	,	19	,	 'BoluModa'	)	,\n" + 
							"(	1316	,	 'VEDAT'	,	 'AYIK'	,	20	,	 'DenizliModa'	)	,\n" + 
							"(	1317	,	 'EMCED'	,	 'BİCAN'	,	21	,	 'BursaModa'	)	,\n" + 
							"(	1318	,	 'SÜMEYRA'	,	 'ÖZTÜRK'	,	22	,	 'ÇanakkaleModa'	)	,\n" + 
							"(	1319	,	 'MUSACİDE ZEHRA'	,	 'ÖZDOĞAN KAVZOĞLU'	,	23	,	 'ÇankırıModa'	)	,\n" + 
							"(	1320	,	 'SERPİL'	,	 'ALPSAN GÖKMEN'	,	24	,	 'ÇorumModa'	)	,\n" + 
							"(	1321	,	 'ÖZLEM'	,	 'ALTIN'	,	25	,	 'BurdurModa'	)	,\n" + 
							"(	1322	,	 'YUSUF ZİYA'	,	 'YEGİN'	,	26	,	 'DiyarbakırModa'	)	,\n" + 
							"(	1323	,	 'İLKNUR'	,	 'ÜNAL'	,	27	,	 'DüzceModa'	)	,\n" + 
							"(	1324	,	 'ERKİN'	,	 'KOÇAR'	,	28	,	 'EdirneModa'	)	,\n" + 
							"(	1325	,	 'SERKAN'	,	 'ÇETİNTAŞ'	,	29	,	 'ElazığModa'	)	,\n" + 
							"(	1326	,	 'MUSTAFA'	,	 'TOMBUL'	,	30	,	 'ErzincanModa'	)	,\n" + 
							"(	1327	,	 'MAHMUT'	,	 'ŞİMŞEK'	,	31	,	 'ErzurumModa'	)	,\n" + 
							"(	1328	,	 'MERİH'	,	 'COŞAR'	,	32	,	 'EskişehirModa'	)	,\n" + 
							"(	1329	,	 'PINAR'	,	 'ÖZCAN'	,	33	,	 'GaziantepModa'	)	,\n" + 
							"(	1330	,	 'ÖMER FARUK'	,	 'BİRİ'	,	34	,	 'GiresunModa'	)	,\n" + 
							"(	1331	,	 'SERDAR'	,	 'MERCAN'	,	35	,	 'GümüşhaneModa'	)	,\n" + 
							"(	1332	,	 'ERGÜN'	,	 'ÖZDEMİR'	,	36	,	 'HakkariModa'	)	,\n" + 
							"(	1333	,	 'DERYA'	,	 'CANDANER'	,	37	,	 'HatayModa'	)	,\n" + 
							"(	1334	,	 'ERHAN'	,	 'İPEK'	,	38	,	 'IğdırModa'	)	,\n" + 
							"(	1335	,	 'HANDE'	,	 'EROĞLU'	,	39	,	 'IspartaModa'	)	,\n" + 
							"(	1336	,	 'ALİ'	,	 'SAYIN'	,	40	,	 'İstanbulModa'	)	,\n" + 
							"(	1337	,	 'TUBA'	,	 'ÇEVİRGEN'	,	41	,	 'İzmirModa'	)	,\n" + 
							"(	1338	,	 'BURHANETTİN'	,	 'ÖZDEMİR'	,	42	,	 'KahramanmaraşModa'	)	,\n" + 
							"(	1339	,	 'CAN'	,	 'ZEYBEK'	,	43	,	 'KarabükModa'	)	,\n" + 
							"(	1340	,	 'GÜLŞAH'	,	 'DADALI'	,	44	,	 'KaramanModa'	)	,\n" + 
							"(	1341	,	 'DERYA'	,	 'CELTEMEN'	,	45	,	 'KarsModa'	)	,\n" + 
							"(	1342	,	 'SİBEL'	,	 'EMİRLİOĞLU'	,	46	,	 'KastamonuModa'	)	,\n" + 
							"(	1343	,	 'VEYSEL'	,	 'BABAYİĞİT'	,	47	,	 'KayseriModa'	)	,\n" + 
							"(	1344	,	 'KÜBRA'	,	 'SU KURT'	,	48	,	 'KırıkkaleModa'	)	,\n" + 
							"(	1345	,	 'AYTAÇ'	,	 'GERDAN'	,	49	,	 'KırklareliModa'	)	,\n" + 
							"(	1346	,	 'AHMET'	,	 'SAYİNER'	,	50	,	 'KırşehirModa'	)	,\n" + 
							"(	1347	,	 'NİMET'	,	 'DEMİR'	,	51	,	 'KilisModa'	)	,\n" + 
							"(	1348	,	 'BİLGE MERVE'	,	 'OMAY'	,	52	,	 'KocaeliModa'	)	,\n" + 
							"(	1349	,	 'HATİCE EYLÜL'	,	 'AKOVA'	,	53	,	 'KonyaModa'	)	,\n" + 
							"(	1350	,	 'RAMAZAN'	,	 'KÜTÜK'	,	54	,	 'KütahyaModa'	)	,\n" + 
							"(	1351	,	 'UMUT SİNAN'	,	 'MUMCUOĞLU'	,	55	,	 'MalatyaModa'	)	,\n" + 
							"(	1352	,	 'METE'	,	 'SUCAK'	,	56	,	 'ManisaModa'	)	,\n" + 
							"(	1353	,	 'MUSTAFA'	,	 'YAVUZ'	,	57	,	 'MardinModa'	)	,\n" + 
							"(	1354	,	 'FERAT'	,	 'AYDEMİR'	,	58	,	 'MersinModa'	)	,\n" + 
							"(	1355	,	 'VELİ ENES'	,	 'EREN'	,	59	,	 'MuğlaModa'	)	,\n" + 
							"(	1356	,	 'ŞADİ'	,	 'SAVAŞ'	,	60	,	 'MuşModa'	)	,\n" + 
							"(	1357	,	 'MEHTAP'	,	 'EMET'	,	61	,	 'NevşehirModa'	)	,\n" + 
							"(	1358	,	 'MELTEM'	,	 'KURT'	,	62	,	 'NiğdeModa'	)	,\n" + 
							"(	1359	,	 'TUĞBA'	,	 'ALTUN'	,	63	,	 'OrduModa'	)	,\n" + 
							"(	1360	,	 'CEM'	,	 'GEDİKLİ'	,	64	,	 'OsmaniyeModa'	)	,\n" + 
							"(	1361	,	 'LEYLA'	,	 'ŞEN GÖKÇEİMAM'	,	65	,	 'RizeModa'	)	,\n" + 
							"(	1362	,	 'ABDULKADİR'	,	 'ÖZTÜRK'	,	66	,	 'SakaryaModa'	)	,\n" + 
							"(	1363	,	 'MUMUN'	,	 'GÜNGÖR'	,	67	,	 'SamsunModa'	)	,\n" + 
							"(	1364	,	 'FERAT'	,	 'BEREKATOĞLU'	,	68	,	 'SiirtModa'	)	,\n" + 
							"(	1365	,	 'AYSEL'	,	 'DÖNMEZ'	,	69	,	 'SinopModa'	)	,\n" + 
							"(	1366	,	 'ERAY'	,	 'ADIGÜZEL'	,	70	,	 'SivasModa'	)	,\n" + 
							"(	1367	,	 'EYLEM'	,	 'AKTEMUR'	,	71	,	 'ŞanlıurfaModa'	)	,\n" + 
							"(	1368	,	 'HAŞİM ONUR'	,	 'AYDIN'	,	72	,	 'ŞırnakModa'	)	,\n" + 
							"(	1369	,	 'OSMAN'	,	 'SAYIN'	,	73	,	 'TekirdağModa'	)	,\n" + 
							"(	1370	,	 'ÖMER FARUK'	,	 'AKBULUT'	,	74	,	 'TokatModa'	)	,\n" + 
							"(	1371	,	 'TİMUR'	,	 'KANDEMİR'	,	75	,	 'TrabzonModa'	)	,\n" + 
							"(	1372	,	 'AYSU'	,	 'EROĞLU'	,	76	,	 'TunceliModa'	)	,\n" + 
							"(	1373	,	 'HASAN'	,	 'DİRİCAN'	,	77	,	 'UşakModa'	)	,\n" + 
							"(	1374	,	 'SÜLEYMAN'	,	 'AYDOĞAN'	,	78	,	 'VanModa'	)	,\n" + 
							"(	1375	,	 'EMRE'	,	 'EVREN'	,	79	,	 'YalovaModa'	)	,\n" + 
							"(	1376	,	 'ZAFER'	,	 'KANYILMAZ'	,	80	,	 'YozgatModa'	)	,\n" + 
							"(	1377	,	 'MARUF'	,	 'IŞIKLI'	,	81	,	 'ZonguldakModa'	)	,\n" + 
							"(	1378	,	 'ÖZGÜR'	,	 'BALCI'	,	1	,	 'AdanaModa'	)	,\n" + 
							"(	1379	,	 'OSMAN'	,	 'ERDAL'	,	2	,	 'AdıyamanModa'	)	,\n" + 
							"(	1380	,	 'DUYGU'	,	 'GÖKKOCA'	,	3	,	 'AfyonkarahisarModa'	)	,\n" + 
							"(	1381	,	 'ZÜHRE'	,	 'SANDAL'	,	4	,	 'AğrıModa'	)	,\n" + 
							"(	1382	,	 'SÜMEYYE'	,	 'AKTAŞ'	,	5	,	 'AksarayModa'	)	,\n" + 
							"(	1383	,	 'MUSTAFA'	,	 'TURĞUT'	,	6	,	 'AmasyaModa'	)	,\n" + 
							"(	1384	,	 'ÖZGE'	,	 'BAŞAR'	,	7	,	 'AnkaraModa'	)	,\n" + 
							"(	1385	,	 'ÇAĞRI SERDAR'	,	 'KAYKI'	,	8	,	 'AntalyaModa'	)	,\n" + 
							"(	1386	,	 'AHMET'	,	 'ALTAŞ'	,	9	,	 'ArdahanModa'	)	,\n" + 
							"(	1387	,	 'ALİ'	,	 'ŞİMŞEK'	,	10	,	 'ArtvinModa'	)	,\n" + 
							"(	1388	,	 'MEHTAP'	,	 'TOLA'	,	11	,	 'AydınModa'	)	,\n" + 
							"(	1389	,	 'MEHRİ'	,	 'VEZİROĞLU BİRDANE'	,	12	,	 'BalıkesirModa'	)	,\n" + 
							"(	1390	,	 'SERPİL'	,	 'KARLI'	,	13	,	 'BartınModa'	)	,\n" + 
							"(	1391	,	 'AYŞE CEREN'	,	 'ORHAN'	,	14	,	 'BatmanModa'	)	,\n" + 
							"(	1392	,	 'YUSUF'	,	 'AVŞAR'	,	15	,	 'BayburtModa'	)	,\n" + 
							"(	1393	,	 'DAMLA'	,	 'SÖNMEZ'	,	16	,	 'BilecikModa'	)	,\n" + 
							"(	1394	,	 'ORHAN'	,	 'YARADILMIŞ'	,	17	,	 'BingölModa'	)	,\n" + 
							"(	1395	,	 'MERYEM'	,	 'ESEN'	,	18	,	 'BitlisModa'	)	,\n" + 
							"(	1396	,	 'ÖZLEM'	,	 'KARAKUŞ'	,	19	,	 'BoluModa'	)	,\n" + 
							"(	1397	,	 'SİNEM'	,	 'YORGANCI'	,	20	,	 'DenizliModa'	)	,\n" + 
							"(	1398	,	 'HAMZA'	,	 'BOZOĞLAN'	,	21	,	 'BursaModa'	)	,\n" + 
							"(	1399	,	 'DENİZ'	,	 'BALAL'	,	22	,	 'ÇanakkaleModa'	)	,\n" + 
							"(	1400	,	 'ADNAN'	,	 'SEZGİN'	,	23	,	 'ÇankırıModa'	)	,\n" + 
							"(	1401	,	 'ŞAFAK'	,	 'ŞİMŞEK'	,	24	,	 'ÇorumModa'	)	,\n" + 
							"(	1402	,	 'ÖZEN'	,	 'PAKSOY'	,	25	,	 'BurdurModa'	)	,\n" + 
							"(	1403	,	 'SEZER'	,	 'SARIKAYA'	,	26	,	 'DiyarbakırModa'	)	,\n" + 
							"(	1404	,	 'YELDA'	,	 'KÖKSAL'	,	27	,	 'DüzceModa'	)	,\n" + 
							"(	1405	,	 'ÖMER'	,	 'MERCAN'	,	28	,	 'EdirneModa'	)	,\n" + 
							"(	1406	,	 'SİBEL'	,	 'KARTAL'	,	29	,	 'ElazığModa'	)	,\n" + 
							"(	1407	,	 'CÜNEYT'	,	 'EKİZ'	,	30	,	 'ErzincanModa'	)	,\n" + 
							"(	1408	,	 'YILMAZ'	,	 'ŞİMŞEK'	,	31	,	 'ErzurumModa'	)	,\n" + 
							"(	1409	,	 'SEYFİ'	,	 'KIVRAK'	,	32	,	 'EskişehirModa'	)	,\n" + 
							"(	1410	,	 'DERYA'	,	 'NİZAM'	,	33	,	 'GaziantepModa'	)	,\n" + 
							"(	1411	,	 'ALİ SAİP'	,	 'GENEZ'	,	34	,	 'GiresunModa'	)	,\n" + 
							"(	1412	,	 'FATİH'	,	 'VEZİROĞLU BİRDANE'	,	35	,	 'GümüşhaneModa'	)	,\n" + 
							"(	1413	,	 'TOLGAHAN'	,	 'NAR'	,	36	,	 'HakkariModa'	)	,\n" + 
							"(	1414	,	 'ALİ HASAN'	,	 'COŞKUN'	,	37	,	 'HatayModa'	)	,\n" + 
							"(	1415	,	 'GÖZDE'	,	 'GÖRMELİ'	,	38	,	 'IğdırModa'	)	,\n" + 
							"(	1416	,	 'AHMET ÇAĞRI'	,	 'OYNAK'	,	39	,	 'IspartaModa'	)	,\n" + 
							"(	1417	,	 'KÜBRA'	,	 'GÖKALP'	,	40	,	 'İstanbulModa'	)	,\n" + 
							"(	1418	,	 'ABDULKADİR'	,	 'CAMGÖZ'	,	41	,	 'İzmirModa'	)	,\n" + 
							"(	1419	,	 'ÖMER'	,	 'BALAL'	,	42	,	 'KahramanmaraşModa'	)	,\n" + 
							"(	1420	,	 'GÖKHAN'	,	 'ŞAHİN'	,	43	,	 'KarabükModa'	)	,\n" + 
							"(	1421	,	 'FERHAN'	,	 'YILMAZ GELEBEK'	,	44	,	 'KaramanModa'	)	,\n" + 
							"(	1422	,	 'MUSTAFA'	,	 'MELEKOĞLU'	,	45	,	 'KarsModa'	)	,\n" + 
							"(	1423	,	 'MUSTAFA'	,	 'ARMAĞAN'	,	46	,	 'KastamonuModa'	)	,\n" + 
							"(	1424	,	 'SEVGÜL'	,	 'TURAN'	,	47	,	 'KayseriModa'	)	,\n" + 
							"(	1425	,	 'NİLGÜN'	,	 'ERDOĞAN'	,	48	,	 'KırıkkaleModa'	)	,\n" + 
							"(	1426	,	 'MEHTAP'	,	 'MERHAMETSİZ'	,	49	,	 'KırklareliModa'	)	,\n" + 
							"(	1427	,	 'SEDA'	,	 'BİCAN'	,	50	,	 'KırşehirModa'	)	,\n" + 
							"(	1428	,	 'ÖMER'	,	 'BULUT'	,	51	,	 'KilisModa'	)	,\n" + 
							"(	1429	,	 'ONUR SALİH'	,	 'KURT'	,	52	,	 'KocaeliModa'	)	,\n" + 
							"(	1430	,	 'HASAN'	,	 'ALĞAN'	,	53	,	 'KonyaModa'	)	,\n" + 
							"(	1431	,	 'RUKİYE ÖZDEN'	,	 'BÜYÜKDOĞAN'	,	54	,	 'KütahyaModa'	)	,\n" + 
							"(	1432	,	 'AYSU'	,	 'PAKÖZ'	,	55	,	 'MalatyaModa'	)	,\n" + 
							"(	1433	,	 'NEŞE'	,	 'AKKAYA'	,	56	,	 'ManisaModa'	)	,\n" + 
							"(	1434	,	 'AHMET FURKAN'	,	 'KOYUNCU'	,	57	,	 'MardinModa'	)	,\n" + 
							"(	1435	,	 'ÖZGÜR'	,	 'ÇETİN'	,	58	,	 'MersinModa'	)	,\n" + 
							"(	1436	,	 'SEVGİ'	,	 'SERTOĞLU'	,	59	,	 'MuğlaModa'	)	,\n" + 
							"(	1437	,	 'MÜCAHİT'	,	 'KÜÇÜKYILDIZ'	,	60	,	 'MuşModa'	)	,\n" + 
							"(	1438	,	 'FADIL'	,	 'CAN'	,	61	,	 'NevşehirModa'	)	,\n" + 
							"(	1439	,	 'EREN'	,	 'KORKMAZ'	,	62	,	 'NiğdeModa'	)	,\n" + 
							"(	1440	,	 'MEHMET'	,	 'BAŞTÜRK AYHAN'	,	63	,	 'OrduModa'	)	,\n" + 
							"(	1441	,	 'BARIŞ'	,	 'ÖRDEK'	,	64	,	 'OsmaniyeModa'	)	,\n" + 
							"(	1442	,	 'MURAT'	,	 'ERSOY'	,	65	,	 'RizeModa'	)	,\n" + 
							"(	1443	,	 'LEYLA'	,	 'YILMABAŞAR'	,	66	,	 'SakaryaModa'	)	,\n" + 
							"(	1444	,	 'ORHAN'	,	 'AKÇALI'	,	67	,	 'SamsunModa'	)	,\n" + 
							"(	1445	,	 'HALİL'	,	 'ŞAHİN'	,	68	,	 'SiirtModa'	)	,\n" + 
							"(	1446	,	 'AYŞEGÜL'	,	 'BÖYÜK'	,	69	,	 'SinopModa'	)	,\n" + 
							"(	1447	,	 'ERHAN'	,	 'AYIK'	,	70	,	 'SivasModa'	)	,\n" + 
							"(	1448	,	 'SUNA'	,	 'KAYA'	,	71	,	 'ŞanlıurfaModa'	)	,\n" + 
							"(	1449	,	 'SELİM OZAN'	,	 'BAKIRCI'	,	72	,	 'ŞırnakModa'	)	,\n" + 
							"(	1450	,	 'PINAR'	,	 'ABAT'	,	73	,	 'TekirdağModa'	)	,\n" + 
							"(	1451	,	 'HİLAL'	,	 'BAŞAK'	,	74	,	 'TokatModa'	)	,\n" + 
							"(	1452	,	 'ZEHRA'	,	 'ÇAKIR'	,	75	,	 'TrabzonModa'	)	,\n" + 
							"(	1453	,	 'HALİL İBRAHİM'	,	 'DOĞAN'	,	76	,	 'TunceliModa'	)	,\n" + 
							"(	1454	,	 'ZEYNEP'	,	 'SAÇLI'	,	77	,	 'UşakModa'	)	,\n" + 
							"(	1455	,	 'NİLGÜN'	,	 'ATASOY'	,	78	,	 'VanModa'	)	,\n" + 
							"(	1456	,	 'HACER'	,	 'EFE'	,	79	,	 'YalovaModa'	)	,\n" + 
							"(	1457	,	 'MAHMUT'	,	 'KIRAÇ'	,	80	,	 'YozgatModa'	)	,\n" + 
							"(	1458	,	 'NECİP'	,	 'BARAN'	,	81	,	 'ZonguldakModa'	)	,\n" + 
							"(	1459	,	 'MAKBULE SEDA'	,	 'TAŞ'	,	1	,	 'AdanaModa'	)	,\n" + 
							"(	1460	,	 'ONUR KADİR'	,	 'ÖZ'	,	2	,	 'AdıyamanModa'	)	,\n" + 
							"(	1461	,	 'AYŞEGÜL'	,	 'YILDIZOĞLU'	,	3	,	 'AfyonkarahisarModa'	)	,\n" + 
							"(	1462	,	 'DUYGU'	,	 'TEMURTAŞ'	,	4	,	 'AğrıModa'	)	,\n" + 
							"(	1463	,	 'KAMERCAN'	,	 'KORUCU'	,	5	,	 'AksarayModa'	)	,\n" + 
							"(	1464	,	 'ZEHRA'	,	 'KILAVUZ'	,	6	,	 'AmasyaModa'	)	,\n" + 
							"(	1465	,	 'BÜNYAMİN'	,	 'TIRAŞ'	,	7	,	 'AnkaraModa'	)	,\n" + 
							"(	1466	,	 'FADİME SEVGİ'	,	 'KANKILIÇ'	,	8	,	 'AntalyaModa'	)	,\n" + 
							"(	1467	,	 'FATMA'	,	 'DİKOĞLU'	,	9	,	 'ArdahanModa'	)	,\n" + 
							"(	1468	,	 'MUSTAFA'	,	 'TAN'	,	10	,	 'ArtvinModa'	)	,\n" + 
							"(	1469	,	 'CEM'	,	 'ÇETİNKAYA'	,	11	,	 'AydınModa'	)	,\n" + 
							"(	1470	,	 'BURAK'	,	 'ALTUNÖZ'	,	12	,	 'BalıkesirModa'	)	,\n" + 
							"(	1471	,	 'RECEP GANİ'	,	 'ATLANOĞLU'	,	13	,	 'BartınModa'	)	,\n" + 
							"(	1472	,	 'FUAT'	,	 'ŞİRİN'	,	14	,	 'BatmanModa'	)	,\n" + 
							"(	1473	,	 'FUAT'	,	 'GÜVEN'	,	15	,	 'BayburtModa'	)	,\n" + 
							"(	1474	,	 'YAVUZ SELİM'	,	 'BARAN'	,	16	,	 'BilecikModa'	)	,\n" + 
							"(	1475	,	 'RAMAZAN'	,	 'AKKAŞ'	,	17	,	 'BingölModa'	)	,\n" + 
							"(	1476	,	 'ELİF'	,	 'KAHRAMAN'	,	18	,	 'BitlisModa'	)	,\n" + 
							"(	1477	,	 'SÜLEYMAN'	,	 'EMİRLİOĞLU'	,	19	,	 'BoluModa'	)	,\n" + 
							"(	1478	,	 'DERAM'	,	 'ÖZSAYIM'	,	20	,	 'DenizliModa'	)	,\n" + 
							"(	1479	,	 'DENİZ'	,	 'SERBEST'	,	21	,	 'BursaModa'	)	,\n" + 
							"(	1480	,	 'MERVE'	,	 'ŞAŞMAZ'	,	22	,	 'ÇanakkaleModa'	)	,\n" + 
							"(	1481	,	 'MURAT'	,	 'KIZMAZ'	,	23	,	 'ÇankırıModa'	)	,\n" + 
							"(	1482	,	 'BAHRİ'	,	 'ÇAKIR'	,	24	,	 'ÇorumModa'	)	,\n" + 
							"(	1483	,	 'SEYFİ'	,	 'GÜNDÜZ'	,	25	,	 'BurdurModa'	)	,\n" + 
							"(	1484	,	 'SONGÜL'	,	 'DURMUŞ'	,	26	,	 'DiyarbakırModa'	)	,\n" + 
							"(	1485	,	 'NURULLAH'	,	 'DEMİR'	,	27	,	 'DüzceModa'	)	,\n" + 
							"(	1486	,	 'BURAK'	,	 'ÇELİK'	,	28	,	 'EdirneModa'	)	,\n" + 
							"(	1487	,	 'ZERRİN'	,	 'YILDIZ'	,	29	,	 'ElazığModa'	)	,\n" + 
							"(	1488	,	 'EMİNE'	,	 'ŞENTÜRK'	,	30	,	 'ErzincanModa'	)	,\n" + 
							"(	1489	,	 'MEHMET'	,	 'GERGER'	,	31	,	 'ErzurumModa'	)	,\n" + 
							"(	1490	,	 'ASLIHAN'	,	 'ŞAŞMAZ'	,	32	,	 'EskişehirModa'	)	,\n" + 
							"(	1491	,	 'SEDA'	,	 'KILIÇ'	,	33	,	 'GaziantepModa'	)	,\n" + 
							"(	1492	,	 'NİHAT BERKAY'	,	 'ÜZEN'	,	34	,	 'GiresunModa'	)	,\n" + 
							"(	1493	,	 'İLKER'	,	 'AYAS'	,	35	,	 'GümüşhaneModa'	)	,\n" + 
							"(	1494	,	 'ÖMER'	,	 'BAYRAK'	,	36	,	 'HakkariModa'	)	,\n" + 
							"(	1495	,	 'MURAT'	,	 'SÖNMEZ'	,	37	,	 'HatayModa'	)	,\n" + 
							"(	1496	,	 'SÜLEYMAN'	,	 'YAVUZ SEZGİN'	,	38	,	 'IğdırModa'	)	,\n" + 
							"(	1497	,	 'BEDRİ'	,	 'BAYRAM'	,	39	,	 'IspartaModa'	)	,\n" + 
							"(	1498	,	 'ŞERMİN'	,	 'SÜMER'	,	40	,	 'İstanbulModa'	)	,\n" + 
							"(	1499	,	 'SERTAÇ'	,	 'KARACA'	,	41	,	 'İzmirModa'	)	,\n" + 
							"(	1500	,	 'SERKAN'	,	 'EVREN'	,	42	,	 'KahramanmaraşModa'	)	,\n" + 
							"(	1501	,	 'FERDİ'	,	 'BAŞARAN'	,	43	,	 'KarabükModa'	)	,\n" + 
							"(	1502	,	 'ESEN'	,	 'AKTEMUR'	,	44	,	 'KaramanModa'	)	,\n" + 
							"(	1503	,	 'AHMET KÜRŞAD'	,	 'AKANSEL'	,	45	,	 'KarsModa'	)	,\n" + 
							"(	1504	,	 'ŞADİ'	,	 'DOĞAN'	,	46	,	 'KastamonuModa'	)	,\n" + 
							"(	1505	,	 'UĞUR'	,	 'ÇİFTCİ'	,	47	,	 'KayseriModa'	)	,\n" + 
							"(	1506	,	 'SUNA'	,	 'YALÇIN'	,	48	,	 'KırıkkaleModa'	)	,\n" + 
							"(	1507	,	 'DEMET'	,	 'KAYA'	,	49	,	 'KırklareliModa'	)	,\n" + 
							"(	1508	,	 'ABDULLATİF'	,	 'ATAY'	,	50	,	 'KırşehirModa'	)	,\n" + 
							"(	1509	,	 'ASLIHAN'	,	 'ÖZER ÇELİK'	,	51	,	 'KilisModa'	)	,\n" + 
							"(	1510	,	 'ŞAHABETTİN'	,	 'GÜNGÖR'	,	52	,	 'KocaeliModa'	)	,\n" + 
							"(	1511	,	 'CENK'	,	 'SU KURT'	,	53	,	 'KonyaModa'	)	,\n" + 
							"(	1512	,	 'MEHMET BURHAN'	,	 'KOCABIYIK'	,	54	,	 'KütahyaModa'	)	,\n" + 
							"(	1513	,	 'BEYZA'	,	 'KOR'	,	55	,	 'MalatyaModa'	)	,\n" + 
							"(	1514	,	 'MEHMET YILDIRIM'	,	 'BAYANA'	,	56	,	 'ManisaModa'	)	,\n" + 
							"(	1515	,	 'ERKAN SABRİ'	,	 'DEĞİRMENCİ AKAR'	,	57	,	 'MardinModa'	)	,\n" + 
							"(	1516	,	 'GÖZDEM'	,	 'AL'	,	58	,	 'MersinModa'	)	,\n" + 
							"(	1517	,	 'İSMAİL'	,	 'GÖKSEL'	,	59	,	 'MuğlaModa'	)	,\n" + 
							"(	1518	,	 'ARZU'	,	 'TOPALOĞLU'	,	60	,	 'MuşModa'	)	,\n" + 
							"(	1519	,	 'FAİK'	,	 'SAVRAN'	,	61	,	 'NevşehirModa'	)	,\n" + 
							"(	1520	,	 'FATMA BEGÜM'	,	 'KURT'	,	62	,	 'NiğdeModa'	)	,\n" + 
							"(	1521	,	 'YÜCE'	,	 'TEPE'	,	63	,	 'OrduModa'	)	,\n" + 
							"(	1522	,	 'ADEM'	,	 'GENÇ'	,	64	,	 'OsmaniyeModa'	)	,\n" + 
							"(	1523	,	 'MURAT'	,	 'SARIKAYA'	,	65	,	 'RizeModa'	)	,\n" + 
							"(	1524	,	 'EMİNE'	,	 'ÇETİN'	,	66	,	 'SakaryaModa'	)	,\n" + 
							"(	1525	,	 'ZEKİ'	,	 'ARARAT'	,	67	,	 'SamsunModa'	)	,\n" + 
							"(	1526	,	 'PELİN'	,	 'KAYA'	,	68	,	 'SiirtModa'	)	,\n" + 
							"(	1527	,	 'BELGİN'	,	 'DOĞAN'	,	69	,	 'SinopModa'	)	,\n" + 
							"(	1528	,	 'ZAFER'	,	 'DURAN'	,	70	,	 'SivasModa'	)	,\n" + 
							"(	1529	,	 'BEYZA'	,	 'SALDIRAY'	,	71	,	 'ŞanlıurfaModa'	)	,\n" + 
							"(	1530	,	 'EMİNE'	,	 'SERTOĞLU'	,	72	,	 'ŞırnakModa'	)	,\n" + 
							"(	1531	,	 'EMİNE'	,	 'EROL'	,	73	,	 'TekirdağModa'	)	,\n" + 
							"(	1532	,	 'NESLİHAN'	,	 'CANDAN'	,	74	,	 'TokatModa'	)	,\n" + 
							"(	1533	,	 'TEYFİK'	,	 'YÜCEL'	,	75	,	 'TrabzonModa'	)	,\n" + 
							"(	1534	,	 'ESER'	,	 'ALTUNA'	,	76	,	 'TunceliModa'	)	,\n" + 
							"(	1535	,	 'NİHAT'	,	 'GÜRER'	,	77	,	 'UşakModa'	)	,\n" + 
							"(	1536	,	 'KERİM'	,	 'KARADEMİR'	,	78	,	 'VanModa'	)	,\n" + 
							"(	1537	,	 'KAMURAN'	,	 'KOÇ'	,	79	,	 'YalovaModa'	)	,\n" + 
							"(	1538	,	 'NESLİHAN'	,	 'BALOĞLU'	,	80	,	 'YozgatModa'	)	,\n" + 
							"(	1539	,	 'SELÇUK'	,	 'OYNAK'	,	81	,	 'ZonguldakModa'	)	,\n" + 
							"(	1540	,	 'EMRE'	,	 'TURĞUT'	,	1	,	 'AdanaModa'	)	,\n" + 
							"(	1541	,	 'ERKAN SABRİ'	,	 'YALÇIN'	,	2	,	 'AdıyamanModa'	)	,\n" + 
							"(	1542	,	 'NAGİHAN'	,	 'KEKLİKÇİOĞLU'	,	3	,	 'AfyonkarahisarModa'	)	,\n" + 
							"(	1543	,	 'GÖZDE'	,	 'KIYAK'	,	4	,	 'AğrıModa'	)	,\n" + 
							"(	1544	,	 'KAMİL'	,	 'TÜFENK'	,	5	,	 'AksarayModa'	)	,\n" + 
							"(	1545	,	 'MUSTAFA BUĞRA'	,	 'ERAT'	,	6	,	 'AmasyaModa'	)	,\n" + 
							"(	1546	,	 'NESLİHAN'	,	 'DAL'	,	7	,	 'AnkaraModa'	)	,\n" + 
							"(	1547	,	 'METİN'	,	 'YÜKSEL'	,	8	,	 'AntalyaModa'	)	,\n" + 
							"(	1548	,	 'MUHAMMET BAĞBUR'	,	 'ARAZ SERVER'	,	9	,	 'ArdahanModa'	)	,\n" + 
							"(	1549	,	 'MUSTAFA'	,	 'ÇOBANOĞLU'	,	10	,	 'ArtvinModa'	)	,\n" + 
							"(	1550	,	 'COŞKUN'	,	 'BAKLACI'	,	11	,	 'AydınModa'	)	,\n" + 
							"(	1551	,	 'NİHAT'	,	 'AKIN'	,	12	,	 'BalıkesirModa'	)	,\n" + 
							"(	1552	,	 'FATİH'	,	 'EYİSOY'	,	13	,	 'BartınModa'	)	,\n" + 
							"(	1553	,	 'BURAK'	,	 'BAKIRCI'	,	14	,	 'BatmanModa'	)	,\n" + 
							"(	1554	,	 'SERKAN'	,	 'SEVİNÇ'	,	15	,	 'BayburtModa'	)	,\n" + 
							"(	1555	,	 'EBRU'	,	 'DEMİR'	,	16	,	 'BilecikModa'	)	,\n" + 
							"(	1556	,	 'GÜLBERAT'	,	 'KIZANOĞLU'	,	17	,	 'BingölModa'	)	,\n" + 
							"(	1557	,	 'MEHMET'	,	 'GÜNEŞ'	,	18	,	 'BitlisModa'	)	,\n" + 
							"(	1558	,	 'TURGAY YILMAZ'	,	 'ATILGAN'	,	19	,	 'BoluModa'	)	,\n" + 
							"(	1559	,	 'ÖZKAN'	,	 'İMAMOĞLU'	,	20	,	 'DenizliModa'	)	,\n" + 
							"(	1560	,	 'ELİFCAN'	,	 'SU DUR'	,	21	,	 'BursaModa'	)	,\n" + 
							"(	1561	,	 'FATMA'	,	 'POLAT'	,	22	,	 'ÇanakkaleModa'	)	,\n" + 
							"(	1562	,	 'BAHADIR'	,	 'SERTKAYAOĞLU'	,	23	,	 'ÇankırıModa'	)	,\n" + 
							"(	1563	,	 'FUNDA'	,	 'ATİLLA'	,	24	,	 'ÇorumModa'	)	,\n" + 
							"(	1564	,	 'MUSTAFA ABDULLAH'	,	 'KAYA'	,	25	,	 'BurdurModa'	)	,\n" + 
							"(	1565	,	 'UTKU'	,	 'KALYONCU UÇAR'	,	26	,	 'DiyarbakırModa'	)	,\n" + 
							"(	1566	,	 'BAŞAK'	,	 'ATAY'	,	27	,	 'DüzceModa'	)	,\n" + 
							"(	1567	,	 'SİNEM'	,	 'TAŞMALI'	,	28	,	 'EdirneModa'	)	,\n" + 
							"(	1568	,	 'LEVENT'	,	 'KAYA'	,	29	,	 'ElazığModa'	)	,\n" + 
							"(	1569	,	 'AYSEL'	,	 'ÖZKAN'	,	30	,	 'ErzincanModa'	)	,\n" + 
							"(	1570	,	 'ÜMİT'	,	 'BİRİ'	,	31	,	 'ErzurumModa'	)	,\n" + 
							"(	1571	,	 'İBRAHİM'	,	 'HAKYOL'	,	32	,	 'EskişehirModa'	)	,\n" + 
							"(	1572	,	 'ZEYNEP'	,	 'ATMIŞ'	,	33	,	 'GaziantepModa'	)	,\n" + 
							"(	1573	,	 'MÜMÜN FATİH'	,	 'UZUN'	,	34	,	 'GiresunModa'	)	,\n" + 
							"(	1574	,	 'BENHUR ŞİRVAN'	,	 'KARSLI'	,	35	,	 'GümüşhaneModa'	)	,\n" + 
							"(	1575	,	 'SERDAR'	,	 'NADASTEPE'	,	36	,	 'HakkariModa'	)	,\n" + 
							"(	1576	,	 'DENİZ'	,	 'BAYRAK'	,	37	,	 'HatayModa'	)	,\n" + 
							"(	1577	,	 'RECEP'	,	 'BİLGİÇ'	,	38	,	 'IğdırModa'	)	,\n" + 
							"(	1578	,	 'AYŞE'	,	 'ÖZAVCI AYGÜN'	,	39	,	 'IspartaModa'	)	,\n" + 
							"(	1579	,	 'MUHAMMED'	,	 'BARAN'	,	40	,	 'İstanbulModa'	)	,\n" + 
							"(	1580	,	 'MEHMET'	,	 'IŞIKLI'	,	41	,	 'İzmirModa'	)	,\n" + 
							"(	1581	,	 'HASAN'	,	 'KOCUBEYOĞLU'	,	42	,	 'KahramanmaraşModa'	)	,\n" + 
							"(	1582	,	 'METİN'	,	 'KEKLİKÇİOĞLU'	,	43	,	 'KarabükModa'	)	,\n" + 
							"(	1583	,	 'OSMAN TURGUT'	,	 'ŞAHİN'	,	44	,	 'KaramanModa'	)	,\n" + 
							"(	1584	,	 'MUSTAFA KEMAL'	,	 'KILINÇ'	,	45	,	 'KarsModa'	)	,\n" + 
							"(	1585	,	 'CEM'	,	 'KELEŞ'	,	46	,	 'KastamonuModa'	)	,\n" + 
							"(	1586	,	 'REYHAN'	,	 'ATALAY'	,	47	,	 'KayseriModa'	)	,\n" + 
							"(	1587	,	 'BAYRAM'	,	 'İLERİ'	,	48	,	 'KırıkkaleModa'	)	,\n" + 
							"(	1588	,	 'LEYLA'	,	 'ARDA'	,	49	,	 'KırklareliModa'	)	,\n" + 
							"(	1589	,	 'HANIM'	,	 'ORAL'	,	50	,	 'KırşehirModa'	)	,\n" + 
							"(	1590	,	 'HACI'	,	 'MALÇOK'	,	51	,	 'KilisModa'	)	,\n" + 
							"(	1591	,	 'İBRAHİM'	,	 'YAŞAR'	,	52	,	 'KocaeliModa'	)	,\n" + 
							"(	1592	,	 'YURDAGÜL'	,	 'SALDIRAY'	,	53	,	 'KonyaModa'	)	,\n" + 
							"(	1593	,	 'ZEKERİYA'	,	 'KIRLI'	,	54	,	 'KütahyaModa'	)	,\n" + 
							"(	1594	,	 'GÜLSEN'	,	 'AKPINAR'	,	55	,	 'MalatyaModa'	)	,\n" + 
							"(	1595	,	 'ÖNDER TURGUT'	,	 'DANIŞOĞLU'	,	56	,	 'ManisaModa'	)	,\n" + 
							"(	1596	,	 'CUNDULLAH'	,	 'ÇİFT'	,	57	,	 'MardinModa'	)	,\n" + 
							"(	1597	,	 'ENGİN'	,	 'SEĞMEN'	,	58	,	 'MersinModa'	)	,\n" + 
							"(	1598	,	 'VEYSEL'	,	 'AKDENİZ'	,	59	,	 'MuğlaModa'	)	,\n" + 
							"(	1599	,	 'ÖZLEM'	,	 'DEDE'	,	60	,	 'MuşModa'	)	,\n" + 
							"(	1600	,	 'OSMAN'	,	 'KARPUZ'	,	61	,	 'NevşehirModa'	)	,\n" + 
							"(	1601	,	 'HÜSEYİN KUNTER'	,	 'AZRAK'	,	62	,	 'NiğdeModa'	)	,\n" + 
							"(	1602	,	 'KERİM'	,	 'BAŞARAN'	,	63	,	 'OrduModa'	)	,\n" + 
							"(	1603	,	 'BEYZA'	,	 'AKBUDAK'	,	64	,	 'OsmaniyeModa'	)	,\n" + 
							"(	1604	,	 'FUNDA'	,	 'GÖKSEL'	,	65	,	 'RizeModa'	)	,\n" + 
							"(	1605	,	 'İHSAN BURAK'	,	 'SERBEST'	,	66	,	 'SakaryaModa'	)	,\n" + 
							"(	1606	,	 'HASAN SERKAN'	,	 'ATEŞ BUDAK'	,	67	,	 'SamsunModa'	)	,\n" + 
							"(	1607	,	 'ALİ'	,	 'EKİZ'	,	68	,	 'SiirtModa'	)	,\n" + 
							"(	1608	,	 'ÇAĞLA'	,	 'KARAKUŞ'	,	69	,	 'SinopModa'	)	,\n" + 
							"(	1609	,	 'MEHMET DENİZ'	,	 'DOĞAN'	,	70	,	 'SivasModa'	)	,\n" + 
							"(	1610	,	 'DİANA'	,	 'GÖZÜGÜL'	,	71	,	 'ŞanlıurfaModa'	)	,\n" + 
							"(	1611	,	 'İLKNUR'	,	 'AKKAŞ'	,	72	,	 'ŞırnakModa'	)	,\n" + 
							"(	1612	,	 'BURAK'	,	 'ERZURUM'	,	73	,	 'TekirdağModa'	)	,\n" + 
							"(	1613	,	 'ARMAN'	,	 'ÇELİK'	,	74	,	 'TokatModa'	)	,\n" + 
							"(	1614	,	 'LEZİZ'	,	 'FENER'	,	75	,	 'TrabzonModa'	)	,\n" + 
							"(	1615	,	 'HAKAN'	,	 'EMET'	,	76	,	 'TunceliModa'	)	,\n" + 
							"(	1616	,	 'SEMA'	,	 'TOMBUL'	,	77	,	 'UşakModa'	)	,\n" + 
							"(	1617	,	 'HASAN'	,	 'ILGIN'	,	78	,	 'VanModa'	)	,\n" + 
							"(	1618	,	 'SELÇUK'	,	 'SÖYLER'	,	79	,	 'YalovaModa'	)	,\n" + 
							"(	1619	,	 'İLKNUR'	,	 'AKIN'	,	80	,	 'YozgatModa'	)	,\n" + 
							"(	1620	,	 'ALPER'	,	 'TIRAŞ'	,	81	,	 'ZonguldakModa'	)	;\n " ;
					
					boolean rs = stmt.execute(insertTables);	//district					
					boolean rs2 = stmt.execute(insertTables2); 	//country
					boolean rs3 = stmt.execute(insertTables3); //books-name
					boolean rs4 = stmt.execute(insertTables4); //branch1
					boolean rs5 = stmt.execute(insertTables5); //branch2
					boolean rs6 = stmt.execute(insertTables6); //branch3
					boolean rs7 = stmt.execute(insertTables7); //branch4
					boolean rs8 = stmt.execute(insertTables8); //branch5
					boolean rs9 = stmt.execute(insertTables9); //customer-info
					boolean rs19 = stmt.execute(insertTables10); //salesman-info

					// STEP 6: Clean-up environment
					stmt.close();
					conn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					// finally block used to close resources
					try {
						if (stmt != null)
							stmt.close();
					} catch (SQLException se2) {
					}// nothing we can do
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}// end finally try
				}// end try
				//scan.close();
		  }
		});
	}
	
}
