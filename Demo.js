/**
 * Created by Auser on 2017/5/4.
 */

import React, {Component} from "react";
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  ListView,
  TouchableOpacity,
  Image,
  ToastAndroid,
  NativeModules,
  FlatList,
} from "react-native";
import BDdVideoViewManager from "./BDdVideoViewManager";


var video_url = "http://101.201.68.107/热血沸腾!_国外跑酷玩家超能集锦!_标清.mp4";

export default class TXVIDEODemo extends Component {
  componentDidMount(){
    // this.timer = setTimeout(() => {
    //   NativeModules.BDVideoMoudle.pause()
    // }, 10000);
  }
//      clearTimeout(this.timer);
  componentWillUnmount(){
    clearTimeout(this.timer);
    NativeModules.BDVideoMoudle.release()
  }
  video;
  render() {
    return (
      <View style={styles.container}>
        <View style={{
          width: '100%', height: 50, borderWidth: 2, borderColor: '#f00',
          justifyContent: 'center', alignItems: 'center',
        }}>
          <Text style={{textAlign: 'center',}}>百度视频测试（单位都是毫秒）</Text>
        </View>

        <BDdVideoViewManager
          ref="textInputRefer1"
          url={video_url}
          style={{width: '100%', height: '30%'}}>
        </BDdVideoViewManager>
        <BDdVideoViewManager
          ref="textInputRefer2"
          url={video_url}
          style={{width: '100%', height: '30%'}}>
        </BDdVideoViewManager>
        <View style={{flexDirection:'row'}}>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.start()}>播放</Text>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.pause()}>暂停</Text>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.seekTo(20*1000)}>调整播放时间</Text>
        </View>
        <View style={{flexDirection:'row'}}>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.getDuration((p)=>alert(p))}>视频长度</Text>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.getCurrentPosition((p)=>alert(p))}>当前进度</Text>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.getVideoLayout((width,height)=>alert(width+","+height))}>视频宽高</Text>
        </View>
        <Text style={{padding:10}} onPress={()=> this.refs.textInputRefer1.setNativeProps({
          setCurrent:12000
        })
        }>切换当前View1（切换以后可以NativeModules控制）</Text>
        <Text style={{padding:10}} onPress={()=> this.refs.textInputRefer2.setNativeProps({
          setCurrent:12000
        })
        }>切换当前View2（切换以后可以NativeModules控制）</Text>
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