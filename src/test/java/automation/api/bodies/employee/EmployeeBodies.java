package automation.api.bodies.employee;

public final class EmployeeBodies {

    private EmployeeBodies() {
    }

    /**
     * Create Employee
     */
    public static String createEmployeeQuery() {

        return """
                mutation CreateEmployee($input: EmployeeInput!) {
                  createEmployee(input: $input) {
                    id
                    name
                    email
                    username
                    employeeId
                    employeeRole
                    phoneNumber
                  }
                }
                """;
    }

    /**
     * Get Employee By Id
     */
    public static String getEmployeeQuery() {

        return """
                query EmployeeById($id: String!) {
                  employeeById(id: $id) {
                    id
                    name
                    email
                    username
                    employeeId
                    employeeRole
                    phoneNumber
                    address
                  }
                }
                """;
    }

    /**
     * Update Employee
     */
    public static String updateEmployeeQuery() {

        return """
                mutation UpdateEmployee($id: String!, $input: EmployeeInput!) {
                  updateEmployee(id: $id, input: $input) {
                    id
                    name
                    email
                    username
                    employeeRole
                  }
                }
                """;
    }

    /**
     * Delete Employee
     */
    public static String deleteEmployeeQuery() {

        return """
                mutation DeleteEmployee($id: String!) {
                  deleteEmployee(id: $id)
                }
                """;
    }

}