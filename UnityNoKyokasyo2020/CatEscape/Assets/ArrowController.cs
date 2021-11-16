using System.Collections;
using System.Collections.Generic;
using System.Security.Cryptography;
using UnityEngine;

public class ArrowController : MonoBehaviour
{
    private GameObject player;
    
    // Start is called before the first frame update
    void Start()
    {
        this.player = GameObject.Find("player");
    }

    // Update is called once per frame
    void Update()
    {
        transform.Translate(0, -0.1f, 0);

        if (transform.position.y < -5.0f)
        {
            Destroy(gameObject);
        }

        var p1 = transform.position;
        var p2 = this.player.transform.position;
        var dir = p1 - p2;
        var d = dir.magnitude;
        var r1 = 0.5f;
        var r2 = 1.0f;

        if (d < r1 + r2)
        {
            Destroy(gameObject);
        }
    }
}
