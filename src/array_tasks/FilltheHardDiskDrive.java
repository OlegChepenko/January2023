package array_tasks;
//14.12.2022
public class FilltheHardDiskDrive {
    static int ableToSaveIntoHardDiskDrive(int[] files, int capacityDisk){
        int a = 0;
        int number = 0;
        for (int i = 0; i < files.length; i++) {
            a = a + files[i];
            if (a > capacityDisk) break;
            number++;
        }
            return number;
    }

    public static void main(String[] args) {
        int capacityDisk = 18;
        int[] files = {4,4,4,3,3};
        int NumberOfFilesThatCanBeFullySavedInTheHD = ableToSaveIntoHardDiskDrive(files, capacityDisk);
        System.out.println(NumberOfFilesThatCanBeFullySavedInTheHD);
    }
}
