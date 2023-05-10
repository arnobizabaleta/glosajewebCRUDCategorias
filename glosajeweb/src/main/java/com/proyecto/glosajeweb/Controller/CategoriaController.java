package com.proyecto.glosajeweb.Controller;

import com.proyecto.glosajeweb.Model.Categorias;
import com.proyecto.glosajeweb.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @GetMapping(value = "/")
    public String holaMundo(){
        return "Hola mundo";
    }

    @GetMapping(value = "/categorias")
    public List<Categorias> getTasks(){
        return categoriaRepository.findAll();
    }

    @PostMapping(value = "/guardarCategoria")
    public String saveTask(@RequestBody Categorias categoria){
        categoriaRepository.save(categoria);
        return  "Categoria Guardada";
    }

    @PutMapping(value = "/actualizar/{codCategoria}")
    public String actualizarCategoria(@PathVariable long codCategoria, @RequestBody Categorias categoria){
        Categorias categoriaActualizada = categoriaRepository.findById(codCategoria).get();
        categoriaActualizada.setNombre_categoria(categoria.getNombre_categoria());
        categoriaRepository.save(categoriaActualizada);
        return  "Categoria actualizada";
    }

    @DeleteMapping(value = "/eliminar/{codCategoria}")
    public String eliminarCategoria(@PathVariable long codCategoria){
        Categorias categoriaEliminada = categoriaRepository.findById(codCategoria).get();
        categoriaRepository.delete(categoriaEliminada);
        return  "Categoria Eliminada";
    }
}
