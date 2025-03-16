const sqlite3 = require('sqlite3').verbose();
let sql;

const db = new sqlite3.Database('./test.db', sqlite3.OPEN_READWRITE, (err) => {
    if(err) return console.error(err.message)
})


//function usuarioId(id){}

function guardar(first_name, last_name, age){
sql = 'INSERT INTO users (first_name, last_name, age) VALUES (?, ?, ?)';
db.run(sql, [first_name, last_name, age], function (err) {
    if (err) {
      console.error('Error al insertar datos:', err.message);
    } else {
      console.log(`Registro insertado con éxito. ID: ${this.lastID}`);
    }

    // Preguntar si desea seguir insertando datos
   // Recursión para seguir insertando
     
    });
  };

  function eliminar(id) {
  sql = 'DELETE FROM users WHERE id = ?';
  
    db.run(sql, [id], function (err) {
      if (err) {
        return console.error('Error al eliminar datos:', err.message);
      } else {
        console.log(`Dato con ID ${id} eliminado con éxito.`);
      }
    }); 
  }
  
  // Función para actualizar datos
function actualizar(id, first_name, last_name, age, callback) {
  const sql = 'UPDATE users SET first_name = ?, last_name = ?, age = ? WHERE id = ?';
  db.run(sql, [first_name, last_name, age, id], function (err) {
    if (err) {
      callback(err, null);
    } else if (this.changes === 0) {
      callback(null, 'No se encontró un usuario con ese ID.');
    } else {
      callback(null, `Usuario con ID ${id} actualizado correctamente.`);
    }
  });
}
// funcion para traer los datos de la tabla a mi frontend
function obtenerTodos(callback) {
  const sql = 'SELECT * FROM users';
  db.all(sql, [], (err, rows) => {
    if (err) {
      callback(err, null);
    } else {
      callback(null, rows);
    }
  });
}

//Funcion para eliminar todos los datos de la tabla
function eliminarTodos(callback) {
  const sql = 'DELETE FROM users'; // Consulta SQL para eliminar todos los registros de la tabla.
  db.run(sql, function (err) {
    if (err) {
      callback(err); // Si hay un error, pasa el error al callback.
    } else {
      callback(null); // Si no hay errores, llama al callback sin argumentos de error.
    }
  });
}

module.exports = {guardar,eliminar,actualizar, obtenerTodos,eliminarTodos};