package packages.bean;

public class PackageBean {
    private String package_name;
    private String package_code;
    private int package_cost;

    public String getPackageName() {
        return package_name;
    }

    public void setPackageName(String package_name) {
        this.package_name = package_name;
    }

    public String getPackageCode() {
        return package_code;
    }

    public void setPackageCode(String package_code) {
        this.package_code = package_code;
    }

    public int getPackageCost() {
        return package_cost;
    }

    public void setPackageCost(int package_cost) {
        this.package_cost = package_cost;
    }
}
