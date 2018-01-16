package blockloot.blockloot.model;

public class PriceHistoryRequest {
    public String[] symbols;
    public String startDate;
    public String endDate;

    public PriceHistoryRequest(String[] symbols, String startDate, String endDate) {
        this.symbols = symbols;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String[] getSymbols() {
        return symbols;
    }

    public void setSymbols(String[] symbols) {
        this.symbols = symbols;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
