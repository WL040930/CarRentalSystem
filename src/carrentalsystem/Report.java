/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package carrentalsystem;

import java.time.LocalDate;

public class Report extends javax.swing.JPanel {

    static String date; 

        /* Declaration of all necessary variables */
        int economyBookings = 0;
        int compactBookings = 0;
        int luxuryBookings = 0; 
        int vansBookings = 0; 
        int totalBookings = 0; 
    
        int economyUnpaid = 0;
        int compactUnpaid = 0;
        int luxuryUnpaid = 0;
        int vansUnpaid = 0;
        int totalUnpaid = 0;
    
        int economyPaid = 0;
        int compactPaid = 0;
        int luxuryPaid = 0;
        int vansPaid = 0;
        int totalPaid = 0;
    
        int economyTotal = 0;
        int compactTotal = 0;
        int luxuryTotal = 0;
        int vansTotal = 0;
        int totalTotal = 0;

        String bestSelling; 
        int totalQuantity;
        /* End of Declaration of variables */

    public Report(String date) {
        Report.date = date;
        int[] bookingids = Booking.returnRelevantBookingId(date); 
        for (int i = 0; i < bookingids.length; i++) {
            int bookingid = bookingids[i];

            // row number of the booking id in the booking file
            int rowNumber = dataIO.rowNumber(bookingid, 1, dataIO.BOOKING_FILE, 9);
            
            
            String rowCarId = dataIO.readData(rowNumber + 1, dataIO.BOOKING_FILE);
            int rowCarIdInt = Integer.parseInt(rowCarId); 
            
            // row number of the car id in the car file
            int carIdRowInCarFile = dataIO.rowNumber(rowCarIdInt, 1, dataIO.CAR_FILE, 7); 
            
            String rowCarType = dataIO.readData(carIdRowInCarFile + 4, dataIO.CAR_FILE);

            if (rowCarType.equals("Economy")) {
                economyBookings = economyBookings + 1;
            } else if (rowCarType.equals("Compact")) {
                compactBookings = compactBookings + 1;
            } else if (rowCarType.equals("Luxury")) {
                luxuryBookings = luxuryBookings + 1;
            } else if (rowCarType.equals("Vans")) {
                vansBookings = vansBookings + 1;
            }

            String paymentStatus = dataIO.readData(rowNumber + 6, dataIO.BOOKING_FILE);
            LocalDate startDate = LocalDate.parse(dataIO.readData(rowNumber + 3, dataIO.BOOKING_FILE));
            LocalDate endDate = LocalDate.parse(dataIO.readData(rowNumber + 4, dataIO.BOOKING_FILE));
            int days = (int) (endDate.toEpochDay() - startDate.toEpochDay());
            int price = Integer.parseInt(dataIO.readData(carIdRowInCarFile + 3, dataIO.CAR_FILE));
            int total = price * days;

            if (paymentStatus.equals("Unpaid") || paymentStatus.equals("Pending")) {
                if (rowCarType.equals("Economy")) {
                    economyUnpaid = economyUnpaid + total;
                } else if (rowCarType.equals("Compact")) {
                    compactUnpaid = compactUnpaid + total;
                } else if (rowCarType.equals("Luxury")) {
                    luxuryUnpaid = luxuryUnpaid + total;
                } else if (rowCarType.equals("Vans")) {
                    vansUnpaid = vansUnpaid + total;
                }
            } else if (paymentStatus.equals("Paid")) {
                if (rowCarType.equals("Economy")) {
                    economyPaid = economyPaid + total;
                } else if (rowCarType.equals("Compact")) {
                    compactPaid = compactPaid + total;
                } else if (rowCarType.equals("Luxury")) {
                    luxuryPaid = luxuryPaid + total;
                } else if (rowCarType.equals("Vans")) {
                    vansPaid = vansPaid + total;
                }
            } 
        }

        if (economyBookings > compactBookings && economyBookings > luxuryBookings && economyBookings > vansBookings) {
            bestSelling = "Economy Car";
        } else if (compactBookings > economyBookings && compactBookings > luxuryBookings && compactBookings > vansBookings) {
            bestSelling = "Compact Car";
        } else if (luxuryBookings > economyBookings && luxuryBookings > compactBookings && luxuryBookings > vansBookings) {
            bestSelling = "Luxury Car";
        } else if (vansBookings > economyBookings && vansBookings > compactBookings && vansBookings > luxuryBookings) {
            bestSelling = "Vans";
        }

        totalQuantity = economyBookings + compactBookings + luxuryBookings + vansBookings;

        economyTotal = economyPaid + economyUnpaid;
        compactTotal = compactPaid + compactUnpaid;
        luxuryTotal = luxuryPaid + luxuryUnpaid;
        vansTotal = vansPaid + vansUnpaid;
        totalBookings = economyBookings + compactBookings + luxuryBookings + vansBookings;
        totalUnpaid = economyUnpaid + compactUnpaid + luxuryUnpaid + vansUnpaid;
        totalPaid = economyPaid + compactPaid + luxuryPaid + vansPaid;
        totalTotal = economyTotal + compactTotal + luxuryTotal + vansTotal;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        TotalNumberOfBookings = new javax.swing.JLabel();
        TotalUnpaid = new javax.swing.JLabel();
        TotalPaid = new javax.swing.JLabel();
        TotalTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        EconomyNumberOfBookings = new javax.swing.JLabel();
        CompactNumberOfBookings = new javax.swing.JLabel();
        LuxuryNumberOfBookings = new javax.swing.JLabel();
        VansNumberOfBookings = new javax.swing.JLabel();
        EconomyUnpaid = new javax.swing.JLabel();
        CompactUnpaid = new javax.swing.JLabel();
        LuxuryUnpaid = new javax.swing.JLabel();
        VansUnpaid = new javax.swing.JLabel();
        EconomyPaid = new javax.swing.JLabel();
        CompactPaid = new javax.swing.JLabel();
        LuxuryPaid = new javax.swing.JLabel();
        VansPaid = new javax.swing.JLabel();
        EconomyTotal = new javax.swing.JLabel();
        CompactTotal = new javax.swing.JLabel();
        LuxuryTotal = new javax.swing.JLabel();
        VansTotal = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Totalncome = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        BestSellingCar = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        TotalQuantitySold = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrentalsystem/img/reportLogo.jpeg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel2.setText("Panda Car");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel3.setText("Sales Report ");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel4.setText("(Formally known as Panda Car Rental Sdn. Bhd.)");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel5.setText("Copyright (c) 2024 Panda Car. All rights reserved. ");

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel6.setText("From: ");

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel7.setText("To:");

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel8.setText(Booking.returnFirstDay(date));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel9.setText(Booking.returnLastDay(date));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel11.setText("Number of Bookings");

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel12.setText("Unpaid (RM)");

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel13.setText("Paid (RM)");

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel14.setText("Total (RM)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel11)
                .addGap(57, 57, 57)
                .addComponent(jLabel12)
                .addGap(64, 64, 64)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel10.setText("From " + Booking.returnFirstDay(date) + " until " + Booking.returnLastDay(date));

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel15.setText("Economy Car");

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel16.setText("Compact Car");

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel17.setText("Luxury Car");

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel18.setText("Vans");

        jLabel19.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel19.setText("Total");

        TotalNumberOfBookings.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TotalNumberOfBookings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalNumberOfBookings.setText(String.valueOf(totalBookings));

        TotalUnpaid.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TotalUnpaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalUnpaid.setText(String.valueOf(totalUnpaid));

        TotalPaid.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TotalPaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalPaid.setText(String.valueOf(totalPaid));

        TotalTotal.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TotalTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalTotal.setText(String.valueOf(totalTotal));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel19)
                .addGap(90, 90, 90)
                .addComponent(TotalNumberOfBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(TotalUnpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(TotalPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(TotalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TotalNumberOfBookings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TotalUnpaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TotalPaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TotalTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSeparator1.setForeground(new java.awt.Color(242, 242, 242));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        EconomyNumberOfBookings.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        EconomyNumberOfBookings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EconomyNumberOfBookings.setText(String.valueOf(economyBookings));

        CompactNumberOfBookings.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CompactNumberOfBookings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompactNumberOfBookings.setText(String.valueOf(compactBookings));

        LuxuryNumberOfBookings.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        LuxuryNumberOfBookings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LuxuryNumberOfBookings.setText(String.valueOf(luxuryBookings));

        VansNumberOfBookings.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        VansNumberOfBookings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VansNumberOfBookings.setText(String.valueOf(vansBookings));

        EconomyUnpaid.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        EconomyUnpaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EconomyUnpaid.setText(String.valueOf(economyUnpaid));

        CompactUnpaid.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CompactUnpaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompactUnpaid.setText(String.valueOf(compactUnpaid));

        LuxuryUnpaid.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        LuxuryUnpaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LuxuryUnpaid.setText(String.valueOf(luxuryUnpaid));

        VansUnpaid.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        VansUnpaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VansUnpaid.setText(String.valueOf(vansUnpaid));

        EconomyPaid.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        EconomyPaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EconomyPaid.setText(String.valueOf(economyPaid));

        CompactPaid.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CompactPaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompactPaid.setText(String.valueOf(compactPaid));

        LuxuryPaid.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        LuxuryPaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LuxuryPaid.setText(String.valueOf(luxuryPaid));

        VansPaid.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        VansPaid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VansPaid.setText(String.valueOf(vansPaid));

        EconomyTotal.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        EconomyTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EconomyTotal.setText(String.valueOf(economyTotal));

        CompactTotal.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CompactTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompactTotal.setText(String.valueOf(compactTotal));

        LuxuryTotal.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        LuxuryTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LuxuryTotal.setText(String.valueOf(luxuryTotal));

        VansTotal.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        VansTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VansTotal.setText(String.valueOf(vansTotal));

        jLabel25.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel25.setText("Total Income: ");

        Totalncome.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        Totalncome.setText("RM " +String.valueOf(totalTotal));

        jLabel21.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel21.setText("Best Selling Car Type: ");

        BestSellingCar.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BestSellingCar.setText(bestSelling);

        jLabel20.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel20.setText("Total Quantity Sold:");

        TotalQuantitySold.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TotalQuantitySold.setText(String.valueOf(totalQuantity));

        jLabel22.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel22.setText("Unauthorized users are not allowed to read the report.");

        jLabel23.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel23.setText("This report is generated automatically. Please do not modify the report.");

        jLabel24.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel24.setText("Panda Car Rental Sdn. Bhd.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel16)
                                .addComponent(jLabel17)
                                .addComponent(jLabel15))
                            .addGap(37, 37, 37)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(EconomyNumberOfBookings, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(CompactNumberOfBookings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LuxuryNumberOfBookings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VansNumberOfBookings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(45, 45, 45)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(EconomyUnpaid, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                        .addComponent(VansUnpaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(CompactUnpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(LuxuryUnpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(EconomyPaid, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                            .addComponent(VansPaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(CompactPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(EconomyTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                        .addComponent(CompactTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(VansTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LuxuryPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                    .addComponent(LuxuryTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Totalncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BestSellingCar, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addComponent(TotalQuantitySold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(201, 201, 201))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(348, 348, 348))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(96, 96, 96)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EconomyNumberOfBookings)
                            .addComponent(EconomyUnpaid)
                            .addComponent(EconomyPaid)
                            .addComponent(EconomyTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CompactNumberOfBookings)
                            .addComponent(CompactUnpaid)
                            .addComponent(CompactPaid)
                            .addComponent(CompactTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LuxuryNumberOfBookings)
                            .addComponent(LuxuryUnpaid)
                            .addComponent(LuxuryPaid)
                            .addComponent(LuxuryTotal))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VansNumberOfBookings)
                            .addComponent(VansUnpaid)
                            .addComponent(VansPaid)
                            .addComponent(VansTotal)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel16)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel17)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel18))
                    .addComponent(jSeparator1))
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(Totalncome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(BestSellingCar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(TotalQuantitySold))
                .addGap(221, 221, 221)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BestSellingCar;
    private javax.swing.JLabel CompactNumberOfBookings;
    private javax.swing.JLabel CompactPaid;
    private javax.swing.JLabel CompactTotal;
    private javax.swing.JLabel CompactUnpaid;
    private javax.swing.JLabel EconomyNumberOfBookings;
    private javax.swing.JLabel EconomyPaid;
    private javax.swing.JLabel EconomyTotal;
    private javax.swing.JLabel EconomyUnpaid;
    private javax.swing.JLabel LuxuryNumberOfBookings;
    private javax.swing.JLabel LuxuryPaid;
    private javax.swing.JLabel LuxuryTotal;
    private javax.swing.JLabel LuxuryUnpaid;
    private javax.swing.JLabel TotalNumberOfBookings;
    private javax.swing.JLabel TotalPaid;
    private javax.swing.JLabel TotalQuantitySold;
    private javax.swing.JLabel TotalTotal;
    private javax.swing.JLabel TotalUnpaid;
    private javax.swing.JLabel Totalncome;
    private javax.swing.JLabel VansNumberOfBookings;
    private javax.swing.JLabel VansPaid;
    private javax.swing.JLabel VansTotal;
    private javax.swing.JLabel VansUnpaid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
