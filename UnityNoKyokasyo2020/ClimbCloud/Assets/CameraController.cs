using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraController : MonoBehaviour
{

    private GameObject player;
    
    // Start is called before the first frame update
    void Start()
    {
        this.player = GameObject.Find("cat");
    }

    // Update is called once per frame
    void Update()
    {
        var playerPosition = this.player.transform.position;
        transform.position = new Vector3(transform.position.x, playerPosition.y, transform.position.z);
    }
}
