interface DataExporter {
    void exportToCSV(String data);

    void exportToPDF(String data);

    default void exportToJSON(String data) {
        System.out.println("Exporting data to JSON (default): " + data);
    }
}

class ReportExporter implements DataExporter {
    public void exportToCSV(String data) {
        System.out.println("Exporting data to CSV: " + data);
    }

    public void exportToPDF(String data) {
        System.out.println("Exporting data to PDF: " + data);
    }
}

class AdvancedExporter implements DataExporter {
    public void exportToCSV(String data) {
        System.out.println("Advanced CSV export: " + data);
    }

    public void exportToPDF(String data) {
        System.out.println("Advanced PDF export: " + data);
    }

    // Override default JSON export
    public void exportToJSON(String data) {
        System.out.println("Advanced JSON export with formatting: { \"report\": \"" + data + "\" }");
    }
}

// Step 5: Test
public class ExportDemo {
    public static void main(String[] args) {
        DataExporter reportExporter = new ReportExporter();
        DataExporter advancedExporter = new AdvancedExporter();

        System.out.println("=== Report Exporter (uses default JSON) ===");
        reportExporter.exportToCSV("Quarterly Sales");
        reportExporter.exportToPDF("Quarterly Sales");
        reportExporter.exportToJSON("Quarterly Sales");

        System.out.println("\n=== Advanced Exporter (overrides JSON) ===");
        advancedExporter.exportToCSV("Annual Report");
        advancedExporter.exportToPDF("Annual Report");
        advancedExporter.exportToJSON("Annual Report");
    }
}
