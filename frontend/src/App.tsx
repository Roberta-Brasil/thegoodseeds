

import logoseedIMG from '/assets/logoseed.svg'
import Header from "./components/Header"
import SeedsCard from "./components/SeedsCard"


function App() {
  return (
    <>
      <Header />
      <main>
        <section id="seeds">
          <div className ="goodseed-container">
            <SeedsCard />
        </div>
      </section>
    </main>
      </>
      )
}

export default App
