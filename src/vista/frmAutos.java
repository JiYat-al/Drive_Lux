
package vista;

import controlador.AutosController;
import controlador.MarcasController;
import controlador.ModeloController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cars;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import modelo.Brand;
import modelo.Model;

public class frmAutos extends javax.swing.JFrame {

    private final AutosController controller;
    private final MarcasController controllerBrand;
    private final ModeloController controllerModel;

    public frmAutos() {
        initComponents();
        controller = new AutosController();
        controllerBrand = new MarcasController();
        controllerModel = new ModeloController();
        cargarDatos();
        setupTableMouseListener();
        setupTableBrandsMouseListener();
        setupTableModelsMouseListener();
        comboMarcaAutos();
        setupComboListener();
    }
    
    public void combos(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List<Brand> brands = controllerBrand.getAllBrands();
        for(Brand bran: brands){
            modelo.addElement(bran.getName());
        }
        cboMarca.setModel(modelo);
    }

     private void cargarDatos() {
        List<Cars> cars = controller.getAllCarsNotSoldl();
        DefaultTableModel model = (DefaultTableModel) dataJTable.getModel();
        model.setRowCount(0);
        for (Cars car : cars) {
            model.addRow(new Object[]{car.getNum_serie(), controllerModel.getNamebyId(car.getId_model()), controllerModel.getNameBrand(car.getId_model()), car.getYear(), car.getPrice(), car.getColor()});
        }
    } 
     
      private void cargarDatosBrand() {
        List<Brand> brands = controllerBrand.getAllBrands();
        DefaultTableModel model = (DefaultTableModel) tableBrands.getModel();
        model.setRowCount(0);
        for (Brand brand : brands) {
            model.addRow(new Object[]{brand.getId_brand(), brand.getName(), brand.getCountry_origen()});
        }
    }
      
      private void cargarDatosModel() {
        List<Model> models = controllerModel.getAllModels();
        DefaultTableModel modelo = (DefaultTableModel) modelTable.getModel();
        modelo.setRowCount(0);
        for (Model model : models) {
            modelo.addRow(new Object[]{model.getId_model(), model.getName(), model.getBrad()});
        }
    }
      
