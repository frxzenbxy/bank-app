import styles from "../style";
import { products } from "../constants";

const ProductList = () => {
    return (
      <div className="bg-white rounded h-96 w-72 p-4 border-4 border-b-amber-50 flex flex-col py-4 px-4 overflow-y-scroll">
        <button type="button" className={`py-4 px-6 font-poppins font-medium text-[18px] text-primary bg-blue-gradient rounded-[10px] outline-none ${styles}`}>
            Назад
        </button>
        {products.map((el) => (
            <div className="w-full flex justify-between items-center my-1" key={el.id}>
                <p className="mx-1 font-poppins font-medium text-[14px] text-primary">{el.name}</p>
            </div>))
        }
        <button type="button" className={`py-4 px-6 font-poppins font-medium text-[18px] text-primary bg-blue-gradient rounded-[10px] outline-none ${styles}`}>
            Создать новый
        </button>
      </div>
    );
  };
  
  export default ProductList;