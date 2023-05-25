import styles from "./style";
import { Billing, Business, CardDeal, Clients, CTA, Footer, Navbar, Stats, Testimonials, Hero } from "./components";
import Chat from "./components/Chat.jsx";
import ChatAdmin from "./components/ChatAdmin.jsx";
import ChatClosed from "./components/ChatClosed.jsx";
import ManagersList from "./components/ManagersList";

const App = () => (
  <div className="bg-primary w-full overflow-hidden">
    <ManagersList />
    {/* <div className={`${styles.paddingX} ${styles.flexCenter}`}>
      <div className={`${styles.boxWidth}`}>
        <Navbar />
      </div>
    </div>

    <div className={`bg-primary ${styles.flexStart}`}>
      <div className={`${styles.boxWidth}`}>
        <Hero />
      </div>
    </div>
    
    <div className={`bg-primary ${styles.paddingX} ${styles.flexCenter}`}>
      <div className={`${styles.boxWidth}`}>
        <Stats />
        <Business />
        <Footer />
          <ChatAdmin />
      </div>
    </div> */}
  </div>
);

export default App;