    public void comboMarcaAutos(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    List<Brand> brands = controllerBrand.getAllBrands();
    for(Brand brand: brands){
        modelo.addElement(brand);
    }
    cboMarAutos.setModel(modelo);
}

     
   private void comboModeloAutos(int brandId){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    List<Model> models = controllerModel.getModelsByBrand(brandId);
    for(Model model: models){
        modelo.addElement(model);
    }
    cboModAutos.setModel(modelo);        
}

     
    private void setupComboListener() {
        cboMarAutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Brand selectedBrand = (Brand) cboMarAutos.getSelectedItem();
                if (selectedBrand != null) {
                    comboModeloAutos(selectedBrand.getId_brand());
                }
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        confirmacionEliminar = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        panelModelos = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNombreModel = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        cboMarca = new javax.swing.JComboBox<>();
        btnEditarModelo = new javax.swing.JButton();
        btnEliminarModelo = new javax.swing.JButton();
        btnAgregarModelo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        modelTable = new javax.swing.JTable();
        panelMarcas = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPaisOrigen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnEditarMarca = new javax.swing.JButton();
        btnAgregarMarca = new javax.swing.JButton();
        btnEliminarMarca = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBrands = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        anioField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        precioField = new javax.swing.JTextField();
        limpiarCampos = new javax.swing.JButton();
        cboMarAutos = new javax.swing.JComboBox<>();
        cboModAutos = new javax.swing.JComboBox<>();
        colorField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        agregarButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataJTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnModelo = new javax.swing.JButton();
        btnMarca = new javax.swing.JButton();

        jLabel7.setText("¿Estás seguro de eliminar este auto?");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confirmacionEliminarLayout = new javax.swing.GroupLayout(confirmacionEliminar.getContentPane());
        confirmacionEliminar.getContentPane().setLayout(confirmacionEliminarLayout);
        confirmacionEliminarLayout.setHorizontalGroup(
            confirmacionEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmacionEliminarLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(confirmacionEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmacionEliminarLayout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(86, 86, 86)
                        .addComponent(btnAceptar)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmacionEliminarLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );
        confirmacionEliminarLayout.setVerticalGroup(
            confirmacionEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmacionEliminarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addGap(74, 74, 74)
                .addGroup(confirmacionEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Modelos");

        jLabel12.setText("Nombre");

        lblMarca.setText("Marca");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreModel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(31, 31, 31)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtNombreModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnEditarModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditarModelo.setText("Editar");
        btnEditarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarModeloActionPerformed(evt);
            }
        });

        btnEliminarModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quitar-usuario.png"))); // NOI18N
        btnEliminarModelo.setText("Eliminar");
        btnEliminarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarModeloActionPerformed(evt);
            }
        });

        btnAgregarModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-usuario.png"))); // NOI18N
        btnAgregarModelo.setText("Agregar");
        btnAgregarModelo.setPreferredSize(new java.awt.Dimension(103, 41));
        btnAgregarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarModeloActionPerformed(evt);
            }
        });

        modelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#ID", "Nombre", "Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(modelTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnEditarModelo)
                .addGap(37, 37, 37)
                .addComponent(btnEliminarModelo)
                .addGap(44, 44, 44))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEditarModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        javax.swing.GroupLayout panelModelosLayout = new javax.swing.GroupLayout(panelModelos.getContentPane());
        panelModelos.getContentPane().setLayout(panelModelosLayout);
        panelModelosLayout.setHorizontalGroup(
            panelModelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModelosLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelModelosLayout.setVerticalGroup(
            panelModelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModelosLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Nombre");

        jLabel11.setText("País Origen");

        jLabel9.setText("Marcas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtPaisOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPaisOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnEditarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditarMarca.setText("Editar");
        btnEditarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMarcaActionPerformed(evt);
            }
        });

        btnAgregarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-usuario.png"))); // NOI18N
        btnAgregarMarca.setText("Agregar");
        btnAgregarMarca.setMinimumSize(new java.awt.Dimension(103, 41));
        btnAgregarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMarcaActionPerformed(evt);
            }
        });

        btnEliminarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quitar-usuario.png"))); // NOI18N
        btnEliminarMarca.setText("Eliminar");
        btnEliminarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMarcaActionPerformed(evt);
            }
        });

        tableBrands.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#ID", "Nombre", "País Origen"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBrands.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBrandsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableBrands);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(btnAgregarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarMarca)
                    .addComponent(btnEliminarMarca))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMarcasLayout = new javax.swing.GroupLayout(panelMarcas.getContentPane());
        panelMarcas.getContentPane().setLayout(panelMarcasLayout);
        panelMarcasLayout.setHorizontalGroup(
            panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMarcasLayout.setVerticalGroup(
            panelMarcasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jLabel2.setText("Marca:");

        jLabel3.setText("Modelo:");

        jLabel4.setText("Año:");

        anioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioFieldActionPerformed(evt);
            }
        });
        anioField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anioFieldKeyReleased(evt);
            }
        });

        jLabel5.setText("Precio");

        precioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioFieldActionPerformed(evt);
            }
        });

        limpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        limpiarCampos.setText("Limpiar Campos");
        limpiarCampos.setToolTipText("");
        limpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCamposActionPerformed(evt);
            }
        });

        jLabel13.setText("Color");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(anioField)
                                .addComponent(precioField)
                                .addComponent(cboMarAutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboModAutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(colorField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(limpiarCampos)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboMarAutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboModAutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(limpiarCampos)
                .addGap(88, 88, 88))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        agregarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/agregar-usuario (1).png"))); // NOI18N
        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        editarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/usuario.png"))); // NOI18N
        editarButton.setText("Editar");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/basura.png"))); // NOI18N
        eliminarButton.setText("Eliminar");
        eliminarButton.setToolTipText("");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        dataJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#SERIE", "MODELO", "MARCA", "AÑO", "PRECIO", "COLOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dataJTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Titulo"));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/coche-electrico.png"))); // NOI18N
        jLabel6.setText("Autos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/volver (1).png"))); // NOI18N
        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/coche.png"))); // NOI18N
        btnModelo.setText("Modelos");
        btnModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModeloActionPerformed(evt);
            }
        });

        btnMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/auto (2).png"))); // NOI18N
        btnMarca.setText("Marcas");
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtras)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void setupTableMouseListener() {
    dataJTable.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int selectedRow = dataJTable.getSelectedRow();
            String brandName = (String) dataJTable.getValueAt(selectedRow, 2);
            seleccionarMarca(brandName);
            
            // Después de seleccionar la marca, selecciona el modelo correcto
            String modeloName = (String) dataJTable.getValueAt(selectedRow, 1);
            seleccionarModelo(modeloName);
            
            anioField.setText(String.valueOf(dataJTable.getValueAt(selectedRow, 3)));
            precioField.setText(String.valueOf(dataJTable.getValueAt(selectedRow, 4)));
            colorField.setText((String) dataJTable.getValueAt(selectedRow,5));
        }
    });
}


