import styles from "../style";
import { bankManagers } from "../constants";
import { useEffect, useState } from "react";

const ManagersList = () => {
    const [isLoading, setIsLoading] = useState(false)
    const [data, setData] = useState()

  async function fetchUsers() {
    setIsLoading(true);
    const response = await fetch('https://datausa.io/api/data?drilldowns=Nation&measures=Population', {method: "POST"})
    const data = await response.json()
    setIsLoading(false)
    setData(data.data[0].Year)
  }

  useEffect(() => {fetchUsers()}, [])

    return (
      <div className="bg-white rounded h-96 w-72 p-4 border-4 border-b-amber-50 flex flex-col py-4 px-4 overflow-y-scroll">
        <button type="button" className={`py-4 px-6 font-poppins font-medium text-[18px] text-primary bg-blue-gradient rounded-[10px] outline-none ${styles}`}>
            Назад
        </button>
        {bankManagers.map((el) => (
            <div className="w-full flex justify-between items-center my-1" key={el.id}>
                <p className="mx-1 font-poppins font-medium text-[14px] text-primary">{el.name}</p>
                <button type="button" className={`mx-1 py-1 px-2 font-poppins font-medium text-[14px] text-primary bg-blue-gradient rounded-[10px] outline-none ${styles}`}>
                  Назначить роль
                </button>
                <button type="button" className={`mx-1 py-1 px-2 font-poppins font-medium text-[14px] text-primary bg-blue-gradient rounded-[10px] outline-none ${styles}`}>
                  Назначить продукт
                </button>
            </div>))
        }
        {isLoading? "Да" : "Нет"}
        {JSON.stringify(data)}
      </div>
    );
  };
  
  export default ManagersList;