import styles from "../style";
import { dialogs } from "../constants";

const AppealList = () => {
    return (
        <div className="bg-white rounded h-96 w-72 p-4 border-4 border-b-amber-50 flex flex-col py-4 px-4 overflow-y-scroll">
        {dialogs.map((el) => (
            <div className="w-full my-1 border-4" key={el.id}>
                <p className="mx-1 font-poppins font-medium text-[14px] text-primary">{el.client.name}</p>
                <p className="mx-1 font-poppins font-medium text-[14px] text-primary">{el.creationDate}</p>
                <p className="mx-1 font-poppins font-medium text-[14px] text-primary">{el.status}</p>
            </div>))
        }
        </div>
    );
  };
  
  export default AppealList;