private void seleccionarMarca(String brandName) {
            Brand brand;
    for (int i = 0; i < cboMarAutos.getItemCount(); i++) {
        cboMarAutos.setSelectedIndex(i);
        brand =  (Brand) cboMarAutos.getSelectedItem(); // Cast to Brand
        if (brand.getName().equals(brandName)) {
            cboMarAutos.setSelectedIndex(i);
            // Cargar los modelos para la marca seleccionada
            comboModeloAutos(brand.getId_brand());
            break;
        }
    }
}


private void seleccionarModelo(String modeloName) {
    Model model;
    for (int i = 0; i < cboModAutos.getItemCount(); i++) {
        cboModAutos.setSelectedIndex(i);
       model = (Model) cboModAutos.getSelectedItem(); // Cast to Model
        if (model.getName().equals(modeloName)) {
            cboModAutos.setSelectedIndex(i);
            break;
        }
    }
}

    
    
        private void setupTableBrandsMouseListener() {
        tableBrands.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = tableBrands.getSelectedRow();
                txtNombre.setText(String.valueOf(tableBrands.getValueAt(selectedRow, 1)));
                txtPaisOrigen.setText((String) tableBrands.getValueAt(selectedRow, 2));
            }
        });
    }
    
        private void setupTableModelsMouseListener() {
        modelTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = modelTable.getSelectedRow();
                txtNombreModel.setText(String.valueOf(modelTable.getValueAt(selectedRow, 1)));
                cboMarca.setSelectedItem((String) modelTable.getValueAt(selectedRow, 2));
            }
        });
    }
    private void precioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioFieldActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        Model model = (Model) cboModAutos.getSelectedItem();
        int modelo = model.getId_model();
        int anio = Integer.parseInt(anioField.getText());
        double precio = Double.parseDouble(precioField.getText());
        String color = colorField.getText();

        Cars car = new Cars(modelo, anio, precio, color);
        controller.createCar(car);
        cargarDatos();
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        int selectedRow = dataJTable.getSelectedRow();
        if (selectedRow >= 0) {
            String numSerie = (String) dataJTable.getValueAt(selectedRow, 0);
            Model model = (Model) cboModAutos.getSelectedItem();
            int modelo = model.getId_model();
            int anio = Integer.parseInt(anioField.getText());
            double precio = Double.parseDouble(precioField.getText());
            String color = colorField.getText();

            Cars car = new Cars(numSerie, modelo, anio, precio, color);
            controller.updateCar(car);
            cargarDatos();
        } else {
            // Mostrar mensaje de error
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.");
        }
    }//GEN-LAST:event_editarButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        confirmacionEliminar.setSize(400,200);
        confirmacionEliminar.setLocation(100, 100);
        confirmacionEliminar.setVisible(true);
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void limpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarCamposActionPerformed
        cboMarAutos.setSelectedIndex(0);
        anioField.setText("");
        precioField.setText("");
        colorField.setText("");
    }//GEN-LAST:event_limpiarCamposActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        confirmacionEliminar.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        int selectedRow = dataJTable.getSelectedRow();
        if (selectedRow >= 0) {
            String numSerie = (String) dataJTable.getValueAt(selectedRow, 0);
            controller.deleteCar(numSerie);
            cargarDatos();
        } else {
            // Mostrar mensaje de error
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
        }
        confirmacionEliminar.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAgregarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMarcaActionPerformed
        // TODO add your handling code here:
        String name = txtNombre.getText();
        String country_origen = txtPaisOrigen.getText();

        Brand brand = new Brand(name, country_origen);
        controllerBrand.createBrand(brand);
        cargarDatosBrand(); 
        comboMarcaAutos();
    }//GEN-LAST:event_btnAgregarMarcaActionPerformed

    private void btnModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModeloActionPerformed
        // TODO add your handling code here:
        panelModelos.setSize(640, 470);
        panelModelos.setVisible(true);
        combos();
        cargarDatosModel();
    }//GEN-LAST:event_btnModeloActionPerformed

    private void btnEliminarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMarcaActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este elemento?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            // Código para eliminar el elemento
            int selectedRow = tableBrands.getSelectedRow();
            if (selectedRow >= 0) {
                int id_brand = (int) tableBrands.getValueAt(selectedRow, 0);
                controllerBrand.deleteBrand(id_brand);
                cargarDatosBrand();
            } else {
                // Mostrar mensaje de error
                javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
            }
        }
    }//GEN-LAST:event_btnEliminarMarcaActionPerformed

    private void tableBrandsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBrandsMouseClicked

    }//GEN-LAST:event_tableBrandsMouseClicked

    private void btnEditarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMarcaActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableBrands.getSelectedRow();
        if (selectedRow >= 0) {
            int id_brand = (int) tableBrands.getValueAt(selectedRow, 0);
            String name = txtNombre.getText();
            String countryOrigen = txtPaisOrigen.getText();

            Brand brand = new Brand(id_brand, name, countryOrigen);
            controllerBrand.updateBrand(brand);
            cargarDatosBrand();
            comboMarcaAutos();
        } else {
            // Mostrar mensaje de error
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.");
        }
    }//GEN-LAST:event_btnEditarMarcaActionPerformed

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        // TODO add your handling code here:
        panelMarcas.setSize(640, 470);
        panelMarcas.setVisible(true);
        cargarDatosBrand();
    }//GEN-LAST:event_btnMarcaActionPerformed

    private void btnAgregarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarModeloActionPerformed
        // TODO add your handling code here:
        String name = txtNombreModel.getText();
        int marca = controllerModel.buscarPorNombreMarca((String) cboMarca.getSelectedItem());
        Model model = new Model(name, marca);
        controllerModel.createModel(model);
        cargarDatosModel();
    }//GEN-LAST:event_btnAgregarModeloActionPerformed

    private void btnEditarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarModeloActionPerformed
        // TODO add your handling code here:
        int selectedRow = modelTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id_model = (int) modelTable.getValueAt(selectedRow, 0);
            String name = txtNombreModel.getText();
            int id_brand = controllerModel.buscarPorNombreMarca((String) cboMarca.getSelectedItem());

            Model model = new Model(id_model, name, id_brand);
            controllerModel.updateModel(model);
            cargarDatosModel();
        } else {
            // Mostrar mensaje de error
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.");
        }
    }//GEN-LAST:event_btnEditarModeloActionPerformed

    private void btnEliminarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarModeloActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este modelo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            // Código para eliminar el elemento
            int selectedRow = modelTable.getSelectedRow();
            if (selectedRow >= 0) {
                int id_model = (int) modelTable.getValueAt(selectedRow, 0);
                controllerModel.deleteModel(id_model);
                cargarDatosModel();
            } else {
                // Mostrar mensaje de error
                javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
            }
        }
    }//GEN-LAST:event_btnEliminarModeloActionPerformed

    private void anioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anioFieldActionPerformed

    private void anioFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anioFieldKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_anioFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton agregarButton;
    public javax.swing.JTextField anioField;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarMarca;
    private javax.swing.JButton btnAgregarModelo;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarMarca;
    private javax.swing.JButton btnEditarModelo;
    private javax.swing.JButton btnEliminarMarca;
    private javax.swing.JButton btnEliminarModelo;
    private javax.swing.JButton btnMarca;
    private javax.swing.JButton btnModelo;
    private javax.swing.JComboBox<String> cboMarAutos;
    private javax.swing.JComboBox<String> cboMarca;
    private javax.swing.JComboBox<String> cboModAutos;
    private javax.swing.JTextField colorField;
    private javax.swing.JDialog confirmacionEliminar;
    public javax.swing.JTable dataJTable;
    public javax.swing.JButton editarButton;
    public javax.swing.JButton eliminarButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMarca;
    public javax.swing.JButton limpiarCampos;
    private javax.swing.JTable modelTable;
    private javax.swing.JDialog panelMarcas;
    private javax.swing.JDialog panelModelos;
    public javax.swing.JTextField precioField;
    private javax.swing.JTable tableBrands;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreModel;
    private javax.swing.JTextField txtPaisOrigen;
    // End of variables declaration//GEN-END:variables
}
