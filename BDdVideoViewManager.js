/**
 * Created by YiBing on 2017/4/28.
 * react-native: 0.43.3
 * react-native-cli: 2.0.1
 */

import { PropTypes } from 'react';
import { requireNativeComponent, View } from 'react-native';

var iface = {
    name: 'BDdVideoViewManager',
    propTypes: {
        url: PropTypes.string,
        setVideoScalingMode: PropTypes.number,
        ...View.propTypes // include the default view properties
    },
};

module.exports = requireNativeComponent('BDdVideoViewManager', iface);





