import styles from "../style";
import { discount, robot, card } from "../assets";
import GetStarted from "./GetStarted";
import cards from "../assets/cards.png"

const Hero = () => {
  return (
    <section id="home" className={`flex md:flex-row flex-col ${styles.paddingY}`}>
      <div className={`flex-1 ${styles.flexStart} flex-col xl:px-0 sm:px-16 px-6`}>
        <div className="flex flex-row justify-between items-center w-full">
          <h1 className="flex-1 font-poppins font-semibold ss:text-[72px] text-[52px] text-white ss:leading-[100.8px] leading-[75px]">
            Ваш выбор<br className="sm:block hidden" />- это наша {" "}
              <br className="sm:block hidden" /><span className="text-gradient">Дебетовая карта.</span>{" "}
          </h1>
        </div>
          <br/>

        <p className={`${styles.paragraph} max-w-[470px] mt-5 border-l-[1px] px-4 py-2`}>
            Оформи нашу дебетовую карту
            по нереально выгодному предложению <br/></p>
          <p className={`${styles.paragraph} max-w-[470px] mt-5 border-l-[1px] px-4 py-2`}>
            При заказе нашей карты
            получите уникальный дизайн
            и кешбек на любой из представленных категорий
        </p>
      </div>

      <div className={`flex-1 flex ${styles.flexCenter} md:my-0 my-10 relative`}>
        <img src={cards} alt="billing" className="w-[100%] h-[100%] relative z-[5]" />

        {/* gradient start */}
        <div className="absolute z-[0] w-[40%] h-[35%] top-0 pink__gradient" />
        <div className="absolute z-[1] w-[80%] h-[80%] rounded-full white__gradient bottom-40" />
        <div className="absolute z-[0] w-[50%] h-[50%] right-20 bottom-20 blue__gradient" />
        {/* gradient end */}
      </div>

      <div className={`ss:hidden ${styles.flexCenter}`}>
        <GetStarted />
      </div>
    </section>
  );
};

export default Hero;
