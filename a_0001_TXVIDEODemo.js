/**
 * Created by Auser on 2017/5/4.
 */

import React, {Component} from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  ListView,
  TouchableOpacity,
  Image,
  ToastAndroid,
} from 'react-native';

import RCTTXCloudVideoView from './RCTTXCloudVideoView';

var video_url = "http://101.201.68.107/热血沸腾!_国外跑酷玩家超能集锦!_标清.mp4";

export default class TXVIDEODemo extends Component {
  render() {
    return (
      <View style={styles.container}>
        <View style={{
          width: '100%', height: 50, borderWidth: 2, borderColor: '#f00',
          justifyContent: 'center', alignItems: 'center',
        }}>
          <Text style={{textAlign: 'center',}}>腾讯云点播测试</Text>
        </View>


        <RCTTXCloudVideoView
          url={video_url}
          style={{width: '100%', height: '50%'}}>
        </RCTTXCloudVideoView>
        <Text style={{color: '#fff', marginTop: -20}}>sssssssssssssssssssssssssssssssss</Text>

      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});