import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

import HandswapButton from '../HandswapButton'
import './styles.css'

function SeedsCard() {
    return (
        <div className="goodseeds-card">
            <h2 className="goodseeds-title">Seeds</h2>
            <div>
                <div className="goodseeds-search-form-control-container">
                    <input className="goodseeds-form-control" type="text" />
                </div>

                <div className="goodseeds-form-control-container">
                    <DatePicker
                        selected={new Date()}
                        onChange={(date: Date) => { }}
                        className="goodseeds-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
                <div className="goodseeds-form-control-container">
                    <DatePicker
                        selected={new Date()}
                        onChange={(date: Date) => { }}
                        className="goodseeds-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>

                <div>
                    <table className="goodseeds-sales-table">
                        <thead>
                            <tr>
                                <th className="show992">Seed</th>
                                <th className="show576">Popular name</th>
                                <th className="show992">Date Of Collection</th>
                                <th className="show576">Type Of Storage</th>
                                <th className="show576">User</th>
                                <th>Status</th>
                                <th>Click to Swap</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td className="show992">#341</td>
                                <td>Peroba-rosa</td>
                                <td className="show576">08/07/2022</td>
                                <td className="show992">15</td>
                                <td className="show576">11</td>
                                <td>Active</td>
                                <td>
                                    <div className="goodseeds-btn-container">
                                        <HandswapButton />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td className="show992">#341</td>
                                <td>Canela Guaica</td>
                                <td className="show576">08/07/2022</td>
                                <td className="show992">15</td>
                                <td className="show576">11</td>
                                <td>Active</td>
                                <td>
                                    <div className="goodseeds-btn-container">
                                        <HandswapButton />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td className="show992">#341</td>
                                <td>Café de Bugre</td>
                                <td className="show576">08/07/2022</td>
                                <td className="show992">15</td>
                                <td className="show576">11</td>
                                <td>Deactive</td>
                                <td>
                                    <div className="goodseeds-container">
                                        <HandswapButton />
                                    </div>
                                </td>
                            </tr>
                        </tbody>

                    </table>
                </div>

            </div>
        </div>
    )
}

export default SeedsCard