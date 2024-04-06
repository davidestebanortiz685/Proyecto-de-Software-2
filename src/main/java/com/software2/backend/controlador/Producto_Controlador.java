package com.software2.backend.controlador;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.software2.backend.modelo.Producto;

@RestController
@RequestMapping("/api/productos")
public class Producto_Controlador {
    //Metodos que se van a implementar
    private List<Producto> productos;

    public Producto_Controlador(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Producto[] usersArray= objectMapper.readValue(new  ClassPathResource("producto.json").getFile(), Producto[].class);
            productos =new ArrayList<>(Arrays.asList(usersArray));
        } catch (Exception e) {
            e.printStackTrace();
            productos= new ArrayList<>();
        }
    }
    @GetMapping
    public List<Producto> getAllUsers(){
        return productos;
    }
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productos.stream().filter(producto -> producto.getId().equals(id)).findFirst().orElse(null);

    }
      @PostMapping
    public Producto createUser(@RequestBody Producto producto) {
        productos.add(producto);
        return producto;
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto updatedProducto) {
        Producto producto = getProductoById(id);
        if (producto != null) {
            producto.setNombrep(updatedProducto.getNombrep());
            producto.setPrecio(updatedProducto.getPrecio());
            producto.setPeso(updatedProducto.getPeso());
            return producto;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productos.removeIf(producto -> producto.getId().equals(id));
    }
    

}
