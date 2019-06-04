/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Employee.HomelessReport;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HomelessReport.HomelessReport;
import Business.WorkQueue.HomelessReport.HomelessReport.Priority;
import Business.WorkQueue.WorkRequest;
import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.GeocoderCallback;
import com.teamdev.jxmaps.GeocoderRequest;
import com.teamdev.jxmaps.GeocoderResult;
import com.teamdev.jxmaps.GeocoderStatus;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.swing.MapView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import Business.WorkQueue.WorkRequest.Status;
import com.teamdev.jxmaps.Icon;
import com.teamdev.jxmaps.InfoWindowOptions;
import com.teamdev.jxmaps.Size;

/**
 *
 * @author shaoy
 */
public class ShowMapJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShowMapJPanel
     */
    private JPanel userProcessContainer;
    private Organization organization;
    private UserAccount account;

    public ShowMapJPanel(JPanel userProcessContainer, Organization organization, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.account = account;
        drawMap();
    }

    private void drawMap() {
        MapExample sample = new MapExample();
        mapContainer.add(sample, BorderLayout.CENTER);
        mapContainer.add(btnBack, BorderLayout.PAGE_END);
    }

    public class MapExample extends MapView {

        public MapExample() {

            setOnMapReadyHandler(new MapReadyHandler() {
                @Override
                public void onMapReady(MapStatus status) {
                    final Map map = getMap();
                    map.setZoom(10.0);
                    MapOptions options = new MapOptions(map);
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions(map);
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    options.setMapTypeControlOptions(controlOptions);
                    map.setOptions(options);
                    for (WorkRequest w : organization.getWorkQueue().getWorkRequestList()) {
                        if (w instanceof HomelessReport && w.getStatus().equals(Status.Pending.getValue())) {
                            HomelessReport h = (HomelessReport) w;
                            performGeocode(h.getLocation(), h);
                        }
                    }
                    //performGeocodeB(organization.getAddress());
                }
            });
        }

        private void performGeocode(String text, HomelessReport h) {
             Map map = getMap();
            GeocoderRequest request = new GeocoderRequest(map);
            request.setAddress(text);

            getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
                @Override
                public void onComplete(GeocoderResult[] results, GeocoderStatus status) {
                    if ((status == GeocoderStatus.OK) && (results.length > 0)) {
                        GeocoderResult result = results[0];
                        LatLng location = result.getGeometry().getLocation();
                        map.setCenter(location);
                        Marker marker = new Marker(map);

                        Icon icon = new Icon();
                        if (h.getPriority().getValue().equals(Priority.High.getValue())) {
                            icon.loadFromFile("High.png");
                        } else if (h.getPriority().getValue().equals(Priority.Normal.getValue())) {
                            icon.loadFromFile("Normal.png");
                        } else if (h.getPriority().getValue().equals(Priority.Low.getValue())) {
                            icon.loadFromFile("Low.png");
                        }
                        Size size = new Size(50, 50);
                        icon.setSize(size);
                        marker.setIcon(icon);

                        marker.setClickable(true);
                        marker.setPosition(location);
                        InfoWindow infoWindow = new InfoWindow(map);
                        infoWindow.setContent("<b>" + result.getFormattedAddress() + "</b><br>" + h.getMessage());
                        infoWindow.setPosition(location);
                        infoWindow.open(map, marker);

                        //MapOptions mo;
                    }
                }
            });
        }

//        private void performGeocodeB(String text) {
//             Map map = getMap();
//            GeocoderRequest request = new GeocoderRequest(map);
//            request.setAddress(text);
//
//            getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
//                @Override
//                public void onComplete(GeocoderResult[] results, GeocoderStatus status) {
//                    if ((status == GeocoderStatus.OK) && (results.length > 0)) {
//                        GeocoderResult result = results[0];
//                        LatLng location = result.getGeometry().getLocation();
//                        map.setCenter(location);
//                        Marker marker = new Marker(map);
//
////                        Icon icon = new Icon();
////                        icon.loadFromFile("Home.png");
////                        Size size = new Size(50, 50);
////                        icon.setSize(size);
////                        marker.setIcon(icon);
//
//                        marker.setClickable(true);
//                        marker.setPosition(location);
//
////                        InfoWindow infoWindow = new InfoWindow(map);
////                        infoWindow.setContent("<b>" + result.getFormattedAddress() + "</b><br>" + "Base");
////                        infoWindow.setPosition(location);
////                        infoWindow.open(map, marker);
//                        //MapOptions mo;
//                    }
//                }
//            });
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapContainer = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        mapContainer.setLayout(new java.awt.BorderLayout());

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        mapContainer.add(btnBack, java.awt.BorderLayout.PAGE_END);

        add(mapContainer, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel mapContainer;
    // End of variables declaration//GEN-END:variables
}
