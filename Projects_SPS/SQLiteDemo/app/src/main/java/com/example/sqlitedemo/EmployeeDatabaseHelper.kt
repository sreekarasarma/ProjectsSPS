

class EmployeeDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // Insert Employee
    fun insertEmployee(employee: Employee): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, employee.name)
            put(COLUMN_EMAIL, employee.email)
            put(COLUMN_PHONE, employee.phone)
        }
        return db.insert(TABLE_EMPLOYEE, null, values)
    }

    // Update Employee
    fun updateEmployee(employee: Employee): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, employee.name)
            put(COLUMN_EMAIL, employee.email)
            put(COLUMN_PHONE, employee.phone)
        }
        return db.update(TABLE_EMPLOYEE, values, "$COLUMN_ID = ?", arrayOf(employee.id.toString()))
    }

    // Delete Employee by name
    fun deleteEmployee(name: String): Int {
        val db = writableDatabase
        return db.delete(TABLE_EMPLOYEE, "$COLUMN_NAME = ?", arrayOf(name))
    }

    // Get All Employees
    fun getAllEmployees(): List<Employee> {
        val employees = mutableListOf<Employee>()
        val db = readableDatabase
        val cursor = db.query(TABLE_EMPLOYEE, null, null, null, null, null, null)
        if (cursor != null && cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL))
                val phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE))
                employees.add(Employee(id, name, email, phone))
            } while (cursor.moveToNext())
            cursor.close()
        }
        return employees
    }
}
