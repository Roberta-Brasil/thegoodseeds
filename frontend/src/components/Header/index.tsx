
import logo from '../../assets/img/logoseed.svg'
import './styles.css'

function Header() {
    return (
        <header>
            <div className="goodseeds-logo-container">
                <img src = {logo} alt="The Good seeds" />
                <h1>The Good Seeds</h1>
                <p>
                    Developed by
                    <a href="https://www.linkedin.com/in/roberta-brasil/"> Roberta Brasil</a>
                </p>
            </div>
        </header>
    )

}

export default Header