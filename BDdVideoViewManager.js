/**
 * Created by YiBing on 2017/4/28.
 * react-native: 0.43.3
 * react-native-cli: 2.0.1
 */

import PropTypes from 'prop-types';
import { requireNativeComponent, View } from 'react-native';

var iface = {
    name: 'BDdVideoViewManager',
    propTypes: {
        setCurrent: PropTypes.number,
        url: PropTypes.string,
        setVideoScalingMode: PropTypes.number,
        start: PropTypes.number,
        pause: PropTypes.number,
        release: PropTypes.number,
        seekTo: PropTypes.number,
        reSetRender: PropTypes.number,
        ...View.propTypes // include the default view properties
    },
};

module.exports = requireNativeComponent('BDdVideoViewManager', iface);





