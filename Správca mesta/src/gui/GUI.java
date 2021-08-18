package gui;

import buildings.Storage;
import buildings.housing.House;
import buildings.housing.HousingManager;
import buildings.housing.HousingTypes;
import buildings.productionbuildings.Product;
import buildings.productionbuildings.ProductFromProductBuilding;
import buildings.productionbuildings.ProductionBuilding;
import buildings.productionbuildings.WorkManager;
import buildings.productionbuildings.WorkshopType;
import java.awt.Color;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import main.RandomEvents;

/**
 * Hlavná trieda, je tu celé grafické spracovanie hry a prepojenie celého kódu s
 * jednotlivými tlačidlami
 *
 * @author Danko
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Kliknutia na tlačidla
     */
    private PlayerClicks clicks;
    /**
     * Manažér workshopov
     */
    private WorkManager workManager;
    /**
     * Sklad na správu produktov
     */
    private Storage storage;
    /**
     * Správca obyvateľov a ich ubytovania
     */
    private HousingManager houseManager;
    /**
     * Spravovanie skóre
     */
    private Highscore highscore;
    /**
     * Generovanie eventov
     */
    private RandomEvents events;

    /**
     * Vytvorenie grafického prostredia, nastavenie zopár drobných nastavení,
     * spustenie opakovacích metód
     */
    public GUI() {
        this.initComponents();
        UIManager.put("ToolTip.background", Color.white);
        this.pickUpgradedLabel.setVisible(false);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Town manager - Made by Daniel Caban");
        this.clicks = new PlayerClicks();
        this.workManager = new WorkManager();
        this.storage = new Storage();
        this.houseManager = new HousingManager();
        this.highscore = new Highscore();
        this.events = new RandomEvents();
        ToolTipManager.sharedInstance().setInitialDelay(0);
        this.updateAllLabels();
        String score = this.highscore.getScoresToDisplay();
        this.highscores.setText(score);
        this.highscores.setEditable(false);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(this.autoMine(), 0, 3, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(this.eatAndStarve(), 0, 6, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(this.spawnVillagers(), 0, 10, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(this.randomEvent(), 20, 30, TimeUnit.SECONDS);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        mineWood = new javax.swing.JButton();
        mineMeat = new javax.swing.JButton();
        mineIron = new javax.swing.JButton();
        mineGold = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        meatResources = new javax.swing.JLabel();
        woodResources = new javax.swing.JLabel();
        ironResources = new javax.swing.JLabel();
        buySTREET_OF_HOUSES = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        residentsLabel = new javax.swing.JLabel();
        buyTENT = new javax.swing.JButton();
        buyHUT = new javax.swing.JButton();
        buyHOUSE = new javax.swing.JButton();
        buySpaceshipFactory = new javax.swing.JButton();
        buyBLOCK_OF_FLATS = new javax.swing.JButton();
        buyHIGH_RISE_BUILDING = new javax.swing.JButton();
        buySawmill = new javax.swing.JButton();
        buyBigSawmill = new javax.swing.JButton();
        buyIronmine = new javax.swing.JButton();
        buySteelworks = new javax.swing.JButton();
        buySteelFactory = new javax.swing.JButton();
        buyHuntersLodge = new javax.swing.JButton();
        buySlaughterhouse = new javax.swing.JButton();
        buySmokehouse = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        steelResources = new javax.swing.JLabel();
        upgradePickaxe = new javax.swing.JButton();
        buyLaboratory = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        smokedMeatResources = new javax.swing.JLabel();
        pickUpgradedLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        goldResources = new javax.swing.JLabel();
        newVillagersFeed = new javax.swing.JLabel();
        buySpaceship = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        researchPointResources = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        spaceshipPartsResources = new javax.swing.JLabel();
        buyGoldmine = new javax.swing.JButton();
        eventLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        goldWorkers = new javax.swing.JButton();
        woodAddBig = new javax.swing.JButton();
        woodRemoveBig = new javax.swing.JButton();
        woodAddSmall = new javax.swing.JButton();
        woodRemoveSmall = new javax.swing.JButton();
        workersAvailable = new javax.swing.JLabel();
        woodWorkers = new javax.swing.JButton();
        meatAddBig = new javax.swing.JButton();
        meatAddSmall = new javax.swing.JButton();
        meatRemoveSmall = new javax.swing.JButton();
        meatRemoveBig = new javax.swing.JButton();
        ironRemoveBig = new javax.swing.JButton();
        ironRemoveSmall = new javax.swing.JButton();
        ironAddSmall = new javax.swing.JButton();
        ironAddBig = new javax.swing.JButton();
        steelRemoveBig = new javax.swing.JButton();
        steelRemoveSmall = new javax.swing.JButton();
        steelAddSmall = new javax.swing.JButton();
        steelAddBig = new javax.swing.JButton();
        GoldRemoveBig = new javax.swing.JButton();
        goldRemoveSmall = new javax.swing.JButton();
        goldAddSmall = new javax.swing.JButton();
        goldAddBig = new javax.swing.JButton();
        smokedMeatWorkers = new javax.swing.JButton();
        ironWorkers = new javax.swing.JButton();
        meatWorkers = new javax.swing.JButton();
        smokedMeatAddBig = new javax.swing.JButton();
        smokedMeatAddSmall = new javax.swing.JButton();
        smokedMeatRemoveSmall = new javax.swing.JButton();
        smokedMeatRemoveBig = new javax.swing.JButton();
        steelWorkers = new javax.swing.JButton();
        researchPointWorkers = new javax.swing.JButton();
        RPaddBig = new javax.swing.JButton();
        RPAddSmall = new javax.swing.JButton();
        RPRemoveSmall = new javax.swing.JButton();
        RPRemoveBig = new javax.swing.JButton();
        spaceshipPartWorkers = new javax.swing.JButton();
        SPaddBig = new javax.swing.JButton();
        SPAddSmall = new javax.swing.JButton();
        SPRemoveSmall = new javax.swing.JButton();
        SPRemoveBig = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        totalSteel = new javax.swing.JLabel();
        totalWood = new javax.swing.JLabel();
        totalMeat = new javax.swing.JLabel();
        totalIron = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalSmokedMeat = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalMiningClicks = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        highscores = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        totalGold = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        totalRP = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        totalSP = new javax.swing.JLabel();
        presentationMode = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);

        jTabbedPane1.setBackground(new java.awt.Color(250, 250, 250));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setForeground(new java.awt.Color(66, 66, 66));
        jPanel1.setLayout(null);

        mineWood.setBackground(new java.awt.Color(250, 250, 250));
        mineWood.setForeground(new java.awt.Color(66, 66, 66));
        mineWood.setText("Wood");
        mineWood.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        mineWood.setContentAreaFilled(false);
        mineWood.setFocusPainted(false);
        mineWood.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mineWoodFocusGained(evt);
            }
        });
        mineWood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mineWoodActionPerformed(evt);
            }
        });
        jPanel1.add(mineWood);
        mineWood.setBounds(25, 10, 110, 110);

        mineMeat.setBackground(new java.awt.Color(250, 250, 250));
        mineMeat.setForeground(new java.awt.Color(66, 66, 66));
        mineMeat.setText("Hunt");
        mineMeat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        mineMeat.setContentAreaFilled(false);
        mineMeat.setFocusPainted(false);
        mineMeat.setFocusable(false);
        mineMeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mineMeatActionPerformed(evt);
            }
        });
        jPanel1.add(mineMeat);
        mineMeat.setBounds(25, 130, 110, 110);

        mineIron.setBackground(new java.awt.Color(250, 250, 250));
        mineIron.setForeground(new java.awt.Color(66, 66, 66));
        mineIron.setText("Iron");
        mineIron.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        mineIron.setContentAreaFilled(false);
        mineIron.setFocusPainted(false);
        mineIron.setFocusable(false);
        mineIron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mineIronActionPerformed(evt);
            }
        });
        jPanel1.add(mineIron);
        mineIron.setBounds(25, 250, 110, 110);

        mineGold.setBackground(new java.awt.Color(250, 250, 250));
        mineGold.setForeground(new java.awt.Color(66, 66, 66));
        mineGold.setText("Gold");
        mineGold.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        mineGold.setContentAreaFilled(false);
        mineGold.setFocusPainted(false);
        mineGold.setFocusable(false);
        mineGold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mineGoldActionPerformed(evt);
            }
        });
        jPanel1.add(mineGold);
        mineGold.setBounds(25, 370, 110, 110);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Resources");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(670, 10, 280, 30);

        jLabel2.setText("Wood:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(720, 60, 36, 16);

        jLabel4.setText("Iron:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(720, 220, 30, 16);

        jLabel5.setText("Meat:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(720, 110, 31, 16);

        meatResources.setText("cislo");
        jPanel1.add(meatResources);
        meatResources.setBounds(850, 110, 90, 16);

        woodResources.setText("cislo");
        jPanel1.add(woodResources);
        woodResources.setBounds(850, 60, 100, 16);

        ironResources.setText("cislo");
        jPanel1.add(ironResources);
        ironResources.setBounds(850, 220, 100, 16);

        buySTREET_OF_HOUSES.setBackground(new java.awt.Color(250, 250, 250));
        buySTREET_OF_HOUSES.setForeground(new java.awt.Color(66, 66, 66));
        buySTREET_OF_HOUSES.setText("Street of houses: ");
        buySTREET_OF_HOUSES.setToolTipText("Gold:1000 Wood: 2500 Steel: 500 Adds 250 beds\n");
        buySTREET_OF_HOUSES.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buySTREET_OF_HOUSES.setContentAreaFilled(false);
        buySTREET_OF_HOUSES.setFocusPainted(false);
        buySTREET_OF_HOUSES.setFocusable(false);
        buySTREET_OF_HOUSES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySTREET_OF_HOUSESActionPerformed(evt);
            }
        });
        jPanel1.add(buySTREET_OF_HOUSES);
        buySTREET_OF_HOUSES.setBounds(170, 360, 170, 50);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Residents:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(170, 20, 80, 19);

        residentsLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        residentsLabel.setText("cislo/miesto");
        jPanel1.add(residentsLabel);
        residentsLabel.setBounds(260, 20, 120, 19);

        buyTENT.setBackground(new java.awt.Color(250, 250, 250));
        buyTENT.setForeground(new java.awt.Color(66, 66, 66));
        buyTENT.setText("Tent : 0");
        buyTENT.setToolTipText("Wood: 10 Adds 2 beds");
        buyTENT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buyTENT.setContentAreaFilled(false);
        buyTENT.setFocusPainted(false);
        buyTENT.setFocusable(false);
        buyTENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyTENTActionPerformed(evt);
            }
        });
        jPanel1.add(buyTENT);
        buyTENT.setBounds(170, 60, 170, 50);

        buyHUT.setBackground(new java.awt.Color(250, 250, 250));
        buyHUT.setForeground(new java.awt.Color(66, 66, 66));
        buyHUT.setText("Hut: 0");
        buyHUT.setToolTipText("Gold: 10 \nWood: 30 \nAdds 4 beds");
        buyHUT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buyHUT.setContentAreaFilled(false);
        buyHUT.setFocusPainted(false);
        buyHUT.setFocusable(false);
        buyHUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyHUTActionPerformed(evt);
            }
        });
        jPanel1.add(buyHUT);
        buyHUT.setBounds(170, 120, 170, 50);

        buyHOUSE.setBackground(new java.awt.Color(250, 250, 250));
        buyHOUSE.setForeground(new java.awt.Color(66, 66, 66));
        buyHOUSE.setText("House: 0");
        buyHOUSE.setToolTipText("Gold: 30 Wood: 50 Steel: 20 Adds 8 beds\n");
        buyHOUSE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buyHOUSE.setContentAreaFilled(false);
        buyHOUSE.setFocusPainted(false);
        buyHOUSE.setFocusable(false);
        buyHOUSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyHOUSEActionPerformed(evt);
            }
        });
        jPanel1.add(buyHOUSE);
        buyHOUSE.setBounds(170, 180, 170, 50);

        buySpaceshipFactory.setBackground(new java.awt.Color(250, 250, 250));
        buySpaceshipFactory.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        buySpaceshipFactory.setForeground(new java.awt.Color(66, 66, 66));
        buySpaceshipFactory.setText("Spaceship factory:");
        buySpaceshipFactory.setToolTipText("Gold: 2000, Wood: 0, Steel: 3500, Research points: 5000, Work positions: 15, produces 1 spaceship part from 2 steel");
        buySpaceshipFactory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buySpaceshipFactory.setContentAreaFilled(false);
        buySpaceshipFactory.setFocusPainted(false);
        buySpaceshipFactory.setFocusable(false);
        buySpaceshipFactory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySpaceshipFactoryActionPerformed(evt);
            }
        });
        jPanel1.add(buySpaceshipFactory);
        buySpaceshipFactory.setBounds(550, 300, 140, 50);

        buyBLOCK_OF_FLATS.setBackground(new java.awt.Color(250, 250, 250));
        buyBLOCK_OF_FLATS.setForeground(new java.awt.Color(66, 66, 66));
        buyBLOCK_OF_FLATS.setText("Block of flats: 0");
        buyBLOCK_OF_FLATS.setToolTipText("Gold: 100  Wood: 250 Steel: 100  Adds 32 beds\n");
        buyBLOCK_OF_FLATS.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buyBLOCK_OF_FLATS.setContentAreaFilled(false);
        buyBLOCK_OF_FLATS.setFocusPainted(false);
        buyBLOCK_OF_FLATS.setFocusable(false);
        buyBLOCK_OF_FLATS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyBLOCK_OF_FLATSActionPerformed(evt);
            }
        });
        jPanel1.add(buyBLOCK_OF_FLATS);
        buyBLOCK_OF_FLATS.setBounds(170, 240, 170, 50);

        buyHIGH_RISE_BUILDING.setBackground(new java.awt.Color(250, 250, 250));
        buyHIGH_RISE_BUILDING.setForeground(new java.awt.Color(66, 66, 66));
        buyHIGH_RISE_BUILDING.setText("High rise building: 1111");
        buyHIGH_RISE_BUILDING.setToolTipText("Gold:250 Wood: 750 Steel: 450 Adds 128 beds\n");
        buyHIGH_RISE_BUILDING.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buyHIGH_RISE_BUILDING.setContentAreaFilled(false);
        buyHIGH_RISE_BUILDING.setFocusPainted(false);
        buyHIGH_RISE_BUILDING.setFocusable(false);
        buyHIGH_RISE_BUILDING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyHIGH_RISE_BUILDINGActionPerformed(evt);
            }
        });
        jPanel1.add(buyHIGH_RISE_BUILDING);
        buyHIGH_RISE_BUILDING.setBounds(170, 300, 170, 50);

        buySawmill.setBackground(new java.awt.Color(250, 250, 250));
        buySawmill.setForeground(new java.awt.Color(66, 66, 66));
        buySawmill.setText("Sawmill: 0");
        buySawmill.setToolTipText("Gold:0, Wood: 20, Steel: 0, Work positions: 4, produces wood\n");
        buySawmill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buySawmill.setContentAreaFilled(false);
        buySawmill.setFocusPainted(false);
        buySawmill.setFocusable(false);
        buySawmill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySawmillActionPerformed(evt);
            }
        });
        jPanel1.add(buySawmill);
        buySawmill.setBounds(400, 60, 140, 50);

        buyBigSawmill.setBackground(new java.awt.Color(250, 250, 250));
        buyBigSawmill.setForeground(new java.awt.Color(66, 66, 66));
        buyBigSawmill.setText("Big sawmill: 0");
        buyBigSawmill.setToolTipText("Gold: 50, Wood:80, Steel: 0, Work positions: 12, produces wood\n");
        buyBigSawmill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buyBigSawmill.setContentAreaFilled(false);
        buyBigSawmill.setFocusPainted(false);
        buyBigSawmill.setFocusable(false);
        buyBigSawmill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyBigSawmillActionPerformed(evt);
            }
        });
        jPanel1.add(buyBigSawmill);
        buyBigSawmill.setBounds(550, 60, 140, 50);

        buyIronmine.setBackground(new java.awt.Color(250, 250, 250));
        buyIronmine.setForeground(new java.awt.Color(66, 66, 66));
        buyIronmine.setText("Ironmine: 0");
        buyIronmine.setToolTipText("Gold: 120, Wood: 400, Steel: 0, Work positions: 100, produces iron");
        buyIronmine.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buyIronmine.setContentAreaFilled(false);
        buyIronmine.setFocusPainted(false);
        buyIronmine.setFocusable(false);
        buyIronmine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyIronmineActionPerformed(evt);
            }
        });
        jPanel1.add(buyIronmine);
        buyIronmine.setBounds(400, 300, 140, 50);

        buySteelworks.setBackground(new java.awt.Color(250, 250, 250));
        buySteelworks.setForeground(new java.awt.Color(66, 66, 66));
        buySteelworks.setText("Steelworks: 0");
        buySteelworks.setToolTipText("Gold: 100, Wood: 200, Steel: 0, Work positions: 8, produces 1 steel from 2 iron");
        buySteelworks.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buySteelworks.setContentAreaFilled(false);
        buySteelworks.setFocusPainted(false);
        buySteelworks.setFocusable(false);
        buySteelworks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySteelworksActionPerformed(evt);
            }
        });
        jPanel1.add(buySteelworks);
        buySteelworks.setBounds(400, 240, 140, 50);

        buySteelFactory.setBackground(new java.awt.Color(250, 250, 250));
        buySteelFactory.setForeground(new java.awt.Color(66, 66, 66));
        buySteelFactory.setText("Steel factory: 0");
        buySteelFactory.setToolTipText("Gold: 300, Wood: 700, Steel: 200, Workshop positions: 40, produces 1 steel from 2 iron\n");
        buySteelFactory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buySteelFactory.setContentAreaFilled(false);
        buySteelFactory.setFocusPainted(false);
        buySteelFactory.setFocusable(false);
        buySteelFactory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySteelFactoryActionPerformed(evt);
            }
        });
        jPanel1.add(buySteelFactory);
        buySteelFactory.setBounds(550, 180, 140, 50);

        buyHuntersLodge.setBackground(new java.awt.Color(250, 250, 250));
        buyHuntersLodge.setForeground(new java.awt.Color(66, 66, 66));
        buyHuntersLodge.setText("Hunters lodge: 0");
        buyHuntersLodge.setToolTipText("Gold: 0, Wood: 25, Steel: 0, Work positions: 6, produces meat\n");
        buyHuntersLodge.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buyHuntersLodge.setContentAreaFilled(false);
        buyHuntersLodge.setFocusPainted(false);
        buyHuntersLodge.setFocusable(false);
        buyHuntersLodge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyHuntersLodgeActionPerformed(evt);
            }
        });
        jPanel1.add(buyHuntersLodge);
        buyHuntersLodge.setBounds(400, 120, 140, 50);

        buySlaughterhouse.setBackground(new java.awt.Color(250, 250, 250));
        buySlaughterhouse.setForeground(new java.awt.Color(66, 66, 66));
        buySlaughterhouse.setText("Slaughterhouse: 0");
        buySlaughterhouse.setToolTipText("Gold: 300, Wood: 650, Steel: 150, Work positions: 32, produces meat");
        buySlaughterhouse.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buySlaughterhouse.setContentAreaFilled(false);
        buySlaughterhouse.setFocusPainted(false);
        buySlaughterhouse.setFocusable(false);
        buySlaughterhouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySlaughterhouseActionPerformed(evt);
            }
        });
        jPanel1.add(buySlaughterhouse);
        buySlaughterhouse.setBounds(550, 120, 140, 50);

        buySmokehouse.setBackground(new java.awt.Color(250, 250, 250));
        buySmokehouse.setForeground(new java.awt.Color(66, 66, 66));
        buySmokehouse.setText("Smokehouse: 0");
        buySmokehouse.setToolTipText("Gold: 5, Wood: 25, Steel: 0, Work positions: 6, produces 1 smoked meat from 2 meat\n");
        buySmokehouse.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buySmokehouse.setContentAreaFilled(false);
        buySmokehouse.setFocusPainted(false);
        buySmokehouse.setFocusable(false);
        buySmokehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySmokehouseActionPerformed(evt);
            }
        });
        jPanel1.add(buySmokehouse);
        buySmokehouse.setBounds(400, 180, 140, 50);

        jLabel3.setText("Steel: ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(720, 280, 40, 20);

        steelResources.setText("cislo");
        jPanel1.add(steelResources);
        steelResources.setBounds(850, 280, 90, 16);

        upgradePickaxe.setBackground(new java.awt.Color(250, 250, 250));
        upgradePickaxe.setForeground(new java.awt.Color(66, 66, 66));
        upgradePickaxe.setText("Upgrade pickaxe");
        upgradePickaxe.setToolTipText("Gold: 100, halves clicks needed to mine each product ");
        upgradePickaxe.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        upgradePickaxe.setContentAreaFilled(false);
        upgradePickaxe.setFocusPainted(false);
        upgradePickaxe.setFocusable(false);
        upgradePickaxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradePickaxeActionPerformed(evt);
            }
        });
        jPanel1.add(upgradePickaxe);
        upgradePickaxe.setBounds(15, 500, 130, 20);

        buyLaboratory.setBackground(new java.awt.Color(250, 250, 250));
        buyLaboratory.setForeground(new java.awt.Color(66, 66, 66));
        buyLaboratory.setText("Laboratory: 0000");
        buyLaboratory.setToolTipText("Gold: 1500, Wood: 500, Steel: 2000, Work positions: 15, produces research points\n");
        buyLaboratory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buyLaboratory.setContentAreaFilled(false);
        buyLaboratory.setFocusPainted(false);
        buyLaboratory.setFocusable(false);
        buyLaboratory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyLaboratoryActionPerformed(evt);
            }
        });
        jPanel1.add(buyLaboratory);
        buyLaboratory.setBounds(550, 240, 140, 50);

        jLabel6.setText("Smoked meat:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(720, 160, 90, 16);

        smokedMeatResources.setText("jLabel8");
        jPanel1.add(smokedMeatResources);
        smokedMeatResources.setBounds(850, 160, 100, 16);

        pickUpgradedLabel.setText("Pickaxe upgraded");
        jPanel1.add(pickUpgradedLabel);
        pickUpgradedLabel.setBounds(27, 500, 120, 30);

        jLabel10.setText("Gold:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(720, 340, 60, 16);

        goldResources.setText("jLabel13");
        jPanel1.add(goldResources);
        goldResources.setBounds(850, 340, 100, 16);
        jPanel1.add(newVillagersFeed);
        newVillagersFeed.setBounds(170, 450, 340, 40);

        buySpaceship.setBackground(new java.awt.Color(250, 250, 250));
        buySpaceship.setForeground(new java.awt.Color(66, 66, 66));
        buySpaceship.setText("SPACESHIP");
        buySpaceship.setToolTipText("Gold: 10000, Wood:0, Steel: 10000, Spaceship parts: 5000, Build your own spaceship and explore the Universe. Wins the game.");
        buySpaceship.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buySpaceship.setContentAreaFilled(false);
        buySpaceship.setFocusPainted(false);
        buySpaceship.setFocusable(false);
        buySpaceship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySpaceshipActionPerformed(evt);
            }
        });
        jPanel1.add(buySpaceship);
        buySpaceship.setBounds(550, 360, 140, 50);

        jLabel7.setText("Research points:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(720, 390, 100, 16);

        researchPointResources.setText("jLabel19");
        jPanel1.add(researchPointResources);
        researchPointResources.setBounds(850, 390, 100, 16);

        jLabel19.setText("Spaceship parts");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(720, 450, 110, 16);

        spaceshipPartsResources.setText("jLabel20");
        jPanel1.add(spaceshipPartsResources);
        spaceshipPartsResources.setBounds(850, 450, 80, 16);

        buyGoldmine.setBackground(new java.awt.Color(250, 250, 250));
        buyGoldmine.setForeground(new java.awt.Color(66, 66, 66));
        buyGoldmine.setText("Golmine: 0");
        buyGoldmine.setToolTipText("Gold: 100, Wood: 100, Steel: 50, Work positions: 100, produces gold");
        buyGoldmine.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        buyGoldmine.setContentAreaFilled(false);
        buyGoldmine.setFocusPainted(false);
        buyGoldmine.setFocusable(false);
        buyGoldmine.setPreferredSize(new java.awt.Dimension(92, 32));
        buyGoldmine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyGoldmineActionPerformed(evt);
            }
        });
        jPanel1.add(buyGoldmine);
        buyGoldmine.setBounds(400, 360, 140, 50);
        jPanel1.add(eventLabel);
        eventLabel.setBounds(170, 500, 390, 40);

        jTabbedPane1.addTab("City manager", jPanel1);

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setLayout(null);

        jLabel14.setText("Workers available:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(20, 10, 120, 16);

        goldWorkers.setText("Gold");
        goldWorkers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        goldWorkers.setContentAreaFilled(false);
        goldWorkers.setFocusPainted(false);
        goldWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goldWorkersActionPerformed(evt);
            }
        });
        jPanel2.add(goldWorkers);
        goldWorkers.setBounds(500, 180, 190, 60);

        woodAddBig.setText("++");
        woodAddBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        woodAddBig.setContentAreaFilled(false);
        woodAddBig.setFocusPainted(false);
        woodAddBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                woodAddBigActionPerformed(evt);
            }
        });
        jPanel2.add(woodAddBig);
        woodAddBig.setBounds(240, 80, 50, 40);

        woodRemoveBig.setText("--");
        woodRemoveBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        woodRemoveBig.setContentAreaFilled(false);
        woodRemoveBig.setFocusPainted(false);
        woodRemoveBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                woodRemoveBigActionPerformed(evt);
            }
        });
        jPanel2.add(woodRemoveBig);
        woodRemoveBig.setBounds(390, 80, 50, 40);

        woodAddSmall.setText("+");
        woodAddSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        woodAddSmall.setContentAreaFilled(false);
        woodAddSmall.setFocusPainted(false);
        woodAddSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                woodAddSmallActionPerformed(evt);
            }
        });
        jPanel2.add(woodAddSmall);
        woodAddSmall.setBounds(290, 80, 50, 40);

        woodRemoveSmall.setText("-");
        woodRemoveSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        woodRemoveSmall.setContentAreaFilled(false);
        woodRemoveSmall.setFocusPainted(false);
        woodRemoveSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                woodRemoveSmallActionPerformed(evt);
            }
        });
        jPanel2.add(woodRemoveSmall);
        woodRemoveSmall.setBounds(340, 80, 50, 40);

        workersAvailable.setText("jLabel8");
        jPanel2.add(workersAvailable);
        workersAvailable.setBounds(150, 10, 80, 16);

        woodWorkers.setText("Wood");
        woodWorkers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        woodWorkers.setContentAreaFilled(false);
        woodWorkers.setFocusPainted(false);
        woodWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                woodWorkersActionPerformed(evt);
            }
        });
        jPanel2.add(woodWorkers);
        woodWorkers.setBounds(20, 70, 190, 60);

        meatAddBig.setText("++");
        meatAddBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        meatAddBig.setContentAreaFilled(false);
        meatAddBig.setFocusPainted(false);
        meatAddBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meatAddBigActionPerformed(evt);
            }
        });
        jPanel2.add(meatAddBig);
        meatAddBig.setBounds(240, 190, 50, 40);

        meatAddSmall.setText("+");
        meatAddSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        meatAddSmall.setContentAreaFilled(false);
        meatAddSmall.setFocusPainted(false);
        meatAddSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meatAddSmallActionPerformed(evt);
            }
        });
        jPanel2.add(meatAddSmall);
        meatAddSmall.setBounds(290, 190, 50, 40);

        meatRemoveSmall.setText("-");
        meatRemoveSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        meatRemoveSmall.setContentAreaFilled(false);
        meatRemoveSmall.setFocusPainted(false);
        meatRemoveSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meatRemoveSmallActionPerformed(evt);
            }
        });
        jPanel2.add(meatRemoveSmall);
        meatRemoveSmall.setBounds(340, 190, 50, 40);

        meatRemoveBig.setText("--");
        meatRemoveBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        meatRemoveBig.setContentAreaFilled(false);
        meatRemoveBig.setFocusPainted(false);
        meatRemoveBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meatRemoveBigActionPerformed(evt);
            }
        });
        jPanel2.add(meatRemoveBig);
        meatRemoveBig.setBounds(390, 190, 50, 40);

        ironRemoveBig.setText("--");
        ironRemoveBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ironRemoveBig.setContentAreaFilled(false);
        ironRemoveBig.setFocusPainted(false);
        ironRemoveBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ironRemoveBigActionPerformed(evt);
            }
        });
        jPanel2.add(ironRemoveBig);
        ironRemoveBig.setBounds(390, 440, 50, 40);

        ironRemoveSmall.setText("-");
        ironRemoveSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ironRemoveSmall.setContentAreaFilled(false);
        ironRemoveSmall.setFocusPainted(false);
        ironRemoveSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ironRemoveSmallActionPerformed(evt);
            }
        });
        jPanel2.add(ironRemoveSmall);
        ironRemoveSmall.setBounds(340, 440, 50, 40);

        ironAddSmall.setText("+");
        ironAddSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ironAddSmall.setContentAreaFilled(false);
        ironAddSmall.setFocusPainted(false);
        ironAddSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ironAddSmallActionPerformed(evt);
            }
        });
        jPanel2.add(ironAddSmall);
        ironAddSmall.setBounds(290, 440, 50, 40);

        ironAddBig.setText("++");
        ironAddBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ironAddBig.setContentAreaFilled(false);
        ironAddBig.setFocusPainted(false);
        ironAddBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ironAddBigActionPerformed(evt);
            }
        });
        jPanel2.add(ironAddBig);
        ironAddBig.setBounds(240, 440, 50, 40);

        steelRemoveBig.setText("--");
        steelRemoveBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        steelRemoveBig.setContentAreaFilled(false);
        steelRemoveBig.setFocusPainted(false);
        steelRemoveBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                steelRemoveBigActionPerformed(evt);
            }
        });
        jPanel2.add(steelRemoveBig);
        steelRemoveBig.setBounds(870, 80, 50, 40);

        steelRemoveSmall.setText("-");
        steelRemoveSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        steelRemoveSmall.setContentAreaFilled(false);
        steelRemoveSmall.setFocusPainted(false);
        steelRemoveSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                steelRemoveSmallActionPerformed(evt);
            }
        });
        jPanel2.add(steelRemoveSmall);
        steelRemoveSmall.setBounds(820, 80, 50, 40);

        steelAddSmall.setText("+");
        steelAddSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        steelAddSmall.setContentAreaFilled(false);
        steelAddSmall.setFocusPainted(false);
        steelAddSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                steelAddSmallActionPerformed(evt);
            }
        });
        jPanel2.add(steelAddSmall);
        steelAddSmall.setBounds(770, 80, 50, 40);

        steelAddBig.setText("++");
        steelAddBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        steelAddBig.setContentAreaFilled(false);
        steelAddBig.setFocusPainted(false);
        steelAddBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                steelAddBigActionPerformed(evt);
            }
        });
        jPanel2.add(steelAddBig);
        steelAddBig.setBounds(720, 80, 50, 40);

        GoldRemoveBig.setText("--");
        GoldRemoveBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        GoldRemoveBig.setContentAreaFilled(false);
        GoldRemoveBig.setFocusPainted(false);
        GoldRemoveBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoldRemoveBigActionPerformed(evt);
            }
        });
        jPanel2.add(GoldRemoveBig);
        GoldRemoveBig.setBounds(870, 190, 50, 40);

        goldRemoveSmall.setText("-");
        goldRemoveSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        goldRemoveSmall.setContentAreaFilled(false);
        goldRemoveSmall.setFocusPainted(false);
        goldRemoveSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goldRemoveSmallActionPerformed(evt);
            }
        });
        jPanel2.add(goldRemoveSmall);
        goldRemoveSmall.setBounds(820, 190, 50, 40);

        goldAddSmall.setText("+");
        goldAddSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        goldAddSmall.setContentAreaFilled(false);
        goldAddSmall.setFocusPainted(false);
        goldAddSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goldAddSmallActionPerformed(evt);
            }
        });
        jPanel2.add(goldAddSmall);
        goldAddSmall.setBounds(770, 190, 50, 40);

        goldAddBig.setText("++");
        goldAddBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        goldAddBig.setContentAreaFilled(false);
        goldAddBig.setFocusPainted(false);
        goldAddBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goldAddBigActionPerformed(evt);
            }
        });
        jPanel2.add(goldAddBig);
        goldAddBig.setBounds(720, 190, 50, 40);

        smokedMeatWorkers.setText("Smoked meat");
        smokedMeatWorkers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        smokedMeatWorkers.setContentAreaFilled(false);
        smokedMeatWorkers.setFocusPainted(false);
        smokedMeatWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smokedMeatWorkersActionPerformed(evt);
            }
        });
        jPanel2.add(smokedMeatWorkers);
        smokedMeatWorkers.setBounds(20, 300, 190, 60);

        ironWorkers.setText("Iron");
        ironWorkers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ironWorkers.setContentAreaFilled(false);
        ironWorkers.setFocusPainted(false);
        ironWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ironWorkersActionPerformed(evt);
            }
        });
        jPanel2.add(ironWorkers);
        ironWorkers.setBounds(20, 430, 190, 60);

        meatWorkers.setText("Meat");
        meatWorkers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        meatWorkers.setContentAreaFilled(false);
        meatWorkers.setFocusPainted(false);
        meatWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meatWorkersActionPerformed(evt);
            }
        });
        jPanel2.add(meatWorkers);
        meatWorkers.setBounds(20, 180, 190, 60);

        smokedMeatAddBig.setText("++");
        smokedMeatAddBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        smokedMeatAddBig.setContentAreaFilled(false);
        smokedMeatAddBig.setFocusPainted(false);
        smokedMeatAddBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smokedMeatAddBigActionPerformed(evt);
            }
        });
        jPanel2.add(smokedMeatAddBig);
        smokedMeatAddBig.setBounds(240, 310, 50, 40);

        smokedMeatAddSmall.setText("+");
        smokedMeatAddSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        smokedMeatAddSmall.setContentAreaFilled(false);
        smokedMeatAddSmall.setFocusPainted(false);
        smokedMeatAddSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smokedMeatAddSmallActionPerformed(evt);
            }
        });
        jPanel2.add(smokedMeatAddSmall);
        smokedMeatAddSmall.setBounds(290, 310, 50, 40);

        smokedMeatRemoveSmall.setText("-");
        smokedMeatRemoveSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        smokedMeatRemoveSmall.setContentAreaFilled(false);
        smokedMeatRemoveSmall.setFocusPainted(false);
        smokedMeatRemoveSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smokedMeatRemoveSmallActionPerformed(evt);
            }
        });
        jPanel2.add(smokedMeatRemoveSmall);
        smokedMeatRemoveSmall.setBounds(340, 310, 50, 40);

        smokedMeatRemoveBig.setText("--");
        smokedMeatRemoveBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        smokedMeatRemoveBig.setContentAreaFilled(false);
        smokedMeatRemoveBig.setFocusPainted(false);
        smokedMeatRemoveBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smokedMeatRemoveBigActionPerformed(evt);
            }
        });
        jPanel2.add(smokedMeatRemoveBig);
        smokedMeatRemoveBig.setBounds(390, 310, 50, 40);

        steelWorkers.setText("Steel");
        steelWorkers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        steelWorkers.setContentAreaFilled(false);
        steelWorkers.setFocusPainted(false);
        steelWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                steelWorkersActionPerformed(evt);
            }
        });
        jPanel2.add(steelWorkers);
        steelWorkers.setBounds(500, 70, 190, 60);

        researchPointWorkers.setText("Research Point");
        researchPointWorkers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        researchPointWorkers.setContentAreaFilled(false);
        researchPointWorkers.setFocusPainted(false);
        researchPointWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                researchPointWorkersActionPerformed(evt);
            }
        });
        jPanel2.add(researchPointWorkers);
        researchPointWorkers.setBounds(500, 300, 190, 60);

        RPaddBig.setText("++");
        RPaddBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RPaddBig.setContentAreaFilled(false);
        RPaddBig.setFocusPainted(false);
        RPaddBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPaddBigActionPerformed(evt);
            }
        });
        jPanel2.add(RPaddBig);
        RPaddBig.setBounds(720, 310, 50, 40);

        RPAddSmall.setText("+");
        RPAddSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RPAddSmall.setContentAreaFilled(false);
        RPAddSmall.setFocusPainted(false);
        RPAddSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPAddSmallActionPerformed(evt);
            }
        });
        jPanel2.add(RPAddSmall);
        RPAddSmall.setBounds(770, 310, 50, 40);

        RPRemoveSmall.setText("-");
        RPRemoveSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RPRemoveSmall.setContentAreaFilled(false);
        RPRemoveSmall.setFocusPainted(false);
        RPRemoveSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPRemoveSmallActionPerformed(evt);
            }
        });
        jPanel2.add(RPRemoveSmall);
        RPRemoveSmall.setBounds(820, 310, 50, 40);

        RPRemoveBig.setText("--");
        RPRemoveBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RPRemoveBig.setContentAreaFilled(false);
        RPRemoveBig.setFocusPainted(false);
        RPRemoveBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPRemoveBigActionPerformed(evt);
            }
        });
        jPanel2.add(RPRemoveBig);
        RPRemoveBig.setBounds(870, 310, 50, 40);

        spaceshipPartWorkers.setText("Spaceship part");
        spaceshipPartWorkers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        spaceshipPartWorkers.setContentAreaFilled(false);
        spaceshipPartWorkers.setFocusPainted(false);
        spaceshipPartWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spaceshipPartWorkersActionPerformed(evt);
            }
        });
        jPanel2.add(spaceshipPartWorkers);
        spaceshipPartWorkers.setBounds(500, 430, 190, 60);

        SPaddBig.setText("++");
        SPaddBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SPaddBig.setContentAreaFilled(false);
        SPaddBig.setFocusPainted(false);
        SPaddBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPaddBigActionPerformed(evt);
            }
        });
        jPanel2.add(SPaddBig);
        SPaddBig.setBounds(720, 440, 50, 40);

        SPAddSmall.setText("+");
        SPAddSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SPAddSmall.setContentAreaFilled(false);
        SPAddSmall.setFocusPainted(false);
        SPAddSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPAddSmallActionPerformed(evt);
            }
        });
        jPanel2.add(SPAddSmall);
        SPAddSmall.setBounds(770, 440, 50, 40);

        SPRemoveSmall.setText("-");
        SPRemoveSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SPRemoveSmall.setContentAreaFilled(false);
        SPRemoveSmall.setFocusPainted(false);
        SPRemoveSmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPRemoveSmallActionPerformed(evt);
            }
        });
        jPanel2.add(SPRemoveSmall);
        SPRemoveSmall.setBounds(820, 440, 50, 40);

        SPRemoveBig.setText("--");
        SPRemoveBig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SPRemoveBig.setContentAreaFilled(false);
        SPRemoveBig.setFocusPainted(false);
        SPRemoveBig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPRemoveBigActionPerformed(evt);
            }
        });
        jPanel2.add(SPRemoveBig);
        SPRemoveBig.setBounds(870, 440, 50, 40);

        jTabbedPane1.addTab("Work Manager", jPanel2);

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Total steel: ");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(10, 210, 90, 20);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Total wood:");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(10, 30, 90, 20);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Total meat:");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(10, 90, 90, 20);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Total iron:");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(10, 150, 90, 20);

        totalSteel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalSteel.setText("steel");
        jPanel3.add(totalSteel);
        totalSteel.setBounds(180, 210, 70, 20);

        totalWood.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalWood.setText("wood");
        jPanel3.add(totalWood);
        totalWood.setBounds(180, 30, 100, 20);

        totalMeat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalMeat.setText("meat");
        jPanel3.add(totalMeat);
        totalMeat.setBounds(180, 90, 100, 20);

        totalIron.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalIron.setText("iron");
        jPanel3.add(totalIron);
        totalIron.setBounds(180, 150, 70, 20);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Total smoked meat");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(10, 270, 140, 20);

        totalSmokedMeat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalSmokedMeat.setText("smoked");
        jPanel3.add(totalSmokedMeat);
        totalSmokedMeat.setBounds(180, 270, 70, 19);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Total mining clicks:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 500, 140, 20);

        totalMiningClicks.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalMiningClicks.setText("clicks");
        jPanel3.add(totalMiningClicks);
        totalMiningClicks.setBounds(180, 500, 120, 19);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("HIGHSCORES");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(450, 90, 320, 50);

        jScrollPane1.setOpaque(false);

        highscores.setBackground(new java.awt.Color(250, 250, 250));
        highscores.setColumns(20);
        highscores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        highscores.setForeground(new java.awt.Color(66, 66, 66));
        highscores.setLineWrap(true);
        highscores.setRows(5);
        highscores.setOpaque(false);
        jScrollPane1.setViewportView(highscores);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(450, 140, 320, 120);

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("Total gold:");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(10, 330, 80, 20);

        totalGold.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalGold.setText("gold");
        jPanel3.add(totalGold);
        totalGold.setBounds(180, 330, 140, 19);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Total research points:");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(10, 390, 160, 20);

        totalRP.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalRP.setText("RP");
        jPanel3.add(totalRP);
        totalRP.setBounds(180, 390, 110, 19);

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setText("Total spaceship parts");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(10, 440, 170, 20);

        totalSP.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalSP.setText("SP");
        jPanel3.add(totalSP);
        totalSP.setBounds(180, 440, 70, 19);

        presentationMode.setBackground(new java.awt.Color(250, 250, 250));
        presentationMode.setText("Prezentačný mód");
        presentationMode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        presentationMode.setContentAreaFilled(false);
        presentationMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentationModeActionPerformed(evt);
            }
        });
        jPanel3.add(presentationMode);
        presentationMode.setBounds(790, 480, 190, 50);

        jTabbedPane1.addTab("Statistics", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 1000, 600);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Aktualizácia všetkých labelov v hre
     */
    private void updateAllLabels() {
        HashMap<Product, Integer> totalProduced = this.storage.getTotalProduced();
        this.totalWood.setText(Integer.toString(totalProduced.get(Product.WOOD)));
        this.totalMeat.setText(Integer.toString(totalProduced.get(Product.MEAT)));
        this.totalSmokedMeat.setText(Integer.toString(totalProduced.get(Product.SMOKED_MEAT)));
        this.totalIron.setText(Integer.toString(totalProduced.get(Product.IRON)));
        this.totalSteel.setText(Integer.toString(totalProduced.get(Product.STEEL)));
        this.totalMiningClicks.setText(Integer.toString(this.clicks.getTotalNumOfMiningClicks()));
        this.totalGold.setText(Integer.toString(totalProduced.get(Product.GOLD)));
        this.totalRP.setText(Integer.toString(totalProduced.get(Product.RESEARCH_POINT)));
        this.totalSP.setText(Integer.toString(totalProduced.get(Product.SPACESHIP_PART)));

        this.woodResources.setText(Integer.toString(this.storage.getProductStock(Product.WOOD)));
        this.ironResources.setText(Integer.toString(this.storage.getProductStock(Product.IRON)));
        this.meatResources.setText(Integer.toString(this.storage.getProductStock(Product.MEAT)));
        this.steelResources.setText(Integer.toString(this.storage.getProductStock(Product.STEEL)));
        this.smokedMeatResources.setText(Integer.toString(this.storage.getProductStock(Product.SMOKED_MEAT)));
        this.goldResources.setText(Integer.toString(this.storage.getProductStock(Product.GOLD)));
        this.researchPointResources.setText(Integer.toString(this.storage.getProductStock(Product.RESEARCH_POINT)));
        this.spaceshipPartsResources.setText(Integer.toString(this.storage.getProductStock(Product.SPACESHIP_PART)));

        this.residentsLabel.setText((this.houseManager.getNumOfVillagers()) + " / " + (this.houseManager.getTotalFreeBeds() + this.houseManager.getNumOfVillagers()));
        this.workersAvailable.setText(this.workManager.numOfUnemployedVillagers(this.houseManager) + " / " + this.houseManager.getNumOfVillagers());

        this.buyTENT.setText("Tent: " + this.houseManager.getNumOfHouseType(HousingTypes.TENT));
        this.buyHUT.setText("Hut: " + this.houseManager.getNumOfHouseType(HousingTypes.HUT));
        this.buyHOUSE.setText("House: " + this.houseManager.getNumOfHouseType(HousingTypes.HOUSE));
        this.buyBLOCK_OF_FLATS.setText("Block of flats: " + this.houseManager.getNumOfHouseType(HousingTypes.BLOCK_OF_FLATS));
        this.buyHIGH_RISE_BUILDING.setText("High rise building: " + this.houseManager.getNumOfHouseType(HousingTypes.HIGH_RISE_BUILDING));
        this.buySTREET_OF_HOUSES.setText("Street of houses: " + this.houseManager.getNumOfHouseType(HousingTypes.STREET_OF_HOUSES));

        HashMap<WorkshopType, Integer> workshops = this.workManager.getWorkshops();

        this.buySawmill.setText("Sawmill: " + workshops.get(WorkshopType.SAWMILL));
        this.buyBigSawmill.setText("Big sawmill: " + workshops.get(WorkshopType.BIG_SAWMILL));
        this.buySmokehouse.setText("Smokehouse: " + workshops.get(WorkshopType.SMOKEHOUSE));
        this.buyIronmine.setText("Iron mine: " + workshops.get(WorkshopType.IRONMINE));
        this.buyGoldmine.setText("Gold mine: " + workshops.get(WorkshopType.GOLDMINE));
        this.buySteelFactory.setText("Steel factory: " + workshops.get(WorkshopType.STEEL_FACTORY));
        this.buySteelworks.setText("Steelworks: " + workshops.get(WorkshopType.STEELWORKS));
        this.buyHuntersLodge.setText("Hunters lodge: " + workshops.get(WorkshopType.HUNTERS_LODGE));
        this.buySlaughterhouse.setText("Slaughterhouse: " + workshops.get(WorkshopType.SLAUGHTERHOUSE));
        this.buyLaboratory.setText("Laboratory: " + workshops.get(WorkshopType.LABORATORY));
        this.buySpaceshipFactory.setText("Spaceship factory: " + workshops.get(WorkshopType.SPACESHIP_FACTORY));

        this.woodWorkers.setText("Wood: " + this.workManager.getOccupiedPositions(Product.WOOD) + " / " + (this.workManager.getFreePositions(Product.WOOD) + this.workManager.getOccupiedPositions(Product.WOOD)));
        this.ironWorkers.setText("Iron: " + this.workManager.getOccupiedPositions(Product.IRON) + " / " + (this.workManager.getFreePositions(Product.IRON) + this.workManager.getOccupiedPositions(Product.IRON)));
        this.meatWorkers.setText("Meat: " + this.workManager.getOccupiedPositions(Product.MEAT) + " / " + (this.workManager.getFreePositions(Product.MEAT) + this.workManager.getOccupiedPositions(Product.MEAT)));
        this.steelWorkers.setText("Steel: " + this.workManager.getOccupiedPositions(Product.STEEL) + " / " + (this.workManager.getFreePositions(Product.STEEL) + this.workManager.getOccupiedPositions(Product.STEEL)));
        this.smokedMeatWorkers.setText("Smoked meat: " + this.workManager.getOccupiedPositions(Product.SMOKED_MEAT) + " / " + (this.workManager.getFreePositions(Product.SMOKED_MEAT) + this.workManager.getOccupiedPositions(Product.SMOKED_MEAT)));
        this.goldWorkers.setText("Gold: " + this.workManager.getOccupiedPositions(Product.GOLD) + " / " + (this.workManager.getFreePositions(Product.GOLD) + this.workManager.getOccupiedPositions(Product.GOLD)));
        this.researchPointWorkers.setText("Researchers: " + this.workManager.getOccupiedPositions(Product.RESEARCH_POINT) + " / " + (this.workManager.getFreePositions(Product.RESEARCH_POINT) + this.workManager.getOccupiedPositions(Product.RESEARCH_POINT)));
        this.spaceshipPartWorkers.setText("Spaceship builders: " + this.workManager.getOccupiedPositions(Product.SPACESHIP_PART) + " / " + (this.workManager.getFreePositions(Product.SPACESHIP_PART) + this.workManager.getOccupiedPositions(Product.SPACESHIP_PART)));
    }

    /**
     *
     * @return Runnable pre automatické ťaženie
     */
    private Runnable autoMine() {
        Runnable autoMining = new Runnable() {
            public void run() {
                GUI.this.storage.addNewProductsEveryTick(GUI.this.workManager);
                GUI.this.updateAllLabels();
            }
        };
        return autoMining;
    }

    /**
     *
     * @return Runnable pre jedenie mäsa / úmrtia ak nie je dosť mäsa
     */
    private Runnable eatAndStarve() {
        Runnable eatAndStarve = new Runnable() {
            public void run() {
                if (!GUI.this.storage.eatMeat(GUI.this.houseManager)) {
                    int countDead = GUI.this.houseManager.getNumOfVillagers() / 10;
                    GUI.this.houseManager.killVillagers(countDead);
                    GUI.this.workManager.killVillager(countDead);
                }
                GUI.this.updateAllLabels();
            }
        };

        return eatAndStarve;
    }

    /**
     *
     * @return Runnable pre spawnutie nových obyvateľov
     */
    private Runnable spawnVillagers() {
        Runnable spawnVillagers = new Runnable() {
            public void run() {
                if (GUI.this.houseManager.getTotalFreeBeds() != 0) {
                    GUI.this.newVillagersFeed.setText(GUI.this.houseManager.spawnVillager());
                }
                GUI.this.updateAllLabels();
            }
        };
        return spawnVillagers;
    }

    /**
     *
     * @return Runnable pre náhodne generované eventy
     */
    private Runnable randomEvent() {
        Runnable randomEvent = new Runnable() {
            public void run() {
                GUI.this.eventLabel.setText(GUI.this.events.generateEvent(GUI.this.houseManager, GUI.this.workManager, GUI.this.storage));
                GUI.this.updateAllLabels();
            }
        };
        return randomEvent;
    }

        private void mineWoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mineWoodActionPerformed
            if (this.clicks.playerMiningClick(Product.WOOD, this.storage)) {
                this.woodResources.setText(Integer.toString(this.storage.getProductStock(Product.WOOD)));
            }
            this.updateAllLabels();
        }//GEN-LAST:event_mineWoodActionPerformed

        private void mineGoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mineGoldActionPerformed
            if (this.clicks.playerMiningClick(Product.GOLD, this.storage)) {
                this.woodResources.setText(Integer.toString(this.storage.getProductStock(Product.GOLD)));
            }
            this.updateAllLabels();
         }//GEN-LAST:event_mineGoldActionPerformed

        private void buySTREET_OF_HOUSESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySTREET_OF_HOUSESActionPerformed
            House buying = new House(1000, 2500, 500, HousingTypes.STREET_OF_HOUSES);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buySTREET_OF_HOUSESActionPerformed

        private void buyTENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyTENTActionPerformed
            House buying = new House(0, 10, 0, HousingTypes.TENT);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buyTENTActionPerformed

        private void buyHUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyHUTActionPerformed
            House buying = new House(10, 30, 0, HousingTypes.HUT);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();

        }//GEN-LAST:event_buyHUTActionPerformed

        private void buyHOUSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyHOUSEActionPerformed
            House buying = new House(30, 50, 20, HousingTypes.HOUSE);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buyHOUSEActionPerformed

        private void goldWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goldWorkersActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_goldWorkersActionPerformed

        private void woodAddBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_woodAddBigActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.WOOD, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_woodAddBigActionPerformed

        private void woodRemoveBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_woodRemoveBigActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.WOOD, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_woodRemoveBigActionPerformed

        private void woodAddSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_woodAddSmallActionPerformed
            this.clicks.employVillagersClick(this.workManager, houseManager, Product.WOOD, 1);
            this.updateAllLabels();

        }//GEN-LAST:event_woodAddSmallActionPerformed

        private void woodRemoveSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_woodRemoveSmallActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.WOOD, 1);
            this.updateAllLabels();

        }//GEN-LAST:event_woodRemoveSmallActionPerformed

        private void buyBLOCK_OF_FLATSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyBLOCK_OF_FLATSActionPerformed
            House buying = new House(100, 250, 100, HousingTypes.BLOCK_OF_FLATS);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buyBLOCK_OF_FLATSActionPerformed

        private void buyHIGH_RISE_BUILDINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyHIGH_RISE_BUILDINGActionPerformed
            House buying = new House(250, 750, 450, HousingTypes.HIGH_RISE_BUILDING);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();

        }//GEN-LAST:event_buyHIGH_RISE_BUILDINGActionPerformed

        private void woodWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_woodWorkersActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_woodWorkersActionPerformed

        private void meatAddBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meatAddBigActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.MEAT, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_meatAddBigActionPerformed

        private void meatAddSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meatAddSmallActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.MEAT, 1);
            this.updateAllLabels();

        }//GEN-LAST:event_meatAddSmallActionPerformed

        private void meatRemoveSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meatRemoveSmallActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.MEAT, 1);
            this.updateAllLabels();

        }//GEN-LAST:event_meatRemoveSmallActionPerformed

        private void meatRemoveBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meatRemoveBigActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.MEAT, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_meatRemoveBigActionPerformed

        private void ironRemoveBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ironRemoveBigActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.IRON, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_ironRemoveBigActionPerformed

        private void ironRemoveSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ironRemoveSmallActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.IRON, 1);
            this.updateAllLabels();

        }//GEN-LAST:event_ironRemoveSmallActionPerformed

        private void ironAddSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ironAddSmallActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.IRON, 1);
            this.updateAllLabels();

        }//GEN-LAST:event_ironAddSmallActionPerformed

        private void ironAddBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ironAddBigActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.IRON, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_ironAddBigActionPerformed

        private void steelRemoveBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_steelRemoveBigActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.STEEL, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_steelRemoveBigActionPerformed

        private void steelRemoveSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_steelRemoveSmallActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.STEEL, 1);
            this.updateAllLabels();

        }//GEN-LAST:event_steelRemoveSmallActionPerformed

        private void steelAddSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_steelAddSmallActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.STEEL, 1);
            this.updateAllLabels();

        }//GEN-LAST:event_steelAddSmallActionPerformed

        private void steelAddBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_steelAddBigActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.STEEL, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_steelAddBigActionPerformed

        private void GoldRemoveBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoldRemoveBigActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.GOLD, 5);
            this.updateAllLabels();
        }//GEN-LAST:event_GoldRemoveBigActionPerformed

        private void goldRemoveSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goldRemoveSmallActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.GOLD, 1);
            this.updateAllLabels();
        }//GEN-LAST:event_goldRemoveSmallActionPerformed

        private void goldAddSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goldAddSmallActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.GOLD, 1);
            this.updateAllLabels();
        }//GEN-LAST:event_goldAddSmallActionPerformed

        private void goldAddBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goldAddBigActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.GOLD, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_goldAddBigActionPerformed

        private void smokedMeatWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smokedMeatWorkersActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_smokedMeatWorkersActionPerformed

        private void ironWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ironWorkersActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ironWorkersActionPerformed

        private void mineMeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mineMeatActionPerformed
            if (this.clicks.playerMiningClick(Product.MEAT, storage)) {
                this.woodResources.setText(Integer.toString(this.storage.getProductStock(Product.MEAT)));
                this.updateAllLabels();
            }
        }//GEN-LAST:event_mineMeatActionPerformed

        private void mineIronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mineIronActionPerformed
            if (this.clicks.playerMiningClick(Product.IRON, storage)) {
                this.woodResources.setText(Integer.toString(this.storage.getProductStock(Product.IRON)));
                this.updateAllLabels();
            }
        }//GEN-LAST:event_mineIronActionPerformed

        private void buySawmillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySawmillActionPerformed
            ProductionBuilding buying = new ProductionBuilding(0, 20, 0, WorkshopType.SAWMILL, 4, Product.WOOD);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buySawmillActionPerformed

        private void buyBigSawmillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyBigSawmillActionPerformed
            ProductionBuilding buying = new ProductionBuilding(50, 80, 0, WorkshopType.BIG_SAWMILL, 12, Product.WOOD);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buyBigSawmillActionPerformed

        private void buyIronmineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyIronmineActionPerformed
            ProductionBuilding buying = new ProductionBuilding(120, 400, 0, WorkshopType.IRONMINE, 100, Product.IRON);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buyIronmineActionPerformed

        private void buySteelworksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySteelworksActionPerformed
            ProductFromProductBuilding buying = new ProductFromProductBuilding(100, 200, 0, WorkshopType.STEELWORKS, 8, Product.STEEL, Product.IRON);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buySteelworksActionPerformed

        private void buySteelFactoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySteelFactoryActionPerformed
            ProductFromProductBuilding buying = new ProductFromProductBuilding(300, 700, 200, WorkshopType.STEEL_FACTORY, 40, Product.STEEL, Product.IRON);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buySteelFactoryActionPerformed

        private void buyHuntersLodgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyHuntersLodgeActionPerformed
            ProductionBuilding buying = new ProductionBuilding(0, 25, 0, WorkshopType.HUNTERS_LODGE, 6, Product.MEAT);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buyHuntersLodgeActionPerformed

        private void buySlaughterhouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySlaughterhouseActionPerformed
            ProductionBuilding buying = new ProductionBuilding(300, 650, 150, WorkshopType.SLAUGHTERHOUSE, 32, Product.MEAT);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buySlaughterhouseActionPerformed

        private void buySmokehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySmokehouseActionPerformed
            ProductFromProductBuilding buying = new ProductFromProductBuilding(5, 25, 0, WorkshopType.SMOKEHOUSE, 6, Product.SMOKED_MEAT, Product.MEAT);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            this.updateAllLabels();
        }//GEN-LAST:event_buySmokehouseActionPerformed

        private void upgradePickaxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradePickaxeActionPerformed
            House buying = new House(100, 0, 0, HousingTypes.HUT);
            if (this.storage.enoughMaterialsToBuild(buying)) {
                this.storage.removeFromStorage(Product.GOLD, 100);
                this.clicks.upgradePickaxe();
                this.upgradePickaxe.setEnabled(false);
                this.upgradePickaxe.setVisible(false);
                this.pickUpgradedLabel.setVisible(true);

            }
        }//GEN-LAST:event_upgradePickaxeActionPerformed

        private void meatWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meatWorkersActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_meatWorkersActionPerformed

        private void smokedMeatAddBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smokedMeatAddBigActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.SMOKED_MEAT, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_smokedMeatAddBigActionPerformed

        private void smokedMeatAddSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smokedMeatAddSmallActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.SMOKED_MEAT, 1);
            this.updateAllLabels();

        }//GEN-LAST:event_smokedMeatAddSmallActionPerformed

        private void smokedMeatRemoveSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smokedMeatRemoveSmallActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.SMOKED_MEAT, 1);
            this.updateAllLabels();
        }//GEN-LAST:event_smokedMeatRemoveSmallActionPerformed

        private void smokedMeatRemoveBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smokedMeatRemoveBigActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.SMOKED_MEAT, 5);
            this.updateAllLabels();
        }//GEN-LAST:event_smokedMeatRemoveBigActionPerformed

        private void buyLaboratoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyLaboratoryActionPerformed
            ProductionBuilding buying = new ProductionBuilding(1500, 500, 2000, WorkshopType.LABORATORY, 15, Product.RESEARCH_POINT);
            this.clicks.buyBuildingClick(buying, storage, houseManager, workManager);
            this.updateAllLabels();

        }//GEN-LAST:event_buyLaboratoryActionPerformed

        private void buySpaceshipFactoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySpaceshipFactoryActionPerformed
            ProductFromProductBuilding buying = new ProductFromProductBuilding(2000, 0, 3500, WorkshopType.SPACESHIP_FACTORY, 15, Product.STEEL, Product.SPACESHIP_PART);
            if (this.storage.enoughMaterialsToBuy(Product.RESEARCH_POINT, 5000)) {
                clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
                updateAllLabels();
            }
        }//GEN-LAST:event_buySpaceshipFactoryActionPerformed

        private void buySpaceshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySpaceshipActionPerformed
            ProductionBuilding buying = new ProductionBuilding(10000, 0, 10000, WorkshopType.SPACESHIP_FACTORY, 0, Product.WOOD);
            if (this.storage.enoughMaterialsToBuy(Product.SPACESHIP_PART, 5000)) {
                this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
                this.clicks.gameWinningClick(this.highscore, this.storage);
            }
        }//GEN-LAST:event_buySpaceshipActionPerformed

        private void buyGoldmineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyGoldmineActionPerformed
            ProductionBuilding buying = new ProductionBuilding(100, 100, 50, WorkshopType.GOLDMINE, 100, Product.GOLD);
            this.clicks.buyBuildingClick(buying, this.storage, this.houseManager, this.workManager);
            updateAllLabels();
        }//GEN-LAST:event_buyGoldmineActionPerformed

        private void steelWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_steelWorkersActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_steelWorkersActionPerformed

        private void researchPointWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_researchPointWorkersActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_researchPointWorkersActionPerformed

        private void RPaddBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPaddBigActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.RESEARCH_POINT, 5);
            this.updateAllLabels();
        }//GEN-LAST:event_RPaddBigActionPerformed

        private void RPAddSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPAddSmallActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.RESEARCH_POINT, 1);
            this.updateAllLabels();
        }//GEN-LAST:event_RPAddSmallActionPerformed

        private void RPRemoveSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPRemoveSmallActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.RESEARCH_POINT, 1);
            this.updateAllLabels();
        }//GEN-LAST:event_RPRemoveSmallActionPerformed

        private void RPRemoveBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPRemoveBigActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.RESEARCH_POINT, 5);
            this.updateAllLabels();

        }//GEN-LAST:event_RPRemoveBigActionPerformed

        private void spaceshipPartWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spaceshipPartWorkersActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_spaceshipPartWorkersActionPerformed

        private void SPaddBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPaddBigActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.SPACESHIP_PART, 5);
            this.updateAllLabels();
        }//GEN-LAST:event_SPaddBigActionPerformed

        private void SPAddSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPAddSmallActionPerformed
            this.clicks.employVillagersClick(this.workManager, this.houseManager, Product.SPACESHIP_PART, 1);
            this.updateAllLabels();
        }//GEN-LAST:event_SPAddSmallActionPerformed

        private void SPRemoveSmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPRemoveSmallActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.SPACESHIP_PART, 1);
            this.updateAllLabels();
        }//GEN-LAST:event_SPRemoveSmallActionPerformed

        private void SPRemoveBigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPRemoveBigActionPerformed
            this.clicks.fireVillagersClick(this.workManager, Product.SPACESHIP_PART, 5);
            this.updateAllLabels();
        }//GEN-LAST:event_SPRemoveBigActionPerformed

        private void mineWoodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mineWoodFocusGained
            // TODO add your handling code here:
        }//GEN-LAST:event_mineWoodFocusGained

    private void presentationModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentationModeActionPerformed
        this.storage.addToStorage(Product.WOOD, 100000);
        this.storage.addToStorage(Product.STEEL, 100000);
        this.storage.addToStorage(Product.GOLD, 100000);
        this.storage.addToStorage(Product.RESEARCH_POINT, 100000);
        this.storage.addToStorage(Product.SPACESHIP_PART, 100000);
        this.storage.addToStorage(Product.SMOKED_MEAT, 10);
        House house = new House(0, 0, 0, HousingTypes.HOUSE);
        this.houseManager.addBuilding(house);
        House house1 = new House(0, 0, 0, HousingTypes.HOUSE);
        this.houseManager.addBuilding(house1);
        House house2 = new House(0, 0, 0, HousingTypes.HOUSE);
        this.houseManager.addBuilding(house2);
        House house3 = new House(0, 0, 0, HousingTypes.HOUSE);
        this.houseManager.addBuilding(house3);
        House house4 = new House(0, 0, 0, HousingTypes.HOUSE);
        this.houseManager.addBuilding(house4);
        this.houseManager.addVillager(30);
    }//GEN-LAST:event_presentationModeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoldRemoveBig;
    private javax.swing.JButton RPAddSmall;
    private javax.swing.JButton RPRemoveBig;
    private javax.swing.JButton RPRemoveSmall;
    private javax.swing.JButton RPaddBig;
    private javax.swing.JButton SPAddSmall;
    private javax.swing.JButton SPRemoveBig;
    private javax.swing.JButton SPRemoveSmall;
    private javax.swing.JButton SPaddBig;
    private javax.swing.JButton buyBLOCK_OF_FLATS;
    private javax.swing.JButton buyBigSawmill;
    private javax.swing.JButton buyGoldmine;
    private javax.swing.JButton buyHIGH_RISE_BUILDING;
    private javax.swing.JButton buyHOUSE;
    private javax.swing.JButton buyHUT;
    private javax.swing.JButton buyHuntersLodge;
    private javax.swing.JButton buyIronmine;
    private javax.swing.JButton buyLaboratory;
    private javax.swing.JButton buySTREET_OF_HOUSES;
    private javax.swing.JButton buySawmill;
    private javax.swing.JButton buySlaughterhouse;
    private javax.swing.JButton buySmokehouse;
    private javax.swing.JButton buySpaceship;
    private javax.swing.JButton buySpaceshipFactory;
    private javax.swing.JButton buySteelFactory;
    private javax.swing.JButton buySteelworks;
    private javax.swing.JButton buyTENT;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JButton goldAddBig;
    private javax.swing.JButton goldAddSmall;
    private javax.swing.JButton goldRemoveSmall;
    private javax.swing.JLabel goldResources;
    private javax.swing.JButton goldWorkers;
    private javax.swing.JTextArea highscores;
    private javax.swing.JButton ironAddBig;
    private javax.swing.JButton ironAddSmall;
    private javax.swing.JButton ironRemoveBig;
    private javax.swing.JButton ironRemoveSmall;
    private javax.swing.JLabel ironResources;
    private javax.swing.JButton ironWorkers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton meatAddBig;
    private javax.swing.JButton meatAddSmall;
    private javax.swing.JButton meatRemoveBig;
    private javax.swing.JButton meatRemoveSmall;
    private javax.swing.JLabel meatResources;
    private javax.swing.JButton meatWorkers;
    private javax.swing.JButton mineGold;
    private javax.swing.JButton mineIron;
    private javax.swing.JButton mineMeat;
    private javax.swing.JButton mineWood;
    private javax.swing.JLabel newVillagersFeed;
    private javax.swing.JLabel pickUpgradedLabel;
    private javax.swing.JButton presentationMode;
    private javax.swing.JLabel researchPointResources;
    private javax.swing.JButton researchPointWorkers;
    private javax.swing.JLabel residentsLabel;
    private javax.swing.JButton smokedMeatAddBig;
    private javax.swing.JButton smokedMeatAddSmall;
    private javax.swing.JButton smokedMeatRemoveBig;
    private javax.swing.JButton smokedMeatRemoveSmall;
    private javax.swing.JLabel smokedMeatResources;
    private javax.swing.JButton smokedMeatWorkers;
    private javax.swing.JButton spaceshipPartWorkers;
    private javax.swing.JLabel spaceshipPartsResources;
    private javax.swing.JButton steelAddBig;
    private javax.swing.JButton steelAddSmall;
    private javax.swing.JButton steelRemoveBig;
    private javax.swing.JButton steelRemoveSmall;
    private javax.swing.JLabel steelResources;
    private javax.swing.JButton steelWorkers;
    private javax.swing.JLabel totalGold;
    private javax.swing.JLabel totalIron;
    private javax.swing.JLabel totalMeat;
    private javax.swing.JLabel totalMiningClicks;
    private javax.swing.JLabel totalRP;
    private javax.swing.JLabel totalSP;
    private javax.swing.JLabel totalSmokedMeat;
    private javax.swing.JLabel totalSteel;
    private javax.swing.JLabel totalWood;
    private javax.swing.JButton upgradePickaxe;
    private javax.swing.JButton woodAddBig;
    private javax.swing.JButton woodAddSmall;
    private javax.swing.JButton woodRemoveBig;
    private javax.swing.JButton woodRemoveSmall;
    private javax.swing.JLabel woodResources;
    private javax.swing.JButton woodWorkers;
    private javax.swing.JLabel workersAvailable;
    // End of variables declaration//GEN-END:variables

}
