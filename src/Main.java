import com.parkingLot.controller.ParkingController;
import com.parkingLot.daos.ParkingLotDAO;
import com.parkingLot.daos.ParkingLotDAOImpl;
import com.parkingLot.projos.ParkingSlot;
import com.parkingLot.projos.ParkingTicket;
import com.parkingLot.services.ParkingService;
import com.parkingLot.services.ParkingServiceImpl;

public class Main {
    public static void main(String[] args) {

        ParkingSlot[] slots = new ParkingSlot[5];
        for(int i = 0;i< slots.length; i++)
        {
            slots[i]= new ParkingSlot(i+1);
        }

        ParkingTicket[] tickets = new ParkingTicket[5];

        ParkingLotDAO dao = new ParkingLotDAOImpl(slots, tickets);
        ParkingService service = new ParkingServiceImpl(dao);
        ParkingController controller = new ParkingController(service);

        controller.start();

    }
